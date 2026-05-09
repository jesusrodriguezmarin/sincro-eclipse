package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutFlow6 extends JFrame {
    public LayoutFlow6() {
        setTitle("FlowLayout con 6 Paneles");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        setContentPane(contentPane);

        for (int i = 0; i < 6; i++) {
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(100, 100));
            p.setBackground(new Color(50 * i, 100, 150)); // Colores variados
            p.add(new JLabel("P" + (i + 1)));
            contentPane.add(p);
        }
    }
    public static void main(String[] args) { new LayoutFlow6().setVisible(true); }
}