package br.com.poo.pessoas;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;
import br.com.poo.vo.CadastroClienteVO;
import br.com.poo.vo.CadastroFuncionarioVO;

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
		CadastroFuncionarioVO cadastro = new CadastroFuncionarioVO();
		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		cadastro.setSalarios(JOptionPane.showInputDialog("Insira o sálario inicial"));
		cadastro.setCargo(JOptionPane.showInputDialog("Qual o cargo?"));
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		JOptionPane.showInputDialog("Qual o tipo de conta?");
//arrumar forma de converter string para double
//			Caixa novocaixa = new Caixa(nome, sobrenome, cpf, cpf, contato, 5000);
//			System.out.println(novocaixa.getNome());
		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo )"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'" + cadastro.getCpf() + "'" + ",'" + cadastro.getEmail()
				+ "','" + cadastro.getContato() + "'" + ",'" + cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'" + cadastro.getCargo() + "'"+",'"+ tipoconta + ")";
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

	public void CadastroCliente() {
		Conexao con = new Conexao();
		CadastroClienteVO cadastro = new CadastroClienteVO();
		
		Object[] escolha = { "Corrente", "Poupanca" , "Ambos"};
		Object opcao = JOptionPane.showInputDialog(null, "Conta", "Escolha o tipo de conta:",
		JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[2]);
		String selecao = (String) opcao;
		System.out.println();
		
		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		cadastro.setCargo("cliente");
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		double salario = 0;
		
//		String nome = JOptionPane.showInputDialog("Insira o nome ");
//		String sobrenome = JOptionPane.showInputDialog("Insira o sobrenome");
//		String cpf = JOptionPane.showInputDialog("Insira o CPF");
//		String email = JOptionPane.showInputDialog("Insira o email");
//		String contato = JOptionPane.showInputDialog("Insira telefone para Contato");
//		String cargo = "cliente";
//		String senha = JOptionPane.showInputDialog("Crie uma senha");
//		String saldos = JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00");
//		double saldo = Double.parseDouble(saldos);
//		double salario = 0;
		

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,saldo)"
				+ "values (default," + "'" + cadastro.getNome()+ "'" + ",'" + cadastro.getSobrenome() + "'" + ",'" +cadastro.getSobrenome() + "'" + ",'" +cadastro.getEmail()
				+ "','" +cadastro.getContato() + "'" + ",'" + cadastro.getSalario() + "'" + ",'" +cadastro.getCpf()+cadastro.getSenha()+ "'" + ",'" +cadastro.getCargo() + "'" + ",'"+cadastro.getSaldo()+"'" + ")";
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
		} else {
			System.out.println("Erro durante o cadastro");
		}
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
