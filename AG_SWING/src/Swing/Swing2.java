package Swing;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;

public class Swing2 {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					JMiVentana miVentana = new JMiVentana();
					miVentana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class JMiVentana extends JFrame {
	// Constructor
	public JMiVentana() {
		this.setTitle("Titulo de la ventana");
		this.setLayout(null);
		
		this.setBounds(100,100, 500, 300);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

//		Object[] colores = { "Rojo", "Verde", "Azul" };
//
//		int valorElegido = JOptionPane.showOptionDialog(
//		        null, // parentComponent, basta con null
//		        "Escoja un color de la lista", // mensaje
//		        "Ventana para elegir un color", // titulo de ventana
//		        JOptionPane.YES_NO_CANCEL_OPTION, // opciones de acciones
//		        JOptionPane.QUESTION_MESSAGE, // ipo de mensaje
//		        null, // icono. null para icono por defecto
//		        colores, // opciones de texto
//		        colores[0]); // opcion por defecto
//
//		if (valorElegido != -1)
//		    System.out.println("Se ha elegido el color " + (valorElegido + 1));
//		else
//		    System.out.println("No se ha elegido color ");
		
		
//		JCheckBox
		
//		JTextArea elemento = new JTextArea();
//		elemento.setBounds(10,10,200,200);
//		elemento.setLineWrap( false );
		
		JRadioButton r1=new JRadioButton("Comunitario");    
		JRadioButton r2=new JRadioButton("No Comunitario");    
		r1.setBounds(75,50,150,30);    
		r2.setBounds(75,70,150,30);    
		this.getContentPane().add(r1);
		this.getContentPane().add(r2);      
	
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);    
//		
//		this.getContentPane().add(scrollPane);
//		this.getContentPane().add(asd);
	}
}
