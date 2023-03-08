package conversor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.util.ArrayList;
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
	private JComboBox<String> jcbDivisaEntrada;
	private JComboBox<String> jcbDivisaSalida;
	private JTextField jtfCantidad;
	
	
	public GUIConversor() {
		// creamos una nueva Instancia de la clase Convertidor
		this.convertidor = new Convertidor();
		// obtenemos la lista de divisas y los ordenamos por orden Alfabetico
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
		// creamos el panel que contendra a los demas paneles.
		JPanel panelPadre = new JPanel();
		// la orientacion sera vertical
		panelPadre.setLayout(new BoxLayout(panelPadre, BoxLayout.Y_AXIS));

		//creamos una lista con los elementos que tendra el nuevo panel
		List<Component> elementosDelPanel = new ArrayList<Component>();
		elementosDelPanel.add(new JLabel("Divisa Entrada:"));
		jcbDivisaEntrada = new JComboBox(listaDivisas.toArray());
		jcbDivisaEntrada.setSelectedIndex(0);
		elementosDelPanel.add(jcbDivisaEntrada);
		agregarPanel(panelPadre,elementosDelPanel);

		// hacemos nueva lista para agregar a un nuevo panel
		elementosDelPanel = new ArrayList<Component>();
		elementosDelPanel.add(new JLabel("Ingrese Cantidad:"));
		jtfCantidad = new JTextField(15);
		elementosDelPanel.add(jtfCantidad);
		agregarPanel(panelPadre,elementosDelPanel);


		elementosDelPanel = new ArrayList<Component>();
		elementosDelPanel.add(new JLabel("Divisa Salida:"));
		jcbDivisaSalida = new JComboBox(listaDivisas.toArray());
		jcbDivisaSalida.setSelectedIndex(listaDivisas.indexOf("Peso Mexicano"));
		elementosDelPanel.add(jcbDivisaSalida);
		agregarPanel(panelPadre,elementosDelPanel);

		elementosDelPanel = new ArrayList<Component>();
		JButton jbIntercambiarDivisas = new JButton("Intercambiar Divisas");
		jbIntercambiarDivisas.addActionListener(this);
		elementosDelPanel.add(jbIntercambiarDivisas);
		JButton jbConvertirDivisa = new JButton("Convertir");
		jbConvertirDivisa.addActionListener(this);
		elementosDelPanel.add(jbConvertirDivisa);
		agregarPanel(panelPadre,elementosDelPanel);

		miFrame.add(panelPadre);
	}

	private void agregarPanel(JPanel panelPadre, List<Component> componentes){
		//creamos el panel hijo
		JPanel panelAux = new JPanel();
		// la orientacion sera horizontal.
		panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.X_AXIS));
		for(Component componente:componentes){
			panelAux.add(componente);
		}
		panelPadre.add(panelAux);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if("Intercambiar Divisas".equals(evento.getActionCommand())){
			int aux = jcbDivisaEntrada.getSelectedIndex();
			jcbDivisaEntrada.setSelectedIndex(jcbDivisaSalida.getSelectedIndex());
			jcbDivisaSalida.setSelectedIndex(aux);
		}else if("Convertir".equals(evento.getActionCommand())){// verificamos que el boton Convertir fue ejecutado
			// obtenemos el texto del Texfiel cantidad y limpiamos de espacios
			String txtCantidad = jtfCantidad.getText().trim();
			
			// verificamos que no sea null y que no sea vacio la entrada.
			if(txtCantidad == null || txtCantidad.isEmpty()){
					JOptionPane.showMessageDialog(miFrame,
											"Debe Ingresar una cantidad",
											"Campo vacio",
											JOptionPane.WARNING_MESSAGE);
					return;
			}
			try{
				// Obtenemos las 2 divisas de los 2 combobox
				String divisa1 = jcbDivisaEntrada.getSelectedItem().toString();
				String divisa2 = jcbDivisaSalida.getSelectedItem().toString();

				//intentamos convertir la entrada de textfield a un double
				double cantidad = Double.parseDouble(txtCantidad);

				//obtenermos el factor de conversion  entre las 2 divisas y multiplicamos por la cantidad
				double resultado = cantidad * this.convertidor.getFactorConversion(divisa2,divisa1);

				// redondeamos a 2 cifras.
				resultado = Math.round(resultado * 100d) / 100d;

				//Mostramos el valor ya redondeado
				JOptionPane.showMessageDialog(miFrame,
										resultado,
										divisa1 + " => " + divisa2,
										JOptionPane.PLAIN_MESSAGE);
			}catch(NumberFormatException ex){ // en caso de que coloco letras en el texfield en vez de numeros
				JOptionPane.showMessageDialog(miFrame,
										"El valor de entrada debe ser un numero: " + txtCantidad,
										"Error de valor de Entrada",
										JOptionPane.ERROR_MESSAGE);
			}catch(Exception ex){// muestra algun error que no contemplamos.
				JOptionPane.showMessageDialog(miFrame,
										ex.getMessage(),
										"Error",
										JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
