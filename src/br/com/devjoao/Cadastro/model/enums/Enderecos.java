package br.com.devjoao.Cadastro.model.enums;

import java.util.ArrayList;
import java.util.List;

import br.com.devjoao.Cadastro.model.entities.Endereco;

public enum Enderecos {
	INSTANCE;

	private List<Endereco> listEnderecos;

	private Enderecos() {
		listEnderecos = new ArrayList<>();
	}

	public void addEndereco(Endereco u) {
		listEnderecos.add(u);
	}

	public List<Endereco> allEnderecos() {
		return listEnderecos;
	}
	
	public void removeEndereco(Endereco u) {
		listEnderecos.remove(u);
		
	}
	
	public void editarEndereco(Endereco u) {
		for(int i = 0; i < listEnderecos.size(); i++ ) {
			if(listEnderecos.get(i).getId().contains(u.getId())) {
				listEnderecos.set(i, u);
				
			}
		}

	}


}
