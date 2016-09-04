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
		
		//Creamos barra de menús
		JMenuBar miBarra = new JMenuBar();
		
		//Creamos 3 cuadros de menú
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamano = new JMenu("Tamaño");
		
		//Agregamos 3 submenús al menú Fuente
		configuraMenu("Arial","fuente","Arial",9,10,"");
		configuraMenu("Courier","fuente","Courier",9,10,"");
		configuraMenu("Verdana","fuente","Verdana",9,10,"");
		
		//Agregamos 2 submenús al menu Estilo
		configuraMenu("Negrita","estilo","",Font.BOLD,1,"bin/ProcesadorTexto/negrita.png");
		configuraMenu("Cursiva","estilo","",Font.ITALIC,1,"bin/ProcesadorTexto/cursiva.png");
		
		//Agregamos 4 submenús al menú Tamaño
		configuraMenu("12","tamaño","",9,12,"");
		configuraMenu("16","tamaño","",9,16,"");
		configuraMenu("20","tamaño","",9,20,"");
		configuraMenu("24","tamaño","",9,24,"");
		
		//Añadimos los menús a la barra de menús
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamano);
		
		//Añadimos la barra de menús a la lámina
		laminaMenu.add(miBarra);
		
		//Añadimos la lámina y la posicionamos
		add(laminaMenu,BorderLayout.NORTH);
		
		//Creamos el área de texto
		miArea = new JTextPane();
		
		//Añadimos el área de texto y la posicionamos
		add(miArea,BorderLayout.CENTER);
		
	}
	
	//Creamos método para crear objetos con menos código
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
			
		}else if (menu == "tamaño"){
			
			tamano.add(elemento);
			
			elemento.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", tam));
			
		}
		
	}
	
	//Declaración de variables
	JTextPane miArea;
	JMenu fuente, estilo, tamano;
	Font letras;
	
}
