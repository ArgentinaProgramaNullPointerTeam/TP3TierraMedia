package services.atraccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class AtraccionService {
	public List<Atraccion> list() {
		HashMap<Integer, Atraccion> ListAtracciones = DAOFactory.getAtraccionDAO().findAll();
		List<Atraccion> atracciones = new ArrayList<Atraccion>(ListAtracciones.values());
		return atracciones;
	}

	public Atraccion create(String nombre, Integer costo, Double duracion, Integer cupo, Integer tipoAtraccion) {
		Atraccion atraccion = new Atraccion(nombre, costo, duracion, cupo, tipoAtraccion);
		if (atraccion.isValid()) {
			AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
			atraccionDAO.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return atraccion;
	}

	public Atraccion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		return atraccionDAO.find(id);
	}

	public Atraccion update(Integer id, String nombre, Integer costo, Integer cupo, Double duracion, int tipoAtraccion) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		Atraccion atraccion = atraccionDAO.find(id);
		atraccion.setNombre(nombre);
		atraccion.setCostoDeVisita(costo);
		atraccion.setCupo(cupo);
		atraccion.setTiempoDeVisita(duracion);
		atraccion.setTipoAtracciones(tipoAtraccion);

		if (atraccion.isValid()) {
			atraccionDAO.update(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}
	
	public void delete(Integer id) {
		Atraccion atraccion = new Atraccion(id, "", 0, 0.0, 0, 0, false);

		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atraccionDAO.delete(atraccion);
	}
}
