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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import beans.Consumidor;
import beans.Pedido;
import beans.Sorvete;
import exceptions.ConsumidorException;

public class RepositorioPedidos implements Serializable {

	private static final long serialVersionUID = -8268941967102544914L;
	File file;
	ArrayList<Pedido> pedidos;
	public static RepositorioPedidos instance;
	private static int cont;
	
	public RepositorioPedidos() {
		pedidos =  new ArrayList<Pedido>();
	}
	
	
	public void listar()
	{
		if(!pedidos.isEmpty())
		{
			for (Pedido pedido : pedidos) {
				System.out.println(pedido.getConsumidor().getNome()+"    "+ pedido.getConsumidor().getCpf()+"    "+pedido.getId());
			}
		}
	}
	
	
	  public static RepositorioPedidos getInstance() throws ClassNotFoundException, IOException {
		    if (instance == null) {
		      instance = lerArquivo();
		    }
		    return instance;
		  }
	  
	  
		public static RepositorioPedidos lerArquivo() throws ClassNotFoundException, IOException
		{
			RepositorioPedidos instancialocal =  null;
			File f = new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqPedidos.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    fis = new FileInputStream(f);
		    ois = new ObjectInputStream(fis);
		    Object o = ois.readObject();
		    instancialocal = (RepositorioPedidos) o;
		    ois.close();


		    return instancialocal;
		}
		
		
		
		public void salvarArquivo() throws IOException
		{

				File f =  new File("baseDados" + File.separatorChar+"pedido"+  File.separatorChar+"arqPedidos.dat");
				FileOutputStream fos = null;
			    ObjectOutputStream oos = null;

			    fos = new FileOutputStream(f);
			    oos = new ObjectOutputStream(fos);
			    oos.writeObject(instance);
			    oos.close(); 
		
		}
		
		
		
	
	public boolean cadastrar(List<Sorvete> sorvete, String status, Consumidor consumidor) throws IOException, ConsumidorException {
		cont +=1;
		Pedido pedido = new Pedido(sorvete, status, consumidor,cont);
		boolean cadastrado =false;
		if(pedido != null)
		{
			pedidos.add(pedido);
			cadastrado =  true;
		}
		


        
		return cadastrado;
	}
	
	
	public ArrayList<Pedido> buscar(Pedido pedido) throws ConsumidorException {
		ArrayList<Pedido> buscarpedidos =  new ArrayList<Pedido>();
		if(pedido != null)
		{
			buscarpedidos = this.retornarIndice(pedido.getConsumidor().getCpf());
				
				
			if(buscarpedidos.isEmpty())
			{
				ConsumidorException buscarconsumidor= new ConsumidorException("Consumidor não existe no repositorio");
				throw buscarconsumidor;
			}

			}
		
		
		return buscarpedidos;
	}
	
	
	private int retornarIndice(int id) {
		int indice =-1;
		for(int i =0; i< pedidos.size(); i++) {
			if(pedidos.get(i).getId() == id) {
				indice = i;
			}
		}
	
		return indice;
		
	}
	
	
	private ArrayList<Pedido> retornarIndice(String cpf) {
		ArrayList<Pedido> indicespedidos =  new ArrayList<Pedido>();
		for(int i =0; i< pedidos.size(); i++) {
			if(pedidos.get(i).getConsumidor().getCpf().equals(cpf)) {
				indicespedidos.add(pedidos.get(i));
			}
		}
		return indicespedidos;
		
	}
	
	
	
	
	public boolean remover(Pedido pedido) throws ConsumidorException {
		boolean removido = false;
		Pedido pedi = null;
		for (Pedido p : pedidos) {
			if(p.getId() == pedido.getId())
			{
				pedi = p;
			}
		}
		
		if(pedi != null)
		{
			pedidos.remove(pedi);
			removido = true;
		}
		else {
			ConsumidorException removerconsumidor =  new ConsumidorException("Consumidor não existe no repositorio");
			throw removerconsumidor;
		}


		return removido;
	}
	
	
	
	public boolean atualizar(List<Sorvete> sorvete, String status, Consumidor consumidor, int id) throws IOException, ConsumidorException {
		Pedido pedido = new Pedido(sorvete, status, consumidor, id);
		boolean atualizado = false;
		if(pedido != null){

			int u = this.retornarIndice(pedido.getId());
			if(u!= -1)
			{
					
				pedidos.set(u, pedido);
				atualizado = true;
			
			}
			if(atualizado == false){
				ConsumidorException atualizarconsumidor = new ConsumidorException("Funcionario não existe no repositorio");
				throw atualizarconsumidor;
			}
		}
		
		
		return atualizado;
		
	}
		
	
	

}
