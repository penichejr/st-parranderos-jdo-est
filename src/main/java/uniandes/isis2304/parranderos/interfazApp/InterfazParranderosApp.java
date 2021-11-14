/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.parranderos.negocio.Cuenta;
import uniandes.isis2304.parranderos.negocio.Oficina;
import uniandes.isis2304.parranderos.negocio.Parranderos;
import uniandes.isis2304.parranderos.negocio.VOAdministrador;
import uniandes.isis2304.parranderos.negocio.VOCajero;
import uniandes.isis2304.parranderos.negocio.VOCliente;
import uniandes.isis2304.parranderos.negocio.VOCuenta;
import uniandes.isis2304.parranderos.negocio.VOGerenteGeneral;
import uniandes.isis2304.parranderos.negocio.VOGerenteOficina;
import uniandes.isis2304.parranderos.negocio.VOPrestamo;
import uniandes.isis2304.parranderos.negocio.VOPuntoDeAtencion;
import uniandes.isis2304.parranderos.negocio.VOTipoBebida;
import uniandes.isis2304.parranderos.negocio.VOUsuario;

/**
 * Clase principal de la interfaz
 * @author Germán Bravo
 */
@SuppressWarnings("serial")

public class InterfazParranderosApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private Parranderos parranderos;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazParranderosApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        parranderos = new Parranderos (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
	/* ****************************************************************
	 * 			CRUD de TipoBebida
	 *****************************************************************/
    /**
     * Adiciona un tipo de bebida con la información dada por el usuario
     * Se crea una nueva tupla de tipoBebida en la base de datos, si un tipo de bebida con ese nombre no existía
     */
    public void adicionarTipoBebida( )
    {
    	try 
    	{
    		String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida (String)", JOptionPane.QUESTION_MESSAGE);
    		if (nombreTipo != null)
    		{
        		VOTipoBebida tb = parranderos.adicionarTipoBebida (nombreTipo);
        		if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}
        		String resultado = "En adicionarTipoBebida\n\n";
        		resultado += "Tipo de bebida adicionado exitosamente: " + tb;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    public void adicionarOficina()
	{
		try
		{
			String loginGO = JOptionPane.showInputDialog (this, "Login de Gerente de Oficina?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			//    		String claveGO = JOptionPane.showInputDialog (this, "Clave de Gerente de Oficina?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			//    		boolean existe = bancandes.existeAdmin(loginGO, claveGO);
			//    		if (existe=false)
			//    		{
			//    			throw new Exception("No se pudo iniciar sesión como Gerente de Oficina");
			//    		}
			String nombreOf = JOptionPane.showInputDialog (this, "Nombre de la oficina?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String direccionOf = JOptionPane.showInputDialog (this, "Dirección de la oficina?", "Continuar", JOptionPane.QUESTION_MESSAGE);

			Oficina oficinanueva= parranderos.adicionarOficina(direccionOf, nombreOf, loginGO);
			String resultado = oficinanueva.toString();
			panelDatos.actualizarInterfaz(resultado);
		}

		catch (Exception e){
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
    
    public void adicionarPrestamo( )
    {
    	try 
    	{
    		String tipo = JOptionPane.showInputDialog (this, "tipo?", "Adicionar tipo (VIVIENDA, ESTUDIO, AUTOMOVIL)", JOptionPane.QUESTION_MESSAGE);
    		String montoT = JOptionPane.showInputDialog (this, "monto?", "Adicionar monto", JOptionPane.QUESTION_MESSAGE);
    		int monto = Integer.parseInt(montoT);
    		String saldoT = JOptionPane.showInputDialog (this, "saldo?", "Adicionar saldo", JOptionPane.QUESTION_MESSAGE);
    		int saldo = Integer.parseInt(saldoT);
    		String interesesT = JOptionPane.showInputDialog (this, "intereses?", "Adicionar intereses", JOptionPane.QUESTION_MESSAGE);
    		int interes = Integer.parseInt(interesesT);
    		String numeroCuotasT = JOptionPane.showInputDialog (this, "numeroCuotas?", "Adicionar numeroCuotas", JOptionPane.QUESTION_MESSAGE);
    		int numeroCuotas = Integer.parseInt(numeroCuotasT);
    		String diaPagoCuotaT = JOptionPane.showInputDialog (this, "diaPagoCuota?", "Adicionar diaPagoCuota", JOptionPane.QUESTION_MESSAGE);
    		int diaPagoCuota = Integer.parseInt(diaPagoCuotaT);
    		String valorCuotaMinimaT = JOptionPane.showInputDialog (this, "valorCuotaMinima?", "Adicionar valorCuotaMinima", JOptionPane.QUESTION_MESSAGE);
    		int valorCuotaMinima = Integer.parseInt(valorCuotaMinimaT);
    		String loginCliente = JOptionPane.showInputDialog (this, "loginCliente?", "Adicionar loginCliente", JOptionPane.QUESTION_MESSAGE);
    		
    		if (tipo != null)
    		{
        		VOPrestamo pr = parranderos.adicionarPrestamo(tipo, monto, saldo, interes, numeroCuotas, diaPagoCuota, valorCuotaMinima, loginCliente);
        		if (pr == null)
        		{
        			throw new Exception ("No se pudo crear un prestamo con tipo: " + tipo);
        		}
        		String resultado = "En adicionarPrestamo\n\n";
        		resultado += "Prestamo adicionado exitosamente: " + pr;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    public void eliminarPrestamoPorId( )
    {
    	try 
    	{
    		String idPrestamo = JOptionPane.showInputDialog (this, "Id del prestamo?", "Borrar prestamo", JOptionPane.QUESTION_MESSAGE);
    		if (idPrestamo != null)
    		{
    			long idTipo = Long.valueOf (idPrestamo);
    			long tbEliminados = parranderos.eliminarPrestamoPorId (idTipo);

    			String resultado = "En eliminar Prestamo\n\n";
    			resultado += tbEliminados + " prestamo eliminado\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    public void eliminarCuentaPorNumeroUnico( )
    {
    	try 
    	{
    		String numeroUnico = JOptionPane.showInputDialog (this, "Id del prestamo?", "Borrar prestamo", JOptionPane.QUESTION_MESSAGE);
    		if (numeroUnico != null)
    		{
    			long idTipo = Long.valueOf (numeroUnico);
    			long tbEliminados = parranderos.eliminarCuentaPorNumeroUnico(idTipo);

    			String resultado = "En eliminar Cuenta\n\n";
    			resultado += tbEliminados + " prestamo eliminado\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    
    public void adicionarUsuario( )
    {
    	try 
    	{
    		System.out.println("hola");
    		String login = JOptionPane.showInputDialog (this, "login?", "Adicionar login ", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(login);
    		String numeroDocumento = JOptionPane.showInputDialog (this, "numeroDocumento?", "Adicionar numeroDocumento", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(numeroDocumento);
    		String tipoDocumento = JOptionPane.showInputDialog (this, "tipoDocumento?", "Adicionar tipoDocumento", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(tipoDocumento);
    		String clave = JOptionPane.showInputDialog (this, "clave?", "Adicionar clave ", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(clave);
    		String nombre = JOptionPane.showInputDialog (this, "nombre?", "Adicionar nombre", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(nombre);
    		String direccion = JOptionPane.showInputDialog (this, "direccion?", "Adicionar direccion", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(direccion);
    		String email = JOptionPane.showInputDialog (this, "email?", "Adicionar email", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(email);
    		String telefono = JOptionPane.showInputDialog (this, "telefono?", "Adicionar telefono", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(telefono);
    		String ciudad = JOptionPane.showInputDialog (this, "ciudad?", "Adicionar ciudad", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(ciudad);
    		String departamento = JOptionPane.showInputDialog (this, "departamento?", "Adicionar departamento", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(departamento);
    		String codigoPostal = JOptionPane.showInputDialog (this, "codigoPostal?", "Adicionar codigoPostal", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(codigoPostal);

    			
    		
    		
    		if (login != null)
    		{
        		String opcion = JOptionPane.showInputDialog (this, "1= Administrador\n2= Gerente General\n3= Gerente Oficina\n4= Cajero\n5= Cliente", "Continuar", JOptionPane.QUESTION_MESSAGE);
        		if(opcion.equals("1")) {
            		String credenciales = JOptionPane.showInputDialog (this, "credenciales?", "Adicionar codigoPostal", JOptionPane.QUESTION_MESSAGE);

        			VOAdministrador pa = parranderos.adicionarAdministrador(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal, credenciales);
            		if (pa == null)
            		{
            			throw new Exception ("No se pudo crear un usuario/Administrador con login: " + login);
            		}
            		
            		String resultado = "En adicionarUsuario\n\n";
            		resultado += "Usuario adicionado exitosamente: " + pa;
        			resultado += "\n Operación terminada";
        			panelDatos.actualizarInterfaz(resultado);

        		}
        		if(opcion.equals("2")) {

        			VOGerenteGeneral pa = parranderos.adicionarGerenteGeneral(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal);
            		if (pa == null)
            		{
            			throw new Exception ("No se pudo crear un usuario/GerenteGeneral con login: " + login);
            		}
            		
            		String resultado = "En adicionarUsuario\n\n";
            		resultado += "Usuario adicionado exitosamente: " + pa;
        			resultado += "\n Operación terminada";
        			panelDatos.actualizarInterfaz(resultado);

        		}
        		if(opcion.equals("3")) {

        			VOGerenteOficina pa = parranderos.adicionarGerenteOficina(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal);
            		if (pa == null)
            		{
            			throw new Exception ("No se pudo crear un usuario/Gerente Oficina con login: " + login);
            		}
            		
            		String resultado = "En adicionarUsuario\n\n";
            		resultado += "Usuario adicionado exitosamente: " + pa;
        			resultado += "\n Operación terminada";
        			panelDatos.actualizarInterfaz(resultado);

        		}
        		if(opcion.equals("4")) {
            		String pA = JOptionPane.showInputDialog (this, "id del punto de Atención?", "Adicionar codigoPostal", JOptionPane.QUESTION_MESSAGE);

        			VOCajero pa = parranderos.adicionarCajero(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal, Long.parseLong(pA));
            		if (pa == null)
            		{
            			throw new Exception ("No se pudo crear un usuario/Cajero con login: " + login);
            		}
            		
            		String resultado = "En adicionarUsuario\n\n";
            		resultado += "Usuario adicionado exitosamente: " + pa;
        			resultado += "\n Operación terminada";
        			panelDatos.actualizarInterfaz(resultado);

        		}
        		if(opcion.equals("5")) {
            		String tipoCliente = JOptionPane.showInputDialog (this, "1 = natural\n2= Juridico", "Adicionar codigoPostal", JOptionPane.QUESTION_MESSAGE);

            		if(tipoCliente.equals("1")) {
            			VOCliente pa = parranderos.adicionarCliente(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal, "NATURAL");
            			if (pa == null)
                		{
                			throw new Exception ("No se pudo crear un usuario/Administrador con login: " + login);
                		}
            			String resultado = "En adicionarUsuario\n\n";
                		resultado += "Usuario adicionado exitosamente: " + pa;
            			resultado += "\n Operación terminada";
            			panelDatos.actualizarInterfaz(resultado);
            		}
            		else {
            			VOCliente pa = parranderos.adicionarCliente(login, numeroDocumento, tipoDocumento, clave, nombre, direccion, email, telefono, ciudad, departamento, codigoPostal, "JURIDICO");
            			if (pa == null)
                		{
                			throw new Exception ("No se pudo crear un usuario/Administrador con login: " + login);
                		}
            			String resultado = "En adicionarUsuario\n\n";
                		resultado += "Usuario adicionado exitosamente: " + pa;
            			resultado += "\n Operación terminada";
            			panelDatos.actualizarInterfaz(resultado);
            		}
            		
            		
            	

        		}
        		
        		
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    
    public void adicionarPuntoDeAtencion( )
    {
    	try 
    	{
    		System.out.println("hola");
    		String tipo = JOptionPane.showInputDialog (this, "Tipo punto de atencion?", "Adicionar tipo", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(tipo);
    		if(tipo!=null)
    			System.out.println("no es nulo");
    		String localizacion = JOptionPane.showInputDialog (this, "Localizacion?", "Adicionar localizacion", JOptionPane.QUESTION_MESSAGE);
    		System.out.println(localizacion);
    		String idOficinaTemp = JOptionPane.showInputDialog (this, "Id Oficina?", "Adicionar Id Oficina", JOptionPane.QUESTION_MESSAGE);
    		int idOficina=0;
    		if(idOficinaTemp=="no")
    			idOficina=-1;
    		else {
    			idOficina=Integer.parseInt(idOficinaTemp);
    		}
    			
    		
    		
    		if (tipo != null)
    		{
        		VOPuntoDeAtencion pa = parranderos.adicionarPuntoDeAtencion(tipo, localizacion, idOficina);
        		if (pa == null)
        		{
        			throw new Exception ("No se pudo crear un punto de atencion con tipo: " + tipo);
        		}
        		String resultado = "En adicionarPuntoDeAtencion\n\n";
        		resultado += "Punto De Atencion adicionado exitosamente: " + pa;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


	public void adicionarCuenta()
	{
		try {
			String tipo = JOptionPane.showInputDialog (this, "Tipo de Cuenta?\n1=Ahorros\n2=Corriente\n3=AFC", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String idOF = JOptionPane.showInputDialog (this, "Id Oficina?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String idPA = JOptionPane.showInputDialog (this, "Id punto de atención", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String loginCliente = JOptionPane.showInputDialog (this, "login Cliente?", "Continuar", JOptionPane.QUESTION_MESSAGE);

			String tipoCuenta = "AFC";
			if(tipo.equals("1"))
			{
				tipoCuenta = "AHORROS";
			}
			else if(tipo.equals("2"))
			{
				tipoCuenta = "CORRIENTE";
			}

			Cuenta cuentanueva =parranderos.adicionarCuenta(tipoCuenta, Long.parseLong(idOF), loginCliente, Long.parseLong(idPA));


			panelDatos.actualizarInterfaz(cuentanueva.toString());

		}
		catch(Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	
	
	public void consignarCuenta()
	{
		try {
			String numero = JOptionPane.showInputDialog (this, "Numero de Cuenta?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String idPA = JOptionPane.showInputDialog (this, "Id punto de atención", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String loginCliente = JOptionPane.showInputDialog (this, "login Cliente?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String monto = JOptionPane.showInputDialog (this, "Monto?", "Continuar", JOptionPane.QUESTION_MESSAGE);


			parranderos.actualizarCuenta(Long.parseLong(numero),idPA, loginCliente, Integer.parseInt(monto));



		}
		catch(Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void transferirCuenta()
	{
		try {
			String idPA = JOptionPane.showInputDialog (this, "Id punto de atención", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String clienteXCajero = JOptionPane.showInputDialog(this, "1= cliente, 2=cajero", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String loginCliente = JOptionPane.showInputDialog (this, "login Cliente?", "Continuar", JOptionPane.QUESTION_MESSAGE);

			if(clienteXCajero.equals("1"))
			{

				String numeroOrigen = JOptionPane.showInputDialog (this, "numero Cuenta Origen?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				String numeroDestino = JOptionPane.showInputDialog (this, "numero Cuenta Destino?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				String monto = JOptionPane.showInputDialog (this, "Monto?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				parranderos.transferirCliente(Long.parseLong(idPA), loginCliente, Long.parseLong(numeroOrigen), Long.parseLong(numeroDestino), Integer.parseInt(monto));

			}
			else {
				String loginCajero = JOptionPane.showInputDialog (this, "login Cajero?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				String numeroOrigen = JOptionPane.showInputDialog (this, "numero Cuenta Origen?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				String numeroDestino = JOptionPane.showInputDialog (this, "numero Cuenta Destino?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				String monto = JOptionPane.showInputDialog (this, "Monto?", "Continuar", JOptionPane.QUESTION_MESSAGE);
				parranderos.transferirCajero(Long.parseLong(idPA), loginCliente, loginCajero, Long.parseLong(numeroOrigen), Long.parseLong(numeroDestino), Integer.parseInt(monto));

			}
			



			//    		panelDatos.actualizarInterfaz(cuentanueva.toString());

		}
		catch(Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	public void pagarCuota()
	{
		try {
			String idPA = JOptionPane.showInputDialog (this, "Id punto de atención", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String loginCliente = JOptionPane.showInputDialog (this, "login Cliente?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String idPrestamo = JOptionPane.showInputDialog (this, "id Prestamo?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String monto = JOptionPane.showInputDialog (this, "Qué valor desea pagar?", "Continuar", JOptionPane.QUESTION_MESSAGE);
			String cuenta = JOptionPane.showInputDialog (this, "De qué número de cuenta?", "Continuar", JOptionPane.QUESTION_MESSAGE);


			parranderos.pagoCuota(Long.parseLong(idPA), loginCliente, Long.parseLong(idPrestamo), Integer.parseInt(monto), Long.parseLong(cuenta));


			//		panelDatos.actualizarInterfaz(cuentanueva.toString());

		}
		catch(Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

    

    /**
     * Consulta en la base de datos los tipos de bebida existentes y los muestra en el panel de datos de la aplicación
     */
    public void listarTipoBebida( )
    {
    	try 
    	{
			List <VOTipoBebida> lista = parranderos.darVOTiposBebida();

			String resultado = "En listarTipoBebida";
			resultado +=  "\n" + listarTiposBebida (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    
    public void listarPuntosDeAtencion( )
    {
    	try 
    	{
			List <VOPuntoDeAtencion> lista = parranderos.darVOPuntosDeAtencion();

			String resultado = "En listarTipoBebida";
			resultado +=  "\n" + listarPuntosDeAtencion(lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    
    public void listarCuentas( )
    {
    	try 
    	{
			List <VOCuenta> lista = parranderos.darVOCuentas();

			String resultado = "En listarCuenta";
			resultado +=  "\n" + listarCuentas(lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Borra de la base de datos el tipo de bebida con el identificador dado po el usuario
     * Cuando dicho tipo de bebida no existe, se indica que se borraron 0 registros de la base de datos
     */
    public void eliminarTipoBebidaPorId( )
    {
    	try 
    	{
    		String idTipoStr = JOptionPane.showInputDialog (this, "Id del tipo de bedida?", "Borrar tipo de bebida por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idTipoStr != null)
    		{
    			long idTipo = Long.valueOf (idTipoStr);
    			long tbEliminados = parranderos.eliminarTipoBebidaPorId (idTipo);

    			String resultado = "En eliminar TipoBebida\n\n";
    			resultado += tbEliminados + " Tipos de bebida eliminados\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Busca el tipo de bebida con el nombre indicado por el usuario y lo muestra en el panel de datos
     */
    public void buscarTipoBebidaPorNombre( )
    {
    	try 
    	{
    		String nombreTb = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Buscar tipo de bebida por nombre", JOptionPane.QUESTION_MESSAGE);
    		if (nombreTb != null)
    		{
    			VOTipoBebida tipoBebida = parranderos.darTipoBebidaPorNombre (nombreTb);
    			String resultado = "En buscar Tipo Bebida por nombre\n\n";
    			if (tipoBebida != null)
    			{
        			resultado += "El tipo de bebida es: " + tipoBebida;
    			}
    			else
    			{
        			resultado += "Un tipo de bebida con nombre: " + nombreTb + " NO EXISTE\n";    				
    			}
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de parranderos
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = parranderos.limpiarParranderos();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Gustan eliminados\n";
			resultado += eliminados [1] + " Sirven eliminados\n";
			resultado += eliminados [2] + " Visitan eliminados\n";
			resultado += eliminados [3] + " Bebidas eliminadas\n";
			resultado += eliminados [4] + " Tipos de bebida eliminados\n";
			resultado += eliminados [5] + " Bebedores eliminados\n";
			resultado += eliminados [6] + " Bares eliminados\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaParranderos.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: Parranderos Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Germán Bravo\n";
		resultado += " * Julio de 2018\n";
		resultado += " * \n";
		resultado += " * Revisado por: Claudia Jiménez, Christian Ariza\n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/
    /**
     * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
     * @param lista - La lista con los tipos de bebida
     * @return La cadena con una líea para cada tipo de bebida recibido
     */
    private String listarTiposBebida(List<VOTipoBebida> lista) 
    {
    	String resp = "Los tipos de bebida existentes son:\n";
    	int i = 1;
        for (VOTipoBebida tb : lista)
        {
        	resp += i++ + ". " + tb.toString() + "\n";
        }
        return resp;
	}
    
    private String listarPuntosDeAtencion(List<VOPuntoDeAtencion> lista) 
    {
    	String resp = "Los puntos de atencion son:\n";
    	int i = 1;
        for (VOPuntoDeAtencion pa : lista)
        {
        	resp += i++ + ". " + pa.toString() + "\n";
        }
        return resp;
	}
    
    
    private String listarCuentas(List<VOCuenta> lista) 
    {
    	String resp = "Las cuentas son:\n";
    	int i = 1;
        for (VOCuenta pa : lista)
        {
        	resp += i++ + ". " + pa.toString() + "\n";
        }
        return resp;
	}

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazParranderosApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazParranderosApp interfaz = new InterfazParranderosApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
