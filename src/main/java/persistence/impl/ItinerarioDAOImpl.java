package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Itinerario;
import model.Producto;
import model.Promocion;
import model.Usuario;
import persistence.ItinerarioDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class ItinerarioDAOImpl implements ItinerarioDAO {
	public Itinerario findById(int idUsuario, HashMap<Integer, Atraccion> atracciones,
			HashMap<Integer, Promocion> promociones) {
		try {
			String sqlItinerarios = "SELECT * FROM itinerario WHERE id_usuario = ?";
			String sqlIdPromociones = "SELECT id_promocion FROM itinerario WHERE id_usuario = ? AND id_promocion IS NOT NULL";
			String sqlIdAtracciones = "SELECT id_atraccion FROM itinerario WHERE id_usuario = ? AND id_atraccion IS NOT NULL";
			Itinerario itinerario = null;
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

				itinerario = toItinerario(idItinerario, idUsuario, atracciones, promociones, resultIdPromociones,
						resultIdAtracciones);
			}
			return itinerario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Itinerario itinerario) {
		int rows = 0;
		try {
			List<Producto> listaCompra = new LinkedList<Producto>();
			String sqlPromo = "INSERT INTO itinerario (id_usuario, id_promocion) VALUES (?, ?)";
			String sqlAtraccion = "INSERT INTO itinerario (id_usuario, id_atraccion) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement promoComprada = conn.prepareStatement(sqlPromo);
			PreparedStatement atracComprada = conn.prepareStatement(sqlAtraccion);

			listaCompra = itinerario.getListaCompra();

			for (Producto producto : listaCompra) {
				if (producto.esPromocion()) {
					promoComprada.setInt(1, itinerario.getIdUsuario());
					promoComprada.setInt(2, producto.getId());
					rows = promoComprada.executeUpdate();
				} else {
					atracComprada.setInt(1, itinerario.getIdUsuario());
					atracComprada.setInt(2, producto.getId());
					rows = atracComprada.executeUpdate();
				}
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int update(Itinerario itinerario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Itinerario itinerario) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int comprar(Usuario usuario, Producto producto) {
		int rows = 0;
		try {
			String sqlPromo = "INSERT INTO itinerario (id_usuario, id_promocion) VALUES (?, ?)";
			String sqlAtraccion = "INSERT INTO itinerario (id_usuario, id_atraccion) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement promoComprada = conn.prepareStatement(sqlPromo);
			PreparedStatement atracComprada = conn.prepareStatement(sqlAtraccion);

			if (producto.esPromocion()) {
				promoComprada.setInt(1, usuario.getId());
				promoComprada.setInt(2, producto.getId());
				rows = promoComprada.executeUpdate();
			} else {
				atracComprada.setInt(1, usuario.getId());
				atracComprada.setInt(2, producto.getId());
				rows = atracComprada.executeUpdate();
			}
			return rows;
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
