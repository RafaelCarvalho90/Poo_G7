package br.com.poo.interfac;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import javax.swing.JOptionPane;
import javax.management.remote.SubjectDelegationPermission;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import br.com.poo.contas.Conta;
import br.com.poo.pessoas.*;

public class Interface extends JFrame{
	

	
 public Interface() {
	 	 
 }
 
 public void MenuLogin() {
	 		int i=0;
	    	while(i<3) {
	    		String usuario = JOptionPane.showInputDialog(null, "Usuário:");
	    		String senha = JOptionPane.showInputDialog(null, "Senha:");
	        
	    		if(usuario.equals("Rafael") && senha.equals("1234")) {
	    			JOptionPane.showMessageDialog(null, "Bem-vindo!");
	    			MenuCliente();
	    			break;
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
	    			i++;
	    		}
	    		}
	    	int x =30;
	    	while(x>0) {
	    		JOptionPane.showMessageDialog(null, x);
	    		System.out.println(x);
	    		x--;
	    	}
	    	MenuLogin();
	    }

 

 public void Principal() {
	 JButton botao = new JButton("Acessar Conta");
	 this.setSize(400, 400);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocationRelativeTo(null);
	 this.setVisible(true);
	 this.setTitle("Piramide Tec");
	 //painel.set
	 JPanel p = new JPanel();
	 botao.setBounds(10, 100, 100, 30);
	 add(p);
	 p.add(botao);
	 botao.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			botao.setVisible(false);
			MenuLogin();
			;		
		}
	});
 }
	 
	 public void Posmenu() {
		 this.setSize(400,400);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true); 
		 this.setTitle("Menu Principal");
		 JButton bsaldo = new JButton("Saldo");
		 JPanel r = new JPanel();
		 bsaldo.setBounds(85, 100, 100, 30);
		 add(r);
		 r.add(bsaldo);	
		 bsaldo.setVisible(true);
		 JButton conta = new JButton("Criar conta");
		 r.add(conta);
		 conta.setVisible(true);
		 conta.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					conta.setVisible(false);;
					Diretor dir = new Diretor("Dany","Fiorava","1478874558","dany@dadaa","789974258",5000);
					dir.CadastroFuncionario();
					
					;		
				}
			});	 
 } 
	 public static void MenuCliente() {
		 int operacao =
		 Integer.parseInt(JOptionPane.showInputDialog("------Selecione uma operação------\n"+
				 					"| Opção 1 -Saque\n"+
				 					"| Opção 2 -Saldo\n"+
				 					"| Opção 3 -Deposito\n"+
				 					"| Opção 4 -Transferir\n"+
				 					"| Opção 5 -Extratos\n"+
				 					"| Digite 0 para sair"));
		 switch (operacao) {
		 
		 case 1: String valor = JOptionPane.showInputDialog("Qual valor gostaria de sacar?");
		 		 double saque = Double.parseDouble(valor);
		 			
		 		 Conta novaconta = new Conta();
		 		 novaconta.sacar(saque);
		 	}
		
		 
		 
		 
		 } 
	 
} 