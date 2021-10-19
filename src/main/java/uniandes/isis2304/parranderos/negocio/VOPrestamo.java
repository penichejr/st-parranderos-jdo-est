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
public interface VOPrestamo 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/
     /**
	 * @return El id del bar
	 */
	public long getId();
	
	/**
	 * @return el nombre del bar
	 */
	public String getTipo();
	
	/**
	 * @return la ciudad del bar
	 */
	public int getMonto();
	
	/**
	 * @return El presupuesto del bar
	 */
	public int getSaldo();
	
	/**
	 * @return la cantSedes del bar
	 */
	public int getIntereses();
	
	/**
	 * @return la cantSedes del bar
	 */
	public int getNumeroCuotas();
	
	/**
	 * @return la cantSedes del bar
	 */
	public int getDiaPagoCuota();
	
	/**
	 * @return la cantSedes del bar
	 */
	public int getValorCuotaMinima();
	
	/**
	 * @return la cantSedes del bar
	 */
	public String getLoginCliente();

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString();
	
	
	public enum tipoPrestamo {
		VIVIENDA,
		ESTUDIO,
		AUTOMOVIL,
		CALAMIDADDOMESTICA,
		LIBREINVERSION
	}

}
