package beans;

public class Sorvete {
	private String sabor;
	private String nome;
	private double preco;
	
	
	public Sorvete(String sabor, String nome, double preco) {
		this.sabor = sabor;
		this.nome = nome;
		this.preco = preco;
	}


	public String getSabor() {
		return sabor;
	}


	public void setSabor(String sabor) {
		this.sabor = sabor;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
