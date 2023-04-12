package br.com.poo.pessoas;
import java.text.DecimalFormat;

public class Caixa extends Pessoa
{
	public double salarioCaixa;
	
	public Caixa() 
	{		
	}
	
	public Caixa(String nome, String sobrenome, String cpf, String email, String contato, double salarioCaixa)
	{
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.salarioCaixa = salarioCaixa;
	}
	
	public double getSalarioCaixa() 
	{
		return salarioCaixa;	
	}

	
}
