package br.com.devjoao.Cadastro.model.enums;

public enum Sexo {

	MASCULINO("Masculino"), 
	FEMININO("Feminino");

	private String label;

	private Sexo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
