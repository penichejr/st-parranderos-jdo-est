package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public class AprobarPrestamo implements VOAprobarPrestamo {

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
	public AprobarPrestamo() {
		this.idPuntoAtencion = 0;
		this.loginCliente = "";
		this.idPrestamo = 0;
		this.fecha = new Timestamp (0);
	}
		
	

	public AprobarPrestamo(long idPuntoAtencion, String loginCliente, long idPrestamo, Timestamp fecha) {
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
		return "AprobarPrestamo [idPrestamo=" + idPrestamo+" ]";
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
