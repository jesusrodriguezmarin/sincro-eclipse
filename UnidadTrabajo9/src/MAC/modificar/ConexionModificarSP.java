package MAC.modificar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionModificarSP {

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

	public void mostrarSP(JTable tablaSP) {
		try {
			String consulta = "SELECT * FROM \"SP\"";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Cod. Proveedor", "Cod. Pieza", "Cantidad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			while (rs.next()) {
				fila[0] = rs.getString("sn").trim();
				fila[1] = rs.getString("pn").trim();
				fila[2] = rs.getInt("cant");
				modelo.addRow(fila);
			}
			tablaSP.setModel(modelo);
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarSP(String codS, String codP, String cantidad) {
		try {
			String sql = "UPDATE \"SP\" SET \"cant\" = ? WHERE TRIM(\"sn\") = ? AND TRIM(\"pn\") = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			if (cantidad.isEmpty()) {
				pst.setString(1, null);
			} else {
				pst.setInt(1, Integer.parseInt(cantidad));
			}
			pst.setString(2, codS.trim());
			pst.setString(3, codP.trim());
			
			int filas = pst.executeUpdate();
			pst.close();
			
			if (filas > 0) {
				JOptionPane.showMessageDialog(null, "Cantidad del envío modificada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el registro de envío (Combinación Prov/Pieza incorrecta)", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al modificar la cantidad. Asegúrate de ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}