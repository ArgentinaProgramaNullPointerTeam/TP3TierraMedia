package persistence;

import java.util.HashMap;

import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import persistence.commons.GenericDAO;

public interface ItinerarioDAO extends GenericDAO<Itinerario> {
	public abstract Itinerario findById(int id, HashMap<Integer, Atraccion> atracciones,
			HashMap<Integer, Promocion> promociones);	
}
