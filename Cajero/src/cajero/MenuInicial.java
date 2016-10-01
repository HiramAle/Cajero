/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class MenuInicial extends JFrame {

    JPanel panelPrincipal, Botton;
    ImageIcon imagen;
    JLabel texto;

    public MenuInicial() {
        super();
        setSize(600, 600);
        setTitle("Cajerito");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        Botton = new JPanel();
        nuevoBotonOperacion("Iniciar Sesion");
        nuevoBotonOperacion("Registrarse");
        
        
        
        
        texto = new JLabel();
        texto.setIcon(new ImageIcon(getClass().getResource("/Cajero/banamex.gif")));
        texto.setSize(600, 400);
        texto.setVisible(true);
        panelPrincipal.add(texto);
        
        panelPrincipal.add("Center", Botton);

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
        Botton.add(btn);
    }

    private void operacionPulsado(String tecla) {
        int num = 0;
        if (tecla.equals("Iniciar Sesion")) {
            Inicio log = new Inicio();
            log.setVisible(true);
            this.dispose();
        } else if (tecla.equals("Registrarse")) {
           Registro Reg = new Registro();
           Reg.setVisible(true);
           this.dispose();
        }
    }
}
