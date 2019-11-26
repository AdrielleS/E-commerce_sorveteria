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
import exceptions.FuncionarioException;
import exceptions.PedidoException;

public class RepositorioPedidos implements Serializable {

	private static final long serialVersionUID = -8268941967102544914L;
	File file;
	ArrayList<Pedido> pedidos;
	public static RepositorioPedidos instance;
	
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
		
		
		
	
	public boolean cadastrar(Pedido pedido) throws IOException, PedidoException {

		boolean cadastrado =false;
		if(pedido != null)
		{
			if(!pedidos.contains(pedido)) 
			{
				pedidos.add(pedido);
				cadastrado =  true;
			}
			else
			{
				PedidoException cadastrarPedido =  new PedidoException("Pedido não pode ser cadastrado");
				throw cadastrarPedido;
			}
		}

		
        
		return cadastrado;
	}
	
	
	public ArrayList<Pedido> buscar(String cpf) throws PedidoException {
		ArrayList<Pedido> buscarpedidos =  new ArrayList<Pedido>();
		if(cpf != null)
		{
			for (Pedido pedido : pedidos) {
				if(pedido.getConsumidor().getCpf().equals(cpf))
				{
					buscarpedidos.add(pedido);
				}
			}
				
			if(buscarpedidos.isEmpty())
			{
				PedidoException buscarpedido = new PedidoException("Pedido não existe no repositorio");
				throw buscarpedido;
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
	
	
	public boolean remover(int id) throws PedidoException {
		boolean removido = false;
		Pedido resul = null;
		for (Pedido pedido2 : pedidos) {
			if(pedido2.getId() == id)
			{
				resul = pedido2;
				
			}
		}

		if(resul == null)
		{
			PedidoException removerPedido =  new PedidoException("Pedido não existe no repositorio");
			throw removerPedido;
		}
		else 
		{
			pedidos.remove(resul);
			removido = true;
			
		}



		return removido;
	}
	
	
	public boolean remover(Pedido pedido) throws PedidoException
	{
		boolean removido =  false;
		if(pedido != null)
		{
			if(pedidos.contains(pedido))
			{
				pedidos.remove(pedido);
				removido = true;
			}
			else
			{
				PedidoException removerPedido = new PedidoException("Pedido não existe no repositorio");
				throw removerPedido;
			}
		}
		
		return removido;
	}
	
	
	public boolean atualizar(List<Sorvete> sorvete, String status, Consumidor consumidor, int id) throws IOException, PedidoException {
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
				PedidoException atualizarPedido = new PedidoException("Pedido não existe no repositorio");
				throw atualizarPedido;
			}
		}
		
		
		return atualizado;
		
	}
		
	
	

}
