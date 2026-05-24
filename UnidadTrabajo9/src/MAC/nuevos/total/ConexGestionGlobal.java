package MAC.nuevos.total;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexGestionGlobal {

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

	public void mostrarTabla(JTable tabla, String tablaSeleccionada) {
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
			JOptionPane.showMessageDialog(null, "Error al cargar datos en la tabla: " + e.getMessage(), "Error de lectura", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void contarFilas(String tablaSeleccionada) {
		try {
			String nombreTablaBD = tablaSeleccionada.equals("Proveedores (S)") ? "s" : tablaSeleccionada.equals("Piezas (P)") ? "p" : "sp";
			String sql = "select count(*) from " + nombreTablaBD;
			
			PreparedStatement pst = conexion.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				int total = rs.getInt(1);
				JOptionPane.showMessageDialog(null, "La tabla de " + tablaSeleccionada + " tiene actualmente " + total + " filas.", "Recuento de filas", JOptionPane.INFORMATION_MESSAGE);
			}
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertarRegistro(JTable tabla, String tablaSeleccionada, String f1, String f2, String f3, String f4, String f5) {
		try {
			PreparedStatement pst = null;
			
			if (tablaSeleccionada.equals("Proveedores (S)")) {
				pst = conexion.prepareStatement("insert into s values (?, ?, ?, ?)");
				pst.setString(1, f1.trim());
				pst.setString(2, f2.trim());
				pst.setInt(3, Integer.parseInt(f3.trim()));
				pst.setString(4, f4.trim());
				
			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				pst = conexion.prepareStatement("insert into p values (?, ?, ?, ?, ?)");
				pst.setString(1, f1.trim());
				pst.setString(2, f2.trim());
				pst.setString(3, f3.trim());
				pst.setInt(4, Integer.parseInt(f4.trim()));
				pst.setString(5, f5.trim());
				
			} else {
				pst = conexion.prepareStatement("insert into sp values (?, ?, ?)");
				pst.setString(1, f1.trim());
				pst.setString(2, f2.trim());
				pst.setInt(3, Integer.parseInt(f3.trim()));
			}

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Registro insertado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			mostrarTabla(tabla, tablaSeleccionada);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al insertar. Verifica formatos numéricos o que la clave no esté duplicada.", "Error en Alta", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * ELIMINAR DEFINITIVO: Usa operador LIKE con comodín '%' para destruir el registro 
	 * saltándose los problemas de bloqueo por tamaño fijo de caracteres (CHAR) en HSQLDB.
	 */
	public void eliminarRegistroSeleccionado(JTable tabla, String tablaSeleccionada) {
		int filaSeleccionada = tabla.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, haz clic sobre una fila de la tabla para poder eliminarla.", "Ninguna fila seleccionada", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			PreparedStatement pst = null;
			// Capturamos el código limpio de la fila clicada
			String f1 = tabla.getValueAt(filaSeleccionada, 0).toString().trim();

			if (tablaSeleccionada.equals("Proveedores (S)")) {
				pst = conexion.prepareStatement("delete from s where sn like ?");
				pst.setString(1, f1 + "%"); // Borra concordando el inicio sin importar espacios extra
			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				pst = conexion.prepareStatement("delete from p where pn like ?");
				pst.setString(1, f1 + "%");
			} else {
				String f2 = tabla.getValueAt(filaSeleccionada, 1).toString().trim();
				pst = conexion.prepareStatement("delete from sp where sn like ? and pn like ?");
				pst.setString(1, f1 + "%");
				pst.setString(2, f2 + "%");
			}

			int filasAfectadas = pst.executeUpdate();
			pst.close();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Registro eliminado correctamente de la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				mostrarTabla(tabla, tablaSeleccionada); // Refresco inmediato del JScrollPane
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro. El código no coincide.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se puede eliminar el registro.\nComprueba si este elemento está vinculado en un envío activo dentro de la tabla SP (Violación de Integridad Referencial).", "Error de Clave Ajena", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * MODIFICAR DEFINITIVO: Permite actualizar cualquier campo basándose en la clave primaria
	 */
	public void modificarRegistro(JTable tabla, String tablaSeleccionada, String f1, String f2, String f3, String f4, String f5) {
		try {
			PreparedStatement pst = null;

			if (tablaSeleccionada.equals("Proveedores (S)")) {
				pst = conexion.prepareStatement("update s set snombre = ?, estado = ?, ciudad = ? where sn like ?");
				pst.setString(1, f2.trim());
				pst.setInt(2, Integer.parseInt(f3.trim()));
				pst.setString(3, f4.trim());
				pst.setString(4, f1.trim() + "%");

			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				pst = conexion.prepareStatement("update p set pnombre = ?, color = ?, peso = ?, ciudad = ? where pn like ?");
				pst.setString(1, f2.trim());
				pst.setString(2, f3.trim());
				pst.setInt(3, Integer.parseInt(f4.trim()));
				pst.setString(4, f5.trim());
				pst.setString(5, f1.trim() + "%");

			} else {
				pst = conexion.prepareStatement("update sp set cant = ? where sn like ? and pn like ?");
				pst.setInt(1, Integer.parseInt(f3.trim()));
				pst.setString(2, f1.trim() + "%");
				pst.setString(3, f2.trim() + "%");
			}

			int filasAfectadas = pst.executeUpdate();
			pst.close();

			if (filasAfectadas > 0) {
				JOptionPane.showMessageDialog(null, "Registro modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				mostrarTabla(tabla, tablaSeleccionada);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el registro para actualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al modificar. Revisa los formatos numéricos e intenta de nuevo.", "Error en Modificación", JOptionPane.ERROR_MESSAGE);
		}
	}
}