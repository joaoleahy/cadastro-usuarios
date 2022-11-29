package br.com.devjoao.Cadastro.model.enums;

public enum PessoaTipo {
	PF("Pessoa F�sica"), 
	PJ("Pessoa Jur�dica");
	
	private String label;

	private PessoaTipo(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
