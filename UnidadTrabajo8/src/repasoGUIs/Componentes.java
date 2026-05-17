package repasoGUIs;

import javax.swing.*;
import javax.swing.JFrame;

public class Componentes extends JFrame {
	
	/**
	 * Declaración de los componentes
	 */
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JButton boton;
	private JTextField campo;
	private JCheckBox seleccionador1;
	private ButtonGroup grupo;
	private JRadioButton selector1, selector2, selector3;
	private JComboBox<String> combo;
	private JTextArea area;
	private JScrollPane scrol;
	
	
	/**
	 * Constructor
	 */
	public Componentes() {
		
		// Utilizamo un posicionamiento absoluto
		setLayout(null);
		
		// Inicialización de los componentes
		etiqueta1 = new JLabel("COMPONENTES");
		etiqueta1.setBounds(100, 50, 100, 25);
		add(etiqueta1);
		
		campo = new JTextField();
		campo.setBounds(200, 50, 100, 25);
		add(campo);
		
		etiqueta2 = new JLabel("Area:");
		etiqueta2.setBounds(150, 100, 50, 25);
		add(etiqueta2);
		
		area = new JTextArea();
		area.setLineWrap(true);
		//area.setBounds(150, 125, 100, 50);
		add(area);
		
		scrol = new JScrollPane(area);
		scrol.setBounds(150, 125, 100, 50);
		add(scrol);
		
		boton = new JButton("CLICK");
		boton.setBounds(165, 200, 80, 30);
		add(boton);
		
		seleccionador1 = new JCheckBox("Pulsa");
		seleccionador1.setBounds(140, 250, 100, 25);
		add(seleccionador1);
		
		JCheckBox seleccionador2 = new JCheckBox("Pulsa", true);
		seleccionador2.setBounds(140, 275, 100, 25);
		add(seleccionador2);
		
		grupo = new ButtonGroup();
		
		selector1 = new JRadioButton("Hombre");
		selector1.setBounds(140, 350, 100, 25);
		grupo.add(selector1);
		add(selector1);
		
		selector2 = new JRadioButton("Mujer");
		selector2.setBounds(140, 375, 100, 25);
		grupo.add(selector2);
		add(selector2);
		
		selector3 = new JRadioButton("Animal", true);
		selector3.setBounds(140, 400, 100, 25);
		grupo.add(selector3);
		add(selector3);
		
		combo = new JComboBox<>();
		combo.setBounds(140, 500, 120, 20);
		combo.addItem("Viernes");
		combo.addItem("Sábado");
		combo.addItem("Domingo");
		add(combo);
		
	}

	public static void main(String[] args) {
		// Instanciamos
		Componentes v = new Componentes();
		v.setTitle("Componentes");
		v.setSize(400,800);
		v.setLocationRelativeTo(null);
		v.setVisible(true);
		v.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
