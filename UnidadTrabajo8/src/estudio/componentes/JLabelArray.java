package estudio.componentes;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

public class JLabelArray extends JFrame {

	private JPanel contentPane;
	// 1. Declaramos el array de etiquetas
	private JLabel[] misEtiquetas = new JLabel[6];

	public JLabelArray() {
		setTitle("Ventana con Array de Etiquetas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 150);
		setLocationRelativeTo(null);
		
		// Usamos GridLayout para que las etiquetas queden alineadas como casillas
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 6, 10, 10)); // 1 fila, 6 columnas, hueco de 10px
		setContentPane(contentPane);

		// 2. Bucle para crear y configurar las etiquetas
		for (int i = 0; i < misEtiquetas.length; i++) {
			// Creamos la etiqueta con texto inicial (por ejemplo un guion bajo)
			misEtiquetas[i] = new JLabel("_", SwingConstants.CENTER);
			
			// Diseño de "Casilla"
			misEtiquetas[i].setFont(new Font("Monospaced", Font.BOLD, 30));
			misEtiquetas[i].setOpaque(true);
			misEtiquetas[i].setBackground(Color.WHITE);
			misEtiquetas[i].setBorder(new LineBorder(Color.BLACK, 2));
			
			// Añadimos al panel
			contentPane.add(misEtiquetas[i]);
		}
	}

	// 3. MÉTODO ÚTIL PARA EL EXAMEN: Cambiar texto de una casilla específica
	public void actualizarCasilla(int posicion, String letra) {
		if (posicion >= 0 && posicion < misEtiquetas.length) {
			misEtiquetas[posicion].setText(letra.toUpperCase());
			misEtiquetas[posicion].setForeground(Color.BLUE);
		}
	}

	public static void main(String[] args) {
		JLabelArray ventana = new JLabelArray();
		ventana.setVisible(true);
		
		// Ejemplo de uso: cambiar la segunda casilla (índice 1)
		ventana.actualizarCasilla(1, "A");
	}
}
