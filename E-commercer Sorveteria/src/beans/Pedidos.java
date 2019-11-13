package beans;

public class Pedidos {
	private Sorvete sorvete;
	private String status;
	private Consumidor consumidor;
	
	public Pedidos(Sorvete sorvete, String status, Consumidor consumidor) {
		super();
		this.sorvete = sorvete;
		this.status = status;
		this.consumidor = consumidor;
	}

	
	public double precoFinal()
	{
		
		//à implementar
		return 0;
		
	}
}
