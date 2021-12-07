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
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
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

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, 1);
		ArrayList<Producto> sugerenciasEsperadas = new ArrayList<Producto>();
		sugerenciasEsperadas.add(atraccion1);
		Itinerario itinerario = new Itinerario(1, 1, sugerenciasEsperadas);

		HashMap<Integer, Itinerario> itinerariosEsperados = new HashMap<Integer, Itinerario>();
		itinerariosEsperados.put(itinerario.getIdUsuario(), itinerario);

		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		HashMap<Integer, Itinerario> itinerariosObtenidos = itinerarioDAO.findById(1, atraccionesObtenidas,
				promocionesObtenidas);

		assertEquals(itinerariosEsperados, itinerariosObtenidos);
	}

}
