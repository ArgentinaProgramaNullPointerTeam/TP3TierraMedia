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

@WebServlet("/editPromo.adm")
public class EditPromocionServlet extends HttpServlet {
	private static final long serialVersionUID = -3169608166770960069L;
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
		Integer id = Integer.parseInt(req.getParameter("id"));

		Promocion promocion = promocionService.find(id);
		req.setAttribute("promocion", promocion);
		List<Atraccion> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarFormPromocion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer atraccion3 = 0, descuentoA = 0;
		Double descuentoP = 0.0;
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String tipo = req.getParameter("tipo");
		// Integer cost = req.getParameter("cost").trim() == "" ? null :
		// Integer.parseInt(req.getParameter("cost"));
		if (tipo.equals("AXB")) {
			atraccion3 = Integer.parseInt(req.getParameter("atraccion3"));
			//el descuento en el AXB es la atraccion misma.
		} else if (tipo.equals("Porcentual")) {
			descuentoP = Double.parseDouble(req.getParameter("descuento"));
		} else if (tipo.equals("Absoluta")) {
			descuentoA = Integer.parseInt(req.getParameter("descuento"));
		}
		Integer tipoAtraccion = Integer.parseInt(req.getParameter("tipoAtraccion"));
		Integer atraccion1 = Integer.parseInt(req.getParameter("atraccion1"));
		Integer atraccion2 = Integer.parseInt(req.getParameter("atraccion2"));
		Promocion promocion = promocionService.update(id, nombre, tipo, tipoAtraccion, descuentoP, descuentoA,
				atraccion1, atraccion2, atraccion3);

		if (promocion.isValid()) {
			resp.sendRedirect("/TP3TierraMedia/abm.adm");
		} else {
			req.setAttribute("atraccion", promocion);
			req.setAttribute("errores", promocion.getErrors());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarFormPromocion.jsp");;
			dispatcher.forward(req, resp);
		}
	}
}
