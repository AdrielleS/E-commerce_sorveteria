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
import java.util.List;

import beans.Entrega;

public class RepositorioEntregas implements IRepositorioEntrega, Serializable {
	
	private static final long serialVersionUID = 6388339813502649421L;
	private List<Entrega> entregas;
	private static RepositorioEntregas instance;
	

	private RepositorioEntregas() {
		entregas = new ArrayList<Entrega>();
	}
	
	public static RepositorioEntregas getInstance() {
		if (instance == null) {
			      instance = RepositorioEntregas.lerArquivo();
		 }
		return instance;
	}

	@Override
	public void cadastrar(Entrega e) {
		if(e !=null) {
			entregas.add(e);
		}

	}

	@Override
	public List<Entrega> listarTodasEntregas() {
		return entregas;
	}

	@Override
	public List<Entrega> listarEntregasPorData(LocalDate d) {
		List<Entrega> lista = new ArrayList<Entrega>();
		for(Entrega e: entregas) {
			if(e.getDataEntrega().equals(d)) {
				lista.add(e);
			}
		}
		
		return lista;
	}

	@Override
	public List<Entrega> listarEntregasPorEntregador(String cpf) {
		List<Entrega> lista = new ArrayList<Entrega>();
		for(Entrega e: entregas) {
			if(e.getEntregador().getCpf().equals(cpf)) {
				lista.add(e);
			}
		}
		
		return lista;
	}

	private static RepositorioEntregas lerArquivo() {
		RepositorioEntregas instanciaLocal =  null;
		File f = new File("baseDados" + File.separatorChar+"entregas"+  File.separatorChar+"arqEntregas.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
   
	    try{
	    	
	    	fis = new FileInputStream(f);
	 	    ois = new ObjectInputStream(fis);
	 	    Object o = ois.readObject();
	 	    instanciaLocal = (RepositorioEntregas) o;
	 	    
	      }
	      catch(Exception e){
	    	  
	        
	    	  instanciaLocal = new RepositorioEntregas();
	        
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
	public void salvar(){
		if(instance == null){
			return;
		}
		     
		File f = new File("baseDados" + File.separatorChar+"entregas"+  File.separatorChar+"arqEntregas.dat");
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

}
