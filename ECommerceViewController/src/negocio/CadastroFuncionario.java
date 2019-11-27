package negocio;

import beans.Funcionario;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class CadastroFuncionario {
    
    private RepositorioFuncionarios repFuncionario;

        
    public CadastroFuncionario() throws IOException{
        this.repFuncionario = RepositorioFuncionarios.getInstance();
    }
    
    public void cadastrar(Funcionario funcionario) throws FuncionarioException{
    	LocalDate hoje = LocalDate.now();
        if (funcionario != null && this.eNumero(funcionario.getCpf())) {
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
	
	private boolean eNumero(String s) {
		boolean r;
		if(s.contains("^[a-Z]")) {
			r = false;
		}else{
			r =true;
		}
		return r;
		
	}
    
    

}