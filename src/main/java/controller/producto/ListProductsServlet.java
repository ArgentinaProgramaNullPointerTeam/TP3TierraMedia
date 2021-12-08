package controller.producto;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import services.producto.ProductoService;

@WebServlet("/producto/list.do")
public class ListProductsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 4269229300666995937L;
	private ProductoService productoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productoService = new ProductoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// se trae de la sesion la preferencia que se guardo cuando se logueo. Es un int
		// porque es un FK que viene de la BD
		List<Producto> productos = productoService.list((int) req.getSession().getAttribute("id"));
		req.setAttribute("productos", productos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/productos.jsp");
		dispatcher.forward(req, resp);

	}

}
