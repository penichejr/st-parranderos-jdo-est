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
 * Clase para modelar el concepto Prestamo del negocio de los Parranderos
 *
 * @author Javier Peniche
 */
public class Prestamo implements VOPrestamo
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
	private int monto;
	
	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private int saldo;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private int intereses;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private int numeroCuotas;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private int diaPagoCuota;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private int valorCuotaMinima;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private String loginCliente;

	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public Prestamo() 
    {
    	this.id = 0;
		this.tipo = "";
		this.monto = 0;
		this.saldo = 0;
		this.intereses = 0;
		this.numeroCuotas = 0;
		this.diaPagoCuota = 0;
		this.valorCuotaMinima = 0;
		this.loginCliente = "";
	}


	public Prestamo(long id, String tipo, int monto, int saldo, int intereses, int numeroCuotas, int diaPagoCuota,
			int valorCuotaMinima, String loginCliente) {
		this.id = id;
		this.tipo = tipo;
		this.monto = monto;
		this.saldo = saldo;
		this.intereses = intereses;
		this.numeroCuotas = numeroCuotas;
		this.diaPagoCuota = diaPagoCuota;
		this.valorCuotaMinima = valorCuotaMinima;
		this.loginCliente = loginCliente;
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
	 * @return the monto
	 */
	public int getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(int monto) {
		this.monto = monto;
	}

	/**
	 * @return the saldo
	 */
	public int getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return the intereses
	 */
	public int getIntereses() {
		return intereses;
	}

	/**
	 * @param intereses the intereses to set
	 */
	public void setIntereses(int intereses) {
		this.intereses = intereses;
	}

	/**
	 * @return the numeroCuotas
	 */
	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	/**
	 * @param numeroCuotas the numeroCuotas to set
	 */
	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	/**
	 * @return the diaPagoCuota
	 */
	public int getDiaPagoCuota() {
		return diaPagoCuota;
	}

	/**
	 * @param diaPagoCuota the diaPagoCuota to set
	 */
	public void setDiaPagoCuota(int diaPagoCuota) {
		this.diaPagoCuota = diaPagoCuota;
	}

	/**
	 * @return the valorCuotaMinima
	 */
	public int getValorCuotaMinima() {
		return valorCuotaMinima;
	}

	/**
	 * @param valorCuotaMinima the valorCuotaMinima to set
	 */
	public void setValorCuotaMinima(int valorCuotaMinima) {
		this.valorCuotaMinima = valorCuotaMinima;
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

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString() 
	{
		return "Prestamo [id=" + id + ", tipo=" + tipo + ", monto=" + monto + ", saldo=" + saldo + ", intereses=" + intereses
				+ ", numeroCuotas=" + numeroCuotas + ", diaPagoCuota=" + diaPagoCuota 
				+ ", valorCuotaMinima=" + valorCuotaMinima + ", loginCliente=" + loginCliente
				+ "]";
	}
	

}
