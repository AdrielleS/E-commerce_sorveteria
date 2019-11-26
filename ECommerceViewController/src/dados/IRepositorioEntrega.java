package dados;

import java.time.LocalDate;
import java.util.List;

import beans.Entrega;

public interface IRepositorioEntrega {
	void cadastrar(Entrega e);
	
	List<Entrega> listarTodasEntregas();
	
	List<Entrega> listarEntregasPorData(LocalDate d);
	
	List<Entrega> listarEntregasPorEntregador(String cpf);
	
	void salvar();

}
