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

public class Main {

	public static void main(String[] args) throws IOException, FuncionarioException, ClassNotFoundException, ConsumidorException {
		
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


		//Desse jeito não da erro, o cpf é o mesmo do consumidor1
//		System.out.println();
//		System.out.println("atualizar "+consumidor3.getNome());
//		System.out.println();
//		boolean atualizar = repc.atualizar("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		repc.listar();
		
		
		//error: se atualizar com o cpf do consumidor2 d� erro
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
		
		
		RepositorioPedidos reppedidos =  new RepositorioPedidos();
		
		SaborSorvete[] saboressorevetes =  new SaborSorvete[3];
		saboressorevetes[0] = SaborSorvete.BAUNILHA;
		saboressorevetes[1] = SaborSorvete.CHOCOLATE;
		saboressorevetes[2] = SaborSorvete.COCO;
		
		Sorvete sorvete1 =  new Sorvete(saboressorevetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		Sorvete sorvete2 =  new Sorvete(saboressorevetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		Sorvete sorvete3 =  new Sorvete(saboressorevetes, Incremento.AMEDOIM, Calda.CHOCOLATE, 3);
		
		ArrayList<Sorvete> sorvetes =  new ArrayList<Sorvete>();
		
		sorvetes.add(sorvete1);
		sorvetes.add(sorvete2);
		sorvetes.add(sorvete3);
		
		Consumidor consumidor1 =  new Consumidor("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
		Consumidor consumidor2 =  new Consumidor("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
		
		
		//cadastrar pedidos
		reppedidos.cadastrar(sorvetes, "imcompleto", consumidor1);
		reppedidos.cadastrar(sorvetes, "Completo", consumidor1);
		reppedidos.cadastrar(sorvetes, "Completo", consumidor1);
		
		
		Pedido pedido =  new Pedido(sorvetes, "imcompleto", consumidor1, 2);
		
		System.out.println("Listando cadastros");
		reppedidos.listar();
		
		//remover pedidos
//		reppedidos.remover(pedido);
//		System.out.println();
//		
//		reppedidos.listar();
		
		//atualizar pedidos
		reppedidos.atualizar(sorvetes, "imcompleto", consumidor2, 2);
		System.out.println();
		System.out.println("Atualizando cadastros");
		reppedidos.listar();
		
		
		
		System.out.println();
		System.out.println("Buscando cadastro");
		//buscar
		 ArrayList<Pedido> array = reppedidos.buscar(pedido);
		 
		 for (Pedido pedido2 : array) {
			System.out.println(pedido2.getConsumidor().getNome()+"      "+pedido2.getConsumidor().getCpf()+"    "+pedido2.getId());
		}
		 
		 
		 //salvando instancia, Salvando instancia no arquivo e lendo instancia do arquivo
		 RepositorioPedidos.instance = reppedidos;
		 reppedidos.salvarArquivo();
		 
		 
		 RepositorioPedidos reppedidos2 =  RepositorioPedidos.getInstance();
		 
		 System.out.println();
		 System.out.println("Recuperando instacia do arquivo");

		 reppedidos2.listar();
		

		
	}

}
