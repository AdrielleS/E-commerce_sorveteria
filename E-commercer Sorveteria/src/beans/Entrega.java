package beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Entrega {
	private LocalDate dataEntrega;
	private LocalDateTime horaEntrega;
	
	public Entrega(LocalDate dataEntrega, LocalDateTime horaEntrega) {
		this.dataEntrega = dataEntrega;
		this.horaEntrega = horaEntrega;
	}
	
	
	
}
