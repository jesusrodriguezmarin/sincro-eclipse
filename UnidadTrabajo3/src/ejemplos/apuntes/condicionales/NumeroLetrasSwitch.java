package ejemplos.apuntes.condicionales;

public class NumeroLetrasSwitch {

	/**
	 * Función para aleatorio
	 * @param N - número entero
	 * @return un número aleatorio entre 1 y N
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaración e inicialización del número aleatorio
		int num = aleatorio(10);
		System.out.println(num);
		
		// Mostramos el número por pantalla escrito en letras
		switch(num) {
		case 1: System.out.print("Uno"); break;
		case 2: System.out.print("Dos"); break;
		case 3: System.out.print("Tres"); break;
		case 4: System.out.print("Cuatro"); break;
		case 5: System.out.print("Cinco"); break;
		case 6: System.out.print("Seis"); break;
		case 7: System.out.print("Siete"); break;
		case 8: System.out.print("Ocho"); break;
		case 9: System.out.print("Nueve"); break;
		case 10: System.out.print("Diez"); break;
		}

	}

}
