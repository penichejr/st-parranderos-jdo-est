package uniandes.isis2304.parranderos.negocio;

public class Cliente implements VOCliente{
	
	private String login;
	private String tipoCliente;
	
	

	public Cliente() {
		
		// TODO Auto-generated constructor stub
		tipoCliente=null;
		this.login="";
	}

	public Cliente(String login, String tipoCliente) {
		
		this.tipoCliente = tipoCliente;
		this.login = login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Override
	public String toString() {
		return "Cliente [login=" + login + ", tipoCliente=" + tipoCliente + "]";
	}
	
	
	
	

}
