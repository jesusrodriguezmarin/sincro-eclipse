package recuperaciones.arrays.ejercicios2;

public class Ej7 {

	public static void main(String[] args) {

		// Creamos array de enteros
		int[] a = {-4, 3, -5, 6, -3, 9, 0, 5, -7, 9};
		
		// Variables contadoras
		int negativo = 0;
		int positivo = 0;
		int cero = 0;
		
		double sumap = 0;
		double suman = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				negativo++;
				suman += a[i];
			} else if (a[i] > 0) {
				positivo++;
				sumap += a[i];
			} else if (a[i] == 0) {
				cero++;
			}
		}
		System.out.println("En el array hay: "+negativo+" negativos");
		System.out.println("En el array hay: "+positivo+" positivos");
		System.out.println("En el array hay: "+cero+" ceros");
		
		if (negativo != 0)
			System.out.println("La media de los negativos es: "+(suman/negativo));
		else
			System.out.println("No has introducido números negativos.");
		
		if (positivo != 0)
			System.out.println("La media de los positivos es: "+(sumap/positivo));
		else 
			System.out.println("No has introducido números positivos.");
		
	}

}
