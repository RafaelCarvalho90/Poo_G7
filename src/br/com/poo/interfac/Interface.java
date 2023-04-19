package br.com.poo.interfac;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import br.com.poo.conexao.Conexao;
import br.com.poo.contas.Conta;
import br.com.poo.pessoas.*;
import br.com.poo.sistema.About;
import br.com.poo.sistema.Etapa;
import br.com.poo.sistema.SistemaInterno;

public class Interface extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interface() {

	}

	public static void MenuLogin() {
		// this.setVisible(false);
		int i = 0;
		while (i < 3) {
			String usuario = JOptionPane.showInputDialog(null, "Usuário:", "Usuario", JOptionPane.DEFAULT_OPTION);
			JPasswordField passwordField = new JPasswordField();

			int option = JOptionPane.showOptionDialog(null, passwordField, "Digite a senha",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

			char[] password = passwordField.getPassword();

			String senha = new String(password);
			// String senha = JOptionPane.showInputDialog(null, "Senha:", "Senha",
			// JOptionPane.DEFAULT_OPTION);

			String cpfsenha = usuario + senha;
			Conexao con = new Conexao();
			String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
			ResultSet rs = con.executaBusca(sql);

			try {
				while (rs.next()) {

					String conf = rs.getString("cpfsenha");
					String nome = rs.getString("nome");
					String cargo = rs.getString("cargo");
					if (cpfsenha.equals(conf)) {
						JOptionPane.showMessageDialog(null, "              Bem-vindo!\n                   " + nome);
						if (cargo.equalsIgnoreCase("caixa")) {
							MenuCaixa(cpfsenha);
							break;
						}
						if (cargo.equalsIgnoreCase("Diretor")) {
							MenuDiretor(cpfsenha);
							break;
						}
						if (cargo.equals("Presidente")) {
							MenuDiretor(cpfsenha);
							break;
						}
						if (cargo.equalsIgnoreCase("Gerente")) {
							MenuGerente(cpfsenha);
							break;
						}
						if (cargo.equalsIgnoreCase("Cliente")) {
							MenuCliente(cpfsenha);
							break;
						}

						else {
							JOptionPane.showMessageDialog(null, "Cargo invalido");

						}

					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!");
						i++;
						break;
					}
				}
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		int x = 5;
		while (x > 0) {
			JOptionPane.showMessageDialog(null,
					"Usuario ou senha incorretos!\n Clique em ok para continuar\n Tente Novamente em: " + x, "Error",
					JOptionPane.WARNING_MESSAGE);

			System.out.println(x);
			x--;
		}
		MenuLogin();

	}
//	public String Logado (String nome,String cpf) {
//		MenuLogin
//		this.nome=nome;
//		return nome;
//
//		
//	}

	public void Principal() {
		JButton botao = new JButton("Acessar sua Conta");
		JButton botao1 = new JButton("Sobre");
		this.setSize(280, 75);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setTitle("Bank.jar");
		this.setResizable(false);
		JPanel p = new JPanel();
		botao.setBounds(10, 100, 100, 30);
		add(p);
		p.setOpaque(true);
		// botao.setForeground(Color.TRANSLUCENT);
		p.add(botao);
		p.add(botao1);
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				botao.setVisible(false);
				botao1.setVisible(false);
				p.setVisible(false);
				MenuLogin();
			}
		});

		botao1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,
						"*------------------------------------------------------Banco Serratec------------------------------------------------------*\n"
								+ "Bem-vindo ao nosso programa de finanças pessoais. Estamos muito felizes em ter você\n"
								+ "a bordo para ajudá-lo a gerenciar suas finanças de forma mais eficaz e alcançar seus\n"
								+ "objetivos financeiros."
								+ "O programa é projetado para ajudá-lo a entender seus gastos, identificar\n áreas onde"
								+ "você pode economizar dinheiro e criar um plano financeiro realista para atingir seus\n"
								+ "objetivos financeiros de longo prazo. Nós acreditamos que todos podem ter controle\n"
								+ "financeiro, independentemente de sua renda ou situação atual.\n"
								+ "*-------------------------------------------------------------------------------------------------------------------------------------*",
						"About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/about.jpg"));
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

	public static void MenuCliente(String cpfsenha) {

		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String salario = rs.getString("salario");
				String sobrenome = rs.getString("sobrenome");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String contato = rs.getString("contato");
				String saldos = rs.getString("saldo");
				double saldo = Double.parseDouble(saldos);

				Cliente cli = new Cliente(nome, sobrenome, cpf, email, contato, saldo);

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Digite 0 para sair",
						"Menu Cliente", JOptionPane.INFORMATION_MESSAGE));
				Conta novaconta = new Conta();
				novaconta.depositarDinheiro(1000);

				switch (operacao) {
				case 1:
//					double saque = Double.parseDouble(valor);
//					// System.out.println(novaconta.getSaldo());
//					novaconta.sacar(saque);
//					JOptionPane.showMessageDialog(null, "Seu novo saldo é: " + novaconta.getSaldo());
//					// System.out.println(novaconta.getSaldo());
//					MenuCliente(valor);
					// break;
				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuCliente(cpfsenha);
					// novaconta.getSaldo();
					// JOptionPane.showMessageDialog(null );
					// MenuCliente(valor);
					break;
				case 3:
					JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					MenuCliente(cpfsenha);
					break;
				case 4:
//					Transferir;
					break;
				case 5:
//					Extratos;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuCliente(cpfsenha);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuGerente(String cpfsenha) {
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		Gerente ger = new Gerente();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String salario = rs.getString("salario");
				String nome = rs.getString("nome");
				String saldo = rs.getString("saldo");

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Opção 6 -Cadastrar Cliente\n"
								+ "| Opção 7 -Gerar Relatório Caixa\n" + "| Digite 0 para sair",
						"Menu Gerente ", JOptionPane.INFORMATION_MESSAGE));
				switch (operacao) {
				case 1:
//					saque
					break;

				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuGerente(cpfsenha);

					break;
				case 3:
					JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					MenuGerente(cpfsenha);
					break;
				case 4:
//					Transferir
					break;

//				case 5:Extratos

				case 6:
					ger.cadastroCliente();
					break;
//				case 7: Gerar Relatorio Caixa

				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void MenuDiretor(String cpfsenha) {
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String salario = rs.getString("salario");
				String nome = rs.getString("nome");
				String saldo = rs.getString("saldo");

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Opção 6 -Cadastrar Funcionário\n"
								+ "| Opção 7 -Cadastrar Cliente\n" + "| Digite 0 para sair",
						"Menu Diretor", JOptionPane.NO_OPTION));
				Diretor dir = new Diretor("Maste", "Robot", "1478874558", "robo@dadaa", "789974258", 5000);

				switch (operacao) {
				case 1:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuDiretor(cpfsenha);
				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuDiretor(cpfsenha);
					break;
				case 3:
					JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					MenuDiretor(cpfsenha);
					break;
				case 6:
					dir.CadastroFuncionario();
					MenuDiretor(cpfsenha);
					break;
				case 7:
					dir.CadastroCliente();
					MenuDiretor(cpfsenha);
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuCaixa(String cpfsenha) {
		GregorianCalendar gre = new GregorianCalendar();
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String salario = rs.getString("salario");
				String nome = rs.getString("nome");
				String saldo = rs.getString("saldo");

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Opção 6 -Consultar Saldo Cliente\n"
								+ "| Digite 0 para sair\n",
						"Menu Caixa", JOptionPane.OK_CANCEL_OPTION));
				switch (operacao) {
				case 1:
					JOptionPane.showInternalMessageDialog(null, "Saldo atual: " + saldo);

					MenuCaixa(cpfsenha);

				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuCaixa(cpfsenha);
				case 3:
					JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					MenuCaixa(cpfsenha);
					break;
//				case 4 :Transferencia
//				case 5: Extrato;
				case 6:
					// MenuDiretor();
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}