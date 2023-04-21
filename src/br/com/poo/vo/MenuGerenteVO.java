package br.com.poo.vo;

import java.sql.*;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
import br.com.poo.pessoas.Gerente;

public class MenuGerenteVO {

	public static void MenuGerente(String cpfsenha, String agencia) {
		Object[] escolha = { "Gerente", "Cliente" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Deseja entrar como:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[1]);
		String selecao = (String) opcao;
		if (selecao.equalsIgnoreCase("cliente")) {
			MenuClienteVO.MenuCliente(cpfsenha, agencia);
		} else {

			GregorianCalendar gre = new GregorianCalendar();
			Conexao con = new Conexao();
			Gerente ger = new Gerente();
			String sql = "select * from funcionario f where cpfsenha=" + "'" + cpfsenha + "'"
					+ "and agencia=" + "'" + agencia + "'" + ";";
			ResultSet rs = con.executaBusca(sql);
			try {
				while (rs.next()) {

					String nome = rs.getString("nome");
					double saldo = rs.getDouble("saldo");

					int operacao = Integer.parseInt(JOptionPane.showInputDialog(null, nome + "\n" + gre.getTime()
							+ "\n\n------Selecione uma operação------\n" + "| Opção 1 -Teste -\n" + "| Opção 2 -Saldo\n"
							+ "| Opção 3 -Deposito\n" + "| Opção 4 -Transferir\n" + "| Opção 5 -Extratos\n"
							+ "| Opção 6 -Cadastrar Cliente\n" + "| Opção 7 -Mudar Acesso\n" + "| Digite 0 para sair",
							"Menu Gerente ", JOptionPane.INFORMATION_MESSAGE));
					switch (operacao) {
					case 1:
						Totalagencia(cpfsenha, agencia);
						MenuGerente(cpfsenha, agencia);

						break;

					case 2:
						JOptionPane.showInternalMessageDialog(null, "Seu saldo é: " + saldo);
						MenuGerente(cpfsenha, agencia);

						break;
					case 3:
						JOptionPane.showInputDialog(null, "Qual valor gostaria de depositar?", "Deposito",
								JOptionPane.INFORMATION_MESSAGE, new ImageIcon("res/qr.jpg"), null, null);
						MenuGerente(cpfsenha, agencia);
						break;
					case 4:
//					Transferir
						break;

//				case 5:Extratos

					case 6:
						ger.cadastroCliente(cpfsenha);
						break;
					case 7:
						MenuGerente(cpfsenha, agencia);
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

	public static void Totalagencia(String cpfsenha, String agencia) {

		Conexao con = new Conexao();

		String sql = "select count(agencia) as count from funcionario f where cpfsenha=" + "'" + cpfsenha + "'"
				+ "or agencia=" + "'" + agencia + "'" + ";";

		ResultSet rs = con.Count(sql);
		try {

			while (rs.next()) {

				int count = rs.getInt("count");
				JOptionPane.showMessageDialog(null,"O número de contas na agência " + agencia + " é: " + count);
				System.out.println("esse aqui tem historia"+count);
			}

			//
//
//				JOptionPane.showMessageDialog(null, "O número de registros na tabela com a agencia " + agencia + " é: " + count);
//
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
