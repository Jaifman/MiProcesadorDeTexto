package ProcesadorTexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Lamina extends JPanel {
	
	public Lamina(){
		
		setLayout(new BorderLayout());
		
		JPanel laminaMenu = new JPanel();
		
		JMenuBar miBarra = new JMenuBar();
		
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamano = new JMenu("Tamaño");
		
		JMenuItem arial = new JMenuItem("Arial");
		
		arial.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Arial", Font.PLAIN,12));	
				
			}
		});
		
		JMenuItem courier = new JMenuItem("Courier");
		
		courier.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Courier", Font.PLAIN,12));	
				
			}
		});
		
		JMenuItem verdana = new JMenuItem("Verdana");
		
		verdana.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				miArea.setFont(new Font("Verdana", Font.PLAIN,12));	
				
			}
		});
		
		
		fuente.add(arial);
		fuente.add(courier);
		fuente.add(verdana);
		
		JMenuItem negrita = new JMenuItem("Negrita");
		JMenuItem cursiva = new JMenuItem("Cursiva");
		
		estilo.add(negrita);
		estilo.add(cursiva);
		
		JMenuItem tam12 = new JMenuItem("12");
		JMenuItem tam16 = new JMenuItem("16");
		JMenuItem tam20 = new JMenuItem("20");
		JMenuItem tam24 = new JMenuItem("24");
		
		tamano.add(tam12);
		tamano.add(tam16);
		tamano.add(tam20);
		tamano.add(tam24);
		
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		laminaMenu.add(miBarra);
		
		add(laminaMenu,BorderLayout.NORTH);
		
		miArea = new JTextPane();
		
		add(miArea,BorderLayout.CENTER);
		
	}
	
	JTextPane miArea;
}
