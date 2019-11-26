package negocio;

import java.util.List;

import beans.Pedido;
import dados.RepositorioPedidos;

public class CadastroPedido {
	private RepositorioPedidos repPedido;

	public CadastroPedido() {
		repPedido =  RepositorioPedidos.getInstance();
	}

	public List<Pedido> listarTodosPedidos() {
		return repPedido.listarTodosPedidos();
	}

	public void cadastrar(Pedido pedido) {
		 repPedido.cadastrar(pedido);
		 repPedido.salvarArquivo();
	}

	public void remover(Pedido pedido) {
		repPedido.remover(pedido);
		repPedido.salvarArquivo();
	}
	
	

}
