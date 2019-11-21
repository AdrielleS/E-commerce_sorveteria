package beans;

public enum Incremento {
	PACOCA(1.5),
	GRANULADO(1),
	AMEDOIM(2),
	MeM(2.5);
	
	public double valorCalda;
	Incremento(double valor) {
		this.valorCalda = valor;
	}
	
	public double getValor() {
		return this.valorCalda;
	}
}
