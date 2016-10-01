/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Alumno
 */
public class Registro extends JFrame {

    JPanel panelPrincipal, panelBotones, panelCuadritos, panelCuadritos2, PanelRegistro;
    JTextField usuario, pass;
    JTextField usuarioR, passR;

    public Registro() {
        super();
        setSize(600, 600);
        setTitle("Registro");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        panelBotones = new JPanel();

        panelCuadritos = new JPanel();
        panelCuadritos.setLayout(new BoxLayout(panelCuadritos, BoxLayout.Y_AXIS));
        panelCuadritos2 = new JPanel();
        panelCuadritos2.setLayout(new BorderLayout());

        PanelRegistro = new JPanel();
        PanelRegistro.setLayout(new BorderLayout());

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

        Pantalla in1 = new Pantalla(false, 3);
        usuarioR = in1.RegresarPantalla();
        Pantalla in2 = new Pantalla(false, 3);
        passR = in2.RegresarPantalla();

        Pantalla b = new Pantalla(true, 1);
        pass = b.RegresarPantalla();
        pass.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                pass.setText("");
            }

            public void focusLost(FocusEvent e) {
                // nothing
            }
        });
        pass.setText("Contraseña");
        passR.setText("Ingresa una password:");
        usuario.setText("Nombre");
        usuarioR.setText("Ingresa un usuario:");

        nuevoBotonOperacion("Registrar");
        nuevoBotonOperacion("Regresar");
        panelCuadritos.add(this.usuarioR);
        panelCuadritos.add(this.usuario);
        panelCuadritos.add(this.passR);
        panelCuadritos.add(this.pass);

        panelPrincipal.add("North", panelCuadritos);
        panelPrincipal.add("Center", panelBotones);

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
        panelBotones.add(btn);
    }

    private void operacionPulsado(String tecla) {
        int num = 0;
        switch (tecla) {
            case "Registrar":
                boolean condicion = Validacion();
                if(condicion){
                    JOptionPane.showMessageDialog(null, "¡Ha sido registrado!");
                    Usuario user = new Usuario();
                    user.setNombre(usuario.getText());
                    user.setPass(pass.getText());
                    Cajero c = new Cajero(user);
                    c.setVisible(condicion);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "¡Porfavor, valida los datos!");
                }
                break;
            case "Regresar":
                MenuInicial m = new MenuInicial();
                m.setVisible(true);
                this.dispose();
                break;
            default:
                break;
        }
    }

    private boolean Validacion() {
        if (pass.getText().equals("")||usuario.getText().equals("")) {
            return false;
        } else return true;        
    }
}
