package beans;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	
	private LocalDate dataAdmissao;
	private String tipoFuncionario;
	public Funcionario(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			LocalDate dataAdmissao, String tipoFuncionario) {
		super(nome, email, dataNascimento, senha, cpf);
		this.dataAdmissao = dataAdmissao;
		this.tipoFuncionario = tipoFuncionario;
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
		this.tipoFuncionario = tipoFuncionario;
	}
	
	
	
	
}
