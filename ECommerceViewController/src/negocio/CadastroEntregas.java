package negocio;

import java.time.LocalDate;
import java.util.List;

import beans.Entrega;
import dados.RepositorioEntregas;

public class CadastroEntregas {
	private  RepositorioEntregas repEntregas;

	public CadastroEntregas() {
		this.repEntregas = RepositorioEntregas.getInstance();
	}

	public void cadastrar(Entrega e) {
		repEntregas.cadastrar(e);
		repEntregas.salvar();
	}

	public List<Entrega> listarTodasEntregas() {
		return repEntregas.listarTodasEntregas();
	}

	public List<Entrega> listarEntregasPorData(LocalDate d) {
		return repEntregas.listarEntregasPorData(d);
	}

	public List<Entrega> listarEntregasPorEntregador(String cpf) {
		return repEntregas.listarEntregasPorEntregador(cpf);
	}
	
	

}
