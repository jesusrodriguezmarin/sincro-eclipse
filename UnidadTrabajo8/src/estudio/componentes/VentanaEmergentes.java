package estudio.componentes;

import javax.swing.*;
import java.awt.GridLayout;

public class VentanaEmergentes extends JFrame {

	public VentanaEmergentes() {
		setTitle("Todos los JOptionPane");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Usamos un GridLayout para que todos los botones se vean bien
		setLayout(new GridLayout(3, 2, 10, 10));

		// 1. INFORMACIÓN (Círculo azul "i")
		JButton btnInfo = new JButton("Mostrar Info");
		btnInfo.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Tarea completada.", "Información", JOptionPane.INFORMATION_MESSAGE);
		});

		// 2. ERROR (Círculo rojo "X")
		JButton btnError = new JButton("Mostrar Error");
		btnError.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Fallo en la conexión.", "Error Crítico", JOptionPane.ERROR_MESSAGE);
		});

		// 3. ADVERTENCIA / WARNING (Triángulo amarillo "!")
		JButton btnWarning = new JButton("Mostrar Warning");
		btnWarning.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "Cuidado: El archivo ya existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
		});

		// 4. PREGUNTA (Globo azul "?")
		JButton btnQuestion = new JButton("Mostrar Pregunta");
		btnQuestion.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "¿Está seguro de continuar?", "Duda", JOptionPane.QUESTION_MESSAGE);
		});

		// 5. CONFIRMACIÓN (Botones Sí/No)
		JButton btnConfirma = new JButton("Confirmar Acción");
		btnConfirma.addActionListener(e -> {
			int resp = JOptionPane.showConfirmDialog(this, "¿Deseas borrar los datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
			if (resp == JOptionPane.YES_OPTION) {
				System.out.println("Borrando...");
			}
		});

		// 6. ENTRADA DE DATOS (Input)
		JButton btnInput = new JButton("Pedir Texto");
		btnInput.addActionListener(e -> {
			String texto = JOptionPane.showInputDialog(this, "Introduce tu código:");
			if (texto != null) {
				System.out.println("El usuario escribió: " + texto);
			}
		});

		// Añadir todos al frame
		add(btnInfo);
		add(btnError);
		add(btnWarning);
		add(btnQuestion);
		add(btnConfirma);
		add(btnInput);
	}

	public static void main(String[] args) {
		new VentanaEmergentes().setVisible(true);
	}
}