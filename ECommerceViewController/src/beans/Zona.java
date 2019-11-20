package beans;

public enum Zona {
	NORTE(4.50),
	SUL(5),
	LESTE(6),
	OESTE(6.5);
	
	public double valorCalda;
	Zona(double valor) {
		this.valorCalda = valor;
	}
	public double getValor() {
		return this.valorCalda;
	}

}
