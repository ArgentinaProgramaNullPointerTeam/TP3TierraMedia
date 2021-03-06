package controller.usuario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.usuario.UsuarioService;

@WebServlet("/editarUsuario.adm")
public class EditUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = -4574907080780188953L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario usuario = usuarioService.find(id);
		req.setAttribute("usuarioEditar", usuario);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formEditarUsuario.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");
		Integer atraccionPreferida = Integer.parseInt(req.getParameter("atraccionPreferida"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null :
		// Integer.parseInt(req.getParameter("cost"));
		Integer dineroDisponible = Integer.parseInt(req.getParameter("dineroDisponible"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));

		Usuario usuario = usuarioService.update(id, nombre, password, atraccionPreferida, dineroDisponible, tiempoDisponible, isAdmin, 1);
	
		if (usuario.isValid()) {
			resp.sendRedirect("/TP3TierraMedia/abm.adm");
		} else {
			req.setAttribute("usuarioEditar", usuario);
			req.setAttribute("errores", usuario.getErrores());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formEditarUsuario.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
