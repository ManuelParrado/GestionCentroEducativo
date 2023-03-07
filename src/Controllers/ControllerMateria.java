package Controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	

}
