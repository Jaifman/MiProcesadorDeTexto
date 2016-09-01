package ProcesadorTexto;

import javax.swing.JFrame;

public class Menu extends JFrame {
	
	public Menu(){
		
		setBounds(500,300,550,400);
		
		Lamina miLamina = new Lamina();
		
		add(miLamina);
		
		setVisible(true);	}
}
