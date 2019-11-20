package beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Entrega {
	private List<Venda> vendas;
	private LocalDate dataEntrega;
	private LocalDateTime horaEntrega;
	
	
	public Entrega(LocalDate dataEntrega, LocalDateTime horaEntrega, List<Venda> vendas) {
		this.dataEntrega = dataEntrega;
		this.horaEntrega = horaEntrega;
		this.vendas = vendas;
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

	public LocalDateTime getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(LocalDateTime horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	
	
	
}
