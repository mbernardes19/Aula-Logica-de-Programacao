package aula7;

public class Pokemon {
	public String nome;
	public String[] tipos;
	public double velocidade;
	public double HP;
	public double dano;
	public String[] fraquezas;
	public String[] vantagens;
	
	public double atacar(String tipoAtaque) {
		if (tipos[0].equals(tipoAtaque)) {
			return dano*2;
		}
		else {
			return dano*1;
		}
	};
	
	public double defender(String tipoAtaque) {
		if(fraquezas[0].equals(tipoAtaque)) {
			HP = HP - 20;
		}
		else {
			HP = HP - 10;
		}
		return HP;
	}
	
	public void defineFraquezaEVantagem() {
		fraquezas = new String[1];
		vantagens = new String[1];
		
		for(int i = 0; i < tipos.length; i++) {
			switch(tipos[0]) {
				case "fogo":
					fraquezas[0] = "agua";
					vantagens[0] = "planta";
				case "agua":
					fraquezas[0] = "planta";
					vantagens[0] = "fogo";
				case "planta":
					fraquezas[0] = "fogo";
					vantagens[0] = "agua";
			}
		}
	}
}
