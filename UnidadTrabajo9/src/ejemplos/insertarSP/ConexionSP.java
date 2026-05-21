package ejemplos.insertarSP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionSP {

	// Variable para la conexión
	private Connection conexion = null;

	// Variable para la ruta de la base de datos (Misma ruta de tu Mac)
	private String nombreDB = "/Users/jesusrodriguezmarin/Documents/BDeclipse/envios/envios";

	// Variable para el driver
	private String driver = "org.hsqldb.jdbcDriver";

	// Variable para la url de la base de datos
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	/**
	 * Constructor vacío
	 */
	public ConexionSP() {
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

				System.out.println("Conexión con tabla SP establecida correctamente");
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
	 * Método para mostrar datos de los Envíos en una tabla
	 * @param tablaSP - JTable de la interfaz gráfica
	 */
	public void mostrarSP(JTable tablaSP) {
		try {
			// Variable con la consulta a la tabla SP
			String consulta = "SELECT * FROM SP";

			// Clase para gestionar la consulta
			Statement st = conexion.createStatement();

			// Ejecutamos la consulta y guardamos los resultados
			ResultSet rs = st.executeQuery(consulta);

			// Creamos el modelo
			DefaultTableModel modelo = new DefaultTableModel();
			
			// Columnas de la tabla Envíos
			String atributos[] = { "Cod. Proveedor", "Cod. Pieza", "Cantidad" };
			
			// Inicializamos el objeto DefaultTableModel
			modelo.setColumnIdentifiers(atributos);

			// Se crea un array que será una de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];

			// Bucle para mapear el resultado de la base de datos
			while (rs.next()) {
				// Leemos los campos de la tabla SP (sn, pn, cant)
				fila[0] = rs.getString("sn");
				fila[1] = rs.getString("pn");
				fila[2] = rs.getInt("cant");

				// Añadimos la fila al modelo
				modelo.addRow(fila);
			}

			// Vinculamos el modelo con los datos a la JTable física
			tablaSP.setModel(modelo);

			// Cerramos los recursos
			st.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla de envíos", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para insertar un nuevo envío en la tabla SP
	 */
	public void insertarSP(String codS, String codP, String cantidad) {
		try {
			String sql = "INSERT INTO SP VALUES (?,?,?)";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, codS);
			pst.setString(2, codP);
			
			// Control de nulos para la cantidad (numérico)
			if (cantidad.isEmpty()) {
				pst.setString(3, null);
			} else {
				pst.setInt(3, Integer.parseInt(cantidad));
			}
			
			// Ejecutamos la inserción
			pst.executeUpdate();
			pst.close();
			
			JOptionPane.showMessageDialog(null, "Envío guardado correctamente", "Éxito", 
					JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos. \nComprueba que el proveedor y la pieza existan en sus respectivas tablas, y que la cantidad sea un número.", "Error al insertar el envío",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}