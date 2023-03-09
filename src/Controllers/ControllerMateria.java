package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Model.Curso;
import Model.Materia;

public class ControllerMateria {
	
	private static Connection conn = null;
	
	
	/**
	 * 
	 * @return
	 */
	public Materia cargarPrimerRegistro() {
		
		Materia mat = null;

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.materia order by id limit 1");

			if (rs.next()) {

				mat = new Materia();

				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getNString(2));
				mat.setAcronimo(rs.getString(3));
				//JCombo

			}

			st.close();
			rs.close();
			return mat;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Materia cargarUltimoRegistro() {

		Materia mat = null;

		try {

			conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.materia\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.materia);");

			if (rs.next()) {

				mat = new Materia();

				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getNString(2));
				mat.setAcronimo(rs.getString(3));
				//JCombo

			}

			st.close();
			rs.close();
			return mat;

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
	public static Materia siguienteRegistro(Materia mat) {
		
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from materia where id > "+mat.getId()+" order by id limit 1");

			if (rs.next()) {
				
				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getNString(3));
				//Jcombo

			}

			st.close();
			rs.close();
			return mat;
			
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
	public static Materia anteriorRegistro(Materia mat) {

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT *\r\n"
					+ "FROM centroeducativo.materia\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.materia WHERE id < "+mat.getId()+");");

			if (rs.next()) {

				mat.setId(rs.getInt(1));
				mat.setNombre(rs.getString(2));
				mat.setAcronimo(rs.getNString(3));
				//Jcombo

			}

			st.close();
			rs.close();
			return mat;

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
	public static int guardarRegistro(Materia mat) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			
			// Si el id es 0 quiere decir que se va a introducir un registro
			// Si no es 0 quiere decir que se ha modificar
			if (mat.getId() == 0) {
				afected = st.executeUpdate("INSERT INTO centroeducativo.materia (id, nombre, acronimo, curso_id)"
						+ "VALUES ("+getID()+",'"+mat.getNombre()+"','"+mat.getAcronimo()+"', 1);");
			} else {
				afected = st.executeUpdate("UPDATE centroeducativo.materia SET nombre = '"+mat.getNombre()+"', "
						+ "acronimo = '"+mat.getAcronimo()+"', curso_id = 1 "
								+ "WHERE id = "+mat.getId()+";");	
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
	public static int eliminarRegistro(Materia mat) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			afected = st.executeUpdate("DELETE FROM centroeducativo.materia WHERE id = "+mat.getId()+";");

			st.close();
			
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
        int c = new ControllerMateria().cargarUltimoRegistro().getId() + 1;
        return c;
    }
	

}
