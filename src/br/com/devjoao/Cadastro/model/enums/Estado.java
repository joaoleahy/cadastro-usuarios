package br.com.devjoao.Cadastro.model.enums;

public enum Estado {

	PB("Paraiba"), 
	PE("Pernambuco"), 
	RN("Rio Grande do Norte"), 
	SP("S�o Paulo"), 
	RJ("Rio de Janeiro"),
	RS("Rio Grande do Sul"),
	GO("Goi�s"),
	MA("Maranh�o"),
	PA("Par�"),
	CE("Cear�")
	;

	private String label;

	private Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
