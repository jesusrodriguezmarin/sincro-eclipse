package MAC.nuevos.buscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexBuscarCiudadCombo {

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
	 * Busca en la tabla S (Proveedores) por coincidencia EXACTA de ciudad
	 */
	public void buscarProveedores(JTable tabla, String ciudad) {
		try {
			String sql = "SELECT * FROM \"S\" WHERE TRIM(\"ciudad\") = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, ciudad.trim());
			ResultSet rs = pst.executeQuery();

			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Código Prov.", "Nombre", "Estado", "Ciudad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			int filasEncontradas = 0;

			while (rs.next()) {
				fila[0] = rs.getString("sn").trim();
				fila[1] = rs.getString("snombre");
				fila[2] = rs.getInt("estado");
				fila[3] = rs.getString("ciudad").trim();
				modelo.addRow(fila);
				filasEncontradas++;
			}
			
			tabla.setModel(modelo);
			pst.close();
			rs.close();

			if (filasEncontradas == 0) {
				JOptionPane.showMessageDialog(null, "No existe ningún proveedor en la ciudad exacta: '" + ciudad + "'", "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Busca en la tabla P (Piezas) por coincidencia EXACTA de ciudad
	 */
	public void buscarPiezas(JTable tabla, String ciudad) {
		try {
			String sqlPiezas = "SELECT * FROM \"P\" WHERE TRIM(\"ciudad\") = ?";
			PreparedStatement pst = conexion.prepareStatement(sqlPiezas);
			pst.setString(1, ciudad.trim());
			ResultSet rs = pst.executeQuery();

			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Código Pieza", "Nombre", "Color", "Peso", "Ciudad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			int filasEncontradas = 0;

			while (rs.next()) {
				fila[0] = rs.getString("pn").trim();
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad").trim();
				modelo.addRow(fila);
				filasEncontradas++;
			}
			
			tabla.setModel(modelo);
			pst.close();
			rs.close();

			if (filasEncontradas == 0) {
				JOptionPane.showMessageDialog(null, "No existe ninguna pieza en la ciudad exacta: '" + ciudad + "'", "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Busca en la tabla SP (Envíos) relacionando la ciudad mediante un JOIN con Proveedores
	 */
	public void buscarEnvios(JTable tabla, String ciudad) {
		try {
			// Hacemos un JOIN con S para saber qué envíos pertenecen a proveedores de esa ciudad exactas
			String sqlEnvios = "SELECT SP.\"sn\", SP.\"pn\", SP.\"cant\" FROM \"SP\" "
					+ "INNER JOIN \"S\" ON SP.\"sn\" = \"S\".\"sn\" "
					+ "WHERE TRIM(\"S\".\"ciudad\") = ?";
			
			PreparedStatement pst = conexion.prepareStatement(sqlEnvios);
			pst.setString(1, ciudad.trim());
			ResultSet rs = pst.executeQuery();

			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Código Prov.", "Código Pieza", "Cantidad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			int filasEncontradas = 0;

			while (rs.next()) {
				fila[0] = rs.getString("sn").trim();
				fila[1] = rs.getString("pn").trim();
				fila[2] = rs.getInt("cant");
				modelo.addRow(fila);
				filasEncontradas++;
			}
			
			tabla.setModel(modelo);
			pst.close();
			rs.close();

			if (filasEncontradas == 0) {
				JOptionPane.showMessageDialog(null, "No se encontraron envíos asociados a la ciudad exacta: '" + ciudad + "'", "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error en la consulta de envíos", "Error SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}