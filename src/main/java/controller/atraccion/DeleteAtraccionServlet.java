package controller.atraccion;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.atraccion.AtraccionService;

@WebServlet("/deleteAtraccion.adm")
public class DeleteAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 4307383395129280909L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		atraccionService.delete(id);

		resp.sendRedirect("/TP3TierraMedia/abm.adm");
	}
}
