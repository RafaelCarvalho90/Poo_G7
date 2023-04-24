package br.com.poo.pessoas;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Diretor extends Caixa 
{
	private double salarioDiretor;

	public double getSalario() 
	{
		return salarioDiretor;
	}

	public void aumentoCaixa(Caixa nomeCaixa, double aumento)
	{
//		double porcentagem = aumento
		
		double aumentarCaixa = (salarioCaixa * aumento);
						
		this.salarioCaixa += aumentarCaixa;							
	}
	
	 
}
