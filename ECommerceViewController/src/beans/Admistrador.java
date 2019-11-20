package beans;

import java.time.LocalDate;

public class Admistrador extends Funcionario {

	public Admistrador(String nome, String email, LocalDate dataNascimento, String senha, String cpf,LocalDate dataAdmissao, String tipoFuncionario) {
		super(nome, email, dataNascimento, senha, cpf, dataAdmissao, tipoFuncionario);
	}
	
	
}
