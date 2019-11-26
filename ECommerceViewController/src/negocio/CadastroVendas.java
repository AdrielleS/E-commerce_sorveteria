package negocio;

import java.time.LocalDate;
import java.util.List;

import beans.Consumidor;
import beans.Pedido;
import beans.Venda;
import dados.RepositorioVendas;
import exceptions.VendaException;

public class CadastroVendas {
	private RepositorioVendas repV;

	public CadastroVendas() {
		this.repV = RepositorioVendas.getInstance();
	}
	
	
	

	public void cadastrar(Pedido pedido, String modoPag) throws VendaException  {
		
		Venda v = new Venda(pedido, modoPag);
		if (v  != null) {
			
			this.repV.cadastrar(v);
			this.repV.salvar();
		}
		else{
			
			VendaException venE = new VendaException("Não foi possível realizar a venda!");
			throw venE; 
		}
		
	}

	public boolean remover(Venda v) {
		return repV.remover(v);
	}

	public void salvar() {
		repV.salvar();
	}

	public List<Venda> listarPorData(LocalDate d) {
		return repV.listarPorData(d);
	}

	public List<Venda> listarTodasVendas() {
		return repV.listarTodasVendas();
	}

	public List<Venda> listarPorConsumidor(Consumidor c) {
		return repV.listarPorConsumidor(c);
	}
	
	

}
