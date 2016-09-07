package ProcesadorTexto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

import com.sun.glass.events.KeyEvent;

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
		
		//Agregamos 2 submenús al menu Estilo (Con CheckBoxes)
				
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("bin/ProcesadorTexto/negrita.png"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("bin/ProcesadorTexto/cursiva.png"));
		JCheckBoxMenuItem subrayar = new JCheckBoxMenuItem("Subrayar", new ImageIcon("bin/ProcesadorTexto/subrayar.png"));
		
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		subrayar.addActionListener(new StyledEditorKit.UnderlineAction());
		
		negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_DOWN_MASK));
		subrayar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		
		estilo.add(negrita);
		estilo.add(cursiva);
		estilo.add(subrayar);
		
		//Creamos ButtonGroup para que solo sea seleccionable una opción
		ButtonGroup tamanoLetra = new ButtonGroup();
		
		//Creamos los RadioButtons con las opciones que tendremos
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
				
		//Añadimos los botones al ButtonGroup
		tamanoLetra.add(doce);
		tamanoLetra.add(dieciseis);
		tamanoLetra.add(veinte);
		tamanoLetra.add(veinticuatro);
		
		//Le damos funcionalidad a los botones
		doce.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("cambiaTamaño", 24));
		
		//Añadimos los botones al menú
		tamano.add(doce);
		tamano.add(dieciseis);
		tamano.add(veinte);
		tamano.add(veinticuatro);
		
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
		
		//Creamos Barra de Herramientas
		JToolBar barra = new JToolBar();
		
		//Creamos 3 botones para la Barra de Herramientas
		JButton negritaBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/negrita.png"));
		JButton cursivaBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/cursiva.png"));
		JButton subrayarBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/subrayar.png"));
		JButton azulBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/azul.png"));
		JButton amarilloBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/amarillo.png"));
		JButton rojoBarra = new JButton(new ImageIcon("bin/ProcesadorTexto/rojo.png"));
		JButton aliIzquierda = new JButton(new ImageIcon("bin/ProcesadorTexto/izquierda.png"));
		JButton aliCentro = new JButton(new ImageIcon("bin/ProcesadorTexto/centrado.png"));
		JButton aliDerecha = new JButton(new ImageIcon("bin/ProcesadorTexto/derecha.png"));
		JButton aliJustificado = new JButton(new ImageIcon("bin/ProcesadorTexto/justificado.png"));
		
		//Damos funcionalidad a los botones
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subrayarBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente Azul",Color.BLUE));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente Amarilla",Color.YELLOW));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Fuente Roja",Color.RED));
		aliIzquierda.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda",0));
		aliCentro.addActionListener(new StyledEditorKit.AlignmentAction("Centrado",1));
		aliDerecha.addActionListener(new StyledEditorKit.AlignmentAction("Derecha",2));
		aliJustificado.addActionListener(new StyledEditorKit.AlignmentAction("Justificado",3));
		
		//Añadimos los botones a la barra
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(subrayarBarra);
		barra.add(azulBarra);
		barra.add(amarilloBarra);
		barra.add(rojoBarra);
		barra.add(aliIzquierda);
		barra.add(aliCentro);
		barra.add(aliDerecha);
		barra.add(aliJustificado);
		
		//Determinamos orientación de la barra
		barra.setOrientation(1);
		
		//Añadimos la barra a la lámina y la situamos a la izquierda
		add(barra,BorderLayout.WEST);
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
			
		}
		
	}
	
	//Declaración de variables
	JTextPane miArea;
	JMenu fuente, estilo, tamano;
	Font letras;
	
}
