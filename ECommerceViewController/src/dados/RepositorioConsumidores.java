package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import beans.Consumidor;
import beans.Funcionario;
import dados.IRepositorioConsumidores;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;


public class RepositorioConsumidores implements IRepositorioConsumidores,Serializable {

	private static final long serialVersionUID = -1217645168917213127L;
	private List<Consumidor> consumidores;
	public static RepositorioConsumidores instance;
	
	private RepositorioConsumidores() {
		consumidores =  new ArrayList<Consumidor>();
	}
	
	
	@Override
	public List<Consumidor> listar()
	{
		return this.consumidores;
	}
	

	public static RepositorioConsumidores getInstance() {
		if (instance == null) {
			instance = RepositorioConsumidores.lerArquivo();
		}
		return instance;
	}
	private static RepositorioConsumidores lerArquivo() {
		RepositorioConsumidores instanciaLocal =  null;
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
  
	    try{
	    	
	    	fis = new FileInputStream(f);
	 	    ois = new ObjectInputStream(fis);
	 	    Object o = ois.readObject();
	 	    instanciaLocal = (RepositorioConsumidores) o;
	 	    
	      }
	      catch(Exception e){
	    	  
	        
	    	  instanciaLocal = new RepositorioConsumidores();
	        
	      }
	      finally{
	        if(ois!=null){
	            try{
	              ois.close();
	            }
	            catch(IOException e){
	              System.out.println("N„o foi possÌvel fechar o arquivo!");
	              e.printStackTrace();
	            }
	        }
	      }


	    return instanciaLocal;
	}
	
	@Override
	public void salvarArquivo(){
		if(instance == null){
			return;
		}
		     
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.dat");
	    FileOutputStream fos = null;
	    ObjectOutputStream oos = null;
	    try{
	    	 if(!f.exists()) {
	    		 f.createNewFile();
	    	 }
	    	 fos = new FileOutputStream(f);
			 oos = new ObjectOutputStream(fos);
			 
			 oos.writeObject(instance);   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally{
	        if(oos!=null){
	          
	          try{
	              oos.close();
	          }catch(IOException e){
	        	  System.out.println("N„o foi possÌvel fechar o arquivo.");
	        	  e.printStackTrace();
	          }
	        }
	    }

	}
	

	@Override    

	public void cadastrar(Consumidor consumidor) throws ConsumidorException {
		
		LocalDate hoje = LocalDate.now();
		
		Period periodo = Period.between(consumidor.getDataNascimento(), hoje);
		boolean idade = (periodo.getYears() >= 18) ? true : false;
		
		boolean temEmail = false;
		
		
        if(consumidores.isEmpty()){
        	consumidores.add(consumidor);
        }else{
        	for(Consumidor c: consumidores) {
        		if(c.getEmail().equals(consumidor.getEmail()) || c.getCpf().equals(consumidor.getCpf())) {
        			temEmail = true;
        		}
        		
        	}
            
            if(!temEmail  && idade){
            	consumidores.add(consumidor);
            }else{
				ConsumidorException cadastrarconsumidor = new ConsumidorException("Consumidor n„o encontrado!");

				throw cadastrarconsumidor;
            }
        }
 
	}
	
	
	@Override
	public void remover(Consumidor consumidor) throws ConsumidorException {
		int i = this.retornarIndice(consumidor.getCpf());
		if(consumidor != null && i !=-1 ){
			consumidores.remove(consumidor);
		}else {
			ConsumidorException removerconsumidor =  new ConsumidorException("Consumidor n√£o encontrado!");
			throw removerconsumidor;
		}
	}
		
	
	@Override
	public void atualizar(Consumidor consumidor) throws ConsumidorException {
		boolean atualizado = false;
		if(consumidor != null)
		{
			for (int i =0; i< consumidores.size(); i++) {
				int u = this.retornarIndice(consumidor.getCpf());
				if(u!= -1)
				{
					
					consumidores.set(u, consumidor);
					atualizado = true;
				
				}
			}if(atualizado == false){
				
				ConsumidorException atualizarconsumidor= new ConsumidorException("Consumidor n√£o encontrado!");
				throw atualizarconsumidor;
			}
		}
		
		
	}
	
	@Override
	public Consumidor buscar(String cpf) throws ConsumidorException {
		Consumidor resul = null;
		
		if(cpf != null)
		{
			for (Consumidor c : consumidores)
			{
				if(c.getCpf().equals(cpf))
				{
					resul = c;
				}
			}if(resul == null){

				ConsumidorException buscarconsumidor = new ConsumidorException("Consumidor n„o encotrado!");
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
