package ejemplos.insertarS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionS {

	// Variable para la conexión
	private Connection conexion = null;

	// Variable para la ruta de la base de datos (Misma ruta de tu Mac)
	private String nombreDB = "C:/PG/envios/envios";

	// Variable para el driver
	private String driver = "org.hsqldb.jdbcDriver";

	// Variable para la url de la base de datos
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	/**
	 * Constructor vacío
	 */
	public ConexionS() {
		// Se deja limpio para gestionar la apertura con obtenerConexion()
	}

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

				System.out.println("Conexión con tabla S establecida correctamente");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la BD", "Error de conexión",
					JOptionPane.ERROR_MESSAGE);
		}
		return conexion;
	}
	
	/**
	 * Método para terminar la conexión de datos
	 */
	public void desconectar() {
		try {
			if (conexion != null) {
				conexion.close();
				conexion = null; // Reseteamos a null para futuras reconexiones
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cerrar la conexión con la BD", "Error de conexión",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para mostrar datos de los Proveedores en una tabla
	 * @param tablaS - JTable de la interfaz gráfica
	 */
	public void mostrarS(JTable tablaS) {
		try {
			// Variable con la consulta a la tabla S
			String consulta = "SELECT * FROM S";

			// Clase para gestionar la consulta
			Statement st = conexion.createStatement();

			// Ejecutamos la consulta y guardamos los resultados
			ResultSet rs = st.executeQuery(consulta);

			// Creamos el modelo
			DefaultTableModel modelo = new DefaultTableModel();
			
			// Columnas de la tabla Proveedores
			String atributos[] = { "Código Prov.", "Nombre", "Estado", "Ciudad" };
			
			// Inicializamos el objeto DefaultTableModel
			modelo.setColumnIdentifiers(atributos);

			// Se crea un array que será una de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];

			// Bucle para mapear el resultado de la base de datos
			while (rs.next()) {
				// Leemos los campos de la tabla S (sn, snombre, estado, ciudad)
				fila[0] = rs.getString("sn");
				fila[1] = rs.getString("snombre");
				fila[2] = rs.getInt("estado");
				fila[3] = rs.getString("ciudad");

				// Añadimos la fila al modelo
				modelo.addRow(fila);
			}

			// Vinculamos el modelo con los datos a la JTable física
			tablaS.setModel(modelo);

			// Cerramos los recursos
			st.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla de proveedores", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para insertar un nuevo proveedor en la tabla S
	 */
	public void insertarS(String cod, String nom, String est, String ciud) {
		try {
			String sql = "INSERT INTO S VALUES (?,?,?,?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, cod);
			pst.setString(2, nom);
			
			// Control de nulos para el estado (numérico)
			if (est.isEmpty()) {
				pst.setString(3, null);
			} else {
				pst.setInt(3, Integer.parseInt(est));
			}
			
			pst.setString(4, ciud);
			
			// Ejecutamos la inserción
			pst.executeUpdate();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Proveedor guardado correctamente", "Éxito", 
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos. \nComprueba que el código no está duplicado y el estado sea un número válido.", "Error al insertar el proveedor",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}