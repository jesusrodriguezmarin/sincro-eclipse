package estudio.completos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCifrado extends JFrame implements ActionListener {

    private JTextArea areaInput, areaOutput;
    private JTextField txtClaveCesar;
    private JRadioButton rbCesar, rbRot13, rbRiel;
    private ButtonGroup grupoMetodos;
    private JButton btnCifrar, btnDescifrar;

    public VentanaCifrado() {
        setTitle("Sistema de Cifrado Simplificado");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 15));

        // --- PANEL NORTE: Métodos y Clave César ---
        JPanel pNorte = new JPanel(new GridLayout(2, 1));
        
        JPanel pRadios = new JPanel();
        rbCesar = new JRadioButton("César", true);
        rbRot13 = new JRadioButton("ROT13");
        rbRiel = new JRadioButton("Riel (Simple)");
        
        grupoMetodos = new ButtonGroup();
        grupoMetodos.add(rbCesar);
        grupoMetodos.add(rbRot13);
        grupoMetodos.add(rbRiel);
        
        pRadios.add(rbCesar); 
        pRadios.add(rbRot13); 
        pRadios.add(rbRiel);
        pNorte.add(pRadios);

        JPanel pClave = new JPanel();
        pClave.add(new JLabel("Clave para César:"));
        txtClaveCesar = new JTextField("3", 5);
        pClave.add(txtClaveCesar);
        pNorte.add(pClave);
        
        add(pNorte, BorderLayout.NORTH);

        // --- PANEL CENTRAL: Texto ---
        JPanel pCentral = new JPanel(new GridLayout(2, 1, 10, 10));
        areaInput = new JTextArea("Mensaje...");
        areaInput.setLineWrap(true);
        areaOutput = new JTextArea("Resultado...");
        areaOutput.setEditable(false);
        areaOutput.setBackground(new Color(245, 245, 245));
        
        pCentral.add(new JScrollPane(areaInput));
        pCentral.add(new JScrollPane(areaOutput));
        add(pCentral, BorderLayout.CENTER);

        // --- PANEL SUR: Botones ---
        JPanel pSur = new JPanel();
        btnCifrar = new JButton("CIFRAR");
        btnDescifrar = new JButton("DESCIFRAR");
        btnCifrar.addActionListener(this);
        btnDescifrar.addActionListener(this);
        pSur.add(btnCifrar);
        pSur.add(btnDescifrar);
        add(pSur, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = areaInput.getText();
        
        if (e.getSource() == btnCifrar) {
            if (rbCesar.isSelected()) {
                int clave = obtenerClave();
                areaOutput.setText(cifrarCesar(texto, clave));
            } else if (rbRot13.isSelected()) {
                areaOutput.setText(cifrarCesar(texto, 13));
            } else if (rbRiel.isSelected()) {
                areaOutput.setText(cifrarRielSimple(texto));
            }
        } else {
            if (rbCesar.isSelected()) {
                int clave = obtenerClave();
                areaOutput.setText(cifrarCesar(texto, -clave));
            } else if (rbRot13.isSelected()) {
                areaOutput.setText(cifrarCesar(texto, -13));
            } else if (rbRiel.isSelected()) {
                areaOutput.setText(descifrarRielSimple(texto));
            }
        }
    }

    private int obtenerClave() {
        try {
            return Integer.parseInt(txtClaveCesar.getText().trim());
        } catch (NumberFormatException e) {
            return 3;
        }
    }

    // LÓGICA CÉSAR / ROT13
    private String cifrarCesar(String t, int d) {
        StringBuilder res = new StringBuilder();
        for (char c : t.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int pos = (c - base + d) % 26;
                if (pos < 0) pos += 26;
                res.append((char) (base + pos));
            } else res.append(c);
        }
        return res.toString();
    }

    // LÓGICA RIEL SIMPLE (2 niveles fijos)
    private String cifrarRielSimple(String t) {
        StringBuilder fila1 = new StringBuilder();
        StringBuilder fila2 = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            if (i % 2 == 0) fila1.append(t.charAt(i));
            else fila2.append(t.charAt(i));
        }
        return fila1.toString() + fila2.toString();
    }

    private String descifrarRielSimple(String t) {
        int mitad = (int) Math.ceil(t.length() / 2.0);
        String fila1 = t.substring(0, mitad);
        String fila2 = t.substring(mitad);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mitad; i++) {
            res.append(fila1.charAt(i));
            if (i < fila2.length()) res.append(fila2.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        new VentanaCifrado().setVisible(true);
    }
}