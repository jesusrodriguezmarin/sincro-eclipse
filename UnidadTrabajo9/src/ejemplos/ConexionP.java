package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionP {

	// Variable que usaremos para crear la conexión
	private Connection conectar = null;

	// Nombre del archivo donde tenemos la base de datos
	private String nombreDB = "C:/PG/envios/envios";

	// Driver para conectarnos a la BD de OpenOffice Base
	private String driver = "org.hsqldb.jdbcDriver";

	// URL de nuestra BD
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	/**
	 * Método para obtener una conexión a la base de datos
	 * 
	 * @return conexión
	 */
	public Connection obtenerConexion() {
		try {
			if (conectar == null) {

				// Establecemos la conexión
				Class.forName(driver);
				conectar = DriverManager.getConnection(url);

				System.out.println("Conexión establecida correctamente");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con la BD", "Error de conexión",
					JOptionPane.ERROR_MESSAGE);
		}
		return conectar;
	}
	
	/**
	 * Método para terminar la conexión de la base de datos
	 */
	public void desconectar() {
		try {
			conectar.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cerrar la conexion con la BD", "Error de conexión",
					JOptionPane.ERROR_MESSAGE);		}
	}
	
	/**
	 * Método para mostrar los datos de la base de datos
	 * @param JTable
	 */
	public void mostrar(JTable t) {
		try {
			// Variable para almacenar la consulta
			String consulta = "select * from P";
			
			// Ejecutamos la consulta utilizando el método executeQuery del Statement
			Statement st = conectar.createStatement();
			
			// Pasamos la cadena con la consulta al método
			ResultSet rs = st.executeQuery(consulta);
			
			// Declaramos un objeto tabla que rellenaremos con los datos
			DefaultTableModel modelo = new DefaultTableModel();
			
			// Damos nombre a las columnas
			String atributos[] = {"Código", "Nombre", "Color", "Peso", "Ciudad"};
			// Asignamos los atributos al modelo
			modelo.setColumnIdentifiers(atributos);
			
			// Se crea un array que será de las filas de la tabla
			Object[] fila = new Object[modelo.getColumnCount()];
			
			
			// Bucle para cada resultado de la consulta
			while (rs.next()) {
				
				// Se rellena cada posición del array con cada columna de la tabla
				fila[0] = rs.getString("pn");
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");
				
				// Se añade al modelo la fila completa
				modelo.addRow(fila);
			}
			
			// Metemos los datos en la tabla
			t.setModel(modelo);
			
			st.close();
			rs.close();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla", "Error en la consulta",
					JOptionPane.ERROR_MESSAGE);			}
	}
	

	public void insertarP(String cod, String nom, String col, String pes, String ciud) {
		
		try {
			String sql = "INSERT INTO P VALUES (?,?,?,?,?);";
			
			PreparedStatement pst = conectar.prepareStatement(sql);
			
			pst.setString(1, cod);
			pst.setString(2, nom);
			pst.setString(5, ciud);
			
			// El campo color acepta nulos
			if (col.isEmpty())
				pst.setString(3, null);
			else
				pst.setString(3, col);
			
			// El campo peso acepta nulos
			if (pes.isEmpty()) {
				pst.setString(4, null);
			} else {
				pst.setInt(4, Integer.parseInt(pes));
			}
			
			// Ejecutamos la sentencia
			pst.executeUpdate();
			
			pst.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Datos incorrectos. \nComprueba que el código tiene 3 dígitos o caracteres y no está duplicado.", "Error al insertar el registro en la BD",
					JOptionPane.ERROR_MESSAGE);				}
	}

}
