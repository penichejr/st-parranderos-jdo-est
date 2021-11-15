package uniandes.isis2304.parranderos.negocio;

public class GerenteOficina extends Usuario implements VOGerenteOficina {

	public String login;
	
	
	public GerenteOficina() {
		
		// TODO Auto-generated constructor stub
	}

	public GerenteOficina(String login) {
		this.login = login;
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
		return "GerenteOficina [login=" + login + "]";
	}

	
	
}
