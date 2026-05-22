package ejemplos.insertarP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionP {

	// Variable para la conexión
	private Connection conexion = null;

	// Variable para la ruta de la base de datos (Ruta de Mac)
	private String nombreDB = "C:/PG/envios/envios";

	// Variable para el driver
	private String driver = "org.hsqldb.jdbcDriver";

	// Variable para la url de la base de datos
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	/**
	 * Constructor vacío
	 */
	public ConexionP() {
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

				System.out.println("Conexión establecida correctamente");
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
	 * Método para mostrar datos de la base de datos en una tabla
	 * @param p - JTable de la interfaz gráfica
	 */
	public void mostrarP(JTable p) {
		try {
			// Variable con la consulta
			String consulta = "SELECT * FROM P";

			// Clase para gestionar la consulta
			Statement st = conexion.createStatement();

			// Ejecutamos la consulta y guardamos los resultados
			ResultSet rs = st.executeQuery(consulta);

			// Creamos el modelo
			DefaultTableModel modelo = new DefaultTableModel();
			
			// Declaramos un array de String con los títulos de las columnas
			String atributos[] = { "Código", "Nombre", "Color", "Peso", "Ciudad" };
			
			// Inicializamos el objeto DefaultTableModel para usar con JTable
			modelo.setColumnIdentifiers(atributos);

			// Se crea un array que será una de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];

			// Bucle para el resultado de la consulta
			while (rs.next()) {
				// Leemos los campos mapeados exactamente con los nombres de la BD
				fila[0] = rs.getString("pn");
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");

				// Añadimos la fila al modelo
				modelo.addRow(fila);
			}

			// Vinculamos el modelo con los datos a la JTable física de la ventana
			p.setModel(modelo);

			// Cerramos los recursos
			st.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace(); // Chivato en consola por si ocurre algún error oculto
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para insertar una nueva pieza en la tabla
	 */
	public void insertarP(String cod, String nom, String col, String pes, String ciud) {
		try {
			String sql = "INSERT INTO P VALUES (?,?,?,?,?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, cod);
			pst.setString(2, nom);
			
			// El campo color acepta nulos
			if (col.isEmpty()) {
				pst.setString(3, null);
			} else {
				pst.setString(3, col);
			}
			
			// El peso acepta nulos
			if (pes.isEmpty()) {
				pst.setString(4, null);
			} else {
				pst.setInt(4, Integer.parseInt(pes));
			}
			
			pst.setString(5, ciud);
			
			// Ejecutamos la inserción
			pst.executeUpdate();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Pieza guardada correctamente", "Éxito", 
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos. \nComprueba que el código tiene 3 dígitos o caracteres y no está duplicado.", "Error al insertar el registro en la base de datos",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}