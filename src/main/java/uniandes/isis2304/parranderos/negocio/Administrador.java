package uniandes.isis2304.parranderos.negocio;

public class Administrador extends Usuario implements VOAdministrador{

	private String login;
	private String credenciales;
	
	
	
	public Administrador(String login, String numeroDocumento, String tipoDocumento, String palabraClave, String nombre,
			String nacionalidad, String direccion, String email, String telefono, String ciudad, String departamento,
			String codigoPostal, String credenciales) {
		super( login,  numeroDocumento,  tipoDocumento,  palabraClave,  nombre,
				 direccion,  email,  telefono,  ciudad,  departamento,  codigoPostal);
		// TODO Auto-generated constructor stub
		this.credenciales = credenciales;
	}


	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
		this.credenciales="";
	}


	public String getLogin() {
		return login;
	}
	public void setId(String id) {
		this.login = id;
	}
	public String getCredenciales() {
		return credenciales;
	}
	public void setCredenciales(String credenciales) {
		this.credenciales = credenciales;
	}


	@Override
	public String toString() {
		return "Administrador [login=" + login + ", credenciales=" + credenciales + "]";
	}
	
}
