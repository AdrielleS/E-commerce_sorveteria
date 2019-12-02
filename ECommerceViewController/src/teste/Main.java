package teste;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import beans.Calda;
import beans.Consumidor;
import beans.Funcionario;
import beans.Incremento;
import beans.Pedido;
import beans.SaborSorvete;
import beans.Sorvete;
import beans.Zona;
import dados.RepositorioConsumidores;
import dados.RepositorioFuncionarios;
import dados.RepositorioPedidos;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;
import exceptions.PedidoException;

public class Main {

	public static void main(String[] args) throws IOException, FuncionarioException, ClassNotFoundException, ConsumidorException, PedidoException {
		
		/*classe de testes		
		
		RepositorioConsumidores repc =  new RepositorioConsumidores();
		
		Consumidor consumidor1 =  new Consumidor("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);

		Consumidor consumidor2 =  new Consumidor("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
		
		Consumidor consumidor3 =  new Consumidor("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.OESTE);
		
		System.out.println("CONSUMIDORES\n");
		
		repc.cadastrar("Sonael", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
		repc.cadastrar("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
		System.out.println("cadastrados:");
		repc.listar();


		//Desse jeito nao da erro, o cpf e o mesmo do consumidor1
//		System.out.println();
//		System.out.println("atualizar "+consumidor3.getNome());
//		System.out.println();
//		boolean atualizar = repc.atualizar("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		repc.listar();
		
		
		//error: se atualizar com o cpf do consumidor2 da erro
//		System.out.println();
//		System.out.println("atualizar "+consumidor3.getNome());
//		System.out.println();
//		boolean atualizar = repc.atualizar("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.OESTE);
//		repc.listar();
		
		
		
		
		
		System.out.println();
		System.out.println("remover "+ consumidor2.getNome());
		boolean resul = repc.remover(consumidor2);
		repc.listar();
		
		
		System.out.println("\n");
		System.out.println("Buscar por "+consumidor1.getNome());
		System.out.println(repc.buscar(consumidor1).getNome());
		
		
		//salvando instacia e arquivo
		RepositorioConsumidores.instance = repc;
		repc.salvarArquivo();
		
		//Recuperando inst�cia do arquivo
		RepositorioConsumidores repc2 =  RepositorioConsumidores.getInstance();
		
		//listando nomes da isntacia do arquivo
		System.out.println();
		System.out.println("inst�ncia do arquivo/nomes");
		repc2.listar();*/
		
//		Funcionario f1 = new Funcionario("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", LocalDate.of(2000, 6, 1), "entregador");
//		RepositorioFuncionarios rpf = new RepositorioFuncionarios();
//		System.out.println(rpf.cadastrar("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", LocalDate.of(2000, 6, 1), "entregador"));
//		System.out.println(rpf.atualizar("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", LocalDate.of(2000, 6, 1), "sorveteiro"));
//		System.out.println(rpf.buscar(f1));
		
		//teste repositorio pedidos
		RepositorioPedidos reppedidos =  new RepositorioPedidos();
		
		ArrayList<SaborSorvete> saboressorvetes =  new ArrayList<>();
		saboressorvetes.add(SaborSorvete.BAUNILHA);
		
		
		Sorvete sorvete1 =  new Sorvete(saboressorvetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		//Sorvete sorvete2 =  new Sorvete(saboressorevetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		//Sorvete sorvete3 =  new Sorvete(saboressorevetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		
		ArrayList<Sorvete> sorvetes =  new ArrayList<Sorvete>();
		
		sorvetes.add(sorvete1);
		//sorvetes.add(sorvete2);
		//sorvetes.add(sorvete3);
		
		Consumidor consumidor1 =  new Consumidor("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
		Consumidor consumidor2 =  new Consumidor("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
			
			
		//cadastrar pedidos
			
		Pedido pedido =  new Pedido(sorvetes, "imcompleto", consumidor1);
		Pedido pedido1 =  new Pedido(sorvetes, "Completo", consumidor1);
		Pedido pedido2 =  new Pedido(sorvetes, "Completo", consumidor1);
		Pedido pedido3 =  new Pedido(sorvetes, "Completo", consumidor1);
		
		
		reppedidos.cadastrar(pedido);
		reppedidos.cadastrar(pedido1);
		reppedidos.cadastrar(pedido2);
		
		System.out.println("Listando cadastros");
		//reppedidos.listar();
		

		
		//atualizar pedidos
		//reppedidos.atualizar(sorvetes, "imcompleto", consumidor2, 2);
		//System.out.println();
		//System.out.println("Atualizando cadastros");
		//reppedidos.listar();
		
		//System.out.println();
		//remover pedidos
		//System.out.println("Remover");
		//remover por id
//		reppedidos.remover(4);	
		//remover por objeto
		reppedidos.remover(pedido);
		//reppedidos.listar();
		
		
		
		System.out.println();
		System.out.println("Buscando cadastro");
		//buscar
		// ArrayList<Pedido> array = reppedidos.buscar("13123123123");
		 
		// for (Pedido p : array) {
		//	System.out.println(p.getConsumidor().getNome()+"      "+p.getConsumidor().getCpf()+"    "+p.getId());
		//}
		 
		 
		 //salvando instancia, Salvando instancia no arquivo e lendo instancia do arquivo
		 RepositorioPedidos.instance = reppedidos;
		 reppedidos.salvarArquivo();
		 
		 
		 RepositorioPedidos reppedidos2 =  RepositorioPedidos.getInstance();
		 
		 System.out.println();
		 System.out.println("Recuperando instacia do arquivo");

		// reppedidos2.listar();
		 
		 System.out.println();
		 System.out.println("Adicionando na instancia recuperada do arquivo");
		 reppedidos2.cadastrar(pedido3);
		// reppedidos2.listar();*/
		
//		
//		
		//teste repositorio funcionarios
//		Funcionario funcionario1 =  new Funcionario("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", LocalDate.of(2000, 6, 1), "entregador");
//		Funcionario funcionario2 =  new Funcionario("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", LocalDate.of(2000, 6, 1), "entregador");
//		Funcionario funcionario3 = new Funcionario("Sonael Neto", "SonaelNeto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", LocalDate.of(2000, 6, 1), "entregador");
//		
//		RepositorioFuncionarios repfuncionarios =  new RepositorioFuncionarios();
//		
//		repfuncionarios.cadastrar(funcionario1);
//		repfuncionarios.cadastrar(funcionario2);
//		
//		repfuncionarios.listar();
//		
//		
//		System.out.println();
//		
//		repfuncionarios.atualizar("Sonael Neto", "SonaelNeto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", LocalDate.of(2000, 6, 1), "entregador");
//		
//		repfuncionarios.remover(funcionario1);
//		
//		
//		repfuncionarios.listar();
		
		
		//teste repositorio consumidores
//		Consumidor consumidor1 =  new Consumidor("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		Consumidor consumidor2 =  new Consumidor("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
//		Consumidor consumidor3 =  new Consumidor("SonaelNeto", "SonaelNeto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		
//		
//		RepositorioConsumidores repconsumidores =  new RepositorioConsumidores();
//		
//		repconsumidores.cadastrar(consumidor1);
//		repconsumidores.cadastrar(consumidor2);
//		
//		
//		repconsumidores.listar();
//		
//		
//		System.out.println();
//		
//		repconsumidores.remover(consumidor2);
//		
//		repconsumidores.listar();
//		
//		System.out.println();
//		
//		repconsumidores.atualizar("SonaelNeto", "SonaelNeto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		
//		repconsumidores.listar();
//		
//		
//		RepositorioConsumidores.instance = repconsumidores;
//		
//		RepositorioConsumidores repconConsumidores2 = RepositorioConsumidores.getInstance();
//		
//		System.out.println();
//		
//		repconConsumidores2.listar();
		

		
		
		
		
		
		
		

		
	}

}
