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

	
	
	public Pedido(List<Sorvete> sorvete, String status, Consumidor consumidor) {
		this.sorvetes = sorvete;
		this.status = status;
		this.consumidor = consumidor;
                this.calcularPreco();
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

	private void calcularPreco() {
		this.preco =0;
		for (Sorvete s: sorvetes) {
                    for (SaborSorvete sabor : s.getSabor()) {
                        preco+=sabor.getValor();
                    }
                    this.preco += s.getAdicionais().getValor()+ s.getCalda().getValor();			
		}
	}
        
        public void mudarStatus(){
            
        }

	public String toString() {
		
		return this.consumidor.getCpf()+"\t"+this.sorvetes.get(0).getSabor()+"    "+ this.sorvetes.get(0).getNumeroBolas()+"  "+ this.sorvetes.get(0).getCalda()+"\t"+ this.sorvetes.get(0).getAdicionais() +"\t"+this.status+"\t"+this.consumidor.getEndereco();
		
	}

}
