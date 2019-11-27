package beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Consumidor implements Serializable{
	

	private static final long serialVersionUID = 7874769581605575568L;
	private String endereco;
	private Zona zona;
        private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String senha;
	private String cpf;

    public Consumidor(String nome, String email, LocalDate dataNascimento, String senha, String cpf, String endereco,Zona zona) {
        this.endereco = endereco;
        this.zona = zona;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
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
