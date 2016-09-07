package ProcesadorTexto;

import javax.swing.JFrame;

public class Menu extends JFrame {
	
	public Menu(){
		
		setBounds(325,100,550,550);
		
		Lamina miLamina = new Lamina();
		
		add(miLamina);
		
		setVisible(true);	}
}

