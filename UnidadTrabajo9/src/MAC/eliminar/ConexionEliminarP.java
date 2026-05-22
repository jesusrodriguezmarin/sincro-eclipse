package MAC.eliminar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionEliminarP {

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
	public ConexionEliminarP() {
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

				System.out.println("Conexión establecida correctamente con tabla P");
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
	 * Método para mostrar datos de las Piezas en una tabla
	 * @param tablaP - JTable de la interfaz gráfica
	 */
	public void mostrarP(JTable tablaP) {
		try {
			// Variable con la consulta a la tabla P
			String consulta = "SELECT * FROM \"P\"";

			// Clase para gestionar la consulta
			Statement st = conexion.createStatement();

			// Ejecutamos la consulta y guardamos los resultados
			ResultSet rs = st.executeQuery(consulta);

			// Creamos el modelo
			DefaultTableModel modelo = new DefaultTableModel();
			
			// Columnas de la tabla Piezas
			String atributos[] = { "Código Pieza", "Nombre", "Color", "Peso", "Ciudad" };
			
			// Inicializamos el objeto DefaultTableModel
			modelo.setColumnIdentifiers(atributos);

			// Se crea un array que será una de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];

			// Bucle para mapear el resultado de la base de datos
			while (rs.next()) {
				// Leemos los campos de la tabla P (pn, pnombre, color, peso, ciudad)
				// Usamos .trim() en el código para que en Java no arrastre espacios vacíos del CHAR(3)
				fila[0] = rs.getString("pn").trim();
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");

				// Añadimos la fila al modelo
				modelo.addRow(fila);
			}

			// Vinculamos el modelo con los datos a la JTable física
			tablaP.setModel(modelo);

			// Cerramos los recursos
			st.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla de piezas", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para eliminar una pieza de la base de datos introduciendo su código.
	 * Utiliza TRIM() en el WHERE para ignorar los espacios en blanco del CHAR(3) y borra antes en SP.
	 */
	public void eliminarP(String cod) {
		try {
			// Limpiamos los espacios sobrantes que el usuario pueda escribir por error
			String codigoLimpio = cod.trim();

			// 1. Borramos primero los envíos asociados en la tabla intermedia ("SP") usando TRIM()
			String sqlSP = "DELETE FROM \"SP\" WHERE TRIM(\"pn\") = ?";
			PreparedStatement pstSP = conexion.prepareStatement(sqlSP);
			pstSP.setString(1, codigoLimpio);
			pstSP.executeUpdate();
			pstSP.close();

			// 2. Borramos la pieza en la tabla ("P") usando TRIM()
			String sqlP = "DELETE FROM \"P\" WHERE TRIM(\"pn\") = ?";
			PreparedStatement pstP = conexion.prepareStatement(sqlP);
			pstP.setString(1, codigoLimpio);
			
			int filasAfectadas = pstP.executeUpdate();
			pstP.close();
			
			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Pieza eliminada correctamente", "Éxito", 
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró ninguna pieza con el código: " + codigoLimpio, "Aviso", 
						JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (Exception e) {
			e.printStackTrace(); 
			JOptionPane.showMessageDialog(null, "Error al eliminar la pieza de la base de datos.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}