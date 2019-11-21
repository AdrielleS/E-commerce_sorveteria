package teste;

import java.io.IOException;
import java.time.LocalDate;

import beans.Funcionario;
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
		
		

	}

}
