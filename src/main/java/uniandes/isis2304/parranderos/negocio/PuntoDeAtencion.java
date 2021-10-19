/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar el concepto PuntoDeAtencion del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class PuntoDeAtencion implements VOPuntoDeAtencion
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los bares
	 */
	private long id;
	
	/**
	 * El nombre del bar
	 */
	private String tipo;

	/**
	 * La ciudad donde se encuentra el bar
	 */
	private String localizacion;
	
	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private Integer idOficina;
	


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public PuntoDeAtencion() 
    {
    	this.id = 0;
		this.tipo = "";
		this.localizacion = "";
		this.idOficina = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El id del bart
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param cantSedes - Las sedes del bar (Mayor que 0)
	 */
    public PuntoDeAtencion(long id, String tipo, String localizacion, Integer idOficina) 
    {
    	this.id = id;
		this.tipo = tipo;
		this.localizacion = localizacion;
		
		System.out.println("hola");
		/*if(idOficina==null) {
			this.idOficina=-1;
		}
		else {
			this.idOficina = idOficina;
		}*/
		this.idOficina = idOficina;
		
	}

 
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}


	/**
	 * @return the idOficina
	 */
	public long getIdOficina() {
		return idOficina;
	}

	/**
	 * @param idOficina the idOficina to set
	 */
	public void setIdOficina(Integer idOficina) {
		this.idOficina = idOficina;
	}

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString() 
	{
		return "PuntoDeAtencion [id=" + id + ", tipo=" + tipo + ", localizacion=" + localizacion + ", idOficina=" + idOficina
				 + "]";
	}

	

}
