import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Pantalla {
JTextField pantalla;
    public Pantalla() {
        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(1, 1, 1, 1));
        pantalla.setEditable(false);
    }
    public JTextField RegresarPantalla(){
        return pantalla;
    }

}
