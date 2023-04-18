package br.com.poo.sistema;
import java.util.Scanner;

import javax.swing.JFrame;

import br.com.poo.decod.Decod;
import br.com.poo.interfac.*;
import br.com.poo.pessoas.Diretor;
import br.com.poo.pessoas.Gerente;
import br.com.poo.pessoas.Presidente;
import br.com.poo.conexao.*;


public class SistemaInterno extends JFrame
{
	
	public SistemaInterno() {
		 
		
		add(new Etapa());
		setTitle("Banco Serratec");
		setSize(400,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	

	public static void main(String[] args) 
	{	
		
		
		//Scanner sc = new Scanner(System.in);
		new SistemaInterno();
		Interface lay =new Interface();
		lay.Principal();
		//Diretor dir = new Diretor("Maste","Robot","1478874558","robo@dadaa","789974258",5000);
		//dir.CadastroFuncionario();
		//dir.Consulta();
		
		
	


}
}