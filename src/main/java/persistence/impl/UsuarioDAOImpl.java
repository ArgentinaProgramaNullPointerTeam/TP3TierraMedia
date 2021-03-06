package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map.Entry;

import persistence.commons.ConnectionProvider;
import persistence.commons.DAOFactory;
import persistence.commons.MissingDataException;
import model.Itinerario;
import model.Usuario;
import model.nullObjects.NullUser;
import persistence.AtraccionDAO;
import persistence.ItinerarioDAO;
import persistence.PromocionDAO;
import persistence.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {
	public Usuario findByUsername(String nombre) {
		try {
			String sql = "SELECT u.id_usuario, u.nombre, u.password, u.dinero_disponible, u.tiempo_disponible, tipo.id_tipo_atraccion, tipo.nombre AS 'tipo_atraccion', u.is_admin, u.status "
					+ "FROM 'usuario' AS u INNER JOIN 'tipo_atraccion' AS tipo "
					+ "ON u.id_tipo_atraccion = tipo.id_tipo_atraccion WHERE u.status = '1' AND tipo.status = '1' AND u.nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, nombre);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
				ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
				AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

				Itinerario itinerarios = itinerarioDAO.findById(user.getId(),
						atraccionDAO.findAll(), promocionDAO.findAll(atraccionDAO.findAll()));
				if(itinerarios != null) {
					user.setItinerario(itinerarios);
				}
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario find(Integer id) {
		try {
			String sql = "SELECT u.id_usuario, u.nombre, u.password, u.dinero_disponible, u.tiempo_disponible, tipo.id_tipo_atraccion, tipo.nombre AS 'tipo_atraccion', u.is_admin, u.status "
					+ "FROM 'usuario' AS u INNER JOIN 'tipo_atraccion' AS tipo "
					+ "ON u.id_tipo_atraccion = tipo.id_tipo_atraccion WHERE u.status = '1' AND tipo.status = '1' AND u.id_usuario = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultados = statement.executeQuery();

			Usuario usuario = NullUser.build();
			if (resultados.next()) {
				usuario = toUsuario(resultados);
				ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
				AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

				Itinerario itinerarios = itinerarioDAO.findById(usuario.getId(),
						atraccionDAO.findAll(), promocionDAO.findAll(atraccionDAO.findAll()));
				if(itinerarios != null) {
					usuario.setItinerario(itinerarios);
				}
			}
			

			return usuario;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public HashMap<Integer, Usuario> findAll() {
		try {
			String sql = "SELECT u.id_usuario, u.nombre, u.password, u.dinero_disponible, u.tiempo_disponible, tipo.id_tipo_atraccion, tipo.nombre AS 'tipo_atraccion', u.is_admin, u.status "
					+ "FROM 'usuario' AS u INNER JOIN 'tipo_atraccion' AS tipo "
					+ "ON u.id_tipo_atraccion = tipo.id_tipo_atraccion WHERE u.status = '1' AND tipo.status = '1'";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			HashMap<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
			while (resultados.next()) {
				usuarios.put(resultados.getInt("id_usuario"), toUsuario(resultados));
			}

			for (Entry<Integer, Usuario> cadaUsuario : usuarios.entrySet()) {
				Usuario usuario = usuarios.get(cadaUsuario.getKey());
				ItinerarioDAO itinerarioDAO = DAOFactory.getItinerarioDAO();
				AtraccionDAO atraccionDAO = DAOFactory.getAtraccionDAO();
				PromocionDAO promocionDAO = DAOFactory.getPromocionDAO();

				Itinerario itinerarios = itinerarioDAO.findById(cadaUsuario.getKey(),
						atraccionDAO.findAll(), promocionDAO.findAll(atraccionDAO.findAll()));
				if(itinerarios != null) {
					usuario.setItinerario(itinerarios);
				}
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int insert(Usuario usuario) {
		try {
			String sql = "INSERT INTO usuario (nombre, password, dinero_disponible, tiempo_disponible, id_tipo_atraccion, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getPassword());
			statement.setInt(3, usuario.getDineroDisponible());
			statement.setDouble(4, usuario.getTiempoDisponible());
			statement.setInt(5, usuario.getAtraccionPreferida());
			statement.setInt(6, usuario.isAdmin()? 1:0);

			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuario SET nombre = ?, password = ?, dinero_disponible = ?, tiempo_disponible = ?, id_tipo_atraccion = ?, is_admin = ? WHERE id_usuario = ? AND status = 1";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getPassword());
			statement.setInt(3, usuario.getDineroDisponible());
			statement.setDouble(4, usuario.getTiempoDisponible());
			statement.setInt(5, usuario.getAtraccionPreferida());
			statement.setInt(6, usuario.isAdmin()? 1 :0);
			statement.setInt(7, usuario.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete(Usuario usuario) {
		try {
			String sql = "UPDATE usuario SET status = '0' WHERE id_usuario = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, usuario.getId());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Usuario toUsuario(ResultSet resultados) {
		try {
			return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getString(3),
					resultados.getInt(6), resultados.getString(7), resultados.getInt(4), resultados.getDouble(5), resultados.getInt(8) == 1,
					resultados.getInt(9) == 1);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
}
