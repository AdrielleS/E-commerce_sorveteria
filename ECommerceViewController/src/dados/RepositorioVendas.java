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

import beans.Consumidor;
import beans.Venda;
import dados.IRepositorioVendas;
import exceptions.VendaException;

public class RepositorioVendas implements IRepositorioVendas ,Serializable{

	private static final long serialVersionUID = -441651136385215292L;
	private List<Venda> vendas;
	public static RepositorioVendas instance;
	
	private  RepositorioVendas() {
		vendas = new ArrayList<Venda>();
	}
	
	public static RepositorioVendas getInstance() {
		if (instance == null) {
			instance = RepositorioVendas.lerArquivo();
		}
		return instance;
	}

	@Override
	public void cadastrar(Venda v) {
		v.setDataVenda(LocalDate.now());
		vendas.add(v);
		
		
	}

	@Override
	public boolean remover(Venda v) {
		boolean removido = false;
		if(v !=null) {
			vendas.remove(v);
			removido = true;
		}
		return removido;
	}

	@Override
	public List<Venda> listarPorData(LocalDate d) {
		List<Venda> lista = new ArrayList<Venda>();
		for(Venda v: vendas) {
			if(v.getDataVenda().equals(d)) {
				lista.add(v);
			}
		}
		
		return lista;
	}

	@Override
	public List<Venda> listarTodasVendas() {
		return this.vendas;
	}
	
	@Override
	public List<Venda> listarPorConsumidor (Consumidor c) {
		List<Venda> lista = new ArrayList<Venda>();
		for(Venda v: vendas) {
			if(v.getPedido().getConsumidor().equals(c)) {
				lista.add(v);
			}
		}
		return lista;
	}
	
	@Override
	public void cancelarVenda(Venda v) {
		for(Venda ve: vendas) {
			if(ve.getPedido().getId() == v.getPedido().getId()) {
				ve.getPedido().setStatus("CANCELADO!");
			}
		}
		
	}
	
	private static RepositorioVendas lerArquivo() {
		RepositorioVendas instanciaLocal =  null;
		File f = new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqVendas.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	   
	    try{
	    	
	    	fis = new FileInputStream(f);
	 	    ois = new ObjectInputStream(fis);
	 	    Object o = ois.readObject();
	 	    instanciaLocal = (RepositorioVendas) o;
	 	    
	      }
	      catch(Exception e){
	    	  
	        
	    	  instanciaLocal = new RepositorioVendas();
	        
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
	public void salvar() {
		if(instance == null){
			return;
		}
		     
		File f = new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqVendas.dat");
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
