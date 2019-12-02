package negocio;

import java.util.List;

import beans.Pedido;
import dados.RepositorioPedidos;
import java.util.ArrayList;

public class CadastroPedido {
	private RepositorioPedidos repPedido;

	public CadastroPedido() {
		this.repPedido =  RepositorioPedidos.getInstance();
	}

	public List<Pedido> listarTodosPedidos() {
		return this.repPedido.listarTodosPedidos();
	}

	public void cadastrar(Pedido pedido) {
		 this.repPedido.cadastrar(pedido);
		 this.repPedido.salvarArquivo();
	}

	public void remover(Pedido pedido) {
		this.repPedido.remover(pedido);
		this.repPedido.salvarArquivo();
	}
        
        public void mudarStatus(String cpf){
            this.repPedido.mudarStatus(cpf);
            this.repPedido.salvarArquivo();
        }

        void entregaStatus(String cpf) {
            this.repPedido.statusEntrega(cpf);
            this.repPedido.salvarArquivo();
        }
        
        void entregueStatus(String cpf){
            this.repPedido.statusEntregue(cpf);
            this.repPedido.salvarArquivo();
        }
	
	

}
