package br.com.poo.pessoas;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Funcionarios 
{
	protected String nome;
	protected String sobrenome;
	protected String cpf;
	protected String email;
	protected String contato;
	protected String idFuncionario;
	protected double salario;
	protected static int numFuncionarios = 0;
	static boolean verifica_nome;
	
	
	
	public String getNome() 
	{				
		  
	    
		return null;						
	}
	
	public void setNome(String nome) 
	{							
		for (int i = 0; i < nome.length(); i++) 
		{
	        if (Character.isDigit(nome.charAt(i)) || nome.length() < 3 || nome.equals(" ") || nome.equals("")) 
	        {
	             System.out.println("O Nome não pode:"
		            		+ "\n-Conter números;"
		            		+ "\n-Estar vazio;"
		            		+ "\n-Ser menor que três caracteres;");   	            
	        }
	        else 
	        {	        	
	        	this.nome = nome;
			}
		}		
	}
	
	public String getSobrenome() 
	{
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) 
	{
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() 
	{
		return cpf;
	}
	
	public void setCpf(String cpf) 
	{
		this.cpf = cpf;
	}
	

	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	

	public String getContato() 
	{
		return contato;
	}
	
	public void setContato(String contato) 
	{
		this.contato = contato;
	}
	
	public String getIdFuncionario() 
	{
		return idFuncionario;
	}
	
	public void setIdFuncionario(String idFuncionario) 
	{
		this.idFuncionario = idFuncionario;
	}
	
	public static int getNumFuncionarios() 
	{
		return numFuncionarios;
	}
	
	public static void setNumFuncionarios(int numFuncionarios) 
	{
		Funcionarios.numFuncionarios = numFuncionarios;
	}
		
}
