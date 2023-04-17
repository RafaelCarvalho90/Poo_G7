package br.com.poo.pessoas;

import javax.swing.JOptionPane;

import br.com.poo.conexao.Conexao;

public class Gerente extends Caixa
{
	public Gerente(String nome, String sobrenome, String cpf, String email, String contato,double salario) {
		super(nome, sobrenome, cpf, email, contato, salario);
		
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setSalarioCaixa(double salario) {
		Caixa caixa = new Caixa(getContato(), getContato(), getContato(), getContato(), getContato(), salario);
		caixa.salario= salario;
	}
	
	public double Bonificacao(double bonificacao) {
		bonificacao = bonificacao /100;
		int porcentagem = (int) (salario * bonificacao);
		salario= porcentagem + salario ;
		
		
		return salario;
		
	}
	public void cadastroCliente() {
		Conexao con = new Conexao();
		String nome = JOptionPane.showInputDialog("Insira o nome ");
		String sobrenome = JOptionPane.showInputDialog("Insira o sobrenome");
		String cpf = JOptionPane.showInputDialog("Insira o CPF");
		String email = JOptionPane.showInputDialog("Insira o email");
		String contato = JOptionPane.showInputDialog("Insira telefone para Contato");
		Caixa novocaixa = new Caixa(nome, sobrenome, cpf, cpf, contato, 5000);
		System.out.println(novocaixa.getNome());
		String sql = " Insert into cliente (id, nome , sobrenome, cpf, email, contato )" + "values (default,"
				+ "'" + nome + "'" + ",'" + sobrenome + "'" + ",'" + cpf + "'" + ",'" + email + "','" + contato
				+ "'" + ")";
		int res = con.excutaSql(sql);
		if (res > 0) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
//preciso fazer um retorno
		} else {
			System.out.println("Erro durante o cadastro");
		}
		
		
	}
}
