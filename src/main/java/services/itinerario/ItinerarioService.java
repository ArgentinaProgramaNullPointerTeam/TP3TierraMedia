package services.itinerario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Itinerario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	public List<Itinerario> list(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		HashMap<Integer, Itinerario> ListItinerario = DAOFactory.getItinerarioDAO().findById(id, atraccionDAO.findAll(), promocionDAO.findAll(atraccionDAO.findAll()));
		List<Itinerario> itinerario = new ArrayList<Itinerario>(ListItinerario.values());
		return itinerario;
	}
}
