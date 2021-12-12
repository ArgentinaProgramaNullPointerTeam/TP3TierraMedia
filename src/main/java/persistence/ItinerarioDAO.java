package persistence;

import java.util.HashMap;

import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {
	public abstract Itinerario findById(int id, HashMap<Integer, Atraccion> atracciones,
			HashMap<Integer, Promocion> promociones);
	public int comprar(Usuario usuario, Producto producto);
}
