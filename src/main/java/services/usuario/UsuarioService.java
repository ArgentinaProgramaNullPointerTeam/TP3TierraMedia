package services.usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class UsuarioService {
	public List<Usuario> list() {
		HashMap<Integer, Usuario> ListUsuarios = DAOFactory.getUsuarioDAO().findAll();
		List<Usuario> usuarios = new ArrayList<Usuario>(ListUsuarios.values());
		return usuarios;
	}

	public Usuario create(String nombre, String password, int atraccionPreferida, int dineroDisponible,
			double tiempoDisponible, int isAdmin) {
		Usuario usuario = new Usuario(nombre, password, atraccionPreferida, dineroDisponible, tiempoDisponible, isAdmin == 1);

		if (usuario.isValid()) {
			UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
			usuarioDAO.insert(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return usuario;
	}
	
	public void delete(Integer id) {
		Usuario usuario = new Usuario(id, "", "", 0, 0, 0.0, false, false);

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		usuarioDAO.delete(usuario);
	}
	
	public Usuario find(Integer id) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		return usuarioDAO.find(id);
	}
	
	public Usuario update(Integer id, String nombre, String password, int atraccionPreferida, int dineroDisponible,
			double tiempoDisponible, int isAdmin, int status) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuario = usuarioDAO.find(id);
		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setAtraccionPreferida(atraccionPreferida);
		usuario.setDineroDisponible(dineroDisponible);
		usuario.setTiempoDisponible(tiempoDisponible);
		usuario.setAdmin(isAdmin == 1);
		usuario.setStatus(status == 1);

		if (usuario.isValid()) {
			usuarioDAO.update(usuario);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return usuario;
	}
}
