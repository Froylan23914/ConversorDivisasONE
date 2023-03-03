package conversor;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;



public class GUIConversor {
	
	
	public GUIConversor() {
		// creamos la ventana y le agregamos un titulo
		JFrame miFrame = new JFrame("Conversor de Divisas");
		
		// agregamos un comportamiento al cerrar la ventana
		miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// agregamos contenido al frame 
		agregarElementosalFrame(miFrame.getContentPane());
		
		// desplegamos la ventana
		miFrame.pack();		
		miFrame.setVisible(true);
	}
	
	private void agregarElementosalFrame(Container p) {
		p.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		JComboBox jcbDivisas = new JComboBox();
	}

}
