package com.codejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejava.model.Empresa;


public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
}
