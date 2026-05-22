package MAC.nuevos.buscar.p;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexBuscarRadioP {

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
	 * Realiza la búsqueda en la tabla de Piezas (P) requiriendo coincidencia exacta
	 */
	public void buscarPiezaPorCriterio(JTable tabla, String campoCriterio, String textoBuscado) {
		try {
			String sql = "";
			PreparedStatement pst = null;

			// Si es numérico (Peso)
			if (campoCriterio.equals("Peso")) {
				sql = "SELECT * FROM \"P\" WHERE \"peso\" = ?";
				pst = conexion.prepareStatement(sql);
				
				try {
					pst.setInt(1, Integer.parseInt(textoBuscado.trim()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Para buscar por Peso debes introducir un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				// Mapeo dinámico para campos de texto
				String columnaRealBD = "";
				if (campoCriterio.equals("Código")) columnaRealBD = "pn";
				if (campoCriterio.equals("Nombre")) columnaRealBD = "pnombre";
				if (campoCriterio.equals("Color")) columnaRealBD = "color";
				if (campoCriterio.equals("Ciudad")) columnaRealBD = "ciudad";

				// Usamos "=" en lugar de "LIKE" y eliminamos los "UPPER()" para exigir coincidencia exacta
				sql = "SELECT * FROM \"P\" WHERE TRIM(\"" + columnaRealBD + "\") = ?";
				pst = conexion.prepareStatement(sql);
				pst.setString(1, textoBuscado.trim()); // Pasamos el texto limpio tal y como se escribió
			}

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
				JOptionPane.showMessageDialog(null, "No se encontró ninguna pieza exacta con el valor: '" + textoBuscado + "'", "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda en Piezas", "Error SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}