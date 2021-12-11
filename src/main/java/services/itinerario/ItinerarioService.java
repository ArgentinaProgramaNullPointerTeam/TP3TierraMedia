package services.itinerario;

import model.Itinerario;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	public Itinerario list(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		Itinerario itinerario = DAOFactory.getItinerarioDAO().findById(id, atraccionDAO.findAll(), promocionDAO.findAll(atraccionDAO.findAll()));
		return itinerario;
	}
}
