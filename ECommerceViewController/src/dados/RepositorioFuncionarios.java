package dados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import beans.Funcionario;
import exceptions.FuncionarioException;

public class RepositorioFuncionarios{

	ArrayList<Funcionario> funcionarios;
	File file;
	
	public RepositorioFuncionarios() throws IOException {
		funcionarios = new ArrayList<Funcionario>();
		file =  new File("Arquivo-funcinario.txt");
		if(!file.exists()) 
		{
			file.createNewFile();
		}
		else
		{
			IOException arquivo  =  new IOException("O arquivo não pode ser criado");
			throw arquivo;
		}
	}
	


	public void cadastrar(Funcionario funcionario) throws FuncionarioException, IOException {
		if(funcionario != null)
		{
			for (Funcionario f : funcionarios) {
				if(f.getCpf().equals(funcionario.getCpf()))
				{
					FuncionarioException funcionariocadastrado =  new FuncionarioException("O fucionario já esta cadastrado");
					throw funcionariocadastrado;
				}
				else
				{
					FileWriter w = new FileWriter(file);
					w.append(funcionario.toString());
				}
			}
		}
	}


	public void remover(Funcionario funcionario) throws FuncionarioException {
		if(funcionario != null)
		{
			for (Funcionario f : funcionarios) {
				if(f.getCpf().equals(funcionario.getCpf()))
				{
					funcionarios.remove(funcionario);
				}
				else
				{
					FuncionarioException funcionarioremovido =  new FuncionarioException("O funcionario já foi removido");
					throw funcionarioremovido;
				}
			}
		}
	}


	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	public Object buscar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
