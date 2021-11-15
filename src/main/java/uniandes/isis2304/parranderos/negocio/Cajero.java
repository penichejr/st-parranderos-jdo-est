package uniandes.isis2304.parranderos.negocio;

public class Cajero implements VOCajero {


		private String login;
		private long puntoatencion;
		
		
		
		
		public Cajero(String login, long idPO) {
			
			this.login=login;
			
			this.puntoatencion=idPO;
		}


		public Cajero() {
			super();	}


		public long getPuntoAtencion() {
			return puntoatencion;
		}

		public void setPuntoAtencion(long idPuntoDeAtencion) {
			this.puntoatencion = idPuntoDeAtencion;
		}

		
		
		public String getLogin()
		{
			return login;
			
		}
		
		
		public void setLogin(String login) {
			this.login=login;
		}

		@Override
		public String toString() {
			return "Cajero [id=" + login + "]";
		}
		
		
	

}
