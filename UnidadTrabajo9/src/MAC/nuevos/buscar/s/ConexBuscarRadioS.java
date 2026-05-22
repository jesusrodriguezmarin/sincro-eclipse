package MAC.nuevos.buscar.s;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexBuscarRadioS {

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
	 * Realiza la búsqueda en la tabla de Proveedores (S) requiriendo coincidencia exacta
	 */
	public void buscarProveedorPorCriterio(JTable tabla, String campoCriterio, String textoBuscado) {
		try {
			String sql = "";
			PreparedStatement pst = null;

			// Si el criterio activo es Estado, tratamos la consulta de forma numérica exacta
			if (campoCriterio.equals("Estado")) {
				sql = "SELECT * FROM \"S\" WHERE \"estado\" = ?";
				pst = conexion.prepareStatement(sql);
				
				try {
					pst.setInt(1, Integer.parseInt(textoBuscado.trim()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Para buscar por Estado debes introducir un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				// Mapeo dinámico para campos de texto en la tabla S
				String columnaRealBD = "";
				if (campoCriterio.equals("Código")) columnaRealBD = "sn";
				if (campoCriterio.equals("Nombre")) columnaRealBD = "snombre";
				if (campoCriterio.equals("Ciudad")) columnaRealBD = "ciudad";

				sql = "SELECT * FROM \"S\" WHERE TRIM(\"" + columnaRealBD + "\") = ?";
				pst = conexion.prepareStatement(sql);
				pst.setString(1, textoBuscado.trim()); 
			}

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
				JOptionPane.showMessageDialog(null, "No se encontró ningún proveedor exacto con el valor: '" + textoBuscado + "'", "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda en Proveedores", "Error SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}