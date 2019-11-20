package beans;

public class Sorvete {
	private SaborSorvete[] sabor;
	private Incremento adicionais;
	private  Calda calda;
	private int numeroBolas;
	
	public Sorvete(SaborSorvete[] sabor, Incremento adicionais, Calda calda, int numeroBolas) {
		this.sabor = sabor;
		this.adicionais = adicionais;
		this.calda = calda;
		this.numeroBolas = numeroBolas;
	}

	public SaborSorvete[] getSabor() {
		return sabor;
	}

	public void setSabor(SaborSorvete[] sabor) {
		this.sabor = sabor;
	}

	public Incremento getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(Incremento adicionais) {
		this.adicionais = adicionais;
	}

	public Calda getCalda() {
		return calda;
	}

	public void setCalda(Calda calda) {
		this.calda = calda;
	}

	public int getNumeroBolas() {
		return numeroBolas;
	}

	public void setNumeroBolas(int numeroBolas) {
		this.numeroBolas = numeroBolas;
	}
	
	
	
	


	


	
	
	
	
}
