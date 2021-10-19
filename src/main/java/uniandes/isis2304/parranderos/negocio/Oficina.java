package uniandes.isis2304.parranderos.negocio;

public class Oficina implements VOOficina{

	private long id;
	private String nombre;
	private String direccion;
	private String loginGerenteOficina;
	
	
	public Oficina(long id, String nombre, String direccion, String loginGerenteOficina) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.loginGerenteOficina = loginGerenteOficina;
	}
	
	public Oficina() {
		this.id = 0;
		this.nombre = "";
		this.direccion = "";
		this.loginGerenteOficina ="";
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLoginGerenteOficina() {
		return loginGerenteOficina;
	}

	public void setLoginGerenteOficina(String loginGerenteOficina) {
		this.loginGerenteOficina = loginGerenteOficina;
	}
	
	
	@Override
	public String toString() {
		return "Oficina [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", loginGerenteOficina="
				+ loginGerenteOficina + "]";
	}
}
