package br.com.devjoao.Cadastro.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.devjoao.Cadastro.model.entities.Usuario;

public enum Usuarios {

	INSTANCE;

	private List<Usuario> listUsuarios;

	private Usuarios() {
		listUsuarios = new ArrayList<>();
	}

	public void addUser(Usuario u) {
		listUsuarios.add(u);
	}
	
	public void removeUser(Usuario u) {
		listUsuarios.remove(u);
		
	}
	
	public void editarUser(Usuario u) {
		for(int i = 0; i < listUsuarios.size(); i++ ) {
			if(listUsuarios.get(i).getId().contains(u.getId())) {
				listUsuarios.set(i, u);
				
			}
		}

	}

	public List<Usuario> allUsers() {
		return listUsuarios;
	}
}
