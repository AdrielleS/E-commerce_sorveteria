package negocio;

import beans.Consumidor;
import dados.RepositorioConsumidores;
import exceptions.ConsumidorException;
import java.io.IOException;
import java.util.List;

public class CadastroConsumidor {
    private  RepositorioConsumidores repConsumidor;

        
    public CadastroConsumidor(){
        this.repConsumidor = RepositorioConsumidores.getInstance();
    }
    
    public void cadastrar(Consumidor consumidor) throws ConsumidorException, IOException{
        this.repConsumidor.cadastrar(consumidor);
        this.repConsumidor.salvarArquivo();
    }

	public List<Consumidor> listar() {
		return repConsumidor.listar();
	}

	public void atualizar(Consumidor consumidor) throws ConsumidorException {
		repConsumidor.atualizar(consumidor);
		this.repConsumidor.salvarArquivo();
	}

	public Consumidor buscar(Consumidor consumidor) throws ConsumidorException {
		return repConsumidor.buscar(consumidor);
	}
    
}
