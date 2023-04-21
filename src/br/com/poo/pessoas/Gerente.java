package br.com.poo.pessoas;

import javax.swing.JOptionPane;
import br.com.poo.interfac.*;

import br.com.poo.conexao.Conexao;
import br.com.poo.vo.CadastroClienteVO;
import br.com.poo.vo.MenuGerenteVO;

public class Gerente extends Caixa {
	Interface nova = new Interface();

	public Gerente(String nome, String sobrenome, String cpf, String email, String contato, double salario) {
		super(nome, sobrenome, cpf, email, contato, salario);

	}

	public Gerente() {

	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setSalarioCaixa(double salario) {
		Caixa caixa = new Caixa(getContato(), getContato(), getContato(), getContato(), getContato(), salario);
		caixa.salario = salario;
	}

	public double Bonificacao(double bonificacao) {
		bonificacao = bonificacao / 100;
		int porcentagem = (int) (salario * bonificacao);
		salario = porcentagem + salario;

		return salario;

	}

	public void cadastroCliente(String cpfsenha) {
		Object[] escolha = { "Corrente", "Poupanca", "Ambos" };
		Object opcao = JOptionPane.showInputDialog(null, "Conta", "Escolha o tipo de conta:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[2]);
		String selecao = (String) opcao;

		if (selecao.equalsIgnoreCase("Corrente")) {
			cadastroClienteC(cpfsenha);
		}
		if (selecao.equalsIgnoreCase("Poupanca")) {
			cadastroClienteP(cpfsenha);
		}
		if (selecao.equalsIgnoreCase("Ambos")) {
			cadastroClienteA(cpfsenha);
		}

	}

	public void cadastroClienteC(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia = (String) opcao;
		System.out.println(agencia);
		CadastroClienteVO cadastro = new CadastroClienteVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		cadastro.setCargo("Cliente");
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSalarios("0");
		System.out.println(cadastro.getSaldo());

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,saldo,agencia)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'"
				+ cadastro.getCargo() + "'" + ",'" + cadastro.getSaldo() + "'" + ",'" + agencia + "'" + ")";
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
		} else {
			System.out.println("Erro durante o cadastro");
		}
		MenuGerenteVO.MenuGerente(cpfsenha,agencia);

	}

	public void cadastroClienteP(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia= (String)opcao;
		System.out.println(agencia);
		CadastroClienteVO cadastro = new CadastroClienteVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		cadastro.setCargo("Cliente");
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00"));
		cadastro.setSalarios("0");
		System.out.println(cadastro.getSaldo());

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,poupanca,agencia)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'"
				+ cadastro.getCargo() + "'" + ",'" + cadastro.getSaldo() + "'" + ",'" + agencia + "'" + ")";
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
		} else {
			System.out.println("Erro durante o cadastro");
		}
		MenuGerenteVO.MenuGerente(cpfsenha,agencia);
		
	}

	public void cadastroClienteA(String cpfsenha) {
		Conexao con = new Conexao();
		Object[] escolha = { "3344", "4455", "6678", "0022" };
		Object opcao = JOptionPane.showInputDialog(null, "Escolha", "Informe a agencia:",
				JOptionPane.INFORMATION_MESSAGE, null, escolha, escolha[3]);
		String agencia = (String) opcao;
		System.out.println(agencia);
		CadastroClienteVO cadastro = new CadastroClienteVO();

		cadastro.setNome(JOptionPane.showInputDialog("Insira o nome "));
		cadastro.setSobrenome(JOptionPane.showInputDialog("Insira o sobrenome"));
		cadastro.setCpf(JOptionPane.showInputDialog("Insira o CPF"));
		cadastro.setEmail(JOptionPane.showInputDialog("Insira o email"));
		cadastro.setContato(JOptionPane.showInputDialog("Insira telefone para Contato"));
		cadastro.setCargo("Cliente");
		cadastro.setSenha(JOptionPane.showInputDialog("Crie uma senha"));
		cadastro.setSaldos(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00 na Conta Corrente"));
		cadastro.setSaldops(JOptionPane.showInputDialog("Deposite um valor minimo de R$100,00 na Conta Poupança"));
		cadastro.setSalarios("0");
		System.out.println(cadastro.getSaldo());

		String sql = " Insert into funcionario (id, nome , sobrenome, cpf, email, contato,salario,cpfsenha,cargo,saldo,poupanca,agencia)"
				+ "values (default," + "'" + cadastro.getNome() + "'" + ",'" + cadastro.getSobrenome() + "'" + ",'"
				+ cadastro.getCpf() + "'" + ",'" + cadastro.getEmail() + "','" + cadastro.getContato() + "'" + ",'"
				+ cadastro.getSalario() + "'" + ",'" + cadastro.getCpf() + cadastro.getSenha() + "'" + ",'"
				+ cadastro.getCargo() + "'" + ",'" + cadastro.getSaldo() + "'" + ",'" + cadastro.getSaldop() + "'"
				+ ",'" + agencia + "'" + ")";
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
		} else {
			System.out.println("Erro durante o cadastro");
		}
		MenuGerenteVO.MenuGerente(cpfsenha,agencia);
	}
}
