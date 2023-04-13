package br.com.poo.pessoas;

import java.sql.ResultSet;
import java.util.Scanner;

import br.com.poo.conexao.Conexao;

public class Diretor extends Gerente
{
	public Diretor(String nome, String sobrenome, String cpf, String email, String contato,double salario) {
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Gostaria de criar um novo\n1)Cliente\t2)Caixa\t3)Diretor\t4)Gerente");		
		System.out.println("Prencha os dados de sua conta");
		System.out.print("Nome: ");
		String nome = scanner.next();
		System.out.print("Sobrenome: ");
		String sobrenome= scanner.next();
		System.out.print("CPF: ");
		String cpf= scanner.next();
		System.out.print("Email: ");
		String email= scanner.next();
		System.out.print("Contato: ");
		String contato= scanner.next();
		
				
		String sql =" Insert into funcionario (id, nome , sobrenome, cpf, email, contato )"+
					"values (default,"+"'"+nome+"'"+",'"+sobrenome+"'"+",'"+cpf+"'"+",'"+email+"','"+contato+"'"+")";
		int res = con.excutaSql(sql);
		if(res>0) {
			System.out.println("Cadastrado com sucesso");
		}else {
			  System.out.println("Erro durante o cadastro");
			  		}
		}
	
	public void Consulta() {
		Scanner input= new Scanner(System.in);
		Conexao con = new Conexao();
		System.out.println("Qual Funcionario?");
		String name = input.next();	
		String sql= "select * from funcionario f where nome="+"'"+name+"'"+";";
		ResultSet rs= con.executaBusca(sql);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome= rs.getString("nome");
				String sobrenome=rs.getString("sobrenome");
				String cpf=rs.getString("cpf");
				String email=rs.getString("email");
				System.out.println(id+" - "+nome+" - "+sobrenome+" - "+email+" - "+cpf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
