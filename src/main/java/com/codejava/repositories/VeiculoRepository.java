package com.codejava.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codejava.model.Empresa;
import com.codejava.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	@Query("SELECT v FROM Veiculo v WHERE v.empresa = ?1")
	public List<Veiculo> findByEmpresa(Empresa empresa);
}
