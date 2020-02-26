import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main {

	private JFrame frame;
	
	//Se crea una pila
	//private IStack<String> data_result;
	
	//se crea un factory para poder elegir la implementación del stack
	StackFactory<String> sFactory = new StackFactory<String>();
	
	IStack<String> data_result;
	
	
	//Se crea una calculadora
	private ICalculadora calculadora; 
	
	private JScrollPane scrollPane;
	private JTable tablaResultados;
	private ArrayList<String> respuestas;
	private String[] cadena = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		respuestas = new ArrayList<String>();
		
		/*
		 * Aqui es donde se define que implemetación de stack se va a usar
		 * sFactory.getStack("Vector"); utiliza una implementación con Vector
		 * sFactory.getStack("ArrayList"); utiliza una implementación con List
		 * 
		 * */
		data_result = sFactory.getStack("Vector");
		/**/
		
		calculadora = new Calculadora();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_5568255706808");
		panel.setLayout(null);
		
		JButton btnElegirArchivo = new JButton("Elegir Archivo");
		btnElegirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadena = ArchivoTXT.leerTXT(ArchivoTXT.getPath());
					
					for (String j: cadena) {
						//calculadora.fillStack(j);
						doOperation(j);
						respuestas.add(""+getResult());
					}
					
					JOptionPane.showMessageDialog(null, "Se leyo el archivo con exito");
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo");
				}
				
			}

			
		});
		btnElegirArchivo.setBounds(146, 35, 131, 29);
		panel.add(btnElegirArchivo);
		
		JButton btnMostrarResultado = new JButton("Mostrar Resultado");
		btnMostrarResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel();
				model.setColumnCount(2);
				model.setColumnIdentifiers(new String[] {"Operacion","Resultado"});
				model.setRowCount(cadena.length);
				
				for (int i = 0;i<= cadena.length  -1;i++) {
					model.setValueAt(cadena[i], i, 0);
					model.setValueAt(respuestas.get(i), i, 1);
				}
				
				tablaResultados = new JTable(model);
				scrollPane.setViewportView(tablaResultados);
				
				
			}
		});
		btnMostrarResultado.setBounds(138, 138, 151, 29);
		panel.add(btnMostrarResultado);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 202, 394, 129);
		panel.add(scrollPane);
		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnCount(2);
		model.setColumnIdentifiers(new String[] {"Operacion","Resultado"});
		
		tablaResultados = new JTable(model);
		scrollPane.setViewportView(tablaResultados);
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setBounds(28, 174, 95, 16);
		panel.add(lblResultados);
		frame.setBounds(100, 100, 451, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected String getResult() {
		String result = "";
		
		if (data_result.size() == 1) {
			result = data_result.pop();
		}else 
		{
			result = "Error en la operacion";
		}
			
		return result;
	}

	protected void doOperation(String j) {
		String[] entrada;
		
		entrada = j.split(" ");
		
		try {
			for (int i = 0; i < entrada.length; i++ )
			{
				//es operador o numero?
				if (isOperator(entrada[i])){
					//si es operador se retiran dos elementos de la pila y se operan
					int r = 0, n1= 0, n2 = 0; 
					n1 = Integer.parseInt(data_result.pop());
					n2 = Integer.parseInt(data_result.pop());
					
					switch(entrada[i]) {
					case "+":
						r= calculadora.sumar(n1, n2);
						break;
					case "-":
						r= calculadora.restar(n1, n2);
						break;
					case "*":
						r= calculadora.multiplicar(n1, n2);
						break;
					case "/":
						r= calculadora.dividir(n1, n2);
						break;
					}
					
					//r = operation(entrada[i], n1, n2);
					//se ingresa el resultado de la operacion en la pila
					data_result.push(Integer.toString(r));
					
				}else if (isNumeric(entrada[i])){
					//si es un numero se ingresa a la pila
					data_result.push(entrada[i]);
				} else 
				{ 	//se  limpia la pila
					while (!(data_result.size() == 0)) {
						data_result.pop();
		            } 
					break;
				}
			}
        } catch (NumberFormatException e) {
        	
            while (!(data_result.size() == 0)) {
            	data_result.pop();
            }
        }
		
	}
	
	private boolean isOperator(String op) {
		if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") ) 
			return true;
		else 
			return false;
	}
	
	private boolean isNumeric(String op) {
		boolean numeric = false;
		try {
			Double num = Double.parseDouble(op);
			numeric = true;
        } catch (NumberFormatException e) {
            numeric = false;
        }
		return numeric;
	}
}
