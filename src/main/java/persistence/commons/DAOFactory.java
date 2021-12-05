package persistence.commons;

import persistence.UsuarioDAO;
import persistence.impl.UsuarioDAOImpl;

public class DAOFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
}
