package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Piezas {
	// Variable que usaremos para crear la conexión
	private Connection conexion = null;
	
	// Nombre del archivo donde tenemos la base de datos
	private String nombreDB = "C:/PG/envios/envios";
	
	// Driver para conectarnos
	private String driver = "org.hsqldb.jdbcDriver";
	
	// URL
	private String url = "jdbc:hsqldb:file:"+ nombreDB;

	/**
	 * Método para obtener una conexión a la base de datos
	 * @return conexión
	 */
	public Connection obtenerConexion() {
		try {
			if (conexion == null) {
				
				// Establecemos la conexión
				Class.forName(driver);
				conexion = DriverManager.getConnection(url);
				
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
		try {
			conexion.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexión");
		}
	}
	
	/**
	 * Método para mostrar los datos de la base de datos
	 */
	public void mostrar() {
		try {
			String consulta = "SELECT * from P";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			// Imprimimpos el resultado
			while (rs.next()) {
				System.out.print("\n"+rs.getString("pn"));
				System.out.print("\t"+rs.getString("pnombre"));
				System.out.print("\t"+rs.getString("color"));
				System.out.print("\t"+rs.getString("peso"));
				System.out.print("\t"+rs.getString("ciudad"));
			}
			st.close();
			rs.close();
		} catch (Exception e) {
			System.out.println("Error en la consulta");
		}
	}
	
	
	/**
	 * Programa principal
	 * @param args
	 */
	public static void main(String[] args) {

		// Instanciamos
		Piezas p = new Piezas();
		p.obtenerConexion();
		p.mostrar();
		p.desconectar();

	}

}
