package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Venda implements Serializable{

	private static final long serialVersionUID = -8634188873103876178L;
	private double frete;
	private double valorTotalPedido;
	private Pedido pedido;
	private String modoPagamento;
	private LocalDate dataVenda;
	
	private static final String DEBITO ="debito";
	private static final String CREDITO ="credito";
	private static final String DINHEIRO ="dinheiro";
		
	public Venda(Pedido pedido, String modoPag) {
		this.pedido = pedido;
		this.setModoPagamento(modoPag);
                setFrete();
                setValorTotalPedido();
	}
	
	public Venda(Pedido pedido)
	{
		this.pedido = pedido;
	}
	
		
	public double getFrete() {
		return frete;
	}
	public void setFrete() {
		this.frete = pedido.getConsumidor().getZona().getValor();
	}
	public double getValorTotalPedido() {
		return valorTotalPedido;
	}
	public void setValorTotalPedido() {
		this.valorTotalPedido = pedido.getPreco() + this.frete;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getModoPagamento() {
		return modoPagamento;
	}

	public void setModoPagamento(String modoPagamento) {
		if (modoPagamento != null) {
			if (modoPagamento.equals(DEBITO) || modoPagamento.equals(CREDITO)
					|| modoPagamento.equals(DINHEIRO)) {
				this.modoPagamento = modoPagamento;
			}
		}
	}
	
	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String toString() {
		String s = this.pedido.toString()+","+this.frete+","+this.valorTotalPedido+ ","
				+this.modoPagamento+","+ this.dataVenda.toString() ;
		return s;
	}

	
	
	
	
	
}
