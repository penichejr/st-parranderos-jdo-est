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
 * Interfaz para los métodos get de Prestamo.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Germán Bravo
 */
public interface VOAsociacionCuenta 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
	public String getLoginJefe() ;




	/**
	 * @param loginJefe the loginJefe to set
	 */
	public void setLoginJefe(String loginJefe);




	/**
	 * @return the loginEmpleado
	 */
	public String getLoginEmpleado() ;





	/**
	 * @param loginEmpleado the loginEmpleado to set
	 */
	public void setLoginEmpleado(String loginEmpleado) ;




	/**
	 * @return the numeroCuentaJefe
	 */
	public long getNumeroCuentaJefe() ;




	/**
	 * @param numeroCuentaJefe the numeroCuentaJefe to set
	 */
	public void setNumeroCuentaJefe(int numeroCuentaJefe) ;




	/**
	 * @return the numeroCuentaEmpleado
	 */
	public long getNumeroCuentaEmpleado();



	/**
	 * @param numeroCuentaEmpleado the numeroCuentaEmpleado to set
	 */
	public void setNumeroCuentaEmpleado(int numeroCuentaEmpleado);




	/**
	 * @return the salario
	 */
	public int getSalario() ;



	/**
	 * @param salario the salario to set
	 */
	public void setSalario(int salario);




	/**
	 * @return the frecuenciaDePago
	 */
	public String getFrecuenciaDePago();




	/**
	 * @param frecuenciaDePago the frecuenciaDePago to set
	 */
	public void setFrecuenciaDePago(String frecuenciaDePago);




	@Override
	public String toString();

}
