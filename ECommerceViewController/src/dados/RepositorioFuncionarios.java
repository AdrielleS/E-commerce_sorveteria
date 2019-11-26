package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import beans.Funcionario;
import dados.IRepositorioFuncionarios;
import exceptions.FuncionarioException;

public class RepositorioFuncionarios implements IRepositorioFuncionarios, Serializable{

	private static final long serialVersionUID = 1025911660485970999L;
	private List<Funcionario> funcionarios;
	private static RepositorioFuncionarios instance;

	private RepositorioFuncionarios() {
		funcionarios = new ArrayList<Funcionario>();		
	}
	

	@Override
	public List<Funcionario> listar(){
		return funcionarios;
         
	}
	
	
	
	public static RepositorioFuncionarios getInstance() {
		if (instance == null) {
			      instance = RepositorioFuncionarios.lerArquivo();
		 }
		 return instance;
	}
	
	
	private static RepositorioFuncionarios lerArquivo() {
		RepositorioFuncionarios instanciaLocal =  null;
		File f = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
   
	    try{
	    	
	    	fis = new FileInputStream(f);
	 	    ois = new ObjectInputStream(fis);
	 	    Object o = ois.readObject();
	 	    instanciaLocal = (RepositorioFuncionarios) o;
	 	    
	      }
	      catch(Exception e){
	    	  
	        
	    	  instanciaLocal = new RepositorioFuncionarios();
	        
	      }
	      finally{
	        if(ois!=null){
	            try{
	              ois.close();
	            }
	            catch(IOException e){
	              System.out.println("Não foi possível fechar o arquivo!");
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
		     
		File f =  new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqFuncionarios.dat");
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
	        	  System.out.println("Não foi possível fechar o arquivo.");
	        	  e.printStackTrace();
	          }
	        }
	    }
	}
	

	@Override
	public void cadastrar(Funcionario funcionario) throws FuncionarioException {
		boolean temEmail = false;
		
        if(funcionarios.isEmpty()){
        	funcionarios.add(funcionario);
        }else{
        	for(Funcionario f: funcionarios) {
        		if(f.getEmail().equals(funcionario.getEmail())) {
        			temEmail = true;
        		}
        		
        	}
            
            if(!temEmail){
            	funcionarios.add(funcionario);
            }else{
            	FuncionarioException cadastrofuncionario =  new FuncionarioException("CPF ou e-mail já cadastrado!");
            	throw cadastrofuncionario;
            }
        }
	}
	
	

	@Override
	public void remover(Funcionario funcionario) throws FuncionarioException {
		int i = this.retornarIndice(funcionario.getCpf());
		if(i != -1) {
			funcionarios.remove(funcionario);
		}else{
			FuncionarioException removerfuncionario =  new FuncionarioException("Funcionario nÃ£o encontrado");
			throw removerfuncionario;
		}



	}

	@Override
	public void atualizar(Funcionario funcionario) throws FuncionarioException {
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
				
				FuncionarioException atualizarfuncionario = new FuncionarioException("Funcionario nÃ£o encontrado!");
				throw atualizarfuncionario;
			}
		}
		
		
	}
	
	@Override
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

				FuncionarioException buscarfuncionario = new FuncionarioException("Funcionario nÃ£o encotrado!");
				throw buscarfuncionario;
			}
		}
		
		return resul;
	}
	
	private int retornarIndice(String cpf) {
		int indice =-1;
		for(int i =0; i< funcionarios.size(); i++) {
			if(funcionarios.get(i).getCpf().equals(cpf)) {
				System.out.println(funcionarios.get(i).getCpf()+"    "+cpf);
				indice = i;
			}
		}
		return indice;
		
	}

	
	
}
