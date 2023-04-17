package br.com.poo.pessoas;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class Diretor extends Gerente {
	public Diretor(String nome, String sobrenome, String cpf, String email, String contato, double salario) {
		super(nome, sobrenome, cpf, email, contato, salario);

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void CadastroFuncionario() {

		Conexao con = new Conexao();
//		 Scanner scanner = new Scanner(System.in);
//		Object[] opcaoCadastro = { "1. Novo cliente", "2. Novo Caixa", "3. Novo Gerente" };
//		Object opcaoSelecao = JOptionPane.showInputDialog(null, "Selecione a Opção que deseja cadastrar", null, 0, null,
//				opcaoCadastro, opcaoCadastro[0]);
//		switch (opcaoSelecao.toString().substring(0, 1)) {
//		case "1":
			String nome = JOptionPane.showInputDialog("Insira o nome ");
			String sobrenome = JOptionPane.showInputDialog("Insira o sobrenome");
			String cpf = JOptionPane.showInputDialog("Insira o CPF");
			String email = JOptionPane.showInputDialog("Insira o email");
			String contato = JOptionPane.showInputDialog("Insira telefone para Contato");
			String salarios = JOptionPane.showInputDialog("Insira o sálario inicial");
			double salario = Double.parseDouble(salarios);
			String cargo = JOptionPane.showInputDialog("Qual o cargo?");
			String senha = JOptionPane.showInputDialog("Crie uma senha");
//arrumar forma de converter string para double
			Caixa novocaixa = new Caixa(nome, sobrenome, cpf, cpf, contato, 5000);
			System.out.println(novocaixa.getNome());
			String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo )" + "values (default,"
					+ "'" + nome + "'" + ",'" + sobrenome + "'" + ",'" + cpf + "'" + ",'" + email + "','" + contato
					+ "'" +",'" + salario + "'"+ ",'"+cpf+senha +"'"+",'"+cargo+"'"+")";
			int res = con.excutaSql(sql);
			if (res > 0) {
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
			} else {
				System.out.println("Erro durante o cadastro");
			}

//		case "2":
//			JOptionPane.showMessageDialog(null, "Sistema em implementação");

		}
		// System.out.println("Gostaria de criar um
		// novo\n1)Cliente\t2)Caixa\t3)Diretor\t4)Gerente");
		// System.out.println("Prencha os dados de sua conta");
//		String nome = JOptionPane.showInputDialog("Insira o nome ");
//		String sobrenome = JOptionPane.showInputDialog("Insira o sobrenome");
//		String cpf = JOptionPane.showInputDialog("Insira o CPF");
//		String email = JOptionPane.showInputDialog("Insira o email");
//		String contato = JOptionPane.showInputDialog("Insira telefone para Contato");
//		Caixa novocaixa = new Caixa(nome, sobrenome, cpf, cpf, contato, 5000);
//		System.out.println(novocaixa.getNome());

		// System.out.print("Nome: ");
		// String nome = scanner.next();
		// System.out.print("Sobrenome: ");
		// String sobrenome= scanner.next();
		// System.out.print("CPF: ");
		// String cpf= scanner.next();
		// System.out.print("Email: ");
		// String email= scanner.next();
		// System.out.print("Contato: ");
		// String contato= scanner.next();

//		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato )" + "values (default," + "'"
//				+ nome + "'" + ",'" + sobrenome + "'" + ",'" + cpf + "'" + ",'" + email + "','" + contato + "'" + ")";
//		int res = con.excutaSql(sql);
//		if (res > 0) {
//			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
////preciso fazer um retorno
//		} else {
//			System.out.println("Erro durante o cadastro");
//		}
	
	
//	List<String> caixas = new ArrayList<String>();
//
//    List<String> cpfSenha = new ArrayList<String>();
//
//    caixa.add(cpf);
//    caixa.add(senha);
//    caixas.add(cpfSenha);

	public void Consulta() {

		Conexao con = new Conexao();
		Scanner input = new Scanner(System.in);
		System.out.println("Qual Funcionario?");
		String name = input.next();
		String sql = "select * from funcionario f where nome=" + "'" + name + "'" + ";";
		ResultSet rs = con.executaBusca(sql);

		try {
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				System.out.println(id + " - " + nome + " - " + sobrenome + " - " + email + " - " + cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
