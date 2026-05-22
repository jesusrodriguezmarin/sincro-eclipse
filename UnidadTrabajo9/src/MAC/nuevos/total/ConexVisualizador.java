package MAC.nuevos.total;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexVisualizador {

	private Connection conexion = null;
	private String nombreDB = "/Users/jesusrodriguezmarin/Documents/BDeclipse/envios/envios";
	private String driver = "org.hsqldb.jdbcDriver";
	private String url = "jdbc:hsqldb:file:" + nombreDB;

	public Connection obtenerConexion() {
		try {
			if (conexion == null) {
				Class.forName(driver);
				conexion = DriverManager.getConnection(url);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de conexión", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return conexion;
	}
	
	public void desconectar() {
		try {
			if (conexion != null) {
				conexion.close();
				conexion = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Carga los datos de la tabla seleccionada utilizando índices de posición (1, 2, 3...)
	 * para garantizar que se visualicen correctamente en HSQLDB independientemente del nombre.
	 */
	public void cargarTablaDinamica(JTable tabla, String tablaSeleccionada) {
		try {
			String sql = "";
			String[] atributos;
			
			if (tablaSeleccionada.equals("Proveedores (S)")) {
				sql = "select * from s";
				atributos = new String[] { "Cod. Prov (sn)", "Nombre", "Estado", "Ciudad" };
			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				sql = "select * from p";
				atributos = new String[] { "Cod. Pieza (pn)", "Nombre", "Color", "Peso", "Ciudad" };
			} else {
				sql = "select * from sp";
				atributos = new String[] { "Cod. Prov (sn)", "Cod. Pieza (pn)", "Cantidad" };
			}

			PreparedStatement pst = conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			DefaultTableModel modelo = new DefaultTableModel();
			modelo.setColumnIdentifiers(atributos);

			while (rs.next()) {
				// Creamos la fila con el tamaño exacto del modelo de columnas actual
				Object[] fila = new Object[modelo.getColumnCount()];
				
				if (tablaSeleccionada.equals("Proveedores (S)")) {
					fila[0] = rs.getString(1) != null ? rs.getString(1).trim() : "";
					fila[1] = rs.getString(2) != null ? rs.getString(2).trim() : "";
					fila[2] = rs.getInt(3);
					fila[3] = rs.getString(4) != null ? rs.getString(4).trim() : "";
				} else if (tablaSeleccionada.equals("Piezas (P)")) {
					fila[0] = rs.getString(1) != null ? rs.getString(1).trim() : "";
					fila[1] = rs.getString(2) != null ? rs.getString(2).trim() : "";
					fila[2] = rs.getString(3) != null ? rs.getString(3).trim() : "";
					fila[3] = rs.getInt(4);
					fila[4] = rs.getString(5) != null ? rs.getString(5).trim() : "";
				} else {
					fila[0] = rs.getString(1) != null ? rs.getString(1).trim() : "";
					fila[1] = rs.getString(2) != null ? rs.getString(2).trim() : "";
					fila[2] = rs.getInt(3);
				}
				modelo.addRow(fila);
			}
			
			tabla.setModel(modelo);
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al refrescar la tabla", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}