package boletin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Clase JDialogInfo: Ventana secundaria que bloquea la principal (Modal)
 */
public class JDialogInfo extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JLabel mensaje;
	private JButton btnCerrar;

	/**
	 * Constructor del JDialog
	 * @param padre - Recibe la ventana JFrame principal para poder bloquearla
	 */
	public JDialogInfo(JFrame padre) {
		// super(padre, título, modalidad)
		// El true activa el bloqueo de la ventana principal
		super(padre, "Información del Sistema", true);
		
		// Anulamos la opción de maximizar y redimensionar
		setResizable(false);
		
		// Configuramos el cierre (solo destruye esta ventana)
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// --- Diseño de la Interfaz ---
		
		// Panel principal con BorderLayout y márgenes
		panelPrincipal = new JPanel(new BorderLayout(15, 15));
		panelPrincipal.setBorder(new EmptyBorder(30, 40, 30, 40));
		
		// Establecemos un tamaño preferido para que no aparezca encogida
		panelPrincipal.setPreferredSize(new Dimension(380, 160));
		setContentPane(panelPrincipal);

		// Etiqueta de mensaje centrado
		mensaje = new JLabel("Generador de números de LA LOTERÍA PRIMITIVA", SwingConstants.CENTER);
		mensaje.setFont(new Font("Arial", Font.BOLD, 12));
		panelPrincipal.add(mensaje, BorderLayout.CENTER);

		// Botón de cierre
		btnCerrar = new JButton("Aceptar");
		btnCerrar.addActionListener(this); // Conectamos al método de acción
		
		// Panel inferior para centrar el botón y que no ocupe todo el ancho
		JPanel subPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		subPanel.add(btnCerrar);
		panelPrincipal.add(subPanel, BorderLayout.SOUTH);

		// Empaquetamos los componentes y centramos respecto a la ventana principal
		pack();
		setLocationRelativeTo(padre);
	}

	/**
	 * Gestión del clic en el botón aceptar
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			dispose(); // Cierra y libera la memoria de este JDialog
		}
	}
}
