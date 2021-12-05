package services;

import model.Usuario;
import model.nullObjects.NullUser;
import persistence.UsuarioDAO;
import persistence.commons.DAOFactory;

public class LoginService {
	public Usuario login(String username, String password) {
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
    	Usuario usuario = userDao.findByUsername(username);
    	
    	if (usuario.isNull() || !usuario.checkPass(password)) {
    		usuario = NullUser.build();
    	}
    	return usuario;
	}
}
