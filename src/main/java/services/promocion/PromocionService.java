package services.promocion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import persistence.AtraccionDAO;
import persistence.commons.DAOFactory;

public class PromocionService {
	private HashMap<Integer, Atraccion> atracciones = new HashMap<Integer, Atraccion>();
	public List<Promocion> list() {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atracciones = atraccionDAO.findAll();
		HashMap<Integer, Promocion> ListPromociones = DAOFactory.getPromocionDAO().findAll(this.atracciones);
		List<Promocion> atracciones = new ArrayList<Promocion>(ListPromociones.values());
		return atracciones;
	}
}
