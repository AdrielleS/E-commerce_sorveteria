package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import beans.Consumidor;
import beans.Zona;
import exceptions.ConsumidorException;


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
        Consumidor consumidor = new Consumidor(nome, email, dataNascimento, senha, cpf, endereco, zona);
		
        if(consumidores.isEmpty()){
        	consumidores.add(consumidor);
        	cadastrado = true;
        }else {
        	Consumidor tem = this.buscar(consumidor);
            
            if(tem == null){
            	consumidores.add(consumidor);
            	cadastrado = true;
            }else{
            	ConsumidorException cadastroconsumidor =  new ConsumidorException("Consumidor não pode ser cadastrado");
            	throw cadastroconsumidor;
            }
        }

        
		return cadastrado;
	}
	
	
	
	public boolean remover(Consumidor consumidor) throws ConsumidorException {
		Consumidor consu = this.buscar(consumidor);
		boolean removido = false;
		if(consu != null){
			consumidores.remove(consu);
			removido = true;
		}else {
			ConsumidorException removerconsumidor =  new ConsumidorException("Consumidor não existe no repositorio");
			throw removerconsumidor;
		}


		return removido;
	}
		
	
	
	public boolean atualizar(String nome, String email, LocalDate dataNascimento, 
			String senha, String cpf,String endereco, Zona zona) throws ConsumidorException {
		Consumidor consumidor = new Consumidor(nome, email, dataNascimento, senha, cpf, endereco, zona);
		boolean atualizado = false;
		if(consumidor != null){
			for (int i =0; i< consumidores.size(); i++) {
				int u = this.retornarIndice(consumidores.get(i).getCpf());
				if(u!= -1)
				{
					
					consumidores.set(u, consumidor);
					atualizado = true;
				
				}
			}if(atualizado == false){
				ConsumidorException atualizarconsumidor = new ConsumidorException("Funcionario não existe no repositorio");
				throw atualizarconsumidor;
			}
		}
		
		
		return atualizado;
		
	}
	
	
	public Consumidor buscar(Consumidor consumidor) throws ConsumidorException {
		Consumidor resul = null;
		if(consumidor != null){
			for (Consumidor c : consumidores)
			{
				int i = this.retornarIndice(c.getCpf());
				if(i!=-1){
					resul = c;
				}
			}
			
			if(resul == null){
				ConsumidorException buscarconsumidor= new ConsumidorException("Consumidor não existe no repositorio");
				throw buscarconsumidor;
			}
		}
		
		return resul;
	}
	private int retornarIndice(String cpf) {
		int indice =-1;
		for(int i =0; i< consumidores.size(); i++) {
			if(consumidores.get(i).getCpf().equals(cpf)) {
				indice = i;
			}
		}
		return indice;
		
	}
	

}
