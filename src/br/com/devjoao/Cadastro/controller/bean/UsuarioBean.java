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
import br.com.devjoao.Cadastro.model.entities.Usuario;
import br.com.devjoao.Cadastro.model.enums.Enderecos;
import br.com.devjoao.Cadastro.model.enums.PessoaTipo;
import br.com.devjoao.Cadastro.model.enums.Usuarios;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
	public Usuario usuario;
	public PessoaTipo selectedPessoa; 
	
	private List<SelectItem> listPessoa;
	public Endereco endereco; 
	public String enderecoNome; 
	private List<Usuario> listUsuario; 
	private List<SelectItem> listEndereco;
	private List<Endereco> le;
	
	private String hide;

	
	private String filtro;
	
	private String filtro2;
	
	
	public UsuarioBean() {
		usuario = new Usuario();
		endereco = new Endereco();
		hide = "block"; 
		listUsuario = new ArrayList<>();
		listUsuario = Usuarios.INSTANCE.allUsers();
		
	}
	
	@PostConstruct
	public void initSexo() {
		listPessoa = new ArrayList<>();
		for(PessoaTipo p : PessoaTipo.values()) {
			System.out.println(p);
			listPessoa.add(new SelectItem(p, p.getLabel()));
		}
			
	}
	

	public void prepararEndereco() {
		le = new ArrayList<>();
		le = Enderecos.INSTANCE.allEnderecos();
		listEndereco = new ArrayList<>();
		System.out.println("cheguei aqui");
		for(Endereco e : le) {
			System.out.println("estamos aqui" + e);
			listEndereco.add(new SelectItem(e, e.getLogradouro()));
		}
	}
	
	public void prepararEndereco2() {
		listEndereco = new ArrayList<>();
		System.out.println("cheguei aqui");
		for(Endereco e : le) {
			System.out.println("estamos aqui" + e);
			listEndereco.add(new SelectItem(e, e.getLogradouro()));
		}
		
		if(this.listEndereco.isEmpty()) {
			this.hide = "none"; 
		}else {
			this.hide = "block"; 
		}
		
	}
	
	public void filtrarTabela2() {
		le = new ArrayList<>();
		
		for (Endereco u : Enderecos.INSTANCE.allEnderecos()) {
			if (u.getCEP().contains(filtro2)) {
				le.add(u);
			}
		}
		this.prepararEndereco2();
	}
	
	public List<SelectItem> getListEndereco() {
		return listEndereco;
	}

	public void setListEndereco(List<SelectItem> listEndereco) {
		this.listEndereco = listEndereco;
	}

	public List<Endereco> getLe() {
		return le;
	}

	public void setLe(List<Endereco> le) {
		this.le = le;
	}

	public String prepararCadastro() {
		usuario = new Usuario();
		this.prepararEndereco();
		return "cadastroUsuario";
	}

	public String prepararList() {
		return "";
	}
	
	public String adicionarUsuario() {
		
		le = new ArrayList<>();
		this.endereco.setCEP(filtro2);
		String uniqueID = UUID.randomUUID().toString();
		usuario.setId(uniqueID);
		le = Enderecos.INSTANCE.allEnderecos();
		if(le.isEmpty()) {
			usuario.setEndereco(this.getEndereco());
			Enderecos.INSTANCE.addEndereco(getEndereco());
		}else {
			for(Endereco e : le) {
				if(e.getLogradouro().contains(this.enderecoNome)) {
					usuario.setEndereco(e);
				}else {
					usuario.setEndereco(this.getEndereco());
				}
			}
			
		}

		Usuarios.INSTANCE.addUser(usuario);
		listUsuario = Usuarios.INSTANCE.allUsers();
		return "listarUsuarios";
	}
	
	public void filtrarTabela() {
		listUsuario = new ArrayList<>();
		for (Usuario u : Usuarios.INSTANCE.allUsers()) {
			if (u.getUsername().contains(filtro)) {
				listUsuario.add(u);
			}
		}
	}
	
	public String deletar(Usuario usuario2) {
		Usuarios.INSTANCE.removeUser(usuario2);
		 FacesContext context = FacesContext.getCurrentInstance();
		    return context.getViewRoot().getViewId() + "?faces-redirect=true";
	}
	
	public String editar(Usuario usuario3) {
		Usuarios.INSTANCE.editarUser(usuario3);
		FacesContext context = FacesContext.getCurrentInstance();
	    return context.getViewRoot().getViewId() + "?faces-redirect=true";
		
	}
	
	public PessoaTipo getSelectedPessoa() {
		return selectedPessoa;
	}

	public void setSelectedPessoa(PessoaTipo selectedPessoa) {
		this.selectedPessoa = selectedPessoa;
	}



	public List<SelectItem> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(List<SelectItem> listPessoa) {
		this.listPessoa = listPessoa;
	}

	public String carregarDetalhes(Usuario usuario) {
		this.usuario = usuario;
		return "detalhesUsuario";
	}

	public void carregarDetalhes2(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	public String getEnderecoNome() {
		return enderecoNome;
	}

	public void setEnderecoNome(String enderecoNome) {
		this.enderecoNome = enderecoNome;
	}
	
	public String getFiltro2() {
		return filtro2;
	}

	public void setFiltro2(String filtro2) {
		this.filtro2 = filtro2;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}
	
	

	
	

	
	

}
