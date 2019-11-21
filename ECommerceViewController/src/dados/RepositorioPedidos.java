package dados;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import beans.Consumidor;
import beans.Pedido;
import beans.Sorvete;

public class RepositorioPedidos {
File file;
	
	public RepositorioPedidos() {
		file = new File("baseDados" + File.separatorChar+"arquivosPessoas"+  File.separatorChar+"arqConsumidores.txt");
	}
	
	public boolean cadastrar(List<Sorvete> sorvete, String status, Consumidor consumidor) throws IOException {
		Pedido p = new Pedido(sorvete, status, consumidor);
		boolean cadastrado =false;
		if(!file.exists()) {
			file.createNewFile();
		}
		
		if(p != null)
		{
			FileWriter w =  new FileWriter(file,true);
			BufferedWriter conexao = new BufferedWriter(w);
			conexao.write(p.toString()+"\n");
			conexao.close();
			cadastrado = true;
		
		}	
		return cadastrado;
	}
	

}
