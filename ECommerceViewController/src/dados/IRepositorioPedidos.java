package dados;


import java.util.List;

import beans.Pedido;

public interface IRepositorioPedidos {
	
	List<Pedido> listarTodosPedidos();
	
	boolean cadastrar(Pedido pedido);
	
	boolean remover(Pedido pedido);
	
	public void salvarArquivo();
	

}
