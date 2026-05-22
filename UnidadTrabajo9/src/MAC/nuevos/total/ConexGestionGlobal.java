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

	/**
	 * Muestra los datos de la tabla seleccionada utilizando índices por posición 
	 * para garantizar compatibilidad total con HSQLDB.
	 */
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
				// Creamos el array adaptando su tamaño exacto a la tabla activa
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

	/**
	 * Cuenta el número de filas de la tabla activa usando count(*)
	 */
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

	/**
	 * Inserta un registro validando previamente duplicados de claves primarias o compuestas
	 */
	public void insertarRegistro(JTable tabla, String tablaSeleccionada, String f1, String f2, String f3, String f4, String f5) {
		try {
			PreparedStatement pst = null;
			
			if (tablaSeleccionada.equals("Proveedores (S)")) {
				PreparedStatement check = conexion.prepareStatement("select count(*) from s where sn = ?");
				check.setString(1, f1.trim());
				ResultSet rs = check.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					JOptionPane.showMessageDialog(null, "Error: Ya existe un proveedor con el código " + f1, "Clave duplicada", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				pst = conexion.prepareStatement("insert into s values (?, ?, ?, ?)");
				pst.setString(1, f1.trim());
				pst.setString(2, f2.trim());
				pst.setInt(3, Integer.parseInt(f3.trim()));
				pst.setString(4, f4.trim());
				
			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				PreparedStatement check = conexion.prepareStatement("select count(*) from p where pn = ?");
				check.setString(1, f1.trim());
				ResultSet rs = check.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					JOptionPane.showMessageDialog(null, "Error: Ya existe una pieza con el código " + f1, "Clave duplicada", JOptionPane.ERROR_MESSAGE);
					return;
				}

				pst = conexion.prepareStatement("insert into p values (?, ?, ?, ?, ?)");
				pst.setString(1, f1.trim());
				pst.setString(2, f2.trim());
				pst.setString(3, f3.trim());
				pst.setInt(4, Integer.parseInt(f4.trim()));
				pst.setString(5, f5.trim());
				
			} else {
				PreparedStatement check = conexion.prepareStatement("select count(*) from sp where sn = ? and pn = ?");
				check.setString(1, f1.trim());
				check.setString(2, f2.trim());
				ResultSet rs = check.executeQuery();
				if (rs.next() && rs.getInt(1) > 0) {
					JOptionPane.showMessageDialog(null, "Error: Ya existe un envío del proveedor " + f1 + " para la pieza " + f2, "Clave compuesta duplicada", JOptionPane.ERROR_MESSAGE);
					return;
				}

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
			JOptionPane.showMessageDialog(null, "Error al insertar. Verifica formatos numéricos o la existencia de las claves ajenas.", "Error en Alta", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Elimina la fila seleccionada con el ratón basándose en su clave correspondiente
	 */
	public void eliminarRegistroSeleccionado(JTable tabla, String tablaSeleccionada) {
		int filaSeleccionada = tabla.getSelectedRow();
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(null, "Por favor, haz clic sobre una fila de la tabla para poder eliminarla.", "Ninguna fila seleccionada", JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			PreparedStatement pst = null;
			String f1 = tabla.getValueAt(filaSeleccionada, 0).toString();

			if (tablaSeleccionada.equals("Proveedores (S)")) {
				pst = conexion.prepareStatement("delete from s where sn = ?");
				pst.setString(1, f1);
			} else if (tablaSeleccionada.equals("Piezas (P)")) {
				pst = conexion.prepareStatement("delete from p where pn = ?");
				pst.setString(1, f1);
			} else {
				String f2 = tabla.getValueAt(filaSeleccionada, 1).toString();
				pst = conexion.prepareStatement("delete from sp where sn = ? and pn = ?");
				pst.setString(1, f1);
				pst.setString(2, f2);
			}

			pst.executeUpdate();
			pst.close();
			JOptionPane.showMessageDialog(null, "Registro eliminado de la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			mostrarTabla(tabla, tablaSeleccionada);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se puede eliminar el registro. Comprueba si está vinculado a un envío en la tabla SP (Integridad Referencial).", "Error de Clave Ajena", JOptionPane.ERROR_MESSAGE);
		}
	}
}