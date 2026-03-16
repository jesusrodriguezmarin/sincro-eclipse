package ejemplos2;

public class ConstantesCirc {

	public static void main(String[] args) {
		
		// Declaramos e inicializamos los datos que necesitamos
		int radio=3;
		final double PI=3.141592;
		
		// Calculamos la longitud de una circunferencia
		double longitud;
		longitud=2*PI*radio;
		
		// Calculamos el area de un circulo
		double area;
		area=PI*radio*radio;
		
		System.out.println("La longitud de una circunferencia de radio "+radio+" es : "+longitud);
        System.out.println("El area de un circulo de radio "+radio+" es : "+area);

		
	}

}
