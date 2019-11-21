package beans;

import java.time.LocalDate;

public class Consumidor extends Pessoa {
	
	private String endereco;
	private Zona zona;

	public Consumidor(String nome, String email, LocalDate dataNascimento, String senha, String cpf, String endereco, Zona zona) {
		super(nome, email, dataNascimento, senha, cpf);
		this.endereco = endereco;
		this.zona = zona;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
	public String toString() {
		String s = super.toString()+","+ this.endereco+","+this.zona;
		return s;
	}
	
	

	
}
