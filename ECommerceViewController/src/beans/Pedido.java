package beans;

public class Pedido {
	/*
	 * List<Item> itens; List<Incrementos> incrementos;
	 */
	private Sorvete sorvete;
	private String status;
	private Consumidor consumidor;
	private double preco;
	
	
	public Pedido(Sorvete sorvete, String status, Consumidor consumidor) {
		super();
		this.sorvete = sorvete;
		this.status = status;
		this.consumidor = consumidor;
	}

	public Sorvete getSorvete() {
		return sorvete;
	}

	public void setSorvete(Sorvete sorvete) {
		this.sorvete = sorvete;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor consumidor) {
		this.consumidor = consumidor;
	}

	

}
