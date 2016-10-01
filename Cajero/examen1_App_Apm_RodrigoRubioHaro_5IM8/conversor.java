
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.BorderLayout;

public class conversor extends JFrame {	
	double result;
	String op;
	JPanel panelPrincipal , PNumeros , POperaciones ;
	JTextField pantalla;
	boolean condicion = true;

	
	public conversor(){
		super();
        	setSize(450, 450);
        	setTitle("Calculadora Simple");
        	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        	setResizable(false);		
		
		JPanel panelPrincipal = (JPanel) this.getContentPane();
        	panelPrincipal.setLayout(new BorderLayout());
		
	        Pantalla pantallita = new Pantalla();
        	this.pantalla = pantallita.RegresarPantalla();

        	PanelNumeros Numeros = new PanelNumeros();
        	this.PNumeros = Numeros.RegresarPanel();

        	PanelOperaciones Operaciones = new PanelOperaciones();
        	this.POperaciones = Operaciones.RegresarPanel();
		
				
	//Agregarbotones
	for(int i=0; i<=9; i++){
		GenerarBotonNumerico(""+i);
	}	
	panelPrincipal.add("North",pantalla);
		panelPrincipal.add("Center",PNumeros);
		panelPrincipal.add("East",POperaciones);

	validate();

	}
	
	private void GenerarBotonNumerico(String num) {
        JButton btn = new JButton();
        btn.setText(num);
        btn.addMouseListener(new MouseAdapter() {@Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());}
        });

        PNumeros.add(btn);
    }
	
	public void numeroPulsado(String digito){
		JButton btn = new JButton(digito);	
	}
}