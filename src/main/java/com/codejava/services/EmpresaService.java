package com.codejava.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codejava.model.Empresa;
import com.codejava.repositories.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repo;
	
	public List<Empresa> listAll(){
		return repo.findAll();
	}
	
	public void saveEmpresa(Empresa empresa) {
		repo.save(empresa);
	}
	
	public Empresa get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
