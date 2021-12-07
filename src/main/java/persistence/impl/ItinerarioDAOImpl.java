package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {
	public HashMap<Integer, Itinerario> findById(int idUsuario, HashMap<Integer, Atraccion> atracciones,
			HashMap<Integer, Promocion> promociones) {
		try {
			String sqlItinerarios = "SELECT * FROM itinerario WHERE id_usuario = ?";
			String sqlIdPromociones = "SELECT id_promocion FROM itinerario WHERE id_usuario = ? AND id_promocion IS NOT NULL";
			String sqlIdAtracciones = "SELECT id_atraccion FROM itinerario WHERE id_usuario = ? AND id_atraccion IS NOT NULL";
			HashMap<Integer, Itinerario> itinerario = new HashMap<Integer, Itinerario>();
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statementItinerario = conn.prepareStatement(sqlItinerarios);
			statementItinerario.setInt(1, idUsuario);
			ResultSet resultItinerario = statementItinerario.executeQuery();

			PreparedStatement declarIdPromociones = conn.prepareStatement(sqlIdPromociones);
			PreparedStatement declarIdAtracciones = conn.prepareStatement(sqlIdAtracciones);

			while (resultItinerario.next()) {
				int idItinerario = resultItinerario.getInt("id_itinerario");
				declarIdPromociones.setInt(1, idUsuario);
				declarIdAtracciones.setInt(1, idUsuario);

				ResultSet resultIdPromociones = declarIdPromociones.executeQuery();
				ResultSet resultIdAtracciones = declarIdAtracciones.executeQuery();

				itinerario.put(idItinerario, (toItinerario(idItinerario, idUsuario, atracciones, promociones,
						resultIdPromociones, resultIdAtracciones)));
			}
			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Itinerario toItinerario(int idItinerario, int idUsuario, HashMap<Integer, Atraccion> atracciones,
			HashMap<Integer, Promocion> promociones, ResultSet resultIdPromo, ResultSet resultIdAtrac) {
		try {
			List<Producto> listaCompra = new ArrayList<Producto>();

			while (resultIdPromo.next()) {
				int idPromocion = resultIdPromo.getInt("id_promocion");
				listaCompra.add(promociones.get(idPromocion));
			}
			while (resultIdAtrac.next()) {
				int idAtraccion = resultIdAtrac.getInt("id_atraccion");
				listaCompra.add(atracciones.get(idAtraccion));
			}
			return new Itinerario(idItinerario, idUsuario, listaCompra);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
