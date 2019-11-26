package dados;


import java.util.List;

import beans.Funcionario;
import exceptions.FuncionarioException;

public interface IRepositorioFuncionarios {
	
	List<Funcionario> listar();
	
	void salvarArquivo();
	
	void cadastrar(Funcionario funcionarioo) throws FuncionarioException;
	
	void remover(Funcionario funcionario) throws FuncionarioException;
	
	void atualizar(Funcionario funcionario) throws FuncionarioException;
	
	Funcionario buscar(Funcionario funcionario) throws FuncionarioException ;
	

}
