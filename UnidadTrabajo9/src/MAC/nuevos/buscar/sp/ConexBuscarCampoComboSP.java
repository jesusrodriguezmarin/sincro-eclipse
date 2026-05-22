package MAC.nuevos.buscar.sp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexBuscarCampoComboSP {

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
	 * Busca en la tabla SP (Envíos) de manera EXACTA por la columna seleccionada
	 */
	public void buscarEnvioPorCriterio(JTable tabla, String campoCriterio, String textoBuscado) {
		try {
			String sql = "";
			PreparedStatement pst = null;

			// Filtro exacto para Cantidad (Número entero)
			if (campoCriterio.equals("Cantidad")) {
				sql = "SELECT * FROM \"SP\" WHERE \"cant\" = ?";
				pst = conexion.prepareStatement(sql);
				try {
					pst.setInt(1, Integer.parseInt(textoBuscado.trim()));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero.", "Error de formato", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				// Mapeo estricto de columnas de texto de la tabla SP
				String columnaRealBD = "";
				if (campoCriterio.equals("Código Prov.")) columnaRealBD = "sn";
				if (campoCriterio.equals("Código Pieza")) columnaRealBD = "pn";

				sql = "SELECT * FROM \"SP\" WHERE TRIM(\"" + columnaRealBD + "\") = ?";
				pst = conexion.prepareStatement(sql);
				pst.setString(1, textoBuscado.trim());
			}

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
			
			// --- MENSAJE EMERGENTE SI NO EXISTE COINCIDENCIA EXACTA ---
			if (filasEncontradas == 0) {
				JOptionPane.showMessageDialog(null, "No existe ningún envío exacto con el valor '" + textoBuscado + "' en el campo " + campoCriterio, "Sin resultados", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error SQL en base de datos", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}