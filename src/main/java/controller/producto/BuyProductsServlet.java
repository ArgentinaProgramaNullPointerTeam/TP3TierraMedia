package controller.producto;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.producto.ProductoService;

@WebServlet("/buy.do")
public class BuyProductsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -7794584260712569635L;
	ProductoService productService;

	@Override
	public void init() throws ServletException {
		super.init();
		productService = new ProductoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Integer esPromo = Integer.parseInt(req.getParameter("esPromo"));
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		Map<String, String> errors = productService.buy(user.getId(), id, esPromo == 1);	
		
		if (errors.isEmpty()) {
			req.setAttribute("success", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}
		Usuario usuarioActualizado = DAOFactory.getUsuarioDAO().find(user.getId());
		req.getSession().setAttribute("usuario", usuarioActualizado);
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/index.do");
		dispatcher.forward(req, resp);
	}
}
