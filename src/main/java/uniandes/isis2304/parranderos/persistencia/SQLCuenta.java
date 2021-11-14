package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Cuenta;
import uniandes.isis2304.parranderos.negocio.PuntoDeAtencion;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLCuenta
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
	public SQLCuenta (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	// /**
	//  * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	//  * @param pm - El manejador de persistencia
	//  * @param idBar - El identificador del bar
	//  * @param nombre - El nombre del bar
	//  * @param ciudad - La ciudad del bar
	//  * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	//  * @param sedes - El número de sedes del bar
	//  * @return El número de tuplas insertadas
	//  */
	// public long adicionarBar (PersistenceManager pm, long idBar, String nombre, String ciudad, String presupuesto, int sedes) 
	// {
    //     Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCajero () + "(id, nombre, ciudad, presupuesto, cantsedes) values (?, ?, ?, ?, ?)");
    //     q.setParameters(idBar, nombre, ciudad, presupuesto, sedes);
    //     return (long) q.executeUnique();
	// }

	// /**
	//  * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	//  * @param pm - El manejador de persistencia
	//  * @param nombreBar - El nombre del bar
	//  * @return EL número de tuplas eliminadas
	//  */
	// public long eliminarBaresPorNombre (PersistenceManager pm, String nombreBar)
	// {
    //     Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCajero () + " WHERE nombre = ?");
    //     q.setParameters(nombreBar);
    //     return (long) q.executeUnique();
	// }

	// /**
	//  * Crea y ejecuta la sentencia SQL para eliminar UN BAR de la base de datos de Parranderos, por su identificador
	//  * @param pm - El manejador de persistencia
	//  * @param idBar - El identificador del bar
	//  * @return EL número de tuplas eliminadas
	//  */
	// public long eliminarBarPorId (PersistenceManager pm, long idBar)
	// {
    //     Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCajero () + " WHERE id = ?");
    //     q.setParameters(idBar);
    //     return (long) q.executeUnique();
	// }

	public long adicionarCuenta(PersistenceManager pm, long numCuenta, String tipoCuenta, int saldo, Timestamp fechaActual,
			long idOficina, String loginCliente) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO A_CUENTA "+ "(numerounico, tipo, saldo, fechacreacion,  idoficina, logincliente) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(numCuenta, tipoCuenta, saldo, fechaActual, idOficina, loginCliente);
        return (long) q.executeUnique();
	}
	
	public long eliminarCuentaPorNumeroUnico (PersistenceManager pm, long numeroCuenta)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM A_CUENTA WHERE numeroUnico = ?");
        q.setParameters(numeroCuenta);
        return (long) q.executeUnique();               
	}
     
	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN BAR de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBar - El identificador del bar
	 * @return El objeto BAR que tiene el identificador dado
	 */
//	public Bar darBarPorId (PersistenceManager pm, long idBar) 
//	{
//		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar () + " WHERE id = ?");
//		q.setResultClass(Bar.class);
//		q.setParameters(idBar);
//		return (Bar) q.executeUnique();
//	}
//
//	/**
//	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
//	 * base de datos de Parranderos, por su nombre
//	 * @param pm - El manejador de persistencia
//	 * @param nombreBar - El nombre de bar buscado
//	 * @return Una lista de objetos BAR que tienen el nombre dado
//	 */
//	public List<Bar> darBaresPorNombre (PersistenceManager pm, String nombreBar) 
//	{
//		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar () + " WHERE nombre = ?");
//		q.setResultClass(Bar.class);
//		q.setParameters(nombreBar);
//		return (List<Bar>) q.executeList();
//	}
//
//	/**
//	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
//	 * base de datos de Parranderos
//	 * @param pm - El manejador de persistencia
//	 * @return Una lista de objetos BAR
//	 */

//
//	/**
//	 * Crea y ejecuta la sentencia SQL para aumentar en uno el número de sedes de los bares de la 
//	 * base de datos de Parranderos
//	 * @param pm - El manejador de persistencia
//	 * @param ciudad - La ciudad a la cual se le quiere realizar el proceso
//	 * @return El número de tuplas modificadas
//	 */
//	public long aumentarSedesBaresCiudad (PersistenceManager pm, String ciudad)
//	{
//        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBar () + " SET cantsedes = cantsedes + 1 WHERE ciudad = ?");
//        q.setParameters(ciudad);
//        return (long) q.executeUnique();
//	}

	public long actualizarSaldo(PersistenceManager pm, long numero, int monto) {
		// TODO Auto-generated method stub
		 Query q = pm.newQuery(SQL, "UPDATE A_CUENTA SET SALDO = SALDO + ? " +"WHERE NUMEROUNICO = ? " + "SAVEPOINT sp;");
	        q.setParameters(monto, numero);
	        return (long) q.executeUnique();
	}

	public long reducirSaldo(PersistenceManager pm, long numero, int monto) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "UPDATE A_CUENTA SET SALDO = SALDO - ? " +"WHERE NUMEROUNICO = ? "+ "SAVEPOINT sp;");
        q.setParameters(monto, numero);
        return (long) q.executeUnique();
	}
	
	public List<Cuenta> darCuentas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CUENTA");
		q.setResultClass(Cuenta.class);
		return (List<Cuenta>) q.executeList();
	}

	public boolean verificarCuenta(PersistenceManager pm, long cuenta, String loginCliente) {
		// TODO Auto-generated method stub
		Query q= pm.newQuery(SQL, "SELECT * FROM A_CUENTA WHERE NUMEROUNICO = ? "+ "AND LOGINCLIENTE = ?");
		q.setResultClass(Cuenta.class);
		q.setParameters(cuenta, loginCliente);
		return (List<Cuenta>) q.executeList() != null;
	}

	public boolean verificarMontoCuenta(PersistenceManager pm, long cuenta, int monto) {
		// TODO Auto-generated method stub
		Query q= pm.newQuery(SQL, "SELECT SALDO FROM A_CUENTA WHERE NUMEROUNICO = ?");
		q.setResultClass(Integer.class);
		q.setParameters(cuenta);
		int valor = (int) q.executeUnique();
		return valor>=monto;
	}
	
}