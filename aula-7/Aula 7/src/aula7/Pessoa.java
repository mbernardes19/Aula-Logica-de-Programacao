package aula7;

public class Pessoa {
	public String nome;
	public int idade;
	public double altura;
	public double peso;
	public String CPF;
	public double velocidade = 0;
	
	public void andar() {
		velocidade = velocidade + 5;
	}
	
	public void correr() {
		velocidade = velocidade + 10;
	}
	
	public boolean isMaiorDeIdade() {
		if (idade >= 18) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double valorIMC() {
		return peso/(altura*altura);
	}
	
	public String IMC() {
		if(valorIMC() > 40) {
			return "Obesidade grau 3";
		}
		if(valorIMC() > 35 && valorIMC() < 39.9) {
			return "Obesidade grau 2";
		}
		if(valorIMC() > 30 && valorIMC() < 34.9) {
			return "Obesidade grau 1";
		}
		if(valorIMC() > 25 && valorIMC() < 29.9) {
			return "Sobrepreso";
		}
		if(valorIMC() > 18.5 && valorIMC() < 24.9){
			return "Peso normal";
		}
		if(valorIMC() < 18.5) {
			return "Abaixo do peso";
		}
		return "Valor inválido";
	}
	
	
	

}
