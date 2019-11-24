package teste;

import java.io.IOException;
import java.time.LocalDate;

import beans.Consumidor;
import beans.Funcionario;
import beans.Zona;
import dados.RepositorioConsumidores;
import dados.RepositorioFuncionarios;
import exceptions.ConsumidorException;
import exceptions.FuncionarioException;

public class Main {

	public static void main(String[] args) throws IOException, FuncionarioException, ClassNotFoundException, ConsumidorException {
		
		//classe de testes		
		
		RepositorioConsumidores repc =  new RepositorioConsumidores();
		
		Consumidor consumidor1 =  new Consumidor("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);

		Consumidor consumidor2 =  new Consumidor("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
		
		Consumidor consumidor3 =  new Consumidor("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.OESTE);
		
		System.out.println("CONSUMIDORES\n");
		
		repc.cadastrar("Sonael", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
		repc.cadastrar("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "81982918921289", "xama no xesquedele", Zona.SUL);
		System.out.println("cadastrados:");
		repc.listar();


		//Desse jeito não dá erro, o cpf é o mesmo do consumidor1
//		System.out.println();
//		System.out.println("atualizar "+consumidor3.getNome());
//		System.out.println();
//		boolean atualizar = repc.atualizar("SonaelNeto", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "13123123123", "xama no xesquedele", Zona.OESTE);
//		repc.listar();
		
		
		//error: se atualizar com o cpf do consumidor2 dá erro
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
		
		//Recuperando instâcia do arquivo
		RepositorioConsumidores repc2 =  RepositorioConsumidores.getInstance();
		
		//listando nomes da isntacia do arquivo
		System.out.println();
		System.out.println("instância do arquivo/nomes");
		repc2.listar();
		
		
	}

}
