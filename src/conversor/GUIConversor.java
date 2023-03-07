package conversor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class GUIConversor implements ActionListener{
	
	private Convertidor convertidor;
	private	List<String> listaDivisas;
	private JFrame miFrame;
	
	
	public GUIConversor() {
		this.convertidor = new Convertidor();
		this.listaDivisas = convertidor.getArrayListDivisas()
								  .stream()
								  .sorted(Comparator.comparing(String::toString))
								  .collect(Collectors.toList());
		// creamos la ventana y le agregamos un titulo
		miFrame = new JFrame("Conversor de Divisas");
		
		// agregamos un comportamiento al cerrar la ventana
		miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// agregamos contenido al frame 
		agregarElementosalFrame();
		
		// desplegamos la ventana
		miFrame.pack();		
		miFrame.setVisible(true);
	}
	
	private void agregarElementosalFrame() {
		JPanel panelPadre = new JPanel();
		panelPadre.setLayout(new BoxLayout(panelPadre, BoxLayout.Y_AXIS));

		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.X_AXIS));
		JLabel label = new JLabel("Divisa Entrada:");
		panelAux.add(label);
		JComboBox<String> jcbDivisaEntrada = new JComboBox(listaDivisas.toArray());
		jcbDivisaEntrada.setSelectedIndex(0);
		panelAux.add(jcbDivisaEntrada);
		panelPadre.add(panelAux);

		panelAux = new JPanel();
		panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.X_AXIS));
		label = new JLabel("Ingrese Cantidad:");
		panelAux.add(label);
		JTextField jtfCantidad = new JTextField(15);
		panelAux.add(jtfCantidad);
		panelPadre.add(panelAux);

		panelAux = new JPanel();
		panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.X_AXIS));
		label = new JLabel("Divisa Salida:");
		panelAux.add(label);
		JComboBox<String> jcbDivisaSalida = new JComboBox(listaDivisas.toArray());
		jcbDivisaSalida.setSelectedIndex(0);
		panelAux.add(jcbDivisaSalida);
		panelPadre.add(panelAux);

		JButton jbConvertirDivisa = new JButton("Convertir");
		jbConvertirDivisa.addActionListener(this);
		panelPadre.add(jbConvertirDivisa);

		miFrame.add(panelPadre);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("Convertir".equals(e.getActionCommand())){
			JOptionPane.showMessageDialog(miFrame,
										"Valor",
										"Resultado",
										JOptionPane.PLAIN_MESSAGE);
		}
		
	}

}
