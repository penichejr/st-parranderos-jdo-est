package uniandes.isis2304.parranderos.negocio;

import java.sql.Timestamp;


public interface VOCuenta {

	public long getNumeroUnico();
	public String getTipoCuenta();
	public int getSaldo();
	public Timestamp getFechaCreacion();
	public long getIdOficina();
	public String getLoginCliente();
	
}
