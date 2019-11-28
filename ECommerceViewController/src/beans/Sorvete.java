package beans;

import java.io.Serializable;
import java.util.ArrayList;

public class Sorvete implements Serializable{

	private static final long serialVersionUID = 1966429498693322976L;
	private ArrayList<SaborSorvete> sabor;
	private Incremento adicionais;
	private  Calda calda;
	private int numeroBolas;
	
	public Sorvete(ArrayList<SaborSorvete> sabor, Incremento adicionais, Calda calda, int numeroBolas) {
		this.sabor = sabor;
		this.adicionais = adicionais;
		this.calda = calda;
		this.numeroBolas = numeroBolas;
	}

	public ArrayList<SaborSorvete> getSabor() {
		return sabor;
	}

	public void setSabor(ArrayList<SaborSorvete> sabor) {
	
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
