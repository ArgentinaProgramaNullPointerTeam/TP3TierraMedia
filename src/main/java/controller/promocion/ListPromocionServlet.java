package controller.promocion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promocion;
import services.promocion.PromocionService;

@WebServlet("/producto/delete.adm")
public class ListPromocionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 4269229300666995937L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocion> promos = promocionService.list();
		req.setAttribute("promociones", promos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/algoaca.jsp");
		dispatcher.forward(req, resp);

	}
}
