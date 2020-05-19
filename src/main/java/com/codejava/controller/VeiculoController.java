package com.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejava.model.Empresa;
import com.codejava.model.Veiculo;
import com.codejava.services.EmpresaService;
import com.codejava.services.VeiculoService;

@Controller
public class VeiculoController {

	@Autowired
	private VeiculoService serviceVeiculo;
	@Autowired
	private EmpresaService serviceEmpresa;
	
	@RequestMapping("/listaVeiculos/{id_empresa}")
	public String ViewHomePage(Model model, @PathVariable(name="id_empresa") Long id) {
		Empresa empresa = new Empresa();
		empresa = serviceEmpresa.get(id);
		
		List<Veiculo> listaVeiculos = serviceVeiculo.ListPorEmpresa(empresa);
		model.addAttribute("listaVeiculos", listaVeiculos);
		return "Index_veiculos";
	}
	
	@RequestMapping("/novo_veiculo/{id_empresa}")
	public String formularioNovoVeiculo(Model model ,@PathVariable(name="id_empresa") Long id) {
		Veiculo veiculo = new Veiculo();
		Empresa empresa = new Empresa();
		empresa = serviceEmpresa.get(id);
		
		model.addAttribute("empresa", empresa);
		model.addAttribute("veiculo", veiculo);
		return "novo_veiculo";
	}
	
	@GetMapping("/salvar_veiculo/{id_empresa}")
	public String salvarEstacionamento(@ModelAttribute("veiculo") Veiculo veiculo, @PathVariable(name="id_empresa") Long id) {
		Empresa empresa = new Empresa();
		empresa = serviceEmpresa.get(id);
		veiculo.setEmpresa(empresa);
		serviceVeiculo.saveVeiculo(veiculo);
		
		return "redirect:/listaVeiculos/{id_empresa}";
		
	}
	
	@RequestMapping("/editarVeiculo/{id_veiculo}")
	public ModelAndView formularioEditarEstacionamento(@PathVariable(name = "id_veiculo") Long id) {
		ModelAndView mav = new ModelAndView("editar_veiculo");
		
		Veiculo veiculo = serviceVeiculo.get(id);
		mav.addObject("veiculo", veiculo);
		
		return mav;
	}
	
	@RequestMapping("/deletarVeiculo/{id_veiculo}")
	public String deletarEmpresa(@PathVariable(name = "id_veiculo") Long id) {
		serviceVeiculo.delete(id);
		return "redirect:/";
	}

}
