package br.com.poo.interfac;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import br.com.poo.conexao.Conexao;
import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
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
			Object usuarios = JOptionPane.showInputDialog(null, "Usuário:", "Usuario", JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon("res/loginm.png"), null, null);
			String usuario = (String) usuarios;
			System.out.println(usuario);
			JPasswordField passwordField = new JPasswordField();

			int option = JOptionPane.showOptionDialog(null, passwordField, "Digite a senha",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon("res/senham.gif"), null,
					null);

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
							MenuClienteP(cpfsenha);
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

	public static void MenuClienteC(String cpfsenha) {

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

				Conta cliente = new ContaCorrente();

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Digite 0 para sair",
						"Menu Cliente", JOptionPane.INFORMATION_MESSAGE));

				Conta novaconta = new Conta();
				novaconta.depositarDinheiro(1000);

				switch (operacao) {
				case 1:
					Object valors = JOptionPane.showInputDialog(null, "Qual valor gostaria de sacar?", "Sacar",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/saque.png"), null, null);
					double valor = Double.parseDouble((String) valors);
					System.out.println(novaconta.getSaldo());
					novaconta.sacar(valor);
					JOptionPane.showMessageDialog(null, "Seu novo saldo é: " + novaconta.getSaldo());
					System.out.println(novaconta.getSaldo());
					MenuClienteC(cpfsenha);
					break;
				case 2:
					System.out.println(novaconta.getSaldo());
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuClienteC(cpfsenha);

					// novaconta.getSaldo();
					// JOptionPane.showMessageDialog(null );
					// MenuCliente(valor);
					break;
				case 3:
					Object valord = JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					double valorf = Double.parseDouble((String) valord);
					novaconta.depositarDinheiro(valorf);
					System.out.println(novaconta.getSaldo());

					MenuClienteC(cpfsenha);
					break;
				case 4:
					Object valort = JOptionPane.showInputDialog(null, "Qual valor gostaria de transferir?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/trans.png"), null, null);
					double valortr = Double.parseDouble((String) valort);
					novaconta.transferir(valortr, novaconta);
					break;
				case 5:
//					Extratos;
				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteC(cpfsenha);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuClienteP(String cpfsenha) {

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
				String poupancas = rs.getString("poupanca");
				double poupanca = Double.parseDouble(poupancas);

				Cliente cli = new Cliente(nome, sobrenome, cpf, email, contato, saldo);

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n"
								+ "| Opção 1 -Resgate Poupança\n" + "| Opção 2 -Saldo Poupança\n"
								+ "| Opção 3 -Depósito\n" + "| Opção 4 -Rendimentos\n"
								+ "| Opção 5 -Simulação Rendimento\n" + "| Digite 0 para sair",
						"Menu Cliente", JOptionPane.INFORMATION_MESSAGE));

				Conta novaconta = new ContaPoupanca();
				novaconta.depositarDinheiro(1000);

				switch (operacao) {
				case 1:
					Object valort = JOptionPane.showInputDialog(null, "Qual valor gostaria de sacar?", "Saque",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/saque.png"), null, null);
					double valorpou = Double.parseDouble((String) valort);
					novaconta.transferir(valorpou, novaconta);
//					double saque = Double.parseDouble(valor);
//					// System.out.println(novaconta.getSaldo());
//					novaconta.sacar(saque);
//					JOptionPane.showMessageDialog(null, "Seu novo saldo é: " + novaconta.getSaldo());
//					// System.out.println(novaconta.getSaldo());
//					MenuCliente(valor);
					// break;
				case 2:
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + poupanca);
					novaconta.getSaldo();
					MenuClienteC(cpfsenha);
					// novaconta.getSaldo();
					// JOptionPane.showMessageDialog(null );
					// MenuCliente(valor);
					break;
				case 3:
					Object depoupancaob = JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?",
							"Deposito", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
					double deposito = Double.parseDouble((String) depoupancaob);
					novaconta.depositarDinheiro(deposito);
					System.out.println(novaconta.getSaldo());
					JOptionPane.showMessageDialog(null, "Deposito de " + deposito + "feito com sucesso");
					MenuClienteC(cpfsenha);
					break;
				case 4:
//					Transferir;
					break;
				case 5:

					String valors = JOptionPane.showInputDialog(null, "Digite o valor inicial");
					String dias = JOptionPane.showInputDialog(null, "Digite o dia ");
					String meses = JOptionPane.showInputDialog(null, "Digite o mês ");
					String anos = JOptionPane.showInputDialog(null, "Digite o ano ");
					double valor = Double.parseDouble(valors);
					int dia = Integer.parseInt(dias);
					int mes = Integer.parseInt(meses);
					int ano = Integer.parseInt(anos);
					double taxa = 0.01;
					Calendar datainicial = Calendar.getInstance();
					datainicial.set(ano, mes, dia);
					Calendar hoje = Calendar.getInstance();
					int intervalo = (hoje.get(Calendar.YEAR) * 12 + hoje.get(Calendar.MONTH))
							- (datainicial.get(Calendar.YEAR) * 12 + datainicial.get(Calendar.MONTH));
					System.out.println(intervalo);
					double intervaloD = intervalo;
					double simulacao = valor * Math.pow((1 + taxa), intervaloD);
					DecimalFormat df = new DecimalFormat("R$ #,###.00");
					JOptionPane.showMessageDialog(null,
							"O valor final no prazo de " + intervalo + " meses é de\n" + df.format(simulacao));
					System.out.println();
					MenuClienteP(cpfsenha);

				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteC(cpfsenha);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuGerente(String cpfsenha) {
		Object[] escolha = { "Gerente", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteC(cpfsenha);
		} else {

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
							nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n"
									+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n"
									+ "| Opção 4 -Transferir\n" + "| Opção 5 -Extratos\n"
									+ "| Opção 6 -Cadastrar Cliente\n" + "| Opção 7 -Gerar Relatório Caixa\n"
									+ "| Digite 0 para sair",
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

	}

	public static void MenuDiretor(String cpfsenha) {
		Object[] escolha = { "Diretor", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		System.out.println(selecao);
		System.out.println("opção=" + opcao);
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteC(cpfsenha);
		} else {
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
							nome + "\n" + gre.getTime() + "\n------Selecione uma operação------\n"
									+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n"
									+ "| Opção 4 -Transferir\n" + "| Opção 5 -Extratos\n"
									+ "| Opção 6 -Cadastrar Funcionário\n" + "| Opção 7 -Cadastrar Cliente\n"
									+ "| Digite 0 para sair",
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
	}

	public static void MenuCaixa(String cpfsenha) {
		Object[] escolha = { "Caixa", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteC(cpfsenha);
		} else {
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
							nome + "\n" + gre.getTime() + "\n------Selecione uma operação------\n"
									+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n"
									+ "| Opção 4 -Transferir\n" + "| Opção 5 -Extratos\n"
									+ "| Opção 6 -Consultar Saldo Cliente\n" + "| Digite 0 para sair\n",
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

	public static void MenuPresidente(String cpfsenha) {
		Object[] escolha = { "Presidente", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteC(cpfsenha);
		} else {
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
							nome + "\n" + gre.getTime() + "\n------Selecione uma operação------\n"
									+ "| Opção 1 -Saque\n" + "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n"
									+ "| Opção 4 -Transferir\n" + "| Opção 5 -Extratos\n"
									+ "| Opção 6 -Consultar Saldo Cliente\n" + "| Digite 0 para sair\n",
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

}