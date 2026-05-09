package estudio.componentes;

import javax.swing.*;

public class EJSlider extends JFrame {

	public EJSlider() {
		setTitle("Plantilla Slider");
		setBounds(100, 100, 400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		// JSlider(mínimo, máximo, valor inicial)
		JSlider slider = new JSlider(0, 100, 50);
		slider.setBounds(20, 40, 340, 50);
		
		// Marcas visuales
		slider.setMajorTickSpacing(20); // Marcas grandes cada 20
		slider.setMinorTickSpacing(5);  // Marcas pequeñas cada 5
		slider.setPaintTicks(true);     // Mostrar marcas
		slider.setPaintLabels(true);    // Mostrar números

		JLabel lblValor = new JLabel("Valor: 50");
		lblValor.setBounds(160, 100, 100, 30);

		// Evento para cuando se mueve el slider
		slider.addChangeListener(e -> {
			lblValor.setText("Valor: " + slider.getValue());
		});

		getContentPane().add(slider);
		getContentPane().add(lblValor);
	}

	public static void main(String[] args) { new EJSlider().setVisible(true); }
}