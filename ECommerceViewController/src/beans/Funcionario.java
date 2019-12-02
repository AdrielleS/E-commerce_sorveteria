package beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario implements Serializable{

	private static final long serialVersionUID = -2048168189871662381L;
        
	private LocalDate dataAdmissao;
	private String tipoFuncionario;
        private String nome;
        private String email;
        private LocalDate dataNascimento;
        private String senha;
        private String cpf;
	
	private static final String ENTREGADOR = "ENTREGADOR";
	private static final String SORVETEIRO= "SORVETEIRO";
	
	public Funcionario(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			LocalDate dataAdmissao, String tipoFuncionario) {
            
		this.nome = nome;
                this.email = email;
                this.dataNascimento = dataNascimento;
                this.senha = senha;
                this.cpf = cpf;
		this.dataAdmissao = dataAdmissao;
		this.tipoFuncionario = tipoFuncionario;
	}

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
        
        
	
	
	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public String getTipoFuncionario() {
		return tipoFuncionario;
	}
	public void setTipoFuncionario(String tipoFuncionario) {
		if (tipoFuncionario.equalsIgnoreCase(ENTREGADOR) || 
				tipoFuncionario.equalsIgnoreCase(SORVETEIRO)) {
			this.tipoFuncionario = tipoFuncionario;
		}
	}
	
	public String toString() {
		String s = this.nome+"\t"+this.cpf+"   "+this.dataNascimento.toString()+"\t"+this.tipoFuncionario+"\t"+this.dataAdmissao.toString();
		return s;
	}
	
	
	
}
