package uniandes.isis2304.parranderos.negocio;

public class Cliente extends Usuario implements VOCliente{
	
	private String login;
	private String tipoCliente;
	
	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
		tipoCliente=null;
	}

	public Cliente(String login, String numeroDocumento, String tipoDocumento, String palabraClave, String nombre,
			 String direccion, String email, String telefono, String ciudad, String departamento,
			String codigoPostal, String tipoCliente) {
		super( login,  numeroDocumento,  tipoDocumento,  palabraClave,  nombre,
				 direccion,  email,  telefono,  ciudad,  departamento,  codigoPostal);
		// TODO Auto-generated constructor stub
		this.tipoCliente = tipoCliente;
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
