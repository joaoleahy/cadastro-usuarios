package br.com.devjoao.Cadastro.model.enums;

public enum Cidade {

	JP("Jo�o Pessoa", "PB"), 
	PT("Patos", "PB"), 
	CG("Campina Grande", "PB"), 
	RE("Recife", "PE"), 
	EX("Exu","PE"), 
	PE("Petrolina", "PE"), 
	NT("Natal", "RN"),
	MO("Mossor�", "RN"),
	SP("S�o Paulo", "SP"),
	GR("Guarulhos", "SP"),
	RJ("Rio de Janeiro", "RJ"),
	NI("Niteroi", "RJ"),
	RS("Porto Alegre", "RS"),
	GM("Gramado", "RS"),
	GO("Goiana", "GO"),
	IP("Ipor�", "GO"),
	SL("S�o Lu�s", "MA"),
	CA("Caxias", "MA"),
	BE("Bel�m", "PA"),
	SA("Santar�m", "PA"),
	FO("Fortaleza", "CE"),
	SO("Sobral", "CE");

	private String label;
	private String estado;

	private Cidade(String label, String estado) {
		this.label = label;
		this.estado = estado;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
