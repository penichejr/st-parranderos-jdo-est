package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public class TransferenciaCuenta implements VOTransferenciaCuenta{
private long idPuntoAtencion;
	
	/**
	 * El nombre del bar
	 */
	private String loginCliente;

	/**
	 * La ciudad donde se encuentra el bar
	 */
	private long numeroCuenta;

	private long numeroCuentaDestino;

	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private Timestamp fecha;
	
	
	private int monto;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public TransferenciaCuenta() {
		this.idPuntoAtencion = 0;
		this.loginCliente = "";
		this.numeroCuenta = 0;
		this.numeroCuentaDestino=0;
		this.fecha = new Timestamp (0);
		this.setNumeroCuentaDestino(0);
		this.monto=0;
	}
		
	

	public TransferenciaCuenta(long idPuntoAtencion, String loginCliente, long numeroCuenta, Timestamp fecha, long numeroCuentaDestino, int monto) {
		super();
		this.idPuntoAtencion = idPuntoAtencion;
		this.loginCliente = loginCliente;
		this.numeroCuenta = numeroCuenta;
		this.fecha = fecha;
		this.setNumeroCuentaDestino(numeroCuentaDestino);
		this.monto=monto;
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
		return "Transferencias [numero Cuenta Origen=" + numeroCuenta+" Número cuenta destino="+numeroCuentaDestino+" monto= "+monto+" fecha="+fecha+" ]";
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
	public long getNumeroCuenta() {
		return numeroCuenta;
	}



	/**
	 * @param idPrestamo the idPrestamo to set
	 */
	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
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



	public long getNumeroCuentaDestino() {
		return numeroCuentaDestino;
	}



	public void setNumeroCuentaDestino(long numeroCuentaDestino) {
		this.numeroCuentaDestino = numeroCuentaDestino;
	}



	public int getMonto() {
		return monto;
	}



	public void setMonto(int monto) {
		this.monto = monto;
	}


}
