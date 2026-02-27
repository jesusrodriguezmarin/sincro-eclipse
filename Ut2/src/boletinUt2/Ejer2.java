package boletinUt2;

public class Ejer2 {

	// Declaración de la funcion (parámetros)
		/**
		 * Cálcula el total de segundos de una hora
		 * @param horas horas que queremos convertir a segundos
		 * @param minutos minutos que queremos convertir a segundos
		 * @param segundos segundos en una hora
		 * @return el total de segundos de una hora
		 */
		public static int totalSeg(int horas, int minutos, int segundos) {
			return 3600*horas+60*minutos+segundos;
		}
		
		// Programa principal declaracion de la Llamada de la función
		public static void main(String[] args) {
			int h, m, s;

			// Realizamos los cálculos y mostramos por consola
			h=10; m=15; s=50;
			System.out.println("Hora: "+h+":"+m+":"+s);
			System.out.println("Total segundos: "+totalSeg(h,m,s));
			
			
		}
	}
