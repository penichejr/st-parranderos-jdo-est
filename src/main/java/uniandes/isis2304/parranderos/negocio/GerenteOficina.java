package uniandes.isis2304.parranderos.negocio;

public class GerenteOficina implements VOGerenteOficina {

	public String login;
	
	
	public GerenteOficina() {}

	public GerenteOficina(String login) {
		this.login=login;
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	public void setId(String id) {
		this.login=id;
	}

	@Override
	public String toString() {
		return "GerenteOficina [login=" + login + "]";
	}

	
	
}
