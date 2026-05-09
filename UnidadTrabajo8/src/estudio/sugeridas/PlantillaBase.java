package estudio.sugeridas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class PlantillaBase extends JFrame implements ActionListener {
    private JTextField t1, t2;
    private JTextArea area;
    private JButton btnAccion, btnLimpiar;

    public PlantillaBase() {
        setTitle("Formulario Base");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Panel Principal con margen
        JPanel content = new JPanel(new BorderLayout(10, 10));
        content.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(content);

        // IZQUIERDA: Formulario (GridLayout)
        JPanel pIzquierda = new JPanel(new GridLayout(5, 1, 5, 5));
        pIzquierda.setBorder(new TitledBorder("Datos"));
        pIzquierda.add(new JLabel("Campo 1:"));
        t1 = new JTextField(); pIzquierda.add(t1);
        pIzquierda.add(new JLabel("Campo 2:"));
        t2 = new JTextField(); pIzquierda.add(t2);
        
        btnAccion = new JButton("EJECUTAR");
        pIzquierda.add(btnAccion);
        content.add(pIzquierda, BorderLayout.WEST);

        // CENTRO: Resultados
        area = new JTextArea();
        content.add(new JScrollPane(area), BorderLayout.CENTER);

        // SUR: Botones extra
        btnLimpiar = new JButton("Limpiar");
        content.add(btnLimpiar, BorderLayout.SOUTH);

        // Listeners
        btnAccion.addActionListener(this);
        btnLimpiar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAccion) {
            // Lógica aquí
            area.append(t1.getText() + " - " + t2.getText() + "\n");
        } else if (e.getSource() == btnLimpiar) {
            t1.setText(""); t2.setText(""); area.setText("");
        }
    }

    public static void main(String[] args) { new PlantillaBase().setVisible(true); }
}