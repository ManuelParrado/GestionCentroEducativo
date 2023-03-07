package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Curso;

public class ControllerCurso {
	
	private static Connection conn = null;
	
	
	/**
	 * 
	 */
	public Curso cargarPrimerRegistro() {
		
		Curso curso = null;
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso order by id limit 1");
			
			if(rs.next()) {
				
				curso = new Curso();
				
				curso.setId(rs.getInt(1));
				curso.setDescripcion(rs.getString(2));
				
			}
			
			st.close();
			rs.close();
			return curso;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Curso cargarUltimoRegistro() {

		Curso curso = null;

		try {

			conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.curso\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.curso);");

			if (rs.next()) {

				curso = new Curso();
				
				curso.setId(rs.getInt(1));
				curso.setDescripcion(rs.getString(2));

			}

			st.close();
			rs.close();
			return curso;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Curso siguienteRegistro(Curso curso) {
		
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from curso where id > "+curso.getId()+" order by id limit 1");

			if (rs.next()) {
				
				curso.setId(rs.getInt(1));
				curso.setDescripcion(rs.getString(2));

			}

			st.close();
			rs.close();
			return curso;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Curso anteriorRegistro(Curso curso) {

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from curso where id < "+curso.getId()+" order by id limit 1");

			if (rs.next()) {

				curso.setId(rs.getInt(1));
				curso.setDescripcion(rs.getString(2));

			}

			st.close();
			rs.close();
			return curso;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Curso guardarRegistro(Curso curso) {
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			st.executeUpdate("INSERT INTO centroeducativo.curso (id, descripcion)"
					+ "VALUES ("+curso.getId()+",'"+curso.getDescripcion()+"');");

			
			st.close();
			
			return curso;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Curso eliminarRegistro(Curso curso) {
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			st.executeUpdate("DELETE FROM centroeducativo.curso WHERE id = "+curso.getId()+";");

			
			st.close();
			
			return curso;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	/**
	 * 
	 * @param curso
	 * @return
	 */
	public static Curso insertarRegistro(Curso curso, String valor) {
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();
			
			int id = Integer.parseInt(valor);
			
			// MIRAR
			if (curso.getId() == id) {
				
				st.executeUpdate("UPDATE centroeducativo.curso "
						+ "SET descripcion = '"+curso.getDescripcion()+"' WHERE id = "+curso.getId()+" ;");
				
			} else {
				
				st.executeUpdate("INSERT INTO centroeducativo.curso (id, descripcion)"
						+ "VALUES ("+curso.getId()+",'"+curso.getDescripcion()+"');");
				
			}
				
			
			
			st.close();
			
			return curso;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
