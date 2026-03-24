package ejercicios2;

public class Ejercicio4 {

	/**
	 * Funcion que muestra el total en segundos
	 * @param h un número entero que corresponde a horas
	 * @param m un número entero que corresponde a minutos
	 * @param s un número entero que corresponde a segundos
	 * @return un número tipo entero con el total de segundos
	 */
	public static int TotalSeg(int h, int m, int s) {
		return (h*3600+m*60+s);
	}
	
	public static void main(String[] args) {

		// Total de segundos para h=0, m=0, s=1
		int horas=2, minutos=3, segundos=20;
		System.out.println("El total en segundos de "+horas+" horas, "+minutos+" minutos y "+segundos+" segundos, es: "+TotalSeg(horas, minutos, segundos)+" segundos");
		// Total de segundos para h=1, m=10, s=5
		horas=1; minutos=10; segundos=5;
		System.out.println("El total en segundos de "+horas+" horas, "+minutos+" minutos y "+segundos+" segundos, es: "+TotalSeg(horas, minutos, segundos)+" segundos");
		// Total de segundos para h=2, m=3, s=30
		horas=2; minutos=3; segundos=30;
		System.out.println("El total en segundos de "+horas+" horas, "+minutos+" minutos y "+segundos+" segundos, es: "+TotalSeg(horas, minutos, segundos)+" segundos");
	}

}
