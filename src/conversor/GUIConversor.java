package conversor;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.Box;
import javax.swing.border.EmptyBorder;

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
		
		// ajustamos el frame a su contenido
		miFrame.pack();	
		// quitamos la propiedad de redimencionar el frame
		miFrame.setResizable(false);
		//obtenemos el tamano de la pantalla y colocamos el frame en el centro
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = ((screenSize.width)/2)-(miFrame.getWidth()/2);
		int y = ((screenSize.height)/2)-(miFrame.getHeight()/2);
		miFrame.setLocation(x, y);
		// desplegamos la ventana
		miFrame.setVisible(true);
	}
	
	private void agregarElementosalFrame() {
		//Definimos el tamano de los elementos de la izquierda y derecha
		Dimension sizeDerecha = new Dimension(150, 20);
		Dimension sizeIzquierda = new Dimension(150, 20);
		Dimension sizeBotones = new Dimension(200, 50);
		
		// creamos el panel que contendra a los demas paneles.
		JPanel panelPadre = new JPanel();
		// la orientacion sera vertical
		panelPadre.setLayout(new BoxLayout(panelPadre, BoxLayout.Y_AXIS));

		//creamos una lista  de componentes.
		List<Component> elementosDelPanel = new ArrayList<Component>();
		// creamos label, definimos su tamano y agregamos a la lista
		JLabel auxLabel = new JLabel("Divisa Entrada:");
		setSizeOf(auxLabel,sizeIzquierda);
		elementosDelPanel.add(auxLabel);
		//creamos un combobox con la lista de las divisas y colocamos la opcion de la primera divisa
		jcbDivisaEntrada = new JComboBox(listaDivisas.toArray());
		jcbDivisaEntrada.setSelectedIndex(0);
		// le damos un tamano y lo agregamos el combobox a la lista
		setSizeOf(jcbDivisaEntrada,sizeDerecha);
		elementosDelPanel.add(jcbDivisaEntrada);
		// agregamos todos los elementos de la lista a un nuevo panel y este agregarlo al panel padre
		agregarPanel(panelPadre,elementosDelPanel);

		// hacemos nueva lista para agregar a un nuevo panel
		elementosDelPanel = new ArrayList<Component>();
		// creamos label, definimos su tamano y agregamos a la lista
		auxLabel = new JLabel("Ingrese Cantidad:");
		setSizeOf(auxLabel,sizeIzquierda);
		elementosDelPanel.add(auxLabel);
		// creamos un textfield, le damos un tamano y lo agregamos a la lista
		jtfCantidad = new JTextField(10);
		setSizeOf(jtfCantidad,sizeDerecha);
		elementosDelPanel.add(jtfCantidad);
		// agregamos todos los elementos de la lista a un nuevo panel y este agregarlo al panel padre
		agregarPanel(panelPadre,elementosDelPanel);

		// hacemos nueva lista para agregar a un nuevo panel
		elementosDelPanel = new ArrayList<Component>();
		// creamos label, definimos su tamano y agregamos a la lista
		auxLabel = new JLabel("Divisa Salida:");
		setSizeOf(auxLabel,sizeIzquierda);
		elementosDelPanel.add(auxLabel);
		//creamos un combobox con la lista de las divisas y colocamos la opcion "Peso Mexicano"
		jcbDivisaSalida = new JComboBox(listaDivisas.toArray());
		jcbDivisaSalida.setSelectedIndex(listaDivisas.indexOf("Peso Mexicano"));
		// le damos un tamano y lo agregamos el combobox a la lista
		setSizeOf(jcbDivisaSalida,sizeDerecha);
		elementosDelPanel.add(jcbDivisaSalida);
		// agregamos todos los elementos de la lista a un nuevo panel y este agregarlo al panel padre
		agregarPanel(panelPadre,elementosDelPanel);

		// hacemos nueva lista para agregar a un nuevo panel
		elementosDelPanel = new ArrayList<Component>();
		// agregamos un nuevo boton, le pasamos el ActionListener cambiamos su tamano y los agregamos a la lista
		JButton jbIntercambiarDivisas = new JButton("Intercambiar Divisas");
		jbIntercambiarDivisas.addActionListener(this);
		setSizeOf(jbIntercambiarDivisas,sizeBotones);
		elementosDelPanel.add(jbIntercambiarDivisas);
		// le colocamos un espacio entre los botones
		elementosDelPanel.add(Box.createRigidArea(new Dimension(20,20)));
		// agregamos un nuevo boton, le pasamos el ActionListener cambiamos su tamano y los agregamos a la lista
		JButton jbConvertirDivisa = new JButton("Convertir");
		jbConvertirDivisa.addActionListener(this);
		setSizeOf(jbConvertirDivisa,sizeBotones);
		elementosDelPanel.add(jbConvertirDivisa);
		// agregamos todos los elementos de la lista a un nuevo panel y este agregarlo al panel padre
		agregarPanel(panelPadre,elementosDelPanel);

		// por ultimo agregamos el panel padre al frame
		miFrame.add(panelPadre);
	}

	private void setSizeOf(Component c, Dimension size){
		c.setMaximumSize(size);
		c.setPreferredSize(size);
		c.setMinimumSize(size);
	}

	private void agregarPanel(JPanel panelPadre, List<Component> componentes){
		//creamos el panel hijo
		JPanel panelAux = new JPanel();
		// agregamos un tamano de borde
		int tamBorder = 5;
		panelAux.setBorder(new EmptyBorder(tamBorder,tamBorder,tamBorder, tamBorder));
		// la orientacion sera horizontal.
		panelAux.setLayout(new BoxLayout(panelAux, BoxLayout.X_AXIS));
		// esta bandera nos servira mas adelante
		boolean entro1Vez=false;
		//agregamos cada elemento de la lista al panel creado
		for(Component componente:componentes){
			// con esto colocara un espacio entre elementos a partir del primer elemento
			if(entro1Vez)
				panelAux.add(Box.createHorizontalGlue());
			panelAux.add(componente);
			entro1Vez=true;
		}
		// por ultimo agregamos el panel creado al padre
		panelPadre.add(panelAux);
	}

	// este metodo se sobreescribio de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent evento) {
		if("Intercambiar Divisas".equals(evento.getActionCommand())){// verificamos si el boton Intercambiar divisas fue ejecutado
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
