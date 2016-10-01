/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class Inicio extends JFrame {
    JPanel Principal, Botones, Panel;
    JTextField usuario;
    JPasswordField Contra;

    public Inicio() {
        super();
        setSize(600, 600);
        setTitle("Cajero");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        

        Principal = (JPanel) this.getContentPane();
        Principal.setLayout(new BorderLayout());

        Botones = new JPanel();
        Panel = new JPanel();
        Panel.setLayout(new BorderLayout());

        Pantalla p = new Pantalla(true, 1);
        usuario = p.RegresarPantalla();
        usuario.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                usuario.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
        usuario.setText("Nombre de Usuario");
        Contra = new JPasswordField("0", 20);
        Contra.setBorder(new EmptyBorder(4, 4, 4, 4));
        Contra.setFont(new Font("Century Gothic", Font.BOLD, 30));
        Contra.setHorizontalAlignment(JTextField.CENTER);
        Contra.setEditable(true);
        usuario.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                usuario.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
        Contra.setText("Password");

        nuevoBotonOperacion("Iniciar Sesion");
        nuevoBotonOperacion("Regresar");
        Panel.add("North", this.usuario);
        Panel.add("Center", this.Contra);

        Principal.add("North", Panel);
        Principal.add("Center", Botones);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        Botones.add(btn);
    }

    private void operacionPulsado(String tecla) {
        int num = 0;
        if (tecla.equals("Iniciar Sesion")) {
            this.dispose();
        } else if (tecla.equals("Registrarse")) {
        } else if (tecla.equals("Regresar")) {
            MenuInicial m = new MenuInicial();
            m.setVisible(true);
            this.dispose();
        }
    }
}
