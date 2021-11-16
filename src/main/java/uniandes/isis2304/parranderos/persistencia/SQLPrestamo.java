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

package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.GerenteGeneral;
import uniandes.isis2304.parranderos.negocio.Prestamo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLPrestamo 
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
	public SQLPrestamo (PersistenciaParranderos pp)
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
	public long adicionarPrestamo (PersistenceManager pm, long id, String tipo, int monto, int saldo, int intereses, int numeroCuotas, int diaPagoCuota,
			int valorCuotaMinima, String loginCliente) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaPrestamo () + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        q.setParameters(id, tipo, monto, saldo, intereses, numeroCuotas, diaPagoCuota, valorCuotaMinima, loginCliente);
        return (long) q.executeUnique();
	}
	
	
	public long eliminarPrestamoPorId (PersistenceManager pm, long idPrestamo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaPrestamo()+ " WHERE ID = ?");
        q.setParameters(idPrestamo);
        return (long) q.executeUnique();            
	}
	
	
	public long reducirSaldo(PersistenceManager pm, long idPrestamo, int monto) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "UPDATE A_PRESTAMO SET SALDO = SALDO - ? " +"WHERE ID = ?");
        q.setParameters(monto, idPrestamo);
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
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaBar () + " WHERE nombre = ?");
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
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaBar () + " WHERE id = ?");
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
	public Bar darBarPorId (PersistenceManager pm, long idBar) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar () + " WHERE id = ?");
		q.setResultClass(Bar.class);
		q.setParameters(idBar);
		return (Bar) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreBar - El nombre de bar buscado
	 * @return Una lista de objetos BAR que tienen el nombre dado
	 */
	public List<Bar> darBaresPorNombre (PersistenceManager pm, String nombreBar) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar () + " WHERE nombre = ?");
		q.setResultClass(Bar.class);
		q.setParameters(nombreBar);
		return (List<Bar>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS BARES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos BAR
	 */
	public List<Bar> darBares (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar ());
		q.setResultClass(Bar.class);
		return (List<Bar>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para aumentar en uno el número de sedes de los bares de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param ciudad - La ciudad a la cual se le quiere realizar el proceso
	 * @return El número de tuplas modificadas
	 */
	public long aumentarSedesBaresCiudad (PersistenceManager pm, String ciudad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBar () + " SET cantsedes = cantsedes + 1 WHERE ciudad = ?");
        q.setParameters(ciudad);
        return (long) q.executeUnique();
	}

	public boolean verificarCuota(PersistenceManager pm, long idPrestamo, int monto) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT VALORCUOTAMINIMA FROM A_PRESTAMO" + " WHERE id = ?");
		q.setResultClass(Integer.class);
		q.setParameters(idPrestamo);
		int valor = (int) q.executeUnique();
		return monto>valor;
	}

	public List<Prestamo> darPrestamo(PersistenceManager pm, String tipo, String saldo) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_PRESTAMO WHERE TIPO=? and saldo>?");
		q.setParameters(tipo, saldo);
		q.setResultClass(Prestamo.class);
		return (List<Prestamo>) q.executeList();
	}

	public Prestamo darPrestamoPorID(PersistenceManager pm, Long long1) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_PRESTAMO WHERE ID =?");
		q.setResultClass(Prestamo.class);
		q.setParameters(long1);
		return (Prestamo) q.executeList();
	}
	
	
	public List<GerenteGeneral> chequearGerenteGeneral (PersistenceManager pm, String login) 
	{
		System.out.println("entra");
        Query q = pm.newQuery(SQL, "SELECT * FROM A_GERENTEGENERAL WHERE LOGIN =?");
        q.setResultClass(GerenteGeneral.class);
        q.setParameters(login);
        System.out.println(login);
		return (List<GerenteGeneral>) q.executeList();
	}
	
	public List<Prestamo> darPrestamosPorLogin (PersistenceManager pm, String loginCliente)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaPrestamo ()+ " WHERE LOGINCLIENTE=?");
		q.setResultClass(Prestamo.class);
		q.setParameters(loginCliente);
		return (List<Prestamo>) q.executeList();
	}
	
	
	public List<Prestamo> darTodosPrestamos(PersistenceManager pm) {
		// TODO Auto-generated method stub
		Query q = pm.newQuery(SQL, "SELECT * FROM A_PRESTAMO");
		q.setResultClass(Prestamo.class);
		return (List<Prestamo>) q.executeList();
	}
	
}
