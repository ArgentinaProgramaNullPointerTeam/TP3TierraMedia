package controller.session;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import services.LoginService;
import services.producto.ProductoService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 8308079314140233763L;
	private LoginService loginService;
	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		loginService = new LoginService();
		productoService = new ProductoService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Usuario usuario = loginService.login(username, password);

		if (!usuario.isNull()) {
			req.getSession().setAttribute("usuario", usuario);
			req.getSession().setAttribute("id", usuario.getId());
			
			// se trae de la sesion la preferencia que se guardo cuando se logueo. Es un int
			// porque es un FK que viene de la BD
			List<Producto> productos = productoService.list((int) req.getSession().getAttribute("id"));
			req.setAttribute("productos", productos);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("flash", "Nombre de usuario o contraseña incorrectos");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
