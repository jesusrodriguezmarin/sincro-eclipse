package estudio.componentes;

import javax.swing.*;
import java.awt.event.*;

public class VentanaSecundaria extends JDialog {

	private JPanel contentPane;
	private JButton btnCerrar;
	private JLabel lblMensaje;

	// El constructor recibe el JFrame "padre" para poder bloquearlo
	public VentanaSecundaria(JFrame padre, boolean modal) {
		super(padre, modal); // Llama al constructor de JDialog
		
		setTitle("Ventana Secundaria");
		setBounds(150, 150, 300, 200);
		setLocationRelativeTo(padre); // Se centra respecto a la principal
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);

		lblMensaje = new JLabel("Esta es una ventana secundaria", SwingConstants.CENTER);
		lblMensaje.setBounds(10, 40, 260, 30);
		contentPane.add(lblMensaje);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(90, 100, 100, 30);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Para cerrar una ventana secundaria se usa dispose()
				dispose(); 
			}
		});
		contentPane.add(btnCerrar);
	}
}