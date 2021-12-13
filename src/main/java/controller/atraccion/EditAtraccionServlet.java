package controller.atraccion;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.atraccion.AtraccionService;

@WebServlet("/editAtraccion.adm")
public class EditAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 6362079201415839496L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccionEditar", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarFormAtraccion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Integer costo = Integer.parseInt(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null :
		// Integer.parseInt(req.getParameter("cost"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		Double duracion = Double.parseDouble(req.getParameter("duracion"));
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));

		Atraccion atraccion = atraccionService.update(id, nombre, costo, cupo, duracion, tipoAtraccion);

		if (atraccion.isValid()) {
			resp.sendRedirect("/TP3TierraMedia/abm.adm");
		} else {
			req.setAttribute("atraccionEditar", atraccion);
			req.setAttribute("errores", atraccion.getErrors());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarFormAtraccion.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
