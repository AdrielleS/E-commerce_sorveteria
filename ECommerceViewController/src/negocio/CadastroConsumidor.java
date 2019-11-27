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
        if (this.eNumero(consumidor.getCpf())) {
			this.repConsumidor.cadastrar(consumidor);
			this.repConsumidor.salvarArquivo();
		}
    }

	public List<Consumidor> listar() {
		return repConsumidor.listar();
	}

	public void atualizar(Consumidor consumidor) throws ConsumidorException {
		repConsumidor.atualizar(consumidor);
		this.repConsumidor.salvarArquivo();
	}

	public Consumidor buscar(String cpf) throws ConsumidorException {
		return repConsumidor.buscar(cpf);
	}
	
	private boolean eNumero(String s) {
		boolean r;
	
		if(s.contains("^[a-Z]")) {
			r = false;
		}else{
			r =true;
		}
		return r;
		
	}
    
}
