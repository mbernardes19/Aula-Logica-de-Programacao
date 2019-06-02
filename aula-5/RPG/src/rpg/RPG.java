package rpg;

import java.util.Random;
import java.util.Scanner;

public class RPG {
	static Scanner scan = new Scanner(System.in);
	static String nomeJogador;
	static String classeJogador;
	static int maxHPJogador;
	static int hpJogador;
	static int manaJogador;
	static int maxManaJogador;
	static int danoJogador;
	static int xp;
	static int hpInimigo;
	static int danoInimigo;
    static int level;
    static boolean lutando = false;
    
    public static void ataqueInimigo() {
    	if(rolarDadoD6() > 2) {
    		System.out.println("Inimigo acertou!");
    		hpJogador = hpJogador - danoInimigo;
    		if(hpJogador <= 0) {
    			gameOver();
    			System.exit(0);
    		}
    	}
    }
    
    public static void gameOver() {
    	System.out.println(nomeJogador + " morreu!");
    	System.out.println("===== GAME OVER! =====");
    	System.exit(0);
    	return;
    }
    
    public static void fim() {
    	if(level == 6) {
    		System.out.println("GANHOU!");
    		System.out.println("Feito por: Matheus Bernardes");
    	}
    }
    
    public static void checarLevelUp() {
    	if(xp >= 50 && level == 5) {
    		System.out.println("\nLevel 6!");
    		level = level + 1;
    		maxHPJogador = maxHPJogador + 30;
    		hpJogador = maxHPJogador;
    		if(classeJogador.equals("Mago")) {
    			maxManaJogador = maxManaJogador + 7;
    			manaJogador = maxManaJogador;
    		}
    		danoJogador = danoJogador + 3;
    	}
    	if(xp >= 40 && level == 4) {
    		System.out.println("\nLevel 5!");
    		level = level + 1;
    		maxHPJogador = maxHPJogador + 25;
    		hpJogador = maxHPJogador;
    		if(classeJogador.equals("Mago")) {
    			maxManaJogador = maxManaJogador + 7;
    			manaJogador = maxManaJogador;
    		}
    		danoJogador = danoJogador + 3;
    		imprimirStatusJogador();
    	}
    	if(xp >= 30 && level == 3) {
    		System.out.println("\nLevel 4!");
    		level = level + 1;
    		maxHPJogador = maxHPJogador + 20;
    		hpJogador = maxHPJogador;
    		if(classeJogador.equals("Mago")) {
    			maxManaJogador = maxManaJogador + 7;
    			manaJogador = maxManaJogador;
    		}
    		danoJogador = danoJogador + 2;
    		imprimirStatusJogador();
    	}
    	if(xp >= 20 && level == 2) {
    		System.out.println("\nLevel 3!");
    		level = level + 1;
    		maxHPJogador = maxHPJogador + 10;
    		hpJogador = maxHPJogador;
    		if(classeJogador.equals("Mago")) {
    			maxManaJogador = maxManaJogador + 7;
    			manaJogador = maxManaJogador;
    		}
    		danoJogador = danoJogador + 2;
    		imprimirStatusJogador();
    	}
    	if(xp >= 10 && level == 1) {
    		System.out.println("\nLevel 2!");
    		level = level + 1;
    		maxHPJogador = maxHPJogador + 5;
    		hpJogador = maxHPJogador;
    		if(classeJogador.equals("Mago")) {
    			maxManaJogador = maxManaJogador + 7;
    			manaJogador = maxManaJogador;
    		}
    		danoJogador = danoJogador + 1;
    		imprimirStatusJogador();
    	}
    }
    
    public static int rolarDadoD6() {
    	Random rand = new Random();
    	int n = rand.nextInt(7);
    	while(n == 0) {
    		n = rand.nextInt(7);
    	}
    	return n;
    }
    
    public static int rolarDadoD10() {
    	Random rand = new Random();
    	int n = rand.nextInt(11);
    	while(n == 0) {
    		n = rand.nextInt(11);
    	}
    	return n;
    }
    
    public static int rolarDadoD20() {
    	Random rand = new Random();
    	int n = rand.nextInt(21);
    	while(n == 0) {
    		n = rand.nextInt(11);
    	}
    	return n;
    }
    
    public static boolean atacar() {
    	if(rolarDadoD6() > 2) {
    		System.out.println("Acertou!");
    		hpInimigo = hpInimigo - danoJogador;
    		if(hpInimigo <= 0) {
    			System.out.println("Você venceu!");
    			return false;
    		}
    	} else {
    		System.out.println("Você errou!");
    	}
    	return true;
    }
    
    public static void criarInimigo() {
    	switch(level) {
    	case 1:
    		hpInimigo = 9;
    		danoInimigo = 1;
    		break;
    	case 2:
    		hpInimigo = 19;
    		danoInimigo = 4;
    		break;
    	case 3:
    		hpInimigo = 24;
    		danoInimigo = 6;
    		break;
    	case 4:
    		hpInimigo = 32;
    		danoInimigo = 7;
    		break;
    	case 5:
    		hpInimigo = 40;
    		danoInimigo = 9;
    		break;
    	}
    }

	public static void lutar() {
		String acao;
		String acaoFeitico = null;
		System.out.println("\nUm inimigo selvagem se aproxima");
		criarInimigo();
		lutando = true;
		
		while(lutando = true) {
			System.out.println("\nPressione 'a' para atacar\nPressione 'i' para ver informações");
			if(classeJogador.equals("Mago")) {
				System.out.println("Pressione 'f' para feitiços");
			}
			acao = scan.next();
			if(acao.charAt(0) == 'i') {
				imprimirStatusJogador();
				imprimirStatusInimigo();
				
			}
			if(acao.charAt(0) == 'f') {
				System.out.println("Pressione 'b' para bola de fogo\nPressione 'c' para cura\n");
				acaoFeitico = scan.next();
				if(acaoFeitico.charAt(0) == 'b') {
					if(rolarDadoD10() > 2) {
						manaJogador = manaJogador - 10;
						if(manaJogador < 0) {
							System.out.println("Você não tem mana suficiente...");
							manaJogador = manaJogador + 10;
						} else {
							int k = rolarDadoD10();
							System.out.println("Você acertou " + k + " de dano!");
							hpInimigo = hpInimigo - k;
							if(hpInimigo <= 0) {
								System.out.println("\nVocê venceu!");
								switch(level) {
								case 1:
									xp = xp + 4;
									break;
								case 2:
									xp = xp + 6;
									break;
								case 3:
									xp = xp + 9;
									break;
								case 4:
									xp = xp + 12;
									break;
								}
								System.out.println("Você adquiriu: " + xp + " xp");
								checarLevelUp();
								return;
							}
							ataqueInimigo();
						}
					} else {
						System.out.println("Você errou!");
						ataqueInimigo();
					}
					
				} else if (acaoFeitico.charAt(0) == 'c') {
					manaJogador = manaJogador - 8;
					if(manaJogador < 0) {
						System.out.println("Você não tem mana suficiente...");
						manaJogador = manaJogador + 8;
					} else {
						int x = rolarDadoD10();
						System.out.println("Você curou suas doenças...");
						System.out.println("+ " + x + " hp");
						hpJogador = hpJogador + x;
						if(hpJogador > maxHPJogador) {
							hpJogador = maxHPJogador;
						}
						ataqueInimigo();
					}
				}
			} 
			if(acao.charAt(0) == 'a') {
				lutando = atacar();
				if(lutando == false) {
					switch(level) {
					case 1:
						xp = xp + 4;
						break;
					case 2:
						xp = xp + 6;
						break;
					case 3:
						xp = xp + 9;
						break;
					case 4:
						xp = xp + 12;
						break;
					}
					System.out.println("Você ganhou: " + xp + " xp");
					checarLevelUp();
					return;
				}
				ataqueInimigo();
			}
		}
	}
	
	public static void imprimirStatusInimigo() {
		System.out.println("\n==== STATUS DO INIMIGO ====");
		System.out.println(
				"HP: " + hpInimigo +
				"\nDano: " + danoInimigo
				);
	}
	
	public static void imprimirStatusJogador() {
		System.out.println("\n==== STATUS DO JOGADOR ====");
		if(classeJogador.equals("Mago")) {
			System.out.println(
					nomeJogador +
					"\nClasse: " + classeJogador +
					"\nHP: " + hpJogador +
					"\nMana: " + manaJogador +
					"\nDano: " + danoJogador +
					"\nLevel:" + level +
					"\nXP: " + xp
			);
		} else {
			System.out.println(
					nomeJogador +
					"\nClasse: " + classeJogador +
					"\nHP: " + hpJogador +
					"\nDano: " + danoJogador +
					"\nLevel: " + level +
					"\nXP: " + xp
			);
		}
	}
	
	public static void criarGuerreiro() {
		classeJogador = "Guerreiro";
		maxHPJogador = 20;
		hpJogador = 20;
		danoJogador = 4;
		xp = 0;
		level = 1;
	}
	public static void criarMago() {
		classeJogador = "Mago";
		maxHPJogador = 10;
		hpJogador = 10;
		manaJogador = 20;
		maxManaJogador = 20;
		danoJogador = 2;
		xp = 0;
		level = 1;
	}
	public static void criarArqueiro() {
		classeJogador = "Arqueiro";
		maxHPJogador = 14;
		hpJogador = 14;
		danoJogador = 6;
		xp = 0;
		level = 1;
	}
	
	public static void main(String[] args) {
		System.out.println(
				"______ ______  _____                               \r\n" + 
				"| ___ \\| ___ \\|  __ \\                              \r\n" + 
				"| |_/ /| |_/ /| |  \\/ ____  __ _  _   _  _ __ ___  \r\n" + 
				"|    / |  __/ | | __ |_  / / _` || | | || '_ ` _ \\ \r\n" + 
				"| |\\ \\ | |    | |_\\ \\ / / | (_| || |_| || | | | | |\r\n" + 
				"\\_| \\_|\\_|     \\____//___| \\__,_| \\__,_||_| |_| |_|\r\n" + 
				"                                                   \r\n" + 
				"feito por Matheus Bernardes\n\n                                                 ");
		System.out.println("Qual é o seu nome?");
		nomeJogador = scan.next();
		System.out.println("\nEscolha uma classe:");
		System.out.println("G - Guerreiro \t M - Mago \t A - Arqueiro");
		classeJogador = scan.next();
		
		while(classeJogador.charAt(0) != 'G' && classeJogador.charAt(0) != 'g' && classeJogador.charAt(0) != 'M' && classeJogador.charAt(0) != 'm'
				&& classeJogador.charAt(0) != 'A' && classeJogador.charAt(0) != 'a') {
			
			System.out.println("G - Guerreiro \t M - Mago \t A - Arqueiro");
			classeJogador = scan.next();
		}
		
		if(classeJogador.charAt(0) == 'G' || classeJogador.charAt(0) == 'g') {
			criarGuerreiro();
		}
		if(classeJogador.charAt(0) == 'M' || classeJogador.charAt(0) == 'm') {
			criarMago();
		}
		if(classeJogador.charAt(0) == 'A' || classeJogador.charAt(0) == 'a') {
			criarArqueiro();
		}
		
		imprimirStatusJogador();
		
		while(level == 1) {
			lutar();
		}
		System.out.println("\nEssa área está limpa... Hora de seguir\n");
		while(level == 2) {
			lutar();
		}
		System.out.println("\nEssa área está limpa... Hora de seguir\n");
		while(level == 3) {
			lutar();
		}
		System.out.println("\nEssa área está limpa... Hora de seguir\n");
		while(level == 4) {
			lutar();
		}
		System.out.println("\nEssa área está limpa... Hora de seguir\n");
		while(level == 5) {
			lutar();
		}
		fim();
	}
}
