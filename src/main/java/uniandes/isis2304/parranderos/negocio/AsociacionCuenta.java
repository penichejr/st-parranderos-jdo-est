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
public class AsociacionCuenta implements VOAsociacionCuenta
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	
	/**
	 * El nombre del bar
	 */
	private String loginJefe;

	/**
	 * La ciudad donde se encuentra el bar
	 */
	private String loginEmpleado;
	
	/**
	 * El presupuesto del bar (ALTO, MEDIO, BAJO)
	 */
	private long numeroCuentaJefe;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private long numeroCuentaEmpleado;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private int salario;
	
	/**
	 * El número de sedes del bar en la ciudad
	 */
	private String frecuenciaDePago;


	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
    /**
     * Constructor por defecto
     */
	public AsociacionCuenta() {
		super();
		this.loginJefe = "";
		this.loginEmpleado = "";
		this.numeroCuentaJefe = 0;
		this.numeroCuentaEmpleado = 0;
		this.salario = 0;
		this.frecuenciaDePago = "";
	}




	public AsociacionCuenta(String loginJefe, String loginEmpleado, long numeroCuentaJefe, long numeroCuentaEmpleado,
			int salario, String frecuenciaDePago) {
		super();
		this.loginJefe = loginJefe;
		this.loginEmpleado = loginEmpleado;
		this.numeroCuentaJefe = numeroCuentaJefe;
		this.numeroCuentaEmpleado = numeroCuentaEmpleado;
		this.salario = salario;
		this.frecuenciaDePago = frecuenciaDePago;
	}



	/**
	 * @return the loginJefe
	 */
	public String getLoginJefe() {
		return loginJefe;
	}




	/**
	 * @param loginJefe the loginJefe to set
	 */
	public void setLoginJefe(String loginJefe) {
		this.loginJefe = loginJefe;
	}




	/**
	 * @return the loginEmpleado
	 */
	public String getLoginEmpleado() {
		return loginEmpleado;
	}




	/**
	 * @param loginEmpleado the loginEmpleado to set
	 */
	public void setLoginEmpleado(String loginEmpleado) {
		this.loginEmpleado = loginEmpleado;
	}




	/**
	 * @return the numeroCuentaJefe
	 */
	public long getNumeroCuentaJefe() {
		return numeroCuentaJefe;
	}




	/**
	 * @param numeroCuentaJefe the numeroCuentaJefe to set
	 */
	public void setNumeroCuentaJefe(int numeroCuentaJefe) {
		this.numeroCuentaJefe = numeroCuentaJefe;
	}




	/**
	 * @return the numeroCuentaEmpleado
	 */
	public long getNumeroCuentaEmpleado() {
		return numeroCuentaEmpleado;
	}




	/**
	 * @param numeroCuentaEmpleado the numeroCuentaEmpleado to set
	 */
	public void setNumeroCuentaEmpleado(int numeroCuentaEmpleado) {
		this.numeroCuentaEmpleado = numeroCuentaEmpleado;
	}




	/**
	 * @return the salario
	 */
	public int getSalario() {
		return salario;
	}




	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario) {
		this.salario = salario;
	}




	/**
	 * @return the frecuenciaDePago
	 */
	public String getFrecuenciaDePago() {
		return frecuenciaDePago;
	}




	/**
	 * @param frecuenciaDePago the frecuenciaDePago to set
	 */
	public void setFrecuenciaDePago(String frecuenciaDePago) {
		this.frecuenciaDePago = frecuenciaDePago;
	}




	@Override
	public String toString() {
		return "AsociacionCuenta [loginJefe=" + loginJefe + ", loginEmpleado=" + loginEmpleado + ", numeroCuentaJefe="
				+ numeroCuentaJefe + ", numeroCuentaEmpleado=" + numeroCuentaEmpleado + ", salario=" + salario
				+ ", frecuenciaDePago=" + frecuenciaDePago + "]";
	}
	

}
