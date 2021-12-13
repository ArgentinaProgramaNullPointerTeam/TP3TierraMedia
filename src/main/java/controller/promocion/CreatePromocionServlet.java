package controller.promocion;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import services.atraccion.AtraccionService;
import services.promocion.PromocionService;

@WebServlet("/createPromo.adm")
public class CreatePromocionServlet extends HttpServlet {
	private static final long serialVersionUID = -6309954500106817437L;
	private PromocionService promocionService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Atraccion> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formPromociones.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer cantAtracciones = 0, atraccion3 = 0, descuentoA = 0;
		Double descuentoP = 0.0;
		String nombre = req.getParameter("nombre");
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
		String tipo = req.getParameter("tipo");
		if (tipo.equals("AXB")) {
			cantAtracciones = 3;
			atraccion3 = Integer.parseInt(req.getParameter("atraccion3"));
		} else {
			cantAtracciones = 2;
		}
		if (tipo.equals("Porcentual")) {
			descuentoP = Double.parseDouble(req.getParameter("descuento"));

		} else if (tipo.equals("Absoluta")) {
			descuentoA = Integer.parseInt(req.getParameter("descuento"));
		}
		Integer atraccion1 = Integer.parseInt(req.getParameter("atraccion1"));
		Integer atraccion2 = Integer.parseInt(req.getParameter("atraccion2"));

		Promocion promocion = promocionService.create(tipo, nombre, tipoAtraccion, cantAtracciones, descuentoP,
				descuentoA, atraccion1, atraccion2, atraccion3);

		if (promocion.isValid()) {
			resp.sendRedirect("/TP3TierraMedia/abm.adm");
		} else {
			req.setAttribute("promocion", promocion);
			req.setAttribute("errores", promocion.getErrors());
			List<Atraccion> atracciones = atraccionService.list();
			req.setAttribute("atracciones", atracciones);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/formPromociones.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
