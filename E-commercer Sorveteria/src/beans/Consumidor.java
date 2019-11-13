package beans;

import java.time.LocalDate;

public class Consumidor extends Pessoa {
	
	private String endereco;

	public Consumidor(String nome, String email, LocalDate dataNascimento, String senha, String cpf, String endereco) {
		super(nome, email, dataNascimento, senha, cpf);
		this.endereco = endereco;
	}
	
}
