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

import java.sql.Timestamp;

import oracle.sql.DATE;
import oracle.sql.TIMESTAMP;

/**
 * Clase para modelar el concepto BAR del negocio de los Parranderos
 *
 * @author Germán Bravo
 */
public class CerrarPrestamo implements VOCerrarPrestamo
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador ÚNICO de los bares
	 */
	private long idPuntoAtencion;
	
	/**
	 * El nombre del bar
	 */
	private String loginCliente;

	/**
	 * La ciudad donde se encuentra el bar
	 */
	private long idPrestamo;
	
	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private Timestamp fecha;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public CerrarPrestamo() {
		this.idPuntoAtencion = 0;
		this.loginCliente = "";
		this.idPrestamo = 0;
		this.fecha = new Timestamp (0);
	}
		
	

	public CerrarPrestamo(long idPuntoAtencion, String loginCliente, long idPrestamo, Timestamp fecha) {
		super();
		this.idPuntoAtencion = idPuntoAtencion;
		this.loginCliente = loginCliente;
		this.idPrestamo = idPrestamo;
		this.fecha = fecha;
	}





	/**
	 * Constructor con valores
	 * @param id - El id del bart
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param cantSedes - Las sedes del bar (Mayor que 0)
	 */

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString() 
	{
		return "CerrarPrestamo [idPrestamo=" + idPrestamo+" ]";
	}



	/**
	 * @return the idPuntoAtencion
	 */
	public long getIdPuntoAtencion() {
		return idPuntoAtencion;
	}



	/**
	 * @param idPuntoAtencion the idPuntoAtencion to set
	 */
	public void setIdPuntoAtencion(long idPuntoAtencion) {
		this.idPuntoAtencion = idPuntoAtencion;
	}



	/**
	 * @return the loginCliente
	 */
	public String getLoginCliente() {
		return loginCliente;
	}



	/**
	 * @param loginCliente the loginCliente to set
	 */
	public void setLoginCliente(String loginCliente) {
		this.loginCliente = loginCliente;
	}



	/**
	 * @return the idPrestamo
	 */
	public long getIdPrestamo() {
		return idPrestamo;
	}



	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}



	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}



	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

}
