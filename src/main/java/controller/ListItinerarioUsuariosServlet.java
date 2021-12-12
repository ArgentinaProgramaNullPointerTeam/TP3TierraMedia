package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.usuario.UsuarioService;

@WebServlet("/itinerarioUsuarios.adm")
public class ListItinerarioUsuariosServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -7225284039741445902L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.list();
		if (usuarios != null) {
			req.setAttribute("usuarios", usuarios);
		} else {
			req.setAttribute("flash", "No vendiste nada aún");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itinerarioUsuarios.jsp");
		dispatcher.forward(req, resp);
	}
}
