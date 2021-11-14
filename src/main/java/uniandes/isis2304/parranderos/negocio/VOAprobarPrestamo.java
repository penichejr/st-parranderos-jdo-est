package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOAprobarPrestamo {
	
public long getIdPuntoAtencion();
	
	public void setIdPuntoAtencion(long idPuntoAtencion);
	
	public String getLoginCliente();
	
	public void setLoginCliente(String loginCliente);
	
	public long getIdPrestamo();
	
	public void setIdPrestamo(long idPrestamo);
	
	public Timestamp getFecha();
	
	public void setFecha(Timestamp fecha);	

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString();

}
