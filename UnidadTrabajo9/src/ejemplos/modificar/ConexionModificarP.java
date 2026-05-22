package ejemplos.modificar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionModificarP {

	private Connection conexion = null;
	private String nombreDB = "C:/PG/envios/envios";
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

	public void mostrarP(JTable tablaP) {
		try {
			String consulta = "SELECT * FROM \"P\"";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Código Pieza", "Nombre", "Color", "Peso", "Ciudad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			while (rs.next()) {
				fila[0] = rs.getString("pn").trim();
				fila[1] = rs.getString("pnombre");
				fila[2] = rs.getString("color");
				fila[3] = rs.getInt("peso");
				fila[4] = rs.getString("ciudad");
				modelo.addRow(fila);
			}
			tablaP.setModel(modelo);
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarP(String cod, String nom, String col, String pes, String ciud) {
		try {
			String sql = "UPDATE \"P\" SET \"pnombre\" = ?, \"color\" = ?, \"peso\" = ?, \"ciudad\" = ? WHERE TRIM(\"pn\") = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, nom);
			pst.setString(2, col);
			if (pes.isEmpty()) {
				pst.setString(3, null);
			} else {
				pst.setInt(3, Integer.parseInt(pes));
			}
			pst.setString(4, ciud);
			pst.setString(5, cod.trim());
			
			int filas = pst.executeUpdate();
			pst.close();
			
			if (filas > 0) {
				JOptionPane.showMessageDialog(null, "Pieza modificada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró la pieza", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al modificar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}