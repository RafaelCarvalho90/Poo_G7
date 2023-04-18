package br.com.poo.interfac;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.management.remote.SubjectDelegationPermission;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import br.com.poo.conexao.Conexao;
import br.com.poo.contas.Conta;
import br.com.poo.pessoas.*;
import br.com.poo.sistema.SistemaInterno;

public class Interface extends JFrame {
	private Image fundo;

	public Interface() {

	}

	public void MenuLogin() {
		this.setVisible(false);
		int i = 0;
		while (i < 3) {
			String usuario = JOptionPane.showInputDialog(null, "Usuário:","Usuario",JOptionPane.DEFAULT_OPTION);
			String senha = JOptionPane.showInputDialog(null, "Senha:","Senha",JOptionPane.DEFAULT_OPTION);
			String cpfsenha = usuario + senha;
			Conexao con = new Conexao();
			String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
			ResultSet rs = con.executaBusca(sql);
			System.out.println(rs);
			try {
				while (rs.next()) {

					String conf = rs.getString("cpfsenha");
					String nome = rs.getString("nome");
					String cargo = rs.getString("cargo");
					if (cpfsenha.equals(conf)) {
						JOptionPane.showMessageDialog(null, "              Bem-vindo!\n                   " + nome);
						if (cargo.equalsIgnoreCase("caixa")) {
							MenuCaixa();
							break;
						}
						if (cargo.equalsIgnoreCase("Diretor")) {
							MenuDiretor();
							break;
						}
//						if (cargo.equals("Presidente")) {
//							MenuDiretor();
//							break;
//						}
						if (cargo.equalsIgnoreCase("Gerente")) {
							MenuGerente();
							break;
						}
						if (cargo.equalsIgnoreCase("Cliente")) {
							MenuCliente();
							break;
						}

						else {
							JOptionPane.showMessageDialog(null, "Cargo invalido");

						}

					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
						i++;
					}
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		int x = 5;
		while (x > 0) {
			JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos!\n Clique em ok para continuar\n Tente Novamente em: "+x,"Error",JOptionPane.WARNING_MESSAGE);

			System.out.println(x);
			x--;
		}
		MenuLogin();

	}

	public void EncontrarPessoa() {

	}

	public void Principal() {
		JButton botao = new JButton("Acessar sua Conta");
		JButton botao1 = new JButton("Ajuda");
		this.setSize(400, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Piramide Tec");
		// painel.set
		JPanel p = new JPanel();
		botao.setBounds(10, 100, 100, 30);
		//p.setBackground(Color.BLACK);
		add(p);
		//p.setOpaque(false);
		p.add(botao);
		p.add(botao1);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				botao.setVisible(false);
				botao1.setVisible(false);
				MenuLogin();

				;
			}
		});

		botao1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"*----------------------------------Banco Serratec-------------------------------------*\n"
								+ "|Bem-vindo ao nosso programa de finanças pessoais. Estamos muito felizes em ter você a|\n"
								+ "|bordo para ajudá-lo a gerenciar suas finanças de forma mais eficaz e alcançar seus   |\n"
								+ "|objetivos financeiros.                                                               |\n"
								+ "|O programa é projetado para ajudá-lo a entender seus gastos, identificar áreas onde  |\n"
								+ "|você pode economizar dinheiro e criar um plano financeiro realista para atingir seus |\n"
								+ "|objetivos financeiros de longo prazo. Nós acreditamos que todos podem ter controle   |\n"
								+ "|financeiro, independentemente de sua renda ou situação atual.                        |\n"
								+ "*-------------------------------------------------------------------------------------*");

			}
		});
	}

	public void Posmenu() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(400, 400);
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
				conta.setVisible(false);
				;
				Diretor dir = new Diretor("Dany", "Fiorava", "1478874558", "dany@dadaa", "789974258", 5000);
				dir.CadastroFuncionario();

				;
			}
		});
	}

	public static void MenuCliente() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog("------Selecione uma operação------\n"
				+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
				+ "| Opção 5 -Extratos\n" + "| Digite 0 para sair"));
		Conta novaconta = new Conta();
		novaconta.depositarDinheiro(1000);

		switch (operacao) {
		case 1:
			JOptionPane.showMessageDialog(null, "Seu saldo atual é: " + novaconta.getSaldo());
			String valor = JOptionPane.showInputDialog("Qual valor gostaria de sacar?");
			double saque = Double.parseDouble(valor);
			// System.out.println(novaconta.getSaldo());
			novaconta.sacar(saque);
			JOptionPane.showMessageDialog(null, "Seu novo saldo é: " + novaconta.getSaldo());
			// System.out.println(novaconta.getSaldo());
			MenuCliente();
			// break;
		case 2:
			// novaconta.getSaldo();
			// JOptionPane.showMessageDialog(null );
			MenuCliente();
			break;

		case 0:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
			System.exit(0);
		}

	}

	public void MenuGerente() {
		int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,"------Selecione uma operação------\n"
				+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
				+ "| Opção 5 -Extratos\n" + "| Opção 6 -Cadastrar Cliente\n" + "| Opção 7 -Gerar Relatório Caixa\n"
				+ "| Digite 0 para sair","Menu Gerente",JOptionPane.INFORMATION_MESSAGE));
		switch (operacao) {
		case 1:
//			 	JOptionPane.showMessageDialog(null,"Seu saldo atual é: "+novaconta.getSaldo());
//			 	String valor = JOptionPane.showInputDialog("Qual valor gostaria de sacar?");
//		 		double saque = Double.parseDouble(valor);
//		 		//System.out.println(novaconta.getSaldo()); 
//		 		novaconta.sacar(saque);
//		 		JOptionPane.showMessageDialog(null,"Seu novo saldo é: "+novaconta.getSaldo()); 
//		 		//System.out.println(novaconta.getSaldo());
			MenuCliente();
			// break;
		case 2:
			// novaconta.getSaldo();
			// JOptionPane.showMessageDialog(null );
			MenuCliente();
			break;
		case 6:
			Gerente ger = new Gerente("Teste", "sobrenome", "141545", "rafa", "7845415", 5000);
			ger.cadastroCliente();

		case 0:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
			System.exit(0);
		}

	}

	public void MenuDiretor() {

		int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,"------Selecione uma operação------\n"
				+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
				+ "| Opção 5 -Extratos\n" + "| Opção 6 -Cadastrar Funcionário\n" + "| Opção 7 -Consultar Funcionarios\n"
				+ "| Digite 0 para sair","Menu Diretor",JOptionPane.NO_OPTION));
		switch (operacao) {
		case 1:
//			 	JOptionPane.showMessageDialog(null,"Seu saldo atual é: "+novaconta.getSaldo());
//			 	String valor = JOptionPane.showInputDialog("Qual valor gostaria de sacar?");
//		 		double saque = Double.parseDouble(valor);
//		 		//System.out.println(novaconta.getSaldo()); 
//		 		novaconta.sacar(saque);
//		 		JOptionPane.showMessageDialog(null,"Seu novo saldo é: "+novaconta.getSaldo()); 
//		 		//System.out.println(novaconta.getSaldo());
			MenuCliente();
			// break;
		case 6:
			Diretor dir = new Diretor("Maste", "Robot", "1478874558", "robo@dadaa", "789974258", 5000);
			dir.CadastroFuncionario();
			MenuDiretor();
		case 7:
			// dir.Consulta();
		}
	}

	public void MenuCaixa() {
		
		int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,"------Selecione uma operação------\n"
				+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
				+ "| Opção 5 -Extratos\n" + "| Opção 6 -Consultar Saldo Cliente\n" + "| Digite 0 para sair\n","Menu Caixa",JOptionPane.NO_OPTION));
		switch (operacao) {
		case 1:
//			 	JOptionPane.showMessageDialog(null,"Seu saldo atual é: "+novaconta.getSaldo());
//			 	String valor = JOptionPane.showInputDialog("Qual valor gostaria de sacar?");
//		 		double saque = Double.parseDouble(valor);
//		 		//System.out.println(novaconta.getSaldo()); 
//		 		novaconta.sacar(saque);
//		 		JOptionPane.showMessageDialog(null,"Seu novo saldo é: "+novaconta.getSaldo()); 
//		 		//System.out.println(novaconta.getSaldo());
			MenuCliente();
			// break;
		case 6:
			Diretor dir = new Diretor("Maste", "Robot", "1478874558", "robo@dadaa", "789974258", 5000);
			dir.CadastroFuncionario();
			MenuDiretor();
		case 7:
			Diretor dir1 = new Diretor("Master", "Robot", "1478874558", "robo@dadaa", "789974258", 5000);
			dir1.Consulta();
		case 0:
			JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
			System.exit(0);
		}
	}
}