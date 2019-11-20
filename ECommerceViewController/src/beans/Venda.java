package beans;

public class Venda {
	private double frete;
	private double valorTotalPedido;
	private Pedido pedido;
	
	public Venda(Pedido pedido) {
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
	
	
	
}
