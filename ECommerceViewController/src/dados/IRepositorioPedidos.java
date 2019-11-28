package dados;


import java.util.List;

import beans.Pedido;

public interface IRepositorioPedidos {
	
	List<String> listarTodosPedidos();
	
	void cadastrar(Pedido pedido);
	
	void remover(Pedido pedido);
	
	public void salvarArquivo();
	

}
