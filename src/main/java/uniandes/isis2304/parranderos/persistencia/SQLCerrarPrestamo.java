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

import uniandes.isis2304.parranderos.negocio.CerrarPrestamo;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto CerrarPrestamo de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLCerrarPrestamo 
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
	public SQLCerrarPrestamo (PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un CerrarPrestamo a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idCerrarPrestamo - El identificador del CerrarPrestamo
	 * @param nombre - El nombre del CerrarPrestamo
	 * @param ciudad - La ciudad del CerrarPrestamo
	 * @param presupuesto - El presupuesto del CerrarPrestamo (ALTO, MEDIO, BAJO)
	 * @param sedes - El número de sedes del CerrarPrestamo
	 * @return El número de tuplas insertadas
	 */
	public long adicionarCerrarPrestamo (PersistenceManager pm, long idCerrarPrestamo, String nombre, String ciudad, String presupuesto, int sedes) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaCerrarPrestamo () + "(id, nombre, ciudad, presupuesto, cantsedes) values (?, ?, ?, ?, ?)");
        q.setParameters(idCerrarPrestamo, nombre, ciudad, presupuesto, sedes);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar CerrarPrestamoES de la base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreCerrarPrestamo - El nombre del CerrarPrestamo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCerrarPrestamoesPorNombre (PersistenceManager pm, String nombreCerrarPrestamo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCerrarPrestamo () + " WHERE nombre = ?");
        q.setParameters(nombreCerrarPrestamo);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar UN CerrarPrestamo de la base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idCerrarPrestamo - El identificador del CerrarPrestamo
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarCerrarPrestamoPorId (PersistenceManager pm, long idCerrarPrestamo)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaCerrarPrestamo () + " WHERE id = ?");
        q.setParameters(idCerrarPrestamo);
        return (long) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN CerrarPrestamo de la 
	 * base de datos de Parranderos, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idCerrarPrestamo - El identificador del CerrarPrestamo
	 * @return El objeto CerrarPrestamo que tiene el identificador dado
	 */
	public CerrarPrestamo darCerrarPrestamoPorId (PersistenceManager pm, long idCerrarPrestamo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCerrarPrestamo () + " WHERE id = ?");
		q.setResultClass(CerrarPrestamo.class);
		q.setParameters(idCerrarPrestamo);
		return (CerrarPrestamo) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS CerrarPrestamoES de la 
	 * base de datos de Parranderos, por su nombre
	 * @param pm - El manejador de persistencia
	 * @param nombreCerrarPrestamo - El nombre de CerrarPrestamo buscado
	 * @return Una lista de objetos CerrarPrestamo que tienen el nombre dado
	 */
	public List<CerrarPrestamo> darCerrarPrestamoesPorNombre (PersistenceManager pm, String nombreCerrarPrestamo) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCerrarPrestamo () + " WHERE nombre = ?");
		q.setResultClass(CerrarPrestamo.class);
		q.setParameters(nombreCerrarPrestamo);
		return (List<CerrarPrestamo>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS CerrarPrestamoES de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos CerrarPrestamo
	 */
	public List<CerrarPrestamo> darCerrarPrestamoes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaCerrarPrestamo ());
		q.setResultClass(CerrarPrestamo.class);
		return (List<CerrarPrestamo>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para aumentar en uno el número de sedes de los CerrarPrestamoes de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param ciudad - La ciudad a la cual se le quiere realizar el proceso
	 * @return El número de tuplas modificadas
	 */
	public long aumentarSedesCerrarPrestamoesCiudad (PersistenceManager pm, String ciudad)
	{
        Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaCerrarPrestamo () + " SET cantsedes = cantsedes + 1 WHERE ciudad = ?");
        q.setParameters(ciudad);
        return (long) q.executeUnique();
	}
	
}
