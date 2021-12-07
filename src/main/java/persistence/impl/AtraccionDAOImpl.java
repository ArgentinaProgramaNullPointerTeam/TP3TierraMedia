package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import model.Atraccion;
import persistence.AtraccionDAO;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AtraccionDAOImpl implements AtraccionDAO {
	public HashMap<Integer, Atraccion> findAll() {
		try {
			String sql = "SELECT a.id_atraccion, a.nombre, a.costo_visita, a.cupo, a.tiempo_visita, tipo.id_tipo_atraccion, tipo.nombre as 'tipo_atraccion' , a.status "
					+ "FROM atraccion a INNER JOIN tipo_atraccion tipo "
					+ "ON a.id_tipo_atraccion = tipo.id_tipo_atraccion " + "WHERE a.status = '1' AND tipo.status = '1'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			HashMap<Integer, Atraccion> atracciones = new HashMap<Integer, Atraccion>();
			while (resultados.next()) {
				atracciones.put(resultados.getInt("id_atraccion"), toAtraccion(resultados));
			}

			return atracciones;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Atraccion toAtraccion(ResultSet resultados) {
		try {
			return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getInt(3),
					resultados.getDouble(5), resultados.getInt(4), resultados.getInt(6), resultados.getInt(8));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
