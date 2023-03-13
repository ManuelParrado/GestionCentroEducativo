package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Estudiante;
import Model.Profesor;

public class ControllerProfesor {
	
	private static Connection conn = null;
	
	/**
	 * 
	 * @return
	 */
	public static List<Profesor> findAll() {
		List<Profesor> profesores = new ArrayList<Profesor>();
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from profesor");
			
			while (rs.next()) {
				Profesor profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getNString("nombre"));
				profesor.setApellido1(rs.getNString("apellido1"));
				profesor.setApellido2(rs.getNString("apellido2"));
				profesor.setDni(rs.getString("dni"));
				profesor.setDireccion(rs.getNString("direccion"));
				profesor.setEmail(rs.getNString("email"));
				profesor.setTelefono(rs.getString("telefono"));
				profesores.add(profesor);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return profesores;
	}
	
	/**
	 * 
	 * @return
	 */
	public Profesor cargarPrimerRegistro() {
		
		Profesor pro = null;

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.profesor order by id limit 1");

			if (rs.next()) {

				pro = new Profesor();

				pro.setId(rs.getInt(1));
				pro.setNombre(rs.getNString(2));
				pro.setApellido1(rs.getNString(3));
				pro.setApellido2(rs.getNString(4));
				pro.setDni(rs.getNString(5));
				pro.setDireccion(rs.getNString(6));
				pro.setEmail(rs.getNString(7));
				pro.setTelefono(rs.getNString(8));

			}

			st.close();
			rs.close();
			return pro;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Profesor cargarUltimoRegistro() {

		Profesor pro = null;

		try {

			conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.profesor\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.profesor);");

			if (rs.next()) {

				pro = new Profesor();

				pro.setId(rs.getInt(1));
				pro.setNombre(rs.getNString(2));
				pro.setApellido1(rs.getNString(3));
				pro.setApellido2(rs.getNString(4));
				pro.setDni(rs.getNString(5));
				pro.setDireccion(rs.getNString(6));
				pro.setEmail(rs.getNString(7));
				pro.setTelefono(rs.getNString(8));
				

			}

			st.close();
			rs.close();
			return pro;

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
	public static Profesor siguienteRegistro(Profesor pro) {
		
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from profesor "
					+ "where id > "+pro.getId()+" "
							+ "order by id limit 1");

			if (rs.next()) {
				
				pro.setId(rs.getInt(1));
				pro.setNombre(rs.getNString(2));
				pro.setApellido1(rs.getNString(3));
				pro.setApellido2(rs.getNString(4));
				pro.setDni(rs.getNString(5));
				pro.setDireccion(rs.getNString(6));
				pro.setEmail(rs.getNString(7));
				pro.setTelefono(rs.getNString(8));

			}

			st.close();
			rs.close();
			return pro;
			
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
	public static Estudiante anteriorRegistro(Estudiante est) {

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT *\r\n"
					+ "FROM centroeducativo.estudiante\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.profesor "
					+ "WHERE id < "+est.getId()+");");

			if (rs.next()) {

				est.setId(rs.getInt(1));
				est.setNombre(rs.getNString(2));
				est.setApellido1(rs.getNString(3));
				est.setApellido2(rs.getNString(4));
				est.setDni(rs.getNString(5));
				est.setDireccion(rs.getNString(6));
				est.setEmail(rs.getNString(7));
				est.setTelefono(rs.getNString(8));

			}

			st.close();
			rs.close();
			return est;

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
	public static int guardarRegistro(Profesor pro) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			
			// Si el id es 0 quiere decir que se va a introducir un registro
			// Si no es 0 quiere decir que se ha modificar
			if (pro.getId() == 0) {
				afected = st.executeUpdate("INSERT INTO centroeducativo.profesor "
						+ "(id, nombre, apellido1, apellido2, dni, direccion, email, telefono) \r\n"
						+ "VALUES ("+getID()+", '"+pro.getNombre()+"',"
								+ " '"+pro.getApellido1()+"', '"+pro.getApellido2()+"',"
										+ " '"+pro.getDni()+"', '"+pro.getDireccion()+"',"
												+ " '"+pro.getEmail()+"', '"+pro.getTelefono()+"');");
			} else {
				afected = st.executeUpdate("UPDATE centroeducativo.profesor "
						+ "SET nombre = '"+pro.getNombre()+"', apellido1 = '"+pro.getApellido1()+"', "
								+ "apellido2 = '"+pro.getApellido2()+"', dni = '"+pro.getDni()+"', "
								+ "direccion = '"+pro.getDireccion()+"', email = '?', "
								+ "telefono = '"+pro.getTelefono()+"' "
								+ "WHERE id = "+pro.getId()+";");	
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
	public static int eliminarRegistro(Profesor pro) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			afected = st.executeUpdate("DELETE FROM centroeducativo.profesor "
					+ "WHERE id = "+pro.getId()+";");

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
        int c = new ControllerValoracionMateria().cargarUltimoRegistro().getId() + 1;
        return c;
    }
	
	
}
