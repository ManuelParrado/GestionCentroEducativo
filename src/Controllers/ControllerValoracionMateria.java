package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Model.ValoracionMateria;

public class ControllerValoracionMateria {

	/**
	 * 
	 * @param rs
	 * @return
	 */
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		ValoracionMateria var = null;
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				var = new ValoracionMateria();
				var.setId(rs.getInt("id"));
				var.setIdProfesor(rs.getInt("idProfesor"));
				var.setIdEstudiante(rs.getInt("idEstudiante"));
				var.setIdMateria(rs.getInt("idMateria"));
				var.setValoracion(rs.getFloat("valoracion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return var;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria cargarPrimerRegistro() {
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id limit 1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static ValoracionMateria cargarUltimoRegistro() {

		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria order by id desc limit 1");
		
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static ValoracionMateria siguienteRegistro(int actualId) {
		
		return getEntidadFromResultSet(
				"select * from valoracionmateria where id > "+ actualId +" order by id limit 1");
	
	}
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static ValoracionMateria anteriorRegistro(int actualId) {
		
		return getEntidadFromResultSet(
				"SELECT * FROM centroeducativo.valoracionmateria where id < " + actualId + " order by id desc limit 1");
	
	}
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int modificar (ValoracionMateria var) {
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update valoracionmateria set idProfesor = ?, "
					+ "idEstudiante = ?, idMateria = ?, valoracion = ? where id = ?");
		
			ps.setInt(1, var.getIdProfesor());
			ps.setInt(2, var.getIdEstudiante());
			ps.setInt(3, var.getIdMateria());
			ps.setFloat(4, var.getValoracion());
			ps.setInt(5, var.getId());
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
	public static int insertar (ValoracionMateria var) {
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into valoracionmateria (id, idProfesor, "
					+ "idEstudiante, idMateria, valoracion) "
						+ " values (?, ?, ?, ?, ?)");
		
			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setInt(2, var.getIdProfesor());
			ps.setInt(3, var.getIdEstudiante());
			ps.setInt(4, var.getIdMateria());
			ps.setFloat(5, var.getValoracion());
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
					"delete from valoracionmateria where id = ?");
		
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
					"select max(id) from valoracionmateria");
		
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