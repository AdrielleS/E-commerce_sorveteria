package beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Pessoa implements Serializable {
        private static final long serialVersionUID = 7874335581605575568L;
        
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
        
    
        
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
        @Override
	public String toString() {
		String s = this.cpf+","+this.nome+","+this.dataNascimento.toString()+
				","+this.email+","+this.senha;
		return s;
	}
	
	
	
}
