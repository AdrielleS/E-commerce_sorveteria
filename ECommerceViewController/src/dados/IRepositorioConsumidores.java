package dados;

import java.util.List;

import beans.Consumidor;
import exceptions.ConsumidorException;

public interface IRepositorioConsumidores {
	List<Consumidor> listar();
	
	void salvarArquivo();
	
	boolean cadastrar( Consumidor consumidor) throws ConsumidorException;
	
	boolean remover(Consumidor consumidor) throws ConsumidorException;
	
	boolean atualizar( Consumidor consumidor) throws ConsumidorException;
	
	 Consumidor buscar(Consumidor consumidor) throws ConsumidorException;
	

}
