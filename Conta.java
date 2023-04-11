package br.com.poo.contas;

import java.text.DecimalFormat;

public class Conta 
{
	protected String agencia;
	protected String numeroConta;
	protected String titular;
	protected Double saldo = 0.0;
	
	public String getAgencia() 
	{
		return agencia;
	}
	
	public void setAgencia(String agencia) 
	{
		this.agencia = agencia;
	}
	
	public String getNumeroConta() 
	{
		return numeroConta;
	}
	
	public void setNumeroConta(String numeroConta) 
	{
		this.numeroConta = numeroConta;
	}
	
	public String getTitular() 
	{
		return titular;
	}
	
	public void setTitular(String titular) 
	{
		this.titular = titular;
	}
	
	public String getSaldo() 
	{
		DecimalFormat df = new DecimalFormat("R$ #,###.00");
		if(this.saldo == 0.0)
		{
			return "R$ 0,00";
		}
		else
		{
			return df.format(saldo);
		}		
	}
	
	@Override
	public String toString() 
	{
		return "Conta [agencia=" + agencia + ", numeroConta=" + numeroConta + ", titular=" + titular + ", saldo="
				+ saldo + "]";
	}
			
	public Conta() 
	{
	}
	
	public Conta(String titular) 
	{
		this.titular = titular;		
	}
	
	public Conta(String agencia, String numeroConta, String titular, Double saldo) 
	{
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
	}
	
	public boolean sacar(double valor)
	{
		if(this.saldo < valor || valor <= 0)
		{
			return false;
		}
		else
		{
			this.saldo -= valor;
			return true;
		}
	}
	
	public boolean depositarDinheiro(double valor)
	{
		if(valor <= 0 || valor > 5000)
		{
			return false;
		}
		else
		{
			this.saldo += valor;
			return true;
		}
	}
	
	public boolean depositarCheque(double valor)
	{
		if(valor <= 0 || valor > 50000)
		{
			return false;
		}
		else
		{
			this.saldo += valor;
			return true;
		}
	}
	
	public boolean transferirSaque(double valor)
	{
		if(valor <= 0)
		{
			return false;
		}
		else
		{
			this.saldo += valor;
			return true;
		}
	}
		
	public boolean transferir(double valor, Conta destino)
	{
		if(sacar(valor) && destino.transferirSaque(valor))
		{			
			return true;
		}
		else
		{
			return false;
		}			
	}
		
}
