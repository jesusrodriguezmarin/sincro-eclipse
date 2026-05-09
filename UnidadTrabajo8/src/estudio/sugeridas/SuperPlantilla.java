package estudio.sugeridas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SuperPlantilla extends JFrame implements ActionListener {
    private JTextArea pantalla;
    private JPanel pTeclado;
    private JMenuItem mSalir, mInfo;

    public SuperPlantilla() {
        setBounds(100, 100, 900, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // 1. MENU
        JMenuBar mb = new JMenuBar();
        JMenu m = new JMenu("Archivo");
        mInfo = new JMenuItem("Info"); mSalir = new JMenuItem("Salir");
        m.add(mInfo); m.add(mSalir); mb.add(m); setJMenuBar(mb);

        // 2. LAYOUT PRINCIPAL (null para libertad total o BorderLayout)
        getContentPane().setLayout(null);

        // 3. ZONA DE TEXTO / IMAGEN
        pantalla = new JTextArea();
        pantalla.setBounds(20, 20, 300, 200);
        pantalla.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        getContentPane().add(pantalla);

        // 4. ZONA TECLADO
        pTeclado = new JPanel();
        pTeclado.setBounds(350, 20, 500, 350);
        pTeclado.setBorder(BorderFactory.createTitledBorder("Controles"));
        getContentPane().add(pTeclado);
        
        // Llamada para llenar el teclado
        llenarBotones(pTeclado, "QWERTYUIOPASDFGHJKLÑZXCVBNM");

        // Listeners de menú
        mInfo.addActionListener(this); mSalir.addActionListener(this);
    }

    private void llenarBotones(JPanel panel, String texto) {
        panel.setLayout(new GridLayout(0, 7, 5, 5));
        for(char c : texto.toCharArray()) {
            JButton b = new JButton(String.valueOf(c));
            b.addActionListener(this);
            panel.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mSalir) System.exit(0);
        
        if (e.getSource() instanceof JButton) {
            JButton b = (JButton)e.getSource();
            pantalla.append(b.getText()); // Ejemplo: escribir en pantalla
            // Aquí llamarías a: juego.intentar(b.getText().charAt(0));
        }
    }
    
    public static void main(String[] args) { new SuperPlantilla().setVisible(true); }
}