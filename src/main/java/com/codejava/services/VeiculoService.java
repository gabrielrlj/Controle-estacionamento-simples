package com.codejava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejava.model.Empresa;
import com.codejava.model.Veiculo;
import com.codejava.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repo;
	
	public List<Veiculo> listAll(){
		return repo.findAll();
	}
	
	public List<Veiculo> ListPorEmpresa(Empresa empresa) {
		return repo.findByEmpresa(empresa);
	}
	
	public void saveVeiculo(Veiculo veiculo) {
		repo.save(veiculo);
	}
	
	public Veiculo get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
