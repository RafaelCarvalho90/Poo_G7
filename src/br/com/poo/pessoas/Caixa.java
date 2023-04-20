package br.com.poo.pessoas;

public class Caixa extends Pessoa
{
	public Caixa(String nome, String sobrenome, String cpf, String email, String contato,double salario) {
		super(nome, sobrenome, cpf, email, contato);

	}
	public Caixa() {
		
	}



	double salario;
	
	

	public double getSalario() {
		return salario;
	}

	protected void setSalario(double salario) {
		this.salario = salario;
	}
	
	public double Bonificacao(double bonificacao) {
		
		salario=salario*bonificacao;
		
		return salario;
		
	}
	
	



}
