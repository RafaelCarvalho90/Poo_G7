package br.com.poo.sistema;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class About extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image fundo;
	
	
	public About() {
		
		ImageIcon referencia = new ImageIcon("res\\about.jpg");
		fundo = referencia.getImage();
	}
	
	public void paint(Graphics g) {
		Graphics2D graficos = (Graphics2D) g;
		graficos.drawImage(fundo,0,0,null);
		g.dispose();
	}


}