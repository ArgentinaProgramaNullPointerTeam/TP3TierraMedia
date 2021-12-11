package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Usuario;
import services.atraccion.AtraccionService;
import services.promocion.PromocionService;
import services.usuario.UsuarioService;

@WebServlet("/abm.adm")
public class ListABMServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -3922567452066205289L;
	private UsuarioService usuarioService;
	private PromocionService promocionService;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> usuarios = usuarioService.list();
		List<Promocion> promos = promocionService.list();
		List<Atraccion> atracciones = atraccionService.list();
		
		req.setAttribute("usuarios", usuarios);
		req.setAttribute("promociones", promos);
		req.setAttribute("atracciones", atracciones);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
		dispatcher.forward(req, resp);

	}
}