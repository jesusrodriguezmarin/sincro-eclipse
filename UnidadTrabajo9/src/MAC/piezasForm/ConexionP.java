package MAC.piezasForm;

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

	// Varianle para la ruta de la base de datos
	private String nombreBD = "/Users/jesusrodriguezmarin/Documents/BDeclipse/envios/envios";

	// Variable para el driver
	private String driver = "org.hsqldb.jdbcDriver";

	// Variable para la url de la base de datos
	private String url = "jdbc:hsqldb:file:" + nombreBD;

	/**
	 * Costructor que obtiene la conexión de la base de datos
	 */
	public ConexionP() {
		try {

			if (conexion == null) {
				Class.forName(driver);
				conexion = DriverManager.getConnection(url);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexión con la base de BD",
					"Error de conexión", JOptionPane.ERROR_MESSAGE);// TODO: handle exception
		}
	}

	/**
	 * Método para obtener una conexión a la base de datos
	 * 
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
			conexion.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cerrar la conexión con la BD	", "Error de conexión",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Método para mostrar datos de la base de datos en una tabla
	 */
	public void mostrarP(JTable p) {

		// Control de excepciones
		try {
			// Variable con la consulta
			String consulta = "select * from P";

			// Clase para gestionar la consulta
			Statement st = conexion.createStatement();

			// Ejecutamos la consulta y guardamos
			ResultSet rs = st.executeQuery(consulta);

			// Creamos el modelo
			DefaultTableModel modelo = new DefaultTableModel();
			// Declaramos un array de String con los titulos de las columnas
			String atributos[] = { "Código", "Nombre", "Color", "Peso", "Ciudad" };
			// Inicializamos el objeto DefaultTableModel para usar con JTable
			modelo.setColumnIdentifiers(atributos);

			// Se crea un array que será una de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];

			// Bucle para el resutado de la consulta
			while (rs.next()) {

				// Leemos los campos de cada registro con su método correspondiente
				// Los guardamos en un objeto para formar cada fila
				fila[0] = rs.getString("pn");
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");

				// Añadimos la fila a la tabla
				modelo.addRow(fila);
			}
			// Asignamos el modelo con los datos
			p.setModel(modelo);

			// Cerramos los métodos de ejecución
			st.close();
			rs.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla", "Error de en la consulta",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	/**
	 * Método para insetar una nueva pieza en la tabla
	 * @param cod - código de la pieza
	 * @param nom - nombre de la pieza
	 * @param col - color de la pieza
	 * @param pes - peso de la pieza
	 * @param ciud - ciudad de la pieza
	 */
	public void insertarP(String cod, String nom, String col, String pes, String ciud) {
		try {
			// Variable para la consulta con un ? para cada parámetro de entrada
			String sql = "INSERT INTO P VALUES (?,?,?,?,?)";
			
			// Sentencia para ejecutar varias veces con distintos parámetros
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			// Antes de ejecutar la sentencia suministramos un valor para cada ? con set
			pst.setString(1, cod);
			pst.setString(2, nom);
			
			// El campo colo acepta nulos
			if (col.isEmpty())
				pst.setString(3, null);
			else
				pst.setString(3, col);
			
			// El peso acepta nulos
			if (pes.isEmpty())
				pst.setString(4, null);
			else
				pst.setInt(4, Integer.parseInt(pes));
			
			pst.setString(5, ciud);
			
			// Ejecutamos la sentencia SQL
			pst.executeUpdate();
			
			// Cerramos
			pst.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos. \nComprueba que el código tiene 3 dígitos o caracteres y no está duplicado.", "Error al insertar el registro en la base de datos",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método para modificar los datos de una pieza existente buscando por su código
	 */
	public void modificarP(String cod, String nom, String col, String pes, String ciud) {
	    try {
	        // Sentencia SQL para actualizar los campos filtrando por el código (WHERE pn = ?)
	        String sql = "UPDATE P SET pnombre = ?, color = ?, peso = ?, ciudad = ? WHERE pn = ?";
	        
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        
	        // Asignamos los parámetros en el orden exacto de los interrogantes
	        pst.setString(1, nom);
	        
	        // Control de nulos para el color
	        if (col.isEmpty()) {
	            pst.setString(2, null);
	        } else {
	            pst.setString(2, col);
	        }
	        
	        // Control de nulos para el peso
	        if (pes.isEmpty()) {
	            pst.setString(3, null);
	        } else {
	            pst.setInt(3, Integer.parseInt(pes));
	        }
	        
	        pst.setString(4, ciud);
	        pst.setString(5, cod); // El quinto interrogante es el del WHERE (código)
	        
	        // Ejecutamos la actualización en la BD
	        int filasAfectadas = pst.executeUpdate();
	        
	        if (filasAfectadas > 0) {
	            JOptionPane.showMessageDialog(null, "Pieza modificada correctamente", "Éxito", 
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontró ninguna pieza con el código: " + cod, "Aviso", 
	                    JOptionPane.WARNING_MESSAGE);
	        }
	        
	        pst.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace(); // Chivato en consola por si acaso
	        JOptionPane.showMessageDialog(null, "Error al modificar los datos de la pieza.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	/**
	 * Método para eliminar una pieza de la base de datos introduciendo su código
	 */
	public void eliminarP(String cod) {
	    try {
	        // Sentencia SQL para borrar filas filtrando por la clave primaria
	        String sql = "DELETE FROM P WHERE pn = ?";
	        
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        
	        // Asignamos el código al primer interrogante
	        pst.setString(1, cod);
	        
	        // Ejecutamos el borrado
	        int filasAfectadas = pst.executeUpdate();
	        
	        if (filasAfectadas > 0) {
	            JOptionPane.showMessageDialog(null, "Pieza eliminada correctamente", "Éxito", 
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontró ninguna pieza con el código: " + cod, "Aviso", 
	                    JOptionPane.WARNING_MESSAGE);
	        }
	        
	        pst.close();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al eliminar la pieza de la base de datos.", "Error",
	                JOptionPane.ERROR_MESSAGE);
	    }
	}
	

}
