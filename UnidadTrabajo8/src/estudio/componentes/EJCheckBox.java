package estudio.componentes;

import javax.swing.*;

public class EJCheckBox extends JFrame {

	private JCheckBox chkJava, chkPython;

	public EJCheckBox() {
		setTitle("Plantilla CheckBox");
		setBounds(100, 100, 300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		chkJava = new JCheckBox("Java");
		chkJava.setBounds(20, 20, 100, 30);
		getContentPane().add(chkJava);

		chkPython = new JCheckBox("Python");
		chkPython.setBounds(20, 50, 100, 30);
		getContentPane().add(chkPython);

		JButton btn = new JButton("Comprobar");
		btn.setBounds(20, 100, 120, 30);
		btn.addActionListener(e -> {
			String msg = "Sabes: ";
			if (chkJava.isSelected()) msg += "Java ";
			if (chkPython.isSelected()) msg += "Python";
			JOptionPane.showMessageDialog(this, msg);
		});
		getContentPane().add(btn);
	}

	public static void main(String[] args) { new EJCheckBox().setVisible(true); }
}