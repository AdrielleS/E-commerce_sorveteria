package negocio;

import beans.Consumidor;
import dados.RepositorioConsumidores;
import exceptions.ConsumidorException;
import java.io.IOException;
import java.util.List;

public class CadastroConsumidor {
    private  RepositorioConsumidores RepConsumidor;

        
    public CadastroConsumidor(){
        this.RepConsumidor = RepositorioConsumidores.getInstance();
    }
    
    public void cadastrar(Consumidor consumidor) throws ConsumidorException, IOException{
        this.RepConsumidor.cadastrar(consumidor);
        this.RepConsumidor.salvarArquivo();
    }

	public List<Consumidor> listar() {
		return RepConsumidor.listar();
	}

	public void atualizar(Consumidor consumidor) throws ConsumidorException {
		RepConsumidor.atualizar(consumidor);
		this.RepConsumidor.salvarArquivo();
	}

	public Consumidor buscar(Consumidor consumidor) throws ConsumidorException {
		return RepConsumidor.buscar(consumidor);
	}
    
}
