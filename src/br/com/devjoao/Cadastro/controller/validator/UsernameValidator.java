package br.com.devjoao.Cadastro.controller.validator;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.devjoao.Cadastro.model.entities.Usuario;
import br.com.devjoao.Cadastro.model.enums.Usuarios;

@FacesValidator("usernameValidator")
public class UsernameValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		List<Usuario> listAux = Usuarios.INSTANCE.allUsers();
		String username = arg2.toString();

		if (listAux != null) {
			for (Usuario u : listAux) {
				if (u.getUsername().equals(username)) {
					FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username j� existente",
							"Username j� existente");
					throw new ValidatorException(fm);
				}
			}
		}

	}

}
