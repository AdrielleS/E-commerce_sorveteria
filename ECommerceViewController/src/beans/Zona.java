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
        
        public Zona tipoZona(String zona){
            Zona escolha = null;
            if (zona.equals("NORTE")) {
               escolha = Zona.NORTE;
            }
            if (zona.equals("SUL")) {
                escolha = Zona.SUL;
            }
            if (zona.equals("LESTE")) {
                escolha = Zona.LESTE;
            }
            if (zona.equals("OESTE")) {
                escolha = Zona.OESTE;
            }
            return escolha;
        }

}
