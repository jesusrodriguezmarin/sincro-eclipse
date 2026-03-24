package ejemplos.apuntes.condicionales;

public class NumeroLetras_v2 {

	/**
	 * Función para aleatorio entre 1 y N
	 * @param N - número entero
	 * @return un número entero aleatorio
	 */
	public static int aleatorio(int N) {
		return (int)(Math.random()*N+1);
	}
	
	// Programa principal
	public static void main(String[] args) {
		// Declaración e inicialización dentro del switch
		switch(aleatorio(20)) {
		case 1:
		case 2:
		case 3:
		case 4: System.out.print("Menor que 5"); break;
		case 5: System.out.print("Cinco"); break;
		case 6: System.out.print("Seis"); break;
		case 7: System.out.print("Siete"); break;
		case 8: System.out.print("Ocho"); break;
		case 9: System.out.print("Nueve"); break;
		case 10: System.out.print("Diez"); break;
		default: System.out.print("Mayor que 10");
		}

	}

}
