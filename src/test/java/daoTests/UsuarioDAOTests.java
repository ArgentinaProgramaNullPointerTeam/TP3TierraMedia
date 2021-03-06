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
import model.Usuario;
import persistence.UsuarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;

public class UsuarioDAOTests {
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
	public void cargarUsuariosTest() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> compra = new ArrayList<Producto>();
		compra.add(atraccion1);

		Usuario usuarioEsperado = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 10, 8, false, true);
		Itinerario itinerarioEsperado = new Itinerario(1, usuarioEsperado.getId(), compra);
		usuarioEsperado.setItinerario(itinerarioEsperado);
		HashMap<Integer, Usuario> usuariosEsperados = new HashMap<Integer, Usuario>();
		usuariosEsperados.put(usuarioEsperado.getId(), usuarioEsperado);

		HashMap<Integer, Usuario> usuariosObtenidos = usuarioDAO.findAll();

		assertEquals(usuariosEsperados, usuariosObtenidos);
	}

	@Test
	public void findUsuarioNameTest() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> compra = new ArrayList<Producto>();
		compra.add(atraccion1);
		Usuario usuarioEsperado = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 10, 8, false, true);
		Itinerario itinerarioEsperado = new Itinerario(1, usuarioEsperado.getId(), compra);
		usuarioEsperado.setItinerario(itinerarioEsperado);
		Usuario usuarioObtenido = usuarioDAO.findByUsername("Eowyn");
		assertEquals(usuarioEsperado, usuarioObtenido);
	}

	@Test
	public void findUsuarioTest() {
		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> compra = new ArrayList<Producto>();
		compra.add(atraccion1);
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		Usuario usuarioEsperado = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 10, 8, false, true);
		Itinerario itinerarioEsperado = new Itinerario(1, usuarioEsperado.getId(), compra);
		usuarioEsperado.setItinerario(itinerarioEsperado);
		Usuario usuarioObtenido = usuarioDAO.find(1);
		assertEquals(usuarioEsperado, usuarioObtenido);
	}

	@Test
	public void insertarUsuarioTest() {

		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> compra = new ArrayList<Producto>();
		compra.add(atraccion1);

		Usuario usuarioEsperado1 = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 10, 8, false, true);
		Usuario usuarioEsperado2 = new Usuario(2, "Gandalf", "pass", 1, "Aventura", 8, 5.5, false, true);
		Itinerario itinerarioEsperado = new Itinerario(1, usuarioEsperado1.getId(), compra);
		usuarioEsperado1.setItinerario(itinerarioEsperado);

		HashMap<Integer, Usuario> usuariosEsperados = new HashMap<Integer, Usuario>();
		usuariosEsperados.put(usuarioEsperado1.getId(), usuarioEsperado1);
		usuariosEsperados.put(usuarioEsperado2.getId(), usuarioEsperado2);

		usuarioDAO.insert(usuarioEsperado2);
		HashMap<Integer, Usuario> usuariosObtenidos = usuarioDAO.findAll();
		assertEquals(usuariosEsperados, usuariosObtenidos);
	}

	@Test
	public void updateUsuarioTest() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

		Atraccion atraccion1 = new Atraccion(1, "Moria", 1, 1, 6, 1, "Aventura", true);
		ArrayList<Producto> compra = new ArrayList<Producto>();
		compra.add(atraccion1);

		Usuario usuarioEsperado1 = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 8, 8, false, true);

		Itinerario itinerarioEsperado = new Itinerario(1, usuarioEsperado1.getId(), compra);
		usuarioEsperado1.setItinerario(itinerarioEsperado);

		HashMap<Integer, Usuario> usuariosEsperados = new HashMap<Integer, Usuario>();
		usuariosEsperados.put(usuarioEsperado1.getId(), usuarioEsperado1);

		usuarioDAO.update(usuarioEsperado1);
		HashMap<Integer, Usuario> usuariosObtenidos = usuarioDAO.findAll();
		assertEquals(usuariosEsperados, usuariosObtenidos);
	}

	@Test
	public void deleteUsuarioTest() {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();

		Usuario usuario = new Usuario(1, "Eowyn", "pass", 1, "Aventura", 10, 8, false, true);

		HashMap<Integer, Usuario> usuariosEsperados = new HashMap<Integer, Usuario>();

		usuarioDAO.delete(usuario);
		HashMap<Integer, Usuario> usuariosObtenidos = usuarioDAO.findAll();
		assertEquals(usuariosEsperados, usuariosObtenidos);
	}
}
