package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ConsignarCuenta;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLConsignarCuenta
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaParranderos.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaParranderos pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/

	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLConsignarCuenta(PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	
	
	public List<ConsignarCuenta> darOficinas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA");
		q.setResultClass(ConsignarCuenta.class);
		return (List<ConsignarCuenta>) q.executeList();
	}


	public long adicionarConsignacion(PersistenceManager pm, long numero, String idPA, String loginCliente, Timestamp fecha, int monto) {
		// TODO Auto-generated method stub
		 Query q = pm.newQuery(SQL, "INSERT INTO A_CONSIGNARCUENTA " + "(idpuntoatencion, logincliente, numerocuenta, fecha, monto) values (?, ?, ?, ?, ?)");
	        q.setParameters(idPA, loginCliente, numero, fecha, monto);
	        return (long) q.executeUnique();
		
	}
	
}