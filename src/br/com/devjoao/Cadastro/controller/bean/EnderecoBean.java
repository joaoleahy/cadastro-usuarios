package br.com.devjoao.Cadastro.controller.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.devjoao.Cadastro.model.entities.Endereco;
import br.com.devjoao.Cadastro.model.enums.Cidade;
import br.com.devjoao.Cadastro.model.enums.Enderecos;
import br.com.devjoao.Cadastro.model.enums.Estado;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean {
	
	public Endereco endereco;
	public Cidade cidade;
	private List<SelectItem> listCidade;
	private List<Endereco> listEndereco;

	private Estado selectEstado; 
	private List<SelectItem> listEstados;
	private List<SelectItem> listMunicipios;
	
	private List<String> listLogradouros;

	private String filtro;
	
	public EnderecoBean() {
		endereco = new Endereco();
		listMunicipios = new ArrayList<>();
		listEndereco = new ArrayList<>(); 
		listEndereco = Enderecos.INSTANCE.allEnderecos();
		
	}
	@PostConstruct
	public void initSexo() {
		listCidade = new ArrayList<>();
		for (Cidade s : Cidade.values()) {
			listCidade.add(new SelectItem(s, s.getLabel()));
		}

		listEstados = new ArrayList<>();
		for (Estado s : Estado.values()) {
			listEstados.add(new SelectItem(s, s.getLabel()));
		}
		
		listLogradouros = new ArrayList<>();
		listLogradouros.add("Rua João Vicentina");
		listLogradouros.add("Rua Elisete Marques");
	}
	
	public void carregarMunicipios(Estado e) {
		listMunicipios = new ArrayList<>();
		for (Cidade cidade : Cidade.values()) {
			if (e.name().equals(cidade.getEstado()))
				listMunicipios.add(new SelectItem(cidade, cidade.getLabel()));
		}
	}
	
	public String prepararCadastro() {
		endereco = new Endereco();
		return "cadastroEndereco";
	}
	
	public String prepararList() {
		return "";
	}
	
	public String adicionarEndereco() {
		String uniqueID = UUID.randomUUID().toString();
		endereco.setId(uniqueID);
		Enderecos.INSTANCE.addEndereco(endereco);
		listEndereco = Enderecos.INSTANCE.allEnderecos();
		return "listarEnderecos"; 
	}
	
	public void filtrarTabela() {
		listEndereco = new ArrayList<>();
		for (Endereco u : Enderecos.INSTANCE.allEnderecos()) {
			if (u.getCEP().contains(filtro)) {
				listEndereco.add(u);
			}
		}
	}
	
	public String deletar(Endereco endereco2) {
		Enderecos.INSTANCE.removeEndereco(endereco2);
		 FacesContext context = FacesContext.getCurrentInstance();
		    return context.getViewRoot().getViewId() + "?faces-redirect=true";
	}
	
	public String editar(Endereco endereco3) {
		Enderecos.INSTANCE.editarEndereco(endereco3);
		FacesContext context = FacesContext.getCurrentInstance();
	    return context.getViewRoot().getViewId() + "?faces-redirect=true";
		
	}
	
	public String carregarDetalhes(Endereco endereco) {
		this.endereco = endereco;
		return "detalhesUsuario";
	}

	public void carregarDetalhes2(Endereco endereco) {
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<SelectItem> getListCidade() {
		return listCidade;
	}

	public void setListCidade(List<SelectItem> listCidade) {
		this.listCidade = listCidade;
	}

	public List<Endereco> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<Endereco> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public Estado getSelectEstado() {
		return selectEstado;
	}

	public void setSelectEstado(Estado selectEstado) {
		this.selectEstado = selectEstado;
	}

	public List<SelectItem> getListEstados() {
		return listEstados;
	}

	public void setListEstados(List<SelectItem> listEstados) {
		this.listEstados = listEstados;
	}

	public List<SelectItem> getListMunicipios() {
		return listMunicipios;
	}

	public void setListMunicipios(List<SelectItem> listMunicipios) {
		this.listMunicipios = listMunicipios;
	}

	public List<String> getListLogradouros() {
		return listLogradouros;
	}

	public void setListLogradouros(List<String> listLogradouros) {
		this.listLogradouros = listLogradouros;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	
	
	
	

}
