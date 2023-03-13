package Model;

public class Curso {
	
	private int id;
	private String descripcion;
	
	
	/**
	 * 
	 */
	public Curso() {
		super();
		
	}


	/**
	 * @param id
	 * @param descripcion
	 */
	public Curso(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return descripcion;
	}
	
	
	
	

}
