import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PanelOperaciones {
	private JPanel PanelOperaciones ;
	public PanelOperaciones (){
		PanelOperaciones = new JPanel();
        	PanelOperaciones.setLayout(new GridLayout(4, 3));
        	PanelOperaciones.setBorder(new EmptyBorder(1, 1, 1, 1));	
	}
	public JPanel RegresarPanel(){
        	return PanelOperaciones ;
    	}
}
