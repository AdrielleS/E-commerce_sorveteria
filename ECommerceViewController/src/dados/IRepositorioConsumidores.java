package dados;

import java.util.List;

import beans.Consumidor;
import exceptions.ConsumidorException;

public interface IRepositorioConsumidores {
	List<Consumidor> listar();
	
	void salvarArquivo();
	
	void cadastrar( Consumidor consumidor) throws ConsumidorException;
	
	void remover(Consumidor consumidor) throws ConsumidorException;
	
	void atualizar( Consumidor consumidor) throws ConsumidorException;
	
	 Consumidor buscar(Consumidor consumidor) throws ConsumidorException;
	

}
