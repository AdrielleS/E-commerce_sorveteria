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
	
	
}
