package beans;

import java.time.LocalDate;

public abstract class Pessoa {
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String senha;
	private String cpf;
	
	
	public Pessoa(String nome, String email, LocalDate dataNascimento, String senha, String cpf) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	
}
