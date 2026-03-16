package ejercicios2;

public class Ejercicio8A {

	public static void main(String[] args) {
		
		int radio=5;
		final double PI=3.1416;
		
		// Cálculo y muestra por pantalla de la longitud de una circunferencia
		double longitud;
		longitud=2*PI*radio;
		
		// Cálculo y muestra por pantalla del área de un círculo
		double area;
		area=PI*radio*radio;
		
		System.out.println("La longitud de un círculo con radio "+radio+" es: "+longitud);
		System.out.println("El área de una círcunferencia con radio "+radio+" es: "+area);
	}

}
