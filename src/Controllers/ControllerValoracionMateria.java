package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.ValoracionMateria;

public class ControllerValoracionMateria {

	private static Connection conn = null;
	
	/**
	 * 
	 */
	public ValoracionMateria cargarPrimerRegistro() {
		
		ValoracionMateria valmat = null;
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.valoracionmateria"
					+ " order by id limit 1");
			
			if(rs.next()) {
				
				valmat = new ValoracionMateria();
				
				valmat.setId(rs.getInt(1));
				//ComboProfesor
				//ComboEstudiante
				//ComboMateria
				valmat.setValoracion(rs.getFloat(5));
				
			}
			
			st.close();
			rs.close();
			return valmat;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ValoracionMateria cargarUltimoRegistro() {

		ValoracionMateria valmat = null;

		try {

			conn = ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM centroeducativo.valoracionmateria\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.valoracionmateria);");

			if (rs.next()) {

				valmat = new ValoracionMateria();

				valmat.setId(rs.getInt(1));
				//ComboProfesor
				//ComboEstudiante
				//ComboMateria
				valmat.setValoracion(rs.getFloat(5));
				

			}

			st.close();
			rs.close();
			return valmat;

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
	public static ValoracionMateria siguienteRegistro(ValoracionMateria valmat) {
		
		
		try {
			
			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("select * from valoracionmateria "
					+ "where id > "+valmat.getId()+" "
							+ "order by id limit 1");

			if (rs.next()) {
				
				valmat.setId(rs.getInt(1));
				//ComboProfesor
				//ComboEstudiante
				//ComboMateria
				valmat.setValoracion(rs.getFloat(5));

			}

			st.close();
			rs.close();
			return valmat;
			
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
	public static ValoracionMateria anteriorRegistro(ValoracionMateria valmat) {

		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT *\r\n"
					+ "FROM centroeducativo.valoracionmateria\r\n"
					+ "WHERE id = (SELECT MAX(id) FROM centroeducativo.valoracionmateria "
					+ "WHERE id < "+valmat.getId()+");");

			if (rs.next()) {

				valmat.setId(rs.getInt(1));
				//ComboProfesor
				//ComboEstudiante
				//ComboMateria
				valmat.setValoracion(rs.getFloat(5));

			}

			st.close();
			rs.close();
			return valmat;

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
	public static int guardarRegistro(ValoracionMateria valmat) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			
			// Si el id es 0 quiere decir que se va a introducir un registro
			// Si no es 0 quiere decir que se ha modificar
			if (valmat.getId() == 0) {
				afected = st.executeUpdate("INSERT INTO centroeducativo.valoracionmateria "
						+ "(id, idProfesor, idEstudiante, idMateria, valoracion) "
						+ "VALUES ("+getID()+", 1, 1, 1, '"+valmat.getValoracion()+"');");
			} else {
				afected = st.executeUpdate("UPDATE centroeducativo.valoracionmateria "
						+ "SET idProfesor = 1, "
						+ "idEstudiante = 1, idMateria = 1, "
						+ "valoracion = '"+valmat.getValoracion()+"'"
						+ "WHERE id = "+valmat.getId()+";");	
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
	public static int eliminarRegistro(ValoracionMateria valmat) {
		
		int afected;
		
		try {

			conn = Controllers.ConnectionManagerV1.getConexion();
			java.sql.Statement st = conn.createStatement();

			afected = st.executeUpdate("DELETE FROM centroeducativo.valoracionmateria "
					+ "WHERE id = "+valmat.getId()+";");

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
