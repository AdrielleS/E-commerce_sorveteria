package beans;

import java.time.LocalDate;
import java.util.List;

public class Entrega {
	private List<Venda> vendas;
	private LocalDate dataEntrega;
	private Funcionario entregador;
	
	
	public Entrega(List<Venda> vendas, LocalDate dataEntrega, Funcionario entregador) {
		this.vendas = vendas;
		this.dataEntrega = dataEntrega;
		this.setEntregador(entregador);

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
	
	public Funcionario getEntregador() {
		return entregador;
	}

	public void setEntregador(Funcionario entregador) {
		if (entregador.getTipoFuncionario().equalsIgnoreCase("entregador")) {
			this.entregador = entregador;
		}
	}

	public String toString() {
		String s = "";
		for(Venda v: vendas) {
			s+=v.toString()+",";
		}
		s+=this.dataEntrega.toString()+","+entregador.getCpf()+","+entregador.getNome();
		return s;
	}
	
	
}
