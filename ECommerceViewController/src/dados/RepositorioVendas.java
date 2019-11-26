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

import beans.Consumidor;
import beans.Funcionario;
import beans.Pedido;
import beans.Sorvete;
import beans.Venda;
import exceptions.PedidoException;
import exceptions.VendaExeption;


public class RepositorioVendas implements Serializable{

	private static final long serialVersionUID = -441651136385215292L;
	ArrayList<Venda> vendas;
	File file;
	public static RepositorioVendas instance;
	
	public RepositorioVendas()
	{
		vendas =  new ArrayList<Venda>();
	}
	
	
	public void listar()
	{
		for (Venda venda : vendas)
		{
			
			System.out.println(venda.getPedido().getConsumidor().getNome()+"    "+venda.getPedido().getConsumidor().getCpf()+"    "+venda.getId());
		}
	}
	
	
	  public static RepositorioVendas getInstance() throws ClassNotFoundException, IOException {
		    if (instance == null) {
		      instance = lerArquivo();
		    }
		    return instance;
		  }
	  
	  
		public static RepositorioVendas lerArquivo() throws ClassNotFoundException, IOException
		{
			RepositorioVendas instancialocal =  null;
			File f = new File("baseDados" + File.separatorChar+"vendas"+  File.separatorChar+"arqVendas.dat");
		    FileInputStream fis = null;
		    ObjectInputStream ois = null;
		    fis = new FileInputStream(f);
		    ois = new ObjectInputStream(fis);
		    Object o = ois.readObject();
		    instancialocal = (RepositorioVendas) o;
		    ois.close();


		    return instancialocal;
		}
		
		public void salvarArquivo() throws IOException
		{

				File f =  new File("baseDados" + File.separatorChar+"vendas"+  File.separatorChar+"arqVendas.dat");
				FileOutputStream fos = null;
			    ObjectOutputStream oos = null;

			    fos = new FileOutputStream(f);
			    oos = new ObjectOutputStream(fos);
			    oos.writeObject(instance);
			    oos.close(); 
		
		}
		
		
		
		public boolean cadastrar(Venda venda) throws IOException, VendaExeption {

			boolean cadastrado =false;
			if(venda != null)
			{
				if(!vendas.contains(venda)) 
				{
					vendas.add(venda);
					cadastrado =  true;
				}
				else
				{
					VendaExeption cadastrarVenda =  new VendaExeption("Venda não pode ser cadastrado");
					throw cadastrarVenda;
				}
			}

			
	        
			return cadastrado;
		}
		
		public boolean remover(int id) throws VendaExeption {
			boolean removido = false;
			Venda resul = null;
			for (Venda venda2 : vendas) {
				if(venda2.getId() == id)
				{
					resul = venda2;
					
				}
			}

			if(resul == null)
			{
				VendaExeption removerVendaId =  new VendaExeption("Venda não existe no repositorio");
				throw removerVendaId;
			}
			else 
			{
				vendas.remove(resul);
				removido = true;
				
			}



			return removido;
		}
		
		
		public boolean remover(Venda venda) throws VendaExeption
		{
			boolean removido =  false;
			if(venda != null)
			{
				if(vendas.contains(venda))
				{
					vendas.remove(venda);
					removido = true;
				}
				else
				{
					VendaExeption removerVendaObj = new VendaExeption("Venda não existe no repositorio");
					throw removerVendaObj;
				}
			}
			
			return removido;
		}
		
		
		public boolean atualizar(Pedido pedido) throws IOException, VendaExeption {
			Venda venda =  new Venda(pedido);
			boolean atualizado = false;
			if(pedido != null){

				int u = this.retornarIndice(venda.getId());
				if(u!= -1)
				{
						
					vendas.set(u, venda);
					atualizado = true;
				
				}
				if(atualizado == false){
					VendaExeption atualizarVenda = new VendaExeption("Pedido não existe no repositorio");
					throw atualizarVenda;
				}
			}
			
			
			return atualizado;
			
		}
		
		
		private int retornarIndice(int id) {
			int indice =-1;
			for(int i =0; i< vendas.size(); i++) {
				if(vendas.get(i).getId() == id) {
					indice = i;
				}
			}
		
			return indice;
			
		}
	

}
