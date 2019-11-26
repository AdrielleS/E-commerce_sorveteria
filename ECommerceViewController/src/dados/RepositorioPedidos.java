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


import beans.Pedido;
import dados.IRepositorioPedidos;
import exceptions.PedidoException;


public class RepositorioPedidos implements IRepositorioPedidos,Serializable {

	private static final long serialVersionUID = -8268941967102544914L;
	private List<Pedido> pedidos;
	private static RepositorioPedidos instance;
	private static int cont;
	
	private RepositorioPedidos() {
		pedidos =  new ArrayList<Pedido>();
	}
	
	
	public List<Pedido> listarTodosPedidos(){
		return this.pedidos;
	}
	
	
	public static RepositorioPedidos getInstance() {
		if (instance == null) {
			instance = RepositorioPedidos.lerArquivo();
		}
		return instance;
	}


	public boolean cadastrar(Pedido pedido) {
		boolean cadastrado = false;
		cont  = this.proximoId();
		if (cont >0) {
			pedido.setId(cont);
			pedidos.add(pedido);
			cadastrado = true;
		}
		return cadastrado;
	}
	
	public boolean remover(Pedido pedido) {
		boolean removido = false;
		boolean tem = false;
		for(Pedido p: pedidos) {
			if(p.getId() == pedido.getId()) {
				tem = true;
			}
		}
		if(tem) {
			pedidos.remove(pedido);
			removido = true;
		}

		return removido;
	}
	
	

	private int proximoId() {
		int id = 0 ;
		if(!this.pedidos.isEmpty()) {
			int i= this.pedidos.size()-1;
			id = this.pedidos.get(i).getId()+1;
		}
		
		return id;
	}
	
	private static RepositorioPedidos lerArquivo() {
		RepositorioPedidos instanciaLocal =  null;
		File f = new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqPedidos.dat");
	    FileInputStream fis = null;
	    ObjectInputStream ois = null;
	   
	    try{
	    	
	    	fis = new FileInputStream(f);
	 	    ois = new ObjectInputStream(fis);
	 	    Object o = ois.readObject();
	 	    instanciaLocal = (RepositorioPedidos) o;
	 	    
	      }
	      catch(Exception e){
	    	  
	        
	    	  instanciaLocal = new RepositorioPedidos();
	        
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
	
	public void salvarArquivo(){
		if(instance == null){
			return;
		}
		     
		File f = new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqPedidos.dat");
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
