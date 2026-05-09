package estudio.completos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaLogin extends JFrame implements ActionListener {

    // Componentes
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnEntrar, btnLimpiar;
    
    // Credenciales correctas (En un examen pueden estar fijas o venir de un fichero)
    private final String USUARIO_CORRECTO = "admin";
    private final String PASS_CORRECTA = "1234";

    public VentanaLogin() {
        setTitle("Acceso al Sistema");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(3, 2, 10, 10));

        // 1. Fila Usuario
        add(new JLabel("  Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        // 2. Fila Contraseña
        add(new JLabel("  Contraseña:"));
        txtPassword = new JPasswordField();
        // Opcional: cambiar el carácter de ocultación (por defecto es un punto)
        txtPassword.setEchoChar('*'); 
        add(txtPassword);

        // 3. Fila Botones
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this);
        add(btnLimpiar);

        btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(this);
        add(btnEntrar);
        
        // Hacer que el botón Entrar se active al pulsar "Enter" en el teclado
        getRootPane().setDefaultButton(btnEntrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLimpiar) {
            txtUsuario.setText("");
            txtPassword.setText("");
            txtUsuario.requestFocus(); // Pone el cursor de nuevo en el usuario
        }

        if (e.getSource() == btnEntrar) {
            String user = txtUsuario.getText().trim();
            
            // IMPORTANTE: getPassword() devuelve un char[], hay que convertirlo a String
            String pass = new String(txtPassword.getPassword());

            if (user.equals(USUARIO_CORRECTO) && pass.equals(PASS_CORRECTA)) {
                JOptionPane.showMessageDialog(this, "¡Bienvenido, " + user + "!", "Acceso Concedido", JOptionPane.INFORMATION_MESSAGE);
                
                // Aquí abrirías la ventana principal y cerrarías esta
                // new PlantillaVentanaPrincipal().setVisible(true);
                // this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error de Acceso", JOptionPane.ERROR_MESSAGE);
                txtPassword.setText(""); // Por seguridad, borramos la clave
            }
        }
    }

    public static void main(String[] args) {
        new VentanaLogin().setVisible(true);
    }
}