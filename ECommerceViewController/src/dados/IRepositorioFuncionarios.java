package dados;


import java.util.List;

import beans.Funcionario;
import exceptions.FuncionarioException;

public interface IRepositorioFuncionarios {
	
	List<Funcionario> listar();
	
	void salvarArquivo();
	
	boolean cadastrar(Funcionario funcionarioo) throws FuncionarioException;
	
	boolean remover(Funcionario funcionario) throws FuncionarioException;
	
	boolean atualizar(Funcionario funcionario) throws FuncionarioException;
	
	Funcionario buscar(Funcionario funcionario) throws FuncionarioException ;
	

}
