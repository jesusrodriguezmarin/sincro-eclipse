package MAC.piezasTabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class Piezas {
	
	// Variable que usaremos para crear la conexión
	private Connection conexion = null;

	// Nombre del archivo donde tenemos la base de datos
	private String nombreDB = "/Users/jesusrodriguezmarin/Documents/BDeclipse/envios/envios";

	// Driver para conectarnos
	private String driver = "org.hsqldb.jdbcDriver";

	// URL de la base de datos
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	/**
	 * Método para obtener una conexión a la base de datos
	 * 
	 * @return conexión
	 */
	public Connection obtenerConexion() {
		
		// Control de excepciones para informar al usuario
		try {
			// Si no hay conexión
			if (conexion == null) {

				// --- Establecemos la conexión ---
				
				// 1. Cargamos el driver
				Class.forName(driver);
				// 2. Establecemos la conexión con la url de la BBDDS
				conexion = DriverManager.getConnection(url);

				// Comunicamos si la operación ha sido exitosa
				System.out.println("Conexión establecida correctamente");
			}
		} catch (Exception e) {
			System.out.println("Error al establecer conexión");
		}
		return conexion;
	}

	/**
	 * Método para terminar la conexión de la base de datos
	 */
	public void desconectar() {
		
		// Control de excepciones para informar al usuario
		try {
			// Cerramos la conexión
			conexion.close();
			
		} catch (SQLException e) {
			System.out.println("Error al cerrar la conexión");
		}
	}

	/**
	 * Método para mostrar los datos de la base de datos
	 */
	public void mostrar() {
		try {
			
			// Variable para almacenar la consulta
			String consulta = "SELECT * from P";
			
			// Creamos un objeto Statement para usar su método execuje
			Statement st = conexion.createStatement();
			
			// Ejecuta la consulta con executeQuery y devuelve un objeto result
			ResultSet rs = st.executeQuery(consulta);
			
			// --- Imprimimpos el resultado ---
			
			// El objeto resultset es un boolean que nos muestra el siguiente registro mientras existan
			while (rs.next()) {
				
				// Separamos con tabulación para mejor diseño
				// Obtenemos el resultado de los campos de cada registro con .get sobre el ResultSet
				System.out.print("\n" + rs.getString("pn"));
				System.out.print("\t" + rs.getString("pnombre"));
				System.out.print("\t" + rs.getString("color"));
				System.out.print("\t" + rs.getString("peso"));
				System.out.print("\t" + rs.getString("ciudad"));
			}
			st.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("Error en la consulta");
		}
	}

	/**
	 * Método para mostrar los datos de la base de datos en una tabla
	 * @param objeto DefaultTableModel
	 * Importamos y declaramos antes el DefaultTableModel para usarlo como parámetro
	 * Es una clase que contiene métodos para crear filas y columnas
	 */
	public void mostrarTabla(DefaultTableModel t) {
		
		// Control de errores
		try {
			// Variable para la consulta
			String consulta = "select * from P";
			
			// Creamos un Statement para los métodos de consulta y ejecuciòn
			Statement st = conexion.createStatement();
			
			// Cramos un ResultSet para ejecutar y almacenar el resultado de la consulta
			ResultSet rs = st.executeQuery(consulta);
			
			// Declaramos un array para las filas
			Object fila[] = new Object[t.getColumnCount()];
			
			// --- Insertamos el resultado fila por fila en la tabla con un bucle ---
			
			// Utilizamos el booleano next para recorrer los resultados
			while (rs.next()) {
				
				// Leemos los campos de cada registro con su método correspondiente
				// Los guardamos en un objeto para formar cada fila
				fila[0] = rs.getString("pn");
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");
				
				// Añadimos la fila a la tabla
				t.addRow(fila);
			}
			
			// Cerramos los métodos de ejecución 
			st.close();
			rs.close();
			
		} catch (Exception e) {
			System.err.println("Error en la consulta");
		}
		
		
	}
	
}
