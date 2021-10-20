package uniandes.isis2304.parranderos.persistencia;

import java.sql.Timestamp;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.AbrirCuenta ;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLAbrirCuenta 
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
	public SQLAbrirCuenta(PersistenciaParranderos pp)
	{
		this.pp = pp;
	}
	
	public long adicionarAbrirCuenta(PersistenceManager pm, long idPA, String loginCliente, long numeroCuenta, Timestamp fechaCreacion,
			String tipoCuenta) {
		
		Query q = pm.newQuery(SQL, "INSERT INTO A_ABRIRCUENTA (IDPUNTOATENCION, LOGINCLIENTE, NUMEROCUENTA, FECHA, TIPO) values (?, ?, ?, ?, ?)");
        q.setParameters(idPA, loginCliente, numeroCuenta, fechaCreacion, tipoCuenta);
        return (long) q.executeUnique();
	}


	
	
}