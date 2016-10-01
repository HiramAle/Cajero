/*
 * New Ligths
 * Services info Web
 * Rubio Haro 
 */
package cajero;

import javax.swing.UIManager;

/**
 *
 * @author Rod
 */
public class CajeroMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        MenuInicial m = new MenuInicial();
        m.setVisible(true);
    }
}
