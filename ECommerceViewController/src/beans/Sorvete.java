package beans;

import java.io.Serializable;

public class Sorvete implements Serializable{

	private static final long serialVersionUID = 1966429498693322976L;
	private SaborSorvete[] sabor;
	private Incremento adicionais;
	private  Calda calda;
	private int numeroBolas;
	
	public Sorvete(SaborSorvete[] sabor, Incremento adicionais, Calda calda, int numeroBolas) {
		this.setSabor(sabor); 
		this.adicionais = adicionais;
		this.calda = calda;
		this.numeroBolas = numeroBolas;
	}

	public SaborSorvete[] getSabor() {
		return sabor;
	}

	public void setSabor(SaborSorvete[] sabor) {
		if (sabor.length == this.numeroBolas) {
			this.sabor = sabor;
		}
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
	
	public String toString() {
		String s = "";
		for(int i =0; i < this.numeroBolas; i++) {
			s+= this.getSabor()[i].toString()+",";
		}
		s += this.adicionais.toString()+","+this.calda.toString();
		return s;
	}
	
	
	
	


	


	
	
	
	
}
