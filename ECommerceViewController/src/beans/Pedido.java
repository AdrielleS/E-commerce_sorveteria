package beans;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 545384808876977854L;
	private List<Sorvete> sorvetes;
	private String status;
	private Consumidor consumidor;
	private double preco;
	private int id;
	private static int cont;

	
	
	public Pedido(List<Sorvete> sorvete, String status, Consumidor consumidor) {
		super();
		cont+=1;
		this.sorvetes = sorvete;
		this.status = status;
		this.consumidor = consumidor;
		this.id = cont;
	}
	
	public Pedido(List<Sorvete> sorvete, String status, Consumidor consumidor,int id) {
		super();
		this.sorvetes = sorvete;
		this.status = status;
		this.consumidor = consumidor;
		this.id = id;
	}


	public List<Sorvete> getSorvetes() {
		return sorvetes;
	}

	public void setSorvetes(List<Sorvete> sorvetes) {
		this.sorvetes = sorvetes;
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
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	

	public double getPreco() {
		return preco;
	}

	public void setPreco() {
		this.preco =0;
		for (Sorvete s: sorvetes) {
			for(int i = 0; i < s.getNumeroBolas(); i++) {
				this.preco += s.getSabor()[i].getValor();
			}
			this.preco += s.getAdicionais().getValor()+ s.getCalda().getValor();
		}
	}

	public String toString() {
		String s = "";
		s+=this.consumidor.getCpf()+",";
		for(Sorvete so: sorvetes) {
			s+=so.toString()+",";
		}
		s+= this.status+"," +this.getPreco();
		return s;
	}

}
