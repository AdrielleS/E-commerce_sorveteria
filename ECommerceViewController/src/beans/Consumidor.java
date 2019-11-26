package beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Consumidor extends Pessoa implements Serializable{
	

	private static final long serialVersionUID = 7874769581605575568L;
	private String endereco;
	private Zona zona;
        private Consumidor(){
            super();
        }
        
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
	
	public boolean equals(Consumidor c) {
		boolean igual = false;
		if(c !=null) {
			if(this.getCpf().equals(c.getCpf()) && this.getNome().equalsIgnoreCase(c.getNome())
					&& this.getEmail().equals(c.getEmail())) {
				igual =true;
			}
			
		}
		return igual;
	}
	
	

	
}
