package services.atraccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import persistence.commons.DAOFactory;

public class AtraccionService {
	public List<Atraccion> list() {
		HashMap<Integer, Atraccion> ListAtracciones = DAOFactory.getAtraccionDAO().findAll();
		List<Atraccion> atracciones = new ArrayList<Atraccion>(ListAtracciones.values());
		return atracciones;
	}
}
