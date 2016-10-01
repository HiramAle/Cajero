import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelNumeros {

    private JPanel panelNumeros;

    public PanelNumeros() {
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(1, 1, 1, 1));
    }
    public JPanel RegresarPanel(){
        return panelNumeros;
    }
}