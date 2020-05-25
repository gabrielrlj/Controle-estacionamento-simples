package com.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejava.model.Empresa;
import com.codejava.services.EmpresaService;

@Controller
public class EmpresaController {
	@Autowired
	private EmpresaService service;
	
	
	@RequestMapping("/home")
	public String ViewHomePage(Model model) {
		List<Empresa> listaEmpresas = service.listAll();
		model.addAttribute("listaEmpresas", listaEmpresas);
		return "Index";
	}
	
	@RequestMapping("/novo")
	public String formularioNovoEstacionamento(Model model) {
		Empresa empresa = new Empresa();
		model.addAttribute("empresa", empresa);
		return "novo_estacionamento";
	}
	
	@PostMapping("/salvar")
	//@RequestMapping(value= "/salvar", method = RequestMethod.POST)
	public String salvarEstacionamento(@ModelAttribute("empresa") Empresa empresa) {
		service.saveEmpresa(empresa);
		
		return "redirect:/";
	}
	
	@RequestMapping("/editar/{id_empresa}")
	public ModelAndView formularioEditarEstacionamento(@PathVariable(name = "id_empresa") Long id) {
		ModelAndView mav = new ModelAndView("editar_empresa");
		
		Empresa empresa = service.get(id);
		mav.addObject("empresa", empresa);
		
		return mav;
	}
	
	@RequestMapping("/deletar/{id_empresa}")
	public String deletarEmpresa(@PathVariable(name = "id_empresa") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}
