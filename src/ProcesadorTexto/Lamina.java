package ProcesadorTexto;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class Lamina extends JPanel {
	
	//Creamos el constructor de la clase
	public Lamina(){
		
		//Elegimos el estilo de plantilla
		setLayout(new BorderLayout());
		
		//Creamos lamina sobre la que trabajar
		JPanel laminaMenu = new JPanel();
		
		//Creamos barra de men�s
		JMenuBar miBarra = new JMenuBar();
		
		//Creamos 3 cuadros de men�
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tama�o");
		
		//Agregamos 3 submen�s al men� Fuente
		configuraMenu("Arial","fuente","Arial",9,10,"");
		configuraMenu("Courier","fuente","Courier",9,10,"");
		configuraMenu("Verdana","fuente","Verdana",9,10,"");
		
		//Agregamos 2 submen�s al menu Estilo
		configuraMenu("Negrita","estilo","",Font.BOLD,1,"bin/ProcesadorTexto/negrita.png");
		configuraMenu("Cursiva","estilo","",Font.ITALIC,1,"bin/ProcesadorTexto/cursiva.png");
		
		//Agregamos 4 submen�s al men� Tama�o
		configuraMenu("12","tama�o","",9,12,"");
		configuraMenu("16","tama�o","",9,16,"");
		configuraMenu("20","tama�o","",9,20,"");
		configuraMenu("24","tama�o","",9,24,"");
		
		//A�adimos los men�s a la barra de men�s
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		//A�adimos la barra de men�s a la l�mina
		laminaMenu.add(miBarra);
		
		//A�adimos la l�mina y la posicionamos
		add(laminaMenu,BorderLayout.NORTH);
		
		//Creamos el �rea de texto
		miArea = new JTextPane();
		
		//A�adimos el �rea de texto y la posicionamos
		add(miArea,BorderLayout.CENTER);
		
	}
	
	//Creamos m�todo para crear objetos con menos c�digo
	public void configuraMenu(String texto, String menu, String tipo, int estilos, int tam, String ruta){
		
		JMenuItem elemento = new JMenuItem(texto, new ImageIcon(ruta));
		
		if (menu == "fuente"){
			
			fuente.add(elemento);
			
			if (tipo == "Arial"){
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Arial"));
				
			}else if (tipo == "Courier"){
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Courier"));
				
			}else if (tipo == "Verdana"){
				
				elemento.addActionListener(new StyledEditorKit.FontFamilyAction("cambiaLetra", "Verdana"));
				
			}
			
		}else if (menu == "estilo"){
			
			estilo.add(elemento);
			
			if (estilos == Font.BOLD){
				
				elemento.addActionListener(new StyledEditorKit.BoldAction());
			
			}else if (estilos == Font.ITALIC){
				
				elemento.addActionListener(new StyledEditorKit.ItalicAction());
				
			}
			
		}else if (menu == "tama�o"){
			
			tamano.add(elemento);
			
			elemento.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTama�o", tam));
			
		}
		
	}
	
	//Declaraci�n de variables
	JTextPane miArea;
	JMenu fuente, estilo, tamano;
	Font letras;
	
}
