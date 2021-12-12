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

@WebServlet("/create.adm")
public class CreateUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = -5021110797245542845L;
	private UsuarioService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/attractions/create.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");
		Integer atraccionPreferida = Integer.parseInt(req.getParameter("atraccionPreferida"));
		Integer dineroDisponible = Integer.parseInt(req.getParameter("dineroDisponible"));
		Double tiempoDisponible = Double.parseDouble(req.getParameter("tiempoDisponible"));
		Integer isAdmin = Integer.parseInt(req.getParameter("isAdmin"));
		
		Usuario usuario = usuarioService.create(nombre, password, atraccionPreferida, dineroDisponible, tiempoDisponible, isAdmin);
		if (usuario.isValid()) {
			resp.sendRedirect("/TP3TierraMedia/abm.adm");
		} else {
			req.setAttribute("usuario", usuario);
			req.setAttribute("errores", usuario.getErrores());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formUsuarios.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
