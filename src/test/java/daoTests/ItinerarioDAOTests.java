package daoTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class ItinerarioDAOTests {

	Connection conexion;

	@Before
	public void setUp() throws Exception {
		conexion = ConnectionProvider.getConnection("src/test/resources/tierra_media_test.db");
		conexion.setAutoCommit(false);
	}

	@After
	public void tearDown() throws Exception {
		conexion.rollback();
		conexion.setAutoCommit(true);
	}

	@Test
	public void cargarItinerariosTest() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> sugerenciasEsperadas = new ArrayList<Producto>();
		sugerenciasEsperadas.add(atraccion1);
		Itinerario itinerariosEsperados = new Itinerario(1, 1, sugerenciasEsperadas);

		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		Itinerario itinerariosObtenidos = itinerarioDAO.findById(1, atraccionesObtenidas,
				promocionesObtenidas);

		assertEquals(itinerariosEsperados, itinerariosObtenidos);
	}
	
	@Test
	public void insertarItinerarioTest() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura",true);
		Atraccion atraccion2 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		
		ArrayList<Producto> sugerenciasEsperadas = new ArrayList<Producto>();
		sugerenciasEsperadas.add(atraccion1);
		sugerenciasEsperadas.add(atraccion2);

		Itinerario itinerarioEsperado = new Itinerario(1, 1, sugerenciasEsperadas);
		itinerarioEsperado.setCostoItinerario(2);
		itinerarioEsperado.setDuracionItinerario(2.5);

		HashMap<Integer, Usuario> usuariosObtenidos = usuarioDAO.findAll();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		Itinerario itinerariosObtenidos = itinerarioDAO.findById(1, atraccionesObtenidas,
				promocionesObtenidas);

		Usuario usuarioObtenido = usuariosObtenidos.get(1);
		usuarioObtenido.setItinerario(itinerariosObtenidos);
		usuarioObtenido.comprar(atraccion2);

		usuarioDAO.update(usuarioObtenido);
		itinerarioDAO.insert(itinerariosObtenidos);
		assertEquals(itinerarioEsperado, itinerariosObtenidos);
	}
}
