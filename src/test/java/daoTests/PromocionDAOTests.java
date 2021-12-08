package daoTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Atraccion;
import model.Promocion;
import model.PromocionPorcentual;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class PromocionDAOTests {

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
	public void cargarPromocionesTest() {
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, 1);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, 1);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		Promocion promoEsperada = new PromocionPorcentual(1, "Pack Aventura", 1, 2, atraccionesEsperadas, "Porcentual",
				0.2, 1);
		HashMap<Integer, Promocion> promocionesEsperadas = new HashMap<Integer, Promocion>();
		promocionesEsperadas.put(promoEsperada.getId(), promoEsperada);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		assertEquals(promocionesEsperadas, promocionesObtenidas);
	}
}