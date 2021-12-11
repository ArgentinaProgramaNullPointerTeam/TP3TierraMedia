package controller.itinerario;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import services.itinerario.ItinerarioService;

@WebServlet("/itinerario.do")
public class ListItinerarioServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 985007788312045740L;
	private ItinerarioService itinerarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = (Integer) (req.getSession().getAttribute("id"));
		Itinerario itinerario = itinerarioService.list(id);
		if (itinerario != null) {
			req.setAttribute("itinerario", itinerario);
		} else {
			req.setAttribute("flash", "No compraste nada aún");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itinerario.jsp");
		dispatcher.forward(req, resp);
	}
}
