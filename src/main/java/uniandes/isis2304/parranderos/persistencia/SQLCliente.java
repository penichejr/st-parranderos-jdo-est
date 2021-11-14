package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Cliente;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLCliente
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
	public SQLCliente (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un BAR a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idBar - El identificador del bar
	 * @param nombre - El nombre del bar
	 * @param ciudad - La ciudad del bar
	 * @param presupuesto - El presupuesto del bar (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del bar
	 * @return El número de tuplas insertadas
	 */
	
	
	
	public long adicionarCliente(PersistenceManager pm, String login, String tipo) {
		// TODO Auto-generated method stub
		 Query q = pm.newQuery(SQL, "INSERT INTO A_CLIENTE values (?, ?)");
	        q.setParameters(login, tipo);
	        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar BARES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreBar - El nombre del bar
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarBaresPorNombre (PersistenceManager pm, String nombreBar)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE nombre = ?");
        q.setParameters(nombreBar);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN BAR de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idBar - El identificador del bar
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarBarPorId (PersistenceManager pm, long idBar)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE id = ?");
        q.setParameters(idBar);
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
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM A_CLIENTE");
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}
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

	
	
}
