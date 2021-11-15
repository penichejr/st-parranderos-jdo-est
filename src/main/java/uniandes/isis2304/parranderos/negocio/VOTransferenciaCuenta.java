package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;

public interface VOTransferenciaCuenta {

public long getIdPuntoAtencion();
	
	public void setIdPuntoAtencion(long idPuntoAtencion);
	
	public String getLoginCliente();
	
	public void setLoginCliente(String loginCliente);
	
	public long getNumeroCuenta();
	
	public void setNumeroCuenta(long numeroCuenta);
	
	public Timestamp getFecha();
	
	public void setFecha(Timestamp fecha);	
	
	public long getNumeroCuentaDestino();
	
	public void setNumeroCuentaDestino(long numeroCuenta);
	
	public int getMonto();
	
	public void setMonto( int monto);

	@Override
	/**
	 * @return Una cadena de caracteres con todos los atributos del bar
	 */
	public String toString();
}
