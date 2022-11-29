package br.com.devjoao.Cadastro.model.entities;


import br.com.devjoao.Cadastro.model.enums.Cidade;
import br.com.devjoao.Cadastro.model.enums.Estado;


public class Endereco {
	
	private String id;

	private String logradouro;
	
	
	private Cidade municipio;
	
	
	private Estado estado;
	
	
	private String numero;
	
	
	private String CEP;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Cidade getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Cidade municipio) {
		this.municipio = municipio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
	
	
	
	

}
