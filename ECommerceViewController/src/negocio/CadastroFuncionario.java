package negocio;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.util.List;

public class CadastroFuncionario {
    
    private RepositorioFuncionarios RepFuncionario;

        
    public CadastroFuncionario() throws IOException{
        this.RepFuncionario = RepositorioFuncionarios.getInstance();
    }
    
    public void cadastrar(Funcionario funcionario) throws FuncionarioException{
        if (funcionario != null) {
			this.RepFuncionario.cadastrar(funcionario);
			this.RepFuncionario.salvarArquivo();
		}
    
    }

	public List<Funcionario> listar() {
		return RepFuncionario.listar();
	}

	public void remover(Funcionario funcionario) throws FuncionarioException {
		if (funcionario != null) {
			RepFuncionario.remover(funcionario);
			this.RepFuncionario.salvarArquivo();
		}
	}

	public void atualizar(Funcionario funcionario) throws FuncionarioException {
		if (funcionario != null) {
			RepFuncionario.atualizar(funcionario);
			this.RepFuncionario.salvarArquivo();
		}
	}

	public Funcionario buscar(Funcionario funcionario) throws FuncionarioException {
		return RepFuncionario.buscar(funcionario);
	}
    
    

}