package Model;

public class ValoracionMateria {

	private int id;
	private int idProfesor;
	private int idEstudiante;
	private int idMateria;
	private float valoracion;
	
	
	/**
	 * 
	 */
	public ValoracionMateria() {
		super();
	}


	/**
	 * @param id
	 * @param idProfesor
	 * @param idEstudiante
	 * @param idMateria
	 * @param valoracion
	 */
	public ValoracionMateria(int id, int idProfesor, int idEstudiante, int idMateria, float valoracion) {
		super();
		this.id = id;
		this.idProfesor = idProfesor;
		this.idEstudiante = idEstudiante;
		this.idMateria = idMateria;
		this.valoracion = valoracion;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the idProfesor
	 */
	public int getIdProfesor() {
		return idProfesor;
	}


	/**
	 * @param idProfesor the idProfesor to set
	 */
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}


	/**
	 * @return the idEstudiante
	 */
	public int getIdEstudiante() {
		return idEstudiante;
	}


	/**
	 * @param idEstudiante the idEstudiante to set
	 */
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}


	/**
	 * @return the idMateria
	 */
	public int getIdMateria() {
		return idMateria;
	}


	/**
	 * @param idMateria the idMateria to set
	 */
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}


	/**
	 * @return the valoracion
	 */
	public float getValoracion() {
		return valoracion;
	}


	/**
	 * @param valoracion the valoracion to set
	 */
	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}


	@Override
	public String toString() {
		return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idEstudiante=" + idEstudiante
				+ ", idMateria=" + idMateria + ", valoracion=" + valoracion + "]";
	}
	
	
	
	
	
}
