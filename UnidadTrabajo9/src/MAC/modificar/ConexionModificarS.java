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

public class ConexionModificarS {

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

	public void mostrarS(JTable tablaS) {
		try {
			String consulta = "SELECT * FROM \"S\"";
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(consulta);
			DefaultTableModel modelo = new DefaultTableModel();
			String atributos[] = { "Código Prov.", "Nombre", "Estado", "Ciudad" };
			modelo.setColumnIdentifiers(atributos);
			Object[] fila = new Object[modelo.getColumnCount()];

			while (rs.next()) {
				fila[0] = rs.getString("sn").trim();
				fila[1] = rs.getString("snombre");
				fila[2] = rs.getInt("estado");
				fila[3] = rs.getString("ciudad");
				modelo.addRow(fila);
			}
			tablaS.setModel(modelo);
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarS(String cod, String nom, String est, String ciud) {
		try {
			String sql = "UPDATE \"S\" SET \"snombre\" = ?, \"estado\" = ?, \"ciudad\" = ? WHERE TRIM(\"sn\") = ?";
			PreparedStatement pst = conexion.prepareStatement(sql);
			
			pst.setString(1, nom);
			if (est.isEmpty()) {
				pst.setString(2, null);
			} else {
				pst.setInt(2, Integer.parseInt(est));
			}
			pst.setString(3, ciud);
			pst.setString(4, cod.trim());
			
			int filas = pst.executeUpdate();
			pst.close();
			
			if (filas > 0) {
				JOptionPane.showMessageDialog(null, "Proveedor modificado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el proveedor", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al modificar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}