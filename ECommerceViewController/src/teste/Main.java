package teste;

import java.io.IOException;
import java.time.LocalDate;

import beans.Funcionario;
import beans.Zona;
import dados.RepositorioConsumidores;
import dados.RepositorioFuncionarios;
import exceptions.FuncionarioException;

public class Main {

	public static void main(String[] args) throws IOException, FuncionarioException {
		
		//classe de testes
		
		Funcionario funcionario =  new Funcionario("Sonael", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231",
				LocalDate.of(2019, 8, 5), "ENTREGADOR");
		Funcionario funcionario2 =  new Funcionario("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "16231631632",
				LocalDate.of(2019, 8, 5), "ENTREGADOR");
		
		
		Funcionario funcionario3 =  new Funcionario("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231",
				LocalDate.of(2019, 8, 5), "ENTREGADOR");
		
		
		RepositorioFuncionarios rep =  new RepositorioFuncionarios();
		 boolean ok = rep.cadastrar("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231",
					LocalDate.of(2019, 8, 5), "ENTREGADOR");
		 boolean ok2 = rep.cadastrar("Maria", "Maria@gmail.com", LocalDate.of(2000, 6, 1), "1234", "16231631632",
					LocalDate.of(2019, 8, 5), "ENTREGADOR");
		 boolean ok3 = rep.cadastrar("Sonael", "Sonael@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231",
					LocalDate.of(2019, 8, 5), "ENTREGADOR");
		 System.out.println(ok3);
		 
		if (ok ) {
			System.out.println(rep.buscar(funcionario));
			System.out.println(rep.buscar(funcionario2));
		}
		System.out.println("fora");
		
		RepositorioConsumidores rpc = new RepositorioConsumidores();
		rpc.cadastrar("Sonael", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231", "rua bla", Zona.SUL);
		rpc.cadastrar("gU", "GUo@gmail.com", LocalDate.of(2000, 6, 1), "1234", "1231334455", "rua bla", Zona.NORTE);
		rpc.cadastrar("Sonael", "Sonaelneto@gmail.com", LocalDate.of(2000, 6, 1), "1234", "123131231", "rua bla", Zona.SUL);
		
		

	}

}
