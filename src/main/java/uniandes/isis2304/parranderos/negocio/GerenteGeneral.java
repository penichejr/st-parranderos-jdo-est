package uniandes.isis2304.parranderos.negocio;

public class GerenteGeneral extends Usuario implements VOGerenteGeneral {

	public String login;
	
	
	
	public GerenteGeneral() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GerenteGeneral(String login, String numeroDocumento, String tipoDocumento, String palabraClave,
			String nombre, String direccion, String email, String telefono, String ciudad,
			String departamento, String codigoPostal) {
		super( login,  numeroDocumento,  tipoDocumento,  palabraClave,  nombre,
				 direccion,  email,  telefono,  ciudad,  departamento,  codigoPostal);
		// TODO Auto-generated constructor stub
	}

	public String getLogin()
	{
		return login;
		
	}
	
	public void setId(String id) {
		this.login=id;
	}

	@Override
	public String toString() {
		return "GerenteGeneral [login=" + login + "]";
	}
	
	
}