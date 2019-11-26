package dados;

import java.time.LocalDate;
import java.util.List;

import beans.Consumidor;
import beans.Venda;


public interface IRepositorioVendas {
	void cadastrar(Venda v) ;
	
	boolean remover(Venda v);
	
	List<Venda> listarPorData(LocalDate d);
	
	List<Venda> listarTodasVendas();
	
	List<Venda> listarPorConsumidor(Consumidor c);
	
	void salvar();

}
