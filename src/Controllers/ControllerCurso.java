package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Curso;
import tutorialJava.capitulo9_AWT_SWING.ejemplos.ejemploJTabbedPane.controller.ConnectionManager;

public class ControllerCurso {
	
	private static Connection conn = null;
	
	
	/**
	 * 
	 * @return
	 */
	public static List<Curso> findAll() {
		List<Curso> cursos = new ArrayList<Curso>();
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from curso");
			
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
				cursos.add(curso);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return cursos;
	}
	
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
			conn.close();
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

			ResultSet rs = st.executeQuery("SELECT *\r\n"
					+ "FROM centroeducativo.curso\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.curso WHERE id < "+curso.getId()+");");

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
	public static int guardarRegistro(Curso curso) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();
			
			// Si el id es 0 quiere decir que se va a introducir un registro
			// Si no es 0 quiere decir que se ha modificar
			if (curso.getId() == 0) {
				afected = st.executeUpdate("INSERT INTO centroeducativo.curso (id, descripcion)"
						+ "VALUES ("+getID()+",'"+curso.getDescripcion()+"');");	
			} else {
				afected = st.executeUpdate("UPDATE centroeducativo.curso "
				+ "SET descripcion = '"+curso.getDescripcion()+"' "
						+ "WHERE id = "+curso.getId()+" ;");	
			}

			
			st.close();

			
			return afected;

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
	public static int eliminarRegistro(Curso curso) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			afected = st.executeUpdate("DELETE FROM centroeducativo.curso WHERE id = "+curso.getId()+";");

			st.close();
			conn.close();
			
			return afected;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	private static int getID() {
        int c = new ControllerCurso().cargarUltimoRegistro().getId() + 1;
        return c;
    }

}
