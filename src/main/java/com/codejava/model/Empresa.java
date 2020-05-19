package com.codejava.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_empresa;
	private String nome;
	private String cnpj;
	private String endereco;
	private String telefone;
	private int qtd_carros;
	private int qtd_motos;
	@OneToMany
	private List<Veiculo> veiculos;


	public Empresa() {

	}
	
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public Long getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getQtd_carros() {
		return qtd_carros;
	}

	public void setQtd_carros(int qtd_carros) {
		this.qtd_carros = qtd_carros;
	}

	public int getQtd_motos() {
		return qtd_motos;
	}

	public void setQtd_motos(int qtd_motos) {
		this.qtd_motos = qtd_motos;
	}

}
