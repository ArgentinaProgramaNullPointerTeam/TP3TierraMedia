package services.promocion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAXB;
import model.PromocionAbsoluta;
import model.PromocionPorcentual;
import persistence.AtraccionDAO;
import persistence.PromocionDAO;
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

	public Promocion create(String tipo, String nombre, Integer tipoAtraccion, Integer cantAtracciones,
			Double descuentoP, Integer descuentoA, Integer atraccion1, Integer atraccion2, Integer atraccion3) {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Promocion promocion = null;
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		if (tipo.equals("Absoluta")) {
			atracciones.add(atraccionDAO.find(atraccion1));
			atracciones.add(atraccionDAO.find(atraccion2));
			promocion = new PromocionAbsoluta(nombre, tipoAtraccion, cantAtracciones, atracciones, tipo, descuentoA);
		} else if (tipo.equals("Porcentual")) {
			atracciones.add(atraccionDAO.find(atraccion1));
			atracciones.add(atraccionDAO.find(atraccion2));
			promocion = new PromocionPorcentual(nombre, tipoAtraccion, cantAtracciones, atracciones, tipo, descuentoP > 0 ? descuentoP/100 : 0);
		} else if (tipo.equals("AXB")) {
			atracciones.add(atraccionDAO.find(atraccion1));
			atracciones.add(atraccionDAO.find(atraccion2));
			atracciones.add(atraccionDAO.find(atraccion3));
			promocion = new PromocionAXB(nombre, tipoAtraccion, cantAtracciones, atracciones, tipo, atraccion3);
		}

		if (promocion.isValid()) {
			PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
			promocionDAO.insert(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return promocion;
	}

	public Promocion find(Integer id) {
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atracciones = atraccionDAO.findAll();
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		return promocionDAO.find(id, atracciones);
	}

	public Promocion update(Integer id, String nombre, String tipo, Integer tipoAtraccion, Double descuentoP,
			Integer descuentoA, Integer atraccion1, Integer atraccion2, Integer atraccion3) {
		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
		atracciones = atraccionDAO.findAll();
		Promocion promocion = promocionDAO.find(id, atracciones);
		List<Atraccion> atraccionesEnPromo = new ArrayList<Atraccion>();
		promocion.setNombre(nombre);
		promocion.setTipoDePromocion(tipo);
		atraccionesEnPromo.add(atraccionDAO.find(atraccion1));
		atraccionesEnPromo.add(atraccionDAO.find(atraccion2));
		if (tipo.equals("AXB")) {
			PromocionAXB nuevaPromo1 = (PromocionAXB) promocion;
			nuevaPromo1.setIdAtraccionGratuita(atraccion3);
			atraccionesEnPromo.add(atraccionDAO.find(atraccion3));
		} else if (tipo.equals("Absoluta")) {
			PromocionAbsoluta nuevaPromo2 = (PromocionAbsoluta) promocion;
			nuevaPromo2.setDescuento(descuentoA);
		} else if (tipo.equals("Porcentual")) {
			PromocionPorcentual nuevaPromo3 = (PromocionPorcentual) promocion;
			nuevaPromo3.setDescuento(descuentoP);
		}
		promocion.setAtracciones(atraccionesEnPromo);
		promocion.setTipoAtracciones(tipoAtraccion);

		if (promocion.isValid()) {
			promocionDAO.update(promocion);
			// XXX: si no devuelve "1", es que hubo más errores
		}
		return promocion;
	}

	public void delete(Integer id) {
		Promocion promocion = new PromocionAbsoluta(id, "", 0, 0, null, "", 0, false);

		PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();
		promocionDAO.delete(promocion);
	}
}
