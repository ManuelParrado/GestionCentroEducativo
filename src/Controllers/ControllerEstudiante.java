package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Estudiante;
import Model.Materia;


public class ControllerEstudiante {

	private static Connection conn = null;
	
	/**
	 * 
	 * @return
	 */
	public static List<Estudiante> findAll() {
		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		try {
			Connection conn = ConnectionManagerV1.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from estudiante");
			
			while (rs.next()) {
				Estudiante estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getNString("nombre"));
				estudiante.setApellido1(rs.getNString("apellido1"));
				estudiante.setApellido2(rs.getNString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getNString("direccion"));
				estudiante.setEmail(rs.getNString("email"));
				estudiante.setTelefono(rs.getString("telefono"));
				estudiantes.add(estudiante);
			}
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return estudiantes;
	}
	
	/**
	 * 
	 * @return
	 */
	public Estudiante cargarPrimerRegistro() {
		
		Estudiante est = null;

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.estudiante order by id limit 1");

			if (rs.next()) {

				est = new Estudiante();

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
	 * @return
	 */
	public Estudiante cargarUltimoRegistro() {

		Estudiante est = null;

		try {

			conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.estudiante\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.estudiante);");

			if (rs.next()) {

				est = new Estudiante();

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
	public static Estudiante siguienteRegistro(Estudiante est) {
		
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from estudiante "
					+ "where id > "+est.getId()+" "
							+ "order by id limit 1");

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
	public static Estudiante anteriorRegistro(Estudiante est) {

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT *\r\n"
					+ "FROM centroeducativo.estudiante\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.estudiante "
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
	public static int guardarRegistro(Estudiante est) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			
			// Si el id es 0 quiere decir que se va a introducir un registro
			// Si no es 0 quiere decir que se ha modificar
			if (est.getId() == 0) {
				afected = st.executeUpdate("INSERT INTO centroeducativo.estudiante "
						+ "(id, nombre, apellido1, apellido2, dni, direccion, email, telefono) \r\n"
						+ "VALUES ("+getID()+", '"+est.getNombre()+"',"
								+ " '"+est.getApellido1()+"', '"+est.getApellido2()+"',"
										+ " '"+est.getDni()+"', '"+est.getDireccion()+"',"
												+ " '"+est.getEmail()+"', '"+est.getTelefono()+"');");
			} else {
				afected = st.executeUpdate("UPDATE centroeducativo.estudiante "
						+ "SET nombre = '"+est.getNombre()+"', apellido1 = '"+est.getApellido1()+"', "
								+ "apellido2 = '"+est.getApellido2()+"', dni = '"+est.getDni()+"', "
								+ "direccion = '"+est.getDireccion()+"', email = '?', "
								+ "telefono = '"+est.getTelefono()+"' "
								+ "WHERE id = "+est.getId()+";");	
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
	public static int eliminarRegistro(Estudiante est) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			afected = st.executeUpdate("DELETE FROM centroeducativo.estudiante "
					+ "WHERE id = "+est.getId()+";");

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
        int c = new ControllerEstudiante().cargarUltimoRegistro().getId() + 1;
        return c;
    }
	
}
