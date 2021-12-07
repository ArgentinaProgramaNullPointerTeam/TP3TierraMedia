package persistence;

import java.util.HashMap;

import model.Usuario;
import persistence.commons.GenericDAO;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public abstract Usuario findByUsername(String username);
	public abstract Usuario find(Integer id);
	public abstract HashMap<Integer, Usuario> findAll();
}
