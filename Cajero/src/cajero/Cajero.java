package cajero;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Cajero extends JFrame {

    int num = 0;
    Usuario user;
    JTextField Texto01, Texto02, Texto03, Texto04;
    JPanel PanelPrinipal, PanelNum, PanelOp;

    public Cajero(Usuario user) {

        super();
        setSize(600, 600);
        setTitle("Cajero");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = (JPanel) this.getContentPane();
        panelPrincipal.setLayout(new BorderLayout());

        this.user = user;

        Pantalla Pantallita = new Pantalla(false, 1);
        this.Texto01 = Pantallita.RegresarPantalla();
        this.Texto01.setText("Cuenta de: " + user.getNombre());

        Pantalla Texto1 = new Pantalla(false, 2);
        this.Texto02 = Texto1.RegresarPantalla();
        this.Texto02.setText("Saldo: " + user.getSaldo());

        Pantalla Texto2 = new Pantalla(false, 4);
        this.Texto03 = Texto2.RegresarPantalla();
        this.Texto03.setText("Ingrese el dinero");

        Pantalla Texto3 = new Pantalla(true, 3);
        this.Texto04 = Texto3.RegresarPantalla();
        this.Texto04.setText("0");
        this.Texto04.requestFocusInWindow();

        JPanel panelTextos = new JPanel();
        panelTextos.add(this.Texto01);
        panelTextos.add(this.Texto02);
        panelTextos.add(this.Texto03);
        panelTextos.add(this.Texto04);

        PanelOp = new JPanel();
        nuevoBotonOperacion("Depositar");
        nuevoBotonOperacion("Retirar");
        nuevoBotonOperacion("Regresar");

        panelPrincipal.add("Center", panelTextos);
        panelPrincipal.add("South", PanelOp);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        if (btn.getText().equals("Depositar")) {
            Color Cl = new Color(0, 100, 0);
            btn.setForeground(Cl);
        } else {
            Color Cl = new Color(255, 69, 0);
            btn.setForeground(Cl);
        }
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });
        PanelOp.add(btn);
    }

    private void operacionPulsado(String tecla) {
        Texto03.setText("Procesando...");
        try {
            num = Integer.parseInt(this.Texto04.getText());
        } catch (Exception e) {
            Texto03.setText("Ingresa un numero");
        }
        boolean condicion = false;
        switch (tecla) {
            case "Depositar":
                condicion = validar();
                if (condicion && num > this.user.getSaldo()) {
                    user.setSaldo(this.user.getSaldo() + num);
                    Texto02.setText("Saldo actual: " + this.user.getSaldo());
                    Texto03.setText("Transaccion Exitosa");
                } else {
                    Texto03.setText("Ingresa un numero valido");
                }
                Texto04.setText("0");
                break;
            case ("Retirar"):
                if (this.user.getSaldo() >= num) {

                    int Sure;
                    Sure = JOptionPane.YES_NO_OPTION;
                    condicion = validar();
                    if (condicion) {
                        Sure = JOptionPane.showConfirmDialog(null, "Retirar $" + num + "?", "Confirmacion", Sure);
                        switch (Sure) {
                            case JOptionPane.NO_OPTION:
                                //Opcion que no
                                Texto03.setText("Operacion Anulada");
                                break;
                            case JOptionPane.YES_OPTION:
                                user.setSaldo(this.user.getSaldo() - num);
                                Texto03.setText("Operacion Exitosa");
                                //Opcion que si
                                Texto03.setText("Anulado");
                                break;
                            case JOptionPane.CLOSED_OPTION:
                                Texto03.setText("Anulado");
                                break;
                            default:
                                break;
                        }
                    } else {
                        Texto03.setText("Ingresa un numero valido");
                    }

                    Texto04.setText("0");

                } else {
                    Texto03.setText("Ya no tienes dinero");
                    Texto04.setText("0");
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

    private boolean validar() {
        if (num <= 0) {
            num = 0;
            Texto03.setText("Ingresa un numero valido");
            return false;
        } else {
            return true;
        }
    }
}
