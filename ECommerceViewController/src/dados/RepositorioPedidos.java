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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RepositorioPedidos implements IRepositorioPedidos,Serializable {

	private static final long serialVersionUID = -8268941967102544914L;
	private List<Pedido> pedidos;
	public static RepositorioPedidos instance;
	private static int cont;
        List<String> lista;
	
	public RepositorioPedidos() {
		pedidos =  new ArrayList<Pedido>();
	}
	
	
	public List<Pedido> listarTodosPedidos(){
            lista = new ArrayList<>();
		return pedidos;
	}
        
	public static RepositorioPedidos getInstance() {
		if (instance == null) {
			instance = RepositorioPedidos.lerArquivo();
		}
		return instance;
	}
        
        public void mudarStatus(String cpf){
            for (Pedido p : pedidos) {
                if (p.getConsumidor().getCpf().equals(cpf)) {
                    p.setStatus("Pedido pronto: " + getDateTime());
                }
            }
        }
        
        public void statusEntrega(String cpf){
            for (Pedido p : pedidos) {
                if(p.getConsumidor().getCpf().equals(cpf))
                    p.setStatus("Saiu para entrega: " + getDateTime());
            }
        }
        
        public void statusEntregue(String cpf){
            for (Pedido p : pedidos) {
                if (p.getConsumidor().getCpf().equals(cpf)) {
                    p.setStatus("ENTREGUE: " + getDateTime());
                }
            }
        }


	public void cadastrar(Pedido pedido) {
                pedidos.add(pedido);
	}
	
	public void remover(Pedido pedido) {
		boolean tem = false;
		for(Pedido p: pedidos) {
			if(p.getId() == pedido.getId()) {
				tem = true;
			}
		}
		if(tem) {
			pedidos.remove(pedido);
		}

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
	              System.out.println("Nao foi possivel fechar o arquivo!");
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
	        	  System.out.println("Nao foi possivel fechar o arquivo.");
	        	  e.printStackTrace();
	          }
	        }
	    }
	}
        
        private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
        Date date = new Date();
        return dateFormat.format(date);
}
		
	
	

}
