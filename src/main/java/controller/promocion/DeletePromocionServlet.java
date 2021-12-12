package controller.promocion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.promocion.PromocionService;

@WebServlet("/deletePromo.adm")
public class DeletePromocionServlet extends HttpServlet {
	private static final long serialVersionUID = -4512975282736380916L;
	private PromocionService promocionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		promocionService.delete(id);

		resp.sendRedirect("/TP3TierraMedia/abm.adm");
	}
}
