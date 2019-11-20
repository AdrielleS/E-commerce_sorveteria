package beans;

public enum SaborSorvete {
	CHOCOLATE(2.0),
	BAUNILHA(2.0),
	MORANGO(2.0), 
	LIMAO(2.5),
	COCO(2.5),
	FLOCOS(3.0);
	public double valorCalda;
	SaborSorvete(double valor) {
		this.valorCalda = valor;
	}
	public double getValor() {
		return this.valorCalda;
	}
}
