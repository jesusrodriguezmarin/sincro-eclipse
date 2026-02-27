package hojaEjercícios;

public class Ej13Intercambio {

	public static void main(String[] args) {

		// Declaración e inicialización
		int a, b;
		a=5;
		b=10;
		System.out.println("Primero a vale: "+a);
		System.out.println("Primero b vale "+b);
		
		// Declaro una auxiliar aux para guardar un valor temporal
		int aux;
		
		// Realizo el intercambio de valores
		aux=a;
		a=b;
		b=aux;
		
		// Resultado del intercambio impreso en pantalla
		
		System.out.println("Ahora a vale: "+a);
		System.out.println("Ahora b vale: "+b);


		
	}

}
