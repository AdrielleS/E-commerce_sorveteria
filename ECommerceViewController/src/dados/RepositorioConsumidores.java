package dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import beans.Consumidor;
import beans.Funcionario;
import beans.Zona;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;


public class RepositorioConsumidores implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1217645168917213127L;
	File file;
	ArrayList<Consumidor> consumidores;
	public static RepositorioConsumidores instance;
	
	public RepositorioConsumidores() {
		consumidores =  new ArrayList<Consumidor>();
	}
	
	
	public void listar()
	{
		if(!consumidores.isEmpty())
		{
			for (Consumidor consumidor : consumidores) {
				System.out.println(consumidor.getNome());
			}
		}
	}
	
	
	
	  public static RepositorioConsumidores getInstance() throws ClassNotFoundException, IOException {
		    if (instance == null) {
		      instance = lerArquivo();
		    }
		    return instance;
		  }
	
	
	public static RepositorioConsumidores lerArquivo() throws ClassNotFoundException, IOException
	{
		RepositorioConsumidores instancialocal =  null;
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	    fis = new FileInputStream(f);
	    ois = new ObjectInputStream(fis);
	    Object o = ois.readObject();
	    instancialocal = (RepositorioConsumidores) o;
	    ois.close();


	    return instancialocal;
	}
	
	
	
	public void salvarArquivo() throws IOException
	{

			File f =  new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.dat");
			FileOutputStream fos = null;
		    ObjectOutputStream oos = null;

		    fos = new FileOutputStream(f);
		    oos = new ObjectOutputStream(fos);
		    oos.writeObject(instance);
		    oos.close(); 
		
		
	}
	
	
	
	
	public boolean cadastrar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			String endereco, Zona zona) throws ConsumidorException {
		boolean cadastrado =false;
		boolean resul = false;
        Consumidor consumidor = new Consumidor(nome, email, dataNascimento, senha, cpf, endereco, zona);
		
        if(consumidores.isEmpty())
        {
        	consumidores.add(consumidor);
        	cadastrado = true;
        }
        else
        {
        	for (Consumidor c : consumidores) {
				if(c.getCpf().equals(consumidor.getCpf()))
				{
					resul = true;
				}
			}
            
            if(resul == false)
            {
            	consumidores.add(consumidor);
            	cadastrado = true;
            }
            else
            {
            	ConsumidorException cadastroconsumidor =  new ConsumidorException("Consumidor não pode ser cadastrado");
            	throw cadastroconsumidor;
            }
        }

        
		return cadastrado;
	}
	
	
	
	public boolean remover(Consumidor consumidor) throws ConsumidorException {
		Consumidor consu = null;
		boolean removido = false;
		boolean resul = false;
		if(consumidor != null)
		{
			for (Consumidor c : consumidores)
			{
				if(c.getCpf().equals(consumidor.getCpf()))
				{
					resul = true;
					consu = c;
				}
			}
			
			if(resul == true)
			{
				consumidores.remove(consu);
				removido = true;
			}
			else
			{
				ConsumidorException removerconsumidor =  new ConsumidorException("Consumidor não existe no repositorio");
				throw removerconsumidor;
			}

		}


		return removido;
}
	
	
	public boolean atualizar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,String endereco, Zona zona) throws ConsumidorException {
		
		Consumidor consumidor = new Consumidor(nome, email, dataNascimento, senha, cpf, endereco, zona);
		boolean atualizado = false;
		boolean resul =  false;
		if(consumidor != null)
		{
			for (Consumidor c : consumidores) 
			{
				if(c.getCpf().equals(consumidor.getCpf()))
				{
					consumidores.remove(c);
					resul = true;
				}
			}
			
			if(resul == true)
			{
				consumidores.add(consumidor);
				atualizado = true;
			}
			else
			{
				ConsumidorException atualizarconsumidor = new ConsumidorException("Funcionario não existe no repositorio");
				throw atualizarconsumidor;
			}
		
		}
		
		
		return atualizado;
		
	}
	
	
	public Consumidor buscar(Consumidor consumidor) throws ConsumidorException {
		
		Consumidor resul = null;
		
		if(consumidor != null)
		{
			for (Consumidor c : consumidores)
			{
				if(c.getCpf().equals(consumidor.getCpf()))
				{
					resul = c;
				}
			}
			
			
			if(resul == null)
			{
				ConsumidorException buscarconsumidor= new ConsumidorException("Consumidor não existe no repositorio");
				throw buscarconsumidor;
			}
		}
		
		return resul;
	}
	

}
