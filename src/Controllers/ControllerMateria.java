package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import Model.Materia;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploMVC.ConnectionManager;

public class ControllerMateria {
	
	private static Connection conn = null;
	
	
	/**
	 * 
	 * @return
	 */
	public static List<Materia> findAll() {
		List<Materia> materias = new ArrayList<Materia>();
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from materia");
			
			while (rs.next()) {
				Materia materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAcronimo(rs.getString("acronimo"));
				materia.setCurso_id(rs.getInt("curso_id"));
				materias.add(materia);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return materias;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static Materia getEntidadFromResultSet(String sql) {
		Materia materia = null;
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAcronimo(rs.getString("acronimo"));
				materia.setCurso_id(rs.getInt("curso_id"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return materia;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public static Materia cargarPrimerRegistro() {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia order by id limit 1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static Materia cargarUltimoRegistro() {

		return getEntidadFromResultSet("SELECT * FROM centroeducativo.materia\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.materia);");
		
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Materia siguienteRegistro(int actualId) {
		
		return getEntidadFromResultSet(
				"select * from materia where id > "+ actualId +" order by id limit 1");
	
	}
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Materia anteriorRegistro(int actualId) {
		
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.materia where id < " + actualId + " order by id desc limit 1");
	
	}
	
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (Materia m) {
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update materia set nombre = ?, acronimo = ?, curso_id = ? where id = ?");
		
			ps.setString(1, m.getNombre());
			ps.setString(2, m.getAcronimo());
			ps.setInt(3, m.getCurso_id());
			ps.setInt(4, m.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar (Materia m) {
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into materia (id, nombre, acronimo, curso_id) "
					+ " values (?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, m.getNombre());
			ps.setString(3, m.getAcronimo());
			ps.setInt(4, m.getCurso_id());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static int eliminarRegistro(int id) {

		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"delete from materia where id = ?");
		
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	

	/**
	 * 
	 * @return
	 */
	private static int getSiguientIdValido () {
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"select max(id) from materia");
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}
			
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	

}
