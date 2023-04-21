package br.com.poo.vo;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import br.com.poo.conexao.Conexao;
import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaCorrente;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.interfac.Interface;
import br.com.poo.pessoas.Cliente;

public class MenuClienteVO {
	

	public static void MenuClienteC(String cpfsenha, String agencia) {

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
				String cargo = rs.getString("cargo");

				if (cargo.equalsIgnoreCase("cliente")) {
				}

				Conta cliente = new ContaCorrente();

				int operacao = Integer.parseInt(JOptionPane.showInputDialog(null,
						nome + "\n" + gre.getTime() + "\n\n------Selecione uma operação------\n" + "| Opção 1 -Saque\n"
								+ "| Opção 2 -Saldo\n" + "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n"
								+ "| Opção 5 -Extratos\n" + "| Opção 6- Mudar tipo de Conta\n " + "| Opção 7- Voltar\n"
								+ "| Digite 0 para sair",
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
					MenuClienteC(cpfsenha, agencia);
					break;
				case 2:
					System.out.println(novaconta.getSaldo());
					JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
					MenuClienteC(cpfsenha, agencia);

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

					MenuClienteC(cpfsenha,agencia);
					break;
				case 4:
					Object valort = JOptionPane.showInputDialog(null, "Qual valor gostaria de transferir?", "Deposito",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/trans.png"), null, null);
					double valortr = Double.parseDouble((String) valort);
					novaconta.transferir(valortr, novaconta);
					break;
				case 5:
//					Extratos;
				case 6:
					if (cargo.equalsIgnoreCase("Gerente")) {
						MenuGerenteVO.MenuGerente(cpfsenha,agencia);
					} else if (cargo.equalsIgnoreCase("Diretor")) {
						Interface.MenuDiretor(cpfsenha);
					} else if (cargo.equalsIgnoreCase("Caixa")) {
						Interface.MenuCaixa(cpfsenha);
					} else if (cargo.equalsIgnoreCase("Presidente")) {
						Interface.MenuPresidente(cpfsenha);
						;
					} else {
						JOptionPane.showMessageDialog(null, "Você não possui um cargo dentro desta Empresa");
						MenuClienteVO.MenuClienteC(cpfsenha,agencia);
					}
				case 7:
					MenuCliente(cpfsenha, agencia);

				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteC(cpfsenha, agencia);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuClienteP(String cpfsenha, String agencia) {

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
					MenuClienteVO.MenuClienteC(cpfsenha, agencia);
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
					MenuClienteVO.MenuClienteC(cpfsenha,agencia);
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
					MenuClienteP(cpfsenha,agencia);

				case 0:
					JOptionPane.showMessageDialog(null, "Obrigado por usar nossa agencia");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Opção Invalida");
					MenuClienteVO.MenuClienteC(cpfsenha,agencia);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void MenuCliente(String cpfsenha,String agencia) {
		Conexao con = new Conexao();
		String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'" + ";";
		ResultSet rs = con.executaBusca(sql);
		try {
			while (rs.next()) {

				String tipo = rs.getString("tipoconta");
				
				Object[] escolha = { "Corrente", "Poupança" };
				Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Escolha o tipo de Conta:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
				String selecao = (String) opcao;
				
				if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("Corrente")) {
					MenuClienteC(cpfsenha, agencia);
				} 
				else if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("ambos")){
					MenuClienteC(cpfsenha, agencia);
				}
				else if (selecao.equalsIgnoreCase("Corrente") && tipo.equalsIgnoreCase("Poupança")){
					JOptionPane.showMessageDialog(null, "Você ainda não possui uma Conta Corrente");
					MenuCliente(cpfsenha, agencia);
				}
				else if (selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("ambos")){
					MenuClienteP(cpfsenha,agencia);
				}
				else if (selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("Poupança")){
					MenuClienteP(cpfsenha, agencia);
				}
				else if(selecao.equalsIgnoreCase("Poupança") && tipo.equalsIgnoreCase("Corrente")){
					JOptionPane.showMessageDialog(null, "Você ainda não possui uma Conta Poupança");
					MenuCliente(cpfsenha, agencia);
				}
					
				



			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
