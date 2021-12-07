package persistence;

import java.util.HashMap;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDAO extends GenericDAO<Atraccion> {
	public abstract HashMap<Integer, Atraccion> findAll();
}
