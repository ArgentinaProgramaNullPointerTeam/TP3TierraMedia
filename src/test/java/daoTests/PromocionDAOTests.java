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
import model.PromocionAbsoluta;
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
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, "Aventura", true);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		Promocion promoEsperada = new PromocionPorcentual(1, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Porcentual",
				0.2, true);
		HashMap<Integer, Promocion> promocionesEsperadas = new HashMap<Integer, Promocion>();
		promocionesEsperadas.put(promoEsperada.getId(), promoEsperada);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		assertEquals(promocionesEsperadas, promocionesObtenidas);
	}

	@Test
	public void insertPromocionesTest() {
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, "Aventura", true);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		Promocion promoEsperada1 = new PromocionPorcentual(1, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Porcentual",
				0.2, true);
		Promocion promoEsperada2 = new PromocionAbsoluta(2, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Absoluta", 50,
				true);

		HashMap<Integer, Promocion> promocionesEsperadas = new HashMap<Integer, Promocion>();
		promocionesEsperadas.put(promoEsperada1.getId(), promoEsperada1);
		promocionesEsperadas.put(promoEsperada2.getId(), promoEsperada2);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.insert(promoEsperada2);

		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		assertEquals(promocionesEsperadas, promocionesObtenidas);
	}

	@Test
	public void deletePromocionesTest() {
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, "Aventura", true);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		Promocion promo = new PromocionPorcentual(1, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Porcentual", 0.2, true);
		HashMap<Integer, Promocion> promocionesEsperadas = new HashMap<Integer, Promocion>();

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promo);

		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		assertEquals(promocionesEsperadas, promocionesObtenidas);
	}

	@Test
	public void updatePromocionesTest() {
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, "Aventura", true);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		Promocion promo = new PromocionPorcentual(1, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Porcentual", 0.4, true);
		HashMap<Integer, Promocion> promocionesEsperadas = new HashMap<Integer, Promocion>();
		promocionesEsperadas.put(promo.getId(), promo);
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.update(promo);

		HashMap<Integer, Promocion> promocionesObtenidas = promocionDAO.findAll(atraccionesObtenidas);
		assertEquals(promocionesEsperadas, promocionesObtenidas);
	}
	
	@Test
	public void findTest() {
		Atraccion atraccion1 = new Atraccion(2, "Minas Tirith", 2, 2.5, 25, 1, "Aventura", true);
		Atraccion atraccion2 = new Atraccion(3, "La Comarca", 3, 1, 150, 1, "Aventura", true);
		ArrayList<Atraccion> atraccionesEsperadas = new ArrayList<Atraccion>();
		atraccionesEsperadas.add(atraccion1);
		atraccionesEsperadas.add(atraccion2);
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Promocion promoEsperada = new PromocionPorcentual(1, "Pack Aventura", 1, "Aventura", 2, atraccionesEsperadas, "Porcentual",
				0.4, true);
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		HashMap<Integer, Atraccion> atraccionesObtenidas = atraccionDAO.findAll();
		Promocion promoObtenida = promocionDAO.find(1, atraccionesObtenidas);

		assertEquals(promoEsperada, promoObtenida);
	}

}
