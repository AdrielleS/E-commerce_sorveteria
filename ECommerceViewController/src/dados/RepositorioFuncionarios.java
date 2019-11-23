package dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import beans.Funcionario;
import exceptions.FuncionarioException;
import sun.security.jca.GetInstance.Instance;

import java.time.LocalDate;

public class RepositorioFuncionarios{
	ArrayList<Funcionario> funcionarios;
	File file;
	private static RepositorioFuncionarios instance;
	
	public RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();
		
	}
	
	
	public void listar()
	{
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.getNome());
		}
	}
	
	
	  public static RepositorioFuncionarios getInstance() throws ClassNotFoundException, IOException {
		    if (instance == null) {
		      instance = lerArquivo();
		    }
		    return instance;
		  }
	
	
	public static RepositorioFuncionarios lerArquivo() throws IOException, ClassNotFoundException
	{
		RepositorioFuncionarios instancialocal =  null;
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
		FileInputStream fis =  new FileInputStream(f);
		ObjectInputStream ois =  new ObjectInputStream(fis);
		Object o = ois.readObject();

		instancialocal = (RepositorioFuncionarios) o; 
		
		ois.close();
		
		return instancialocal;
	}
	
	public void salvarArquivo() throws IOException
	{
			File f =  new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
			FileOutputStream fos =  new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(instance);
			
			oos.close();
		
		
	}
	


	public boolean cadastrar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
		
		LocalDate dataAdmissao, String tipoFuncionario) throws FuncionarioException {
		boolean cadastrado =false;
		boolean resul = false;
        Funcionario funcionario = new Funcionario(nome, email, dataNascimento, senha, cpf, dataAdmissao, tipoFuncionario);
		
        if(funcionarios.isEmpty())
        {
        	funcionarios.add(funcionario);
        	cadastrado = true;
        }
        else
        {
        	for (Funcionario f : funcionarios) {
				if(f.getCpf().equals(funcionario.getCpf()))
				{
					resul = true;
				}
			}
            
            if(resul == false)
            {
            	funcionarios.add(funcionario);
            	cadastrado = true;
            }
            else
            {
            	FuncionarioException cadastrofuncionario =  new FuncionarioException("Funcionario não pode ser cadastrado");
            	throw cadastrofuncionario;
            }
        }

        
		return cadastrado;
	}
	
	


	public boolean remover(Funcionario funcionario) throws FuncionarioException {
		boolean removido = false;
		if(funcionario != null)
		{
			if(funcionarios.contains(funcionario))
			{
				funcionarios.remove(funcionario);
				removido = true;
			}
			else
			{
				FuncionarioException removerfuncionario =  new FuncionarioException("Funcionario não existe no repositorio");
				throw removerfuncionario;
			}
		}
		
		return removido;
}


	public boolean atualizar(Funcionario funcionario) throws FuncionarioException {
		boolean atualizado = false;
		boolean resul =  false;
		if(funcionario != null)
		{
			for (Funcionario f : funcionarios) 
			{
				if(f.getCpf().equals(funcionario.getCpf()))
				{
					funcionarios.remove(f);
					resul = true;
				}
			}
			
			if(resul == true)
			{
				funcionarios.add(funcionario);
				atualizado = true;
			}
			else
			{
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
				if(f.getCpf().equals(funcionario.getCpf()))
				{
					resul = f;
				}
			}
			
			
			if(resul == null)
			{
				FuncionarioException buscarfuncionario = new FuncionarioException("Funcionario n existe no repositorio");
				throw buscarfuncionario;
			}
		}
		
		return resul;
	}
	
	

	
	
}
