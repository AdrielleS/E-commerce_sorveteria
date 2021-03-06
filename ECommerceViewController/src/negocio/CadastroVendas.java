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
	
	
	public void cadastrar(Venda v) throws VendaException  {
		if (v  != null) {	
			this.repV.cadastrar(v);
			this.repV.salvar();
		}
	}
	
	
	
	public void cancelarVenda(Venda v) {
		repV.cancelarVenda(v);
	}

	public boolean remover(Venda v) {
		return repV.remover(v);
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
