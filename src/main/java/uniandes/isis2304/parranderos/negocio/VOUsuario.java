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
 * Interfaz para los métodos get de Usuario.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Germán Bravo
 */
public interface VOUsuario 
{
	/* ****************************************************************
	 * 			Métodos 
	 *****************************************************************/

	public String getLogin();
	
	public void setLogin(String login);
	
	public String getNumeroDocumento();
	
	public void setNumeroDocumento(String numeroDocumento);
	
	public String getTipoDocumento();
	
	public void setTipoDocumento(String tipoDocumento);
	
	public String getClave();
	
	public void setClave(String clave);
	
	public String getNombre();
	
	public void setNombre(String nombre);
	
	public String getDireccion();
	
	public void setDireccion(String direccion);
	
	public String getEmail();
	
	public void setEmail(String email);
	
	public String getTelefono();
	
	public void setTelefono(String telefono);
	
	public String getCiudad();
	
	public void setCiudad(String ciudad);
	
	public String getDepartamento();
	
	public void setDepartamento(String departamento);
	
	public String getCodigoPostal();
	
	public void setCodigoPostal(String codigoPostal) ;
	
	


	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString();

}
