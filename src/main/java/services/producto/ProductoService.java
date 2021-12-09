package services.producto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Atraccion;
import model.ComparadorDeProductos;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;
import persistence.UsuarioDAO;

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
	
	public Map<String, String> buy(Integer usuarioId, Integer productoId, Boolean esPromo) {
		UsuarioDAO usuarioDAO = DAOFactory.getUsuarioDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Map<String, String> errors = new HashMap<String, String>();
		Producto producto = null;
		Usuario usuario = usuarioDAO.find(usuarioId);
		if (esPromo) {
			this.leerAtracciones();
			producto = promocionDAO.find(productoId, atracciones);
		}else {
			producto = atraccionDAO.find(productoId);
		}

		if (!producto.hayCupo()) {
			errors.put("producto", "No hay cupo disponible");
		}
		if (!usuario.puedeComprar(producto)) {
			errors.put("usuario", "No puedes comprar este producto");
		}

		if (errors.isEmpty()) {
			ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
			usuario.comprar(producto);
			usuarioDAO.update(usuario); //se modifica las monedas y el tiempo
			itinerarioDAO.insert(usuario.getItinerario());
			// el update de atraccion se hace de forma individual
			// por eso no se usa una lista sino que se recorre la lista antes y se envia la
			// atraccion a updatear
			if (producto.esPromocion()) {
				List<Atraccion> atracciones = new ArrayList<Atraccion>();
				Promocion miPromo = (Promocion) producto;
				atracciones.addAll(miPromo.getAtracciones());
				for (Atraccion atraccion : atracciones) {
					atraccionDAO.update(atraccion); //se modifica el cupo
				}
			} else {
				atraccionDAO.update((Atraccion) producto); //se modifica el cupo
			}
		}

		return errors;

	}
}
