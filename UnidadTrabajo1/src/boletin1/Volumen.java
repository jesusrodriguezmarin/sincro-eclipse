package boletin1;

public class Volumen {

	public static void main(String[] args) {

		// Declaración e inicialización
		int radio=3;
		int altura=5;
		final double PI=3.1416;
		double area;
		
		// Algorítmo
		area=PI*radio*radio*altura;
		
		// Resultado impreso en pantalla
		System.out.println("El área de un cilindro con radio: "+radio+" y altura: "+altura+" es: "+area+" metros cúbicos.");
		
		
	}

}
