package estudio.componentes;

import javax.swing.*;
import java.awt.*;

public class LayoutBorder6 extends JFrame {
    public LayoutBorder6() {
        setTitle("BorderLayout con 6 Paneles");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel(new BorderLayout(5, 5));
        setContentPane(contentPane);

        // Paneles básicos
        JPanel p1 = new JPanel(); p1.setBackground(Color.RED); 
        contentPane.add(p1, BorderLayout.NORTH);

        JPanel p2 = new JPanel(); p2.setBackground(Color.BLUE); 
        contentPane.add(p2, BorderLayout.SOUTH);

        JPanel p3 = new JPanel(); p3.setBackground(Color.GREEN); 
        contentPane.add(p3, BorderLayout.WEST);

        JPanel p4 = new JPanel(); p4.setBackground(Color.YELLOW); 
        contentPane.add(p4, BorderLayout.EAST);

        // EL TRUCO: En el CENTER metemos un panel que contiene los otros 2
        JPanel pCentroContenedor = new JPanel(new GridLayout(2, 1, 5, 5));
        
        JPanel p5 = new JPanel(); p5.setBackground(Color.ORANGE);
        JPanel p6 = new JPanel(); p6.setBackground(Color.MAGENTA);
        
        pCentroContenedor.add(p5);
        pCentroContenedor.add(p6);
        
        contentPane.add(pCentroContenedor, BorderLayout.CENTER);
    }
    public static void main(String[] args) { new LayoutBorder6().setVisible(true); }
}