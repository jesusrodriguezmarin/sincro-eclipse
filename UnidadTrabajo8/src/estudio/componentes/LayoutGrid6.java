package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutGrid6 extends JFrame {
    public LayoutGrid6() {
        setTitle("GridLayout 2x3");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 2 filas y 3 columnas
        JPanel contentPane = new JPanel(new GridLayout(2, 3, 10, 10));
        setContentPane(contentPane);

        Color[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK};
        
        for (int i = 0; i < 6; i++) {
            JPanel p = new JPanel();
            p.setBackground(colores[i]);
            p.add(new JLabel("Panel " + (i + 1)));
            contentPane.add(p);
        }
    }
    public static void main(String[] args) { new LayoutGrid6().setVisible(true); }
}