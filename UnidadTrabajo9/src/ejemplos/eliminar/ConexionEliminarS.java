package ejemplos.eliminar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionEliminarS {

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
	public ConexionEliminarS() {
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
	 * Método para mostrar datos de los Proveedores en una tabla
	 * @param tablaS - JTable de la interfaz gráfica
	 */
	public void mostrarS(JTable tablaS) {
		try {
			// Variable con la consulta a la tabla S
			String consulta = "SELECT * FROM \"S\"";

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
				// Usamos .trim() al leer para que visualmente en la tabla de Java no arrastre espacios vacíos
				fila[0] = rs.getString("sn").trim();
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
	 * Método para eliminar un proveedor de la base de datos introduciendo su código.
	 * Utiliza TRIM() en el WHERE para que ignore los espacios en blanco del CHAR(3).
	 */
	public void eliminarS(String cod) {
		try {
			// Limpiamos los espacios en blanco que el usuario pueda escribir por error en el JTextField
			String codigoLimpio = cod.trim();

			// 1. Borramos primero los envíos asociados en la tabla intermedia ("SP") usando TRIM()
			String sqlSP = "DELETE FROM \"SP\" WHERE TRIM(\"sn\") = ?";
			PreparedStatement pstSP = conexion.prepareStatement(sqlSP);
			pstSP.setString(1, codigoLimpio);
			pstSP.executeUpdate();
			pstSP.close();

			// 2. Borramos al proveedor en la tabla ("S") usando TRIM()
			String sqlS = "DELETE FROM \"S\" WHERE TRIM(\"sn\") = ?";
			PreparedStatement pstS = conexion.prepareStatement(sqlS);
			pstS.setString(1, codigoLimpio);
			
			int filasAfectadas = pstS.executeUpdate();
			pstS.close();
			
			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Proveedor eliminado correctamente", "Éxito", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ningún proveedor con el código: " + codigoLimpio, "Aviso", 
						JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
			JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor de la base de datos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}