package br.com.poo.vo;

public class CadastroFuncionarioVO {

    private String nome; 
	private String sobrenome; 
	private String cpf; 
	private String email; 
	private String contato; 
	private String salarios; 
    private double salario;
	private String cargo; 
	private String senha;
	
    public CadastroFuncionarioVO(String nome, String sobrenome, String cpf, String email, String contato,
		String salarios, double salario, String cargo, String senha) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.salarios = salarios;
		this.salario = salario;
		this.cargo = cargo;
		this.senha = senha;
	}

	public CadastroFuncionarioVO() {
		super();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getSalarios() {
		return salarios;
	}

	public void setSalarios(String salarios) {
		this.salarios = salarios;
	}

	public double getSalario() {
		return Double.parseDouble(salarios);
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	} 
	




}
