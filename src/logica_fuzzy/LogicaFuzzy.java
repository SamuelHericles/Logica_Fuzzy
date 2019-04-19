package logica_fuzzy;

import java.util.Scanner;

public class LogicaFuzzy {
	public static void main(String[] args) {

		System.out.print("Quantidade de freio>>> ");
		Double pressaoFreio = Double.parseDouble(entradaDeValor().nextLine());

		System.out.print("Quantidade de velocidade nas rodas>>> ");
		Double velocidadeRoda = Double.parseDouble(entradaDeValor().nextLine());

		System.out.print("Quantidade de velocidade do carro>>> ");
		Double velocidadeCarro = Double.parseDouble(entradaDeValor().nextLine());

		TheLogica a = new TheLogica(pressaoFreio, velocidadeCarro,velocidadeRoda);
		a.toString();
	}

	private static Scanner entradaDeValor() {
		return new Scanner(System.in);
	}
}
