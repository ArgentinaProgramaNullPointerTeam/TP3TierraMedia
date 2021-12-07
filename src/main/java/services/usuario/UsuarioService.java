package services.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Usuario;
import persistence.commons.DAOFactory;


public class UsuarioService {
	public List<Usuario> list() {
		HashMap<Integer, Usuario> ListUsuarios = DAOFactory.getUsuarioDAO().findAll();
		List<Usuario> usuarios = new ArrayList<Usuario>(ListUsuarios.values());
		return usuarios;
	}
}
