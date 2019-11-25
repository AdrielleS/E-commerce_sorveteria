package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import beans.Funcionario;
import exceptions.FuncionarioException;
import java.time.LocalDate;

public class RepositorioFuncionarios implements Serializable{

	private static final long serialVersionUID = 1025911660485970999L;
	ArrayList<Funcionario> funcionarios;
	File file;
	public static RepositorioFuncionarios instance;
	
	public RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
		
	}
	
	
	public ArrayList<Funcionario> listar()
	{
                return funcionarios;
               /* ArrayList<String> funcionarioString = new ArrayList<>();
		for (Funcionario funcionario : funcionarios) {
                        funcionarioString.add(funcionario.toString());
			System.out.println(funcionario.getNome());
		}
                return funcionarioString */
	}
	
	
	  public static RepositorioFuncionarios getInstance() throws ClassNotFoundException, IOException {
		    if (instance == null) {
		      instance = lerArquivo();
		    }
		    return instance;
		  }
	
	
	public static RepositorioFuncionarios lerArquivo() throws ClassNotFoundException, IOException
	{
		RepositorioFuncionarios instancialocal =  null;
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    fis = new FileInputStream(f);
	    ois = new ObjectInputStream(fis);
	    Object o = ois.readObject();
	    instancialocal = (RepositorioFuncionarios) o;
	    ois.close();


	    return instancialocal;
	}
	
	public void salvarArquivo() throws IOException
	{

			File f =  new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
			FileOutputStream fos = null;
		    ObjectOutputStream oos = null;

		    fos = new FileOutputStream(f);
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(instance);
		    oos.close(); 
		
		
	}
	


	public boolean cadastrar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
		LocalDate dataAdmissao, String tipoFuncionario) throws FuncionarioException {
		boolean cadastrado =false;
        Funcionario funcionario = new Funcionario(nome, email, dataNascimento, senha, cpf, dataAdmissao, tipoFuncionario);
		
        if(funcionarios.isEmpty()){
        	funcionarios.add(funcionario);
        	cadastrado = true;
        }else{
        	Funcionario tem = this.buscar(funcionario);
            if(tem == null){
            	funcionarios.add(funcionario);
            	cadastrado = true;
            }else{
            	FuncionarioException cadastrofuncionario =  new FuncionarioException("Funcionario não pode ser cadastrado");
            	throw cadastrofuncionario;
            }
        }

        
		return cadastrado;
	}
	
	


	public boolean remover(Funcionario funcionario) throws FuncionarioException {
		Funcionario fun = this.buscar(funcionario);
		boolean removido = false;
		if(funcionario != null)
		{
			funcionarios.remove(fun);
			removido = true;
		}else{
			FuncionarioException removerfuncionario =  new FuncionarioException("Funcionario não existe no repositorio");
			throw removerfuncionario;
		}


		return removido;
	}


	public boolean atualizar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			LocalDate dataAdmissao, String tipoFuncionario) throws FuncionarioException {
		
		Funcionario funcionario =  new Funcionario(nome, email, dataNascimento, senha, cpf, dataAdmissao, tipoFuncionario);
		boolean atualizado = false;
		if(funcionario != null)
		{
			for (int i =0; i< funcionarios.size(); i++) {
				int u = this.retornarIndice(funcionario.getCpf());
				if(u!= -1)
				{
					
					funcionarios.set(u, funcionario);
					atualizado = true;
				
				}
			}if(atualizado == false){
				
				FuncionarioException atualizarfuncionario = new FuncionarioException("Funcionario não existe no repositorio");
				throw atualizarfuncionario;
			}
		}
		
		
		return atualizado;
		
	}

	public Funcionario buscar(Funcionario funcionario) throws FuncionarioException {
		
		Funcionario resul = null;
		
		if(funcionario != null)
		{
			for (Funcionario f : funcionarios)
			{
				int i = this.retornarIndice(f.getCpf());
				if(i!=-1)
				{
					resul = f;
				}
			}if(resul == null){
				FuncionarioException buscarfuncionario = new FuncionarioException("Funcionario não existe no repositorio");
				throw buscarfuncionario;
			}
		}
		
		return resul;
	}
	
	private int retornarIndice(String cpf) {
		int indice =-1;
		for(int i =0; i< funcionarios.size(); i++) {
			if(funcionarios.get(i).getCpf().equals(cpf)) {
				indice = i;
			}
		}
		return indice;
		
	}

	
	
}
