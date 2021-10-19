package uniandes.isis2304.parranderos.negocio;
import java.sql.Timestamp;


public class Cuenta implements VOCuenta{
	
	private long numeroUnico;
	private String tipoCuenta;
	private int saldo;
	private Timestamp fechaCreacion;
	private long idOficina;
	private String loginCliente;
	
	
	public Cuenta(long numeroUnico, String tipoCuenta, int saldo, Timestamp fechaCreacion, long idOficina,
			String loginCliente) {
		this.numeroUnico = numeroUnico;
		this.tipoCuenta = tipoCuenta;
		this.saldo = saldo;
		this.fechaCreacion = fechaCreacion;
		this.idOficina = idOficina;
		this.loginCliente = loginCliente;
	}
	
	public Cuenta() {
		this.numeroUnico = 0;
		this.tipoCuenta = null;
		this.saldo = 0;
		this.fechaCreacion = null;
		this.idOficina = 0;
		this.loginCliente = "";
	}

	public long getNumeroUnico() {
		return numeroUnico;
	}

	public void setNumeroUnico(long numeroUnico) {
		this.numeroUnico = numeroUnico;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public long getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(long idOficina) {
		this.idOficina = idOficina;
	}

	public String getLoginCliente() {
		return loginCliente;
	}

	public void setLoginCliente(String loginCliente) {
		this.loginCliente = loginCliente;
	}

	@Override
	public String toString() {
		return "Cuenta [numeroUnico=" + numeroUnico + ", tipoCuenta=" + tipoCuenta + ", saldo=" + saldo
				+ ", fechaCreacion=" + fechaCreacion + ", idOficina=" + idOficina + ", loginCliente=" + loginCliente
				+ "]";
	}
	
	
	
}
