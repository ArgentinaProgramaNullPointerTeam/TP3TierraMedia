package services.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import model.ComparadorDeProductos;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class ProductoService {
	private List<Producto> productos = new ArrayList<Producto>();
	private List<Producto> productosComprables = new ArrayList<Producto>();
	private HashMap<Integer, Atraccion> atracciones = new HashMap<Integer, Atraccion>();
	private HashMap<Integer, Promocion> promociones = new HashMap<Integer, Promocion>();

	private void leerAtracciones() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atracciones = atraccionDAO.findAll();
	}

	private void leerPromociones() {
		if (!atracciones.isEmpty()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promociones = promocionDAO.findAll(this.atracciones);
		}
	}
	//Se arman los productos dependiendo si el usuario puede comprar o si hay cupo
	public List<Producto> list(int id) {
		this.leerAtracciones();
		this.leerPromociones();
		if (!atracciones.isEmpty()) {
			productos.addAll(this.promociones.values());
			productos.addAll(this.atracciones.values());
			Usuario usuario = DAOFactory.getUsuarioDAO().find(id);
			Collections.sort(productos, new ComparadorDeProductos(usuario.getAtraccionPreferida()));
			for (Producto cadaProducto : productos) {
				if (usuario.puedeComprar(cadaProducto) && cadaProducto.hayCupo()) {
					productosComprables.add(cadaProducto);
				}
			}
		}
		return productosComprables;
	}
}
