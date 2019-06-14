package aula7;

public class Principal {

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		
		pessoa.nome = "José";
		pessoa.idade = 15;
		pessoa.altura = 1.70;
		pessoa.peso = 80.0;
		pessoa.CPF = "12345678945";
		
		pessoa.andar();
		System.out.println(pessoa.velocidade);
		
		pessoa.correr();
		System.out.println(pessoa.velocidade);
		
		System.out.println(pessoa.isMaiorDeIdade());
		
		
		System.out.println(Math.round(pessoa.valorIMC()));
		
		System.out.println(pessoa.IMC());
		

	}

}
