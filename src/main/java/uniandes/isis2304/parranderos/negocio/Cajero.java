package uniandes.isis2304.parranderos.negocio;

public class Cajero extends Usuario implements VOCajero {


		private String login;
		private long idPuntoDeAtencion;
		
		
		
		
		public Cajero(String login, String numeroDocumento, String tipoDocumento, String palabraClave, String nombre,
				String nacionalidad, String direccion, String email, String telefono, String ciudad,
				String departamento, String codigoPostal, long idPO) {
			
			super( login,  numeroDocumento,  tipoDocumento,  palabraClave,  nombre,
					 direccion,  email,  telefono,  ciudad,  departamento,  codigoPostal);
			// TODO Auto-generated constructor stub
			
			this.idPuntoDeAtencion=idPO;
		}


		public Cajero() {
			super();
			// TODO Auto-generated constructor stub
			this.idPuntoDeAtencion=0;
		}


		public long getIdPuntoDeAtencion() {
			return idPuntoDeAtencion;
		}

		public void setIdPuntoDeAtencion(long idPuntoDeAtencion) {
			this.idPuntoDeAtencion = idPuntoDeAtencion;
		}

		
		
		public String getLogin()
		{
			return login;
			
		}
		
		public void setId(String login) {
			this.login=login;
		}

		@Override
		public String toString() {
			return "Cajero [id=" + login + "]";
		}
		
		
	

}
