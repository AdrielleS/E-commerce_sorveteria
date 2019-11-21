package dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import beans.Consumidor;
import beans.Zona;


public class RepositorioConsumidores {
	File file;
	
	public RepositorioConsumidores() {
		file = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.txt");
	}
	
	public boolean cadastrar(String nome, String email, LocalDate dataNascimento, String senha, String cpf,
			String endereco, Zona zona) throws IOException {
		boolean cadastrado =false;
        Consumidor c = new Consumidor(nome, email, dataNascimento, senha, cpf, endereco, zona);
		boolean resul = false;
		if(!file.exists()) {
			file.createNewFile();
		}
		
		if(c != null)
		{
			Scanner scan =  new Scanner(file);
			while(scan.hasNext())
			{
				String linha =  scan.nextLine();
				if(linha.contains(c.getCpf()))
				{
					resul = true;
				}
			}
			
			
			if (!resul)
			{
				FileWriter w =  new FileWriter(file,true);
				BufferedWriter conexao = new BufferedWriter(w);
				conexao.write(c.toString()+"\n");
				conexao.close();
				cadastrado = true;
				
			}
			scan.close();
			
		}	
		return cadastrado;
	}
	

}
