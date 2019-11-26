package negocio;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.util.List;

public class CadastroFuncionario {
    
    private RepositorioFuncionarios repFuncionario;

        
    public CadastroFuncionario() throws IOException{
        this.repFuncionario = RepositorioFuncionarios.getInstance();
    }
    
    public void cadastrar(Funcionario funcionario) throws FuncionarioException{
        if (funcionario != null) {
			this.repFuncionario.cadastrar(funcionario);
			this.repFuncionario.salvarArquivo();
		}
    
    }

	public List<Funcionario> listar() {
		return repFuncionario.listar();
	}

	public void remover(Funcionario funcionario) throws FuncionarioException {
		if (funcionario != null) {
			repFuncionario.remover(funcionario);
			this.repFuncionario.salvarArquivo();
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioException {
		if (funcionario != null) {
			repFuncionario.atualizar(funcionario);
			this.repFuncionario.salvarArquivo();
		}
	}

	public Funcionario buscar(Funcionario funcionario) throws FuncionarioException {
		return repFuncionario.buscar(funcionario);
	}
    
    

}