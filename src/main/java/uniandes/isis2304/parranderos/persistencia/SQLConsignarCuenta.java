package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.ConsignarCuenta;
import uniandes.isis2304.parranderos.negocio.TransferenciaCuenta;

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



	public List<ConsignarCuenta> darConsignaciones(PersistenceManager pm) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA");
		q.setResultClass(ConsignarCuenta.class);
		return (List<ConsignarCuenta>) q.executeList();
	}
	
	public List<ConsignarCuenta> darConsignacionesConMontoMinimo(PersistenceManager pm, String monto) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA WHERE MONTO > ?");
		q.setResultClass(ConsignarCuenta.class);
		q.setParameters(monto);
		return (List<ConsignarCuenta>) q.executeList();
	}
	
	public List<ConsignarCuenta> darConsignacionesConPuntoDeAtencion(PersistenceManager pm, String IDPUNTOATENCION) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA WHERE IDPUNTOATENCION = ?");
		q.setResultClass(ConsignarCuenta.class);
		q.setParameters(IDPUNTOATENCION);
		return (List<ConsignarCuenta>) q.executeList();
	}




	public List<ConsignarCuenta> darConsignacionesCliente(PersistenceManager pm, String login) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA WHERE LOGINCLIENTE = ?");
		q.setResultClass(ConsignarCuenta.class);
		q.setParameters(login);
		return (List<ConsignarCuenta>) q.executeList();
	}



	public List<ConsignarCuenta> darConsignacionesEntreFechas(PersistenceManager pm, Timestamp fechaMin2, Timestamp fechaMax2, int montoSi) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CONSIGNARCUENTA WHERE MONTO>= ? AND FECHA BETWEEN ? AND ?");
		q.setResultClass(ConsignarCuenta.class);
		q.setParameters(montoSi, fechaMin2, fechaMax2);
		return (List<ConsignarCuenta>) q.executeList();	}
	
}