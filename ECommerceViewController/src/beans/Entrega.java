package beans;

import java.time.LocalDate;
import java.util.List;

public class Entrega {
	private List<Venda> vendas;
	private LocalDate dataEntrega;
	
	
	public Entrega(List<Venda> vendas, LocalDate dataEntrega) {
		this.vendas = vendas;
		this.dataEntrega = dataEntrega;

	}

	public List<Venda> getVendas() {
		return vendas;
	}




	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}




	public LocalDate getDataEntrega() {
		return dataEntrega;
	}




	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}




	public String toString() {
		String s = "";
		for(Venda v: vendas) {
			s+=v.toString()+",";
		}
		s+=this.dataEntrega.toString();
		return s;
	}
	
	
}
