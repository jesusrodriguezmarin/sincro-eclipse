package ejemplos1;

public class TotalSegundos2 {
	
	// Declaración de la funcion (parámetros)
	/**
	 * Cálcula el total de segundos de una hora
	 * @param horas horas que queremos convertir a segundos
	 * @param minutos minutos que queremos convertir a segundos
	 * @param segundos segundos en una hora
	 * @return el total de segundos de una hora
	 */
	public static int totalSeg(int horas, int minutos, int segundos) { // El parámetro (int num) aqui se declara se inicializa con el valor del argumento
		return 3600*horas+60*minutos+segundos;
	}
	
	// Programa principal declaracion de la Llamada de la función
	public static void main(String[] args) {
		int h, m, s;

		// Realizamos los cálculos y mostramos por consola
		h=0; m=0; s=1;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+totalSeg(h,m,s)+" segundos");
		
		h=1; m=5; s=55;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+totalSeg(h,m,s)+" segundos");
		
		h=3; m=15; s=21;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+totalSeg(h,m,s)+" segundos");
		
		h=0; m=59; s=59;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+totalSeg(h,m,s)+" segundos");	
	}

}
