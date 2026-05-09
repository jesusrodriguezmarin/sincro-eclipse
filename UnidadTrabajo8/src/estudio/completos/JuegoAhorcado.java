package estudio.completos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JuegoAhorcado extends JFrame implements ActionListener {

    private String palabraSecreta = "MURCIA";
    private String palabraVisible = "";
    private int fallos = 0;
    private final int MAX_FALLOS = 6;

    private JLabel lblPalabra, lblImagen;
    private JPanel panelTeclado;
    private JButton[] botonesTeclado = new JButton[26];

    public JuegoAhorcado() {
        setTitle("Ahorcado con Feedback");
        setSize(600, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. IMAGEN / ESTADO (Norte)
        lblImagen = new JLabel("Intentos fallidos: " + fallos, SwingConstants.CENTER);
        lblImagen.setFont(new Font("Arial", Font.BOLD, 16));
        lblImagen.setPreferredSize(new Dimension(200, 100));
        add(lblImagen, BorderLayout.NORTH);

        // 2. PALABRA OCULTA (Centro)
        lblPalabra = new JLabel("", SwingConstants.CENTER);
        lblPalabra.setFont(new Font("Monospaced", Font.BOLD, 35));
        add(lblPalabra, BorderLayout.CENTER);

        // 3. TECLADO (Sur)
        panelTeclado = new JPanel(new GridLayout(3, 9, 5, 5));
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < letras.length(); i++) {
            botonesTeclado[i] = new JButton(String.valueOf(letras.charAt(i)));
            botonesTeclado[i].addActionListener(this);
            panelTeclado.add(botonesTeclado[i]);
        }
        add(panelTeclado, BorderLayout.SOUTH);
        
        inicializarJuego();
    }

    private void inicializarJuego() {
        // Inicializamos la palabra con guiones bajos
        palabraVisible = "";
        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraVisible += "_ ";
        }
        lblPalabra.setText(palabraVisible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        char letraPulsada = btn.getText().charAt(0);
        btn.setEnabled(false); // No se puede volver a pulsar

        // LÓGICA DE COMPROBACIÓN
        if (palabraSecreta.indexOf(letraPulsada) >= 0) {
            // ACIERTO
            actualizarPalabraVisible(letraPulsada);
            JOptionPane.showMessageDialog(this, "¡Bien! La letra '" + letraPulsada + "' se encuentra en la palabra.", "Acierto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // FALLO
            fallos++;
            lblImagen.setText("Intentos fallidos: " + fallos + " / " + MAX_FALLOS);
            JOptionPane.showMessageDialog(this, "Lo siento, la letra '" + letraPulsada + "' NO está.", "Fallo", JOptionPane.WARNING_MESSAGE);
        }

        comprobarEstado();
    }

    private void actualizarPalabraVisible(char letra) {
        StringBuilder nuevaPalabra = new StringBuilder();
        for (int i = 0; i < palabraSecreta.length(); i++) {
            // Comparamos la letra de la palabra real con la pulsada
            if (palabraSecreta.charAt(i) == letra) {
                nuevaPalabra.append(letra).append(" ");
            } else {
                // Mantenemos lo que ya estaba (letra o guion)
                nuevaPalabra.append(palabraVisible.charAt(i * 2)).append(" ");
            }
        }
        palabraVisible = nuevaPalabra.toString();
        lblPalabra.setText(palabraVisible);
    }

    private void comprobarEstado() {
        if (!palabraVisible.contains("_")) {
            JOptionPane.showMessageDialog(this, "¡ENHORABUENA! Has ganado. La palabra era: " + palabraSecreta);
            System.exit(0);
        } else if (fallos >= MAX_FALLOS) {
            JOptionPane.showMessageDialog(this, "GAME OVER. Te has quedado sin intentos.\nLa palabra era: " + palabraSecreta, "Fin del juego", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new JuegoAhorcado().setVisible(true);
    }
}