package cajero;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *Pantalla de la calculadora
 * @author Rod
 */
public class Pantalla {
private final JTextField pantalla;
    public Pantalla(boolean b,int a) {
        
        
        pantalla = new JTextField("0", 40);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Century Gothic", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(JTextField.CENTER);
        pantalla.setEditable(b);
        pantalla.setText("Cajero Automatico");
    }
    
    public JTextField RegresarPantalla(){
        return pantalla;
    }
}
