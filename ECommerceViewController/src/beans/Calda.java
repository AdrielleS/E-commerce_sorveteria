package beans;

public enum Calda {
	CHOCOLATE(1),
	DOCE_DE_lEITE(2.5),
	MORANGO(1),
	LIMAO(2),
	LEITE_CONDENSADO(2.5),
        SEMCALDA(0);
	
	public double valorCalda;
	Calda(double valor) {
		this.valorCalda = valor;
	}
	public double getValor() {
		return this.valorCalda;
	}

}
