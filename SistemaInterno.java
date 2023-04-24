package br.com.poo.sistema;

import br.com.poo.contas.Conta;
import br.com.poo.contas.ContaPoupanca;
import br.com.poo.pessoas.Caixa;
import br.com.poo.pessoas.Diretor;
import br.com.poo.pessoas.Gerente;

import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

public class SistemaInterno 
{
	public static void main(String[] args) 
	{		
		Caixa caixa1 = new Caixa("Gabriel", "Nogueira", "111.222.333-45", "teste@teste.com", "91122-3344", 2600);
		
		System.out.println("Nome: " + caixa1.getNome());
		System.out.println("Salário antes do aumento: " + caixa1.getSalarioCaixa());
		
		Caixa caixa2 = new Caixa("Joana", "Souza", "333.444.555-67", "teste2@teste2.com", "93344-5566", 2700);
		
		System.out.println("Nome: " + caixa2.getNome());
		System.out.println("Salário antes do aumento: " + caixa2.getSalarioCaixa());
		
		Diretor diretor1 = new Diretor();
		
		diretor1.aumentoCaixa(caixa1, 15);
		
		System.out.println("Nome: " + caixa1.getNome());
		System.out.println("Salário depois do aumento: " + caixa1.getSalarioCaixa());
	}
	

}
