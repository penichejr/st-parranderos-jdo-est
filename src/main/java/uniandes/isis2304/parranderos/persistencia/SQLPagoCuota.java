package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.PagoCuota;
import uniandes.isis2304.parranderos.negocio.Prestamo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLPagoCuota
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
	public SQLPagoCuota (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	

	public List<PagoCuota> darPagosCuota (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM A_PAGOCUOTA");
		q.setResultClass(PagoCuota.class);
		return (List<PagoCuota>) q.executeList();
	}

	public long adicionarPago(PersistenceManager pm, long idPA, String loginCliente, long idPrestamo, int monto,
			Timestamp fecha) {
		// TODO Auto-generated method stub
//		 Query q = pm.newQuery(SQL, "INSERT INTO A_PAGOCUOTA (idpuntoatencion, logincliente, idprestamo, valorcuota, fecha) values (?, ?, ?, ?, ?)");
//	        q.setParameters(idPA, loginCliente, idPrestamo, monto, fecha);
//	        return (long) q.executeUnique();
		
		 Query q = pm.newQuery(SQL, "INSERT INTO A_PAGOCUOTA (idpuntoatencion, logincliente, idprestamo, valorcuota, fecha) values (?, ?, ?, ?, ?)");
	        q.setParameters(idPA, loginCliente, idPrestamo, monto, fecha);
	        return (long) q.executeUnique();
	}
	
}