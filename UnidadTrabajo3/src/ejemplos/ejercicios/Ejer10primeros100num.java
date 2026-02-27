package ejemplos.ejercicios;


public class Ejer10primeros100num {

	public static void main(String[] args) {
		// Declaración de variables
		int conta, suma = 0;
		// Condicional
		for (conta = 1; conta <= 100; conta++) {
			suma += conta;
		}
		System.out.println("La suma de los 100 primeros enteros es: "+suma);

	}

}
