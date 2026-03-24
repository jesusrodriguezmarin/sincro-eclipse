package ejemplos.arrayFigura;

public class ArrayFiguraTest {

	public static void main(String[] args) {
		
		// Creamos un objeto generalizado figura e inicializamos a su especificación
		ArrayFigura f;
		
		f = new Circulo(10);
		System.out.println(f.area());
		
		f = new Cuadrado(10);
		System.out.println(f.area());
	}

}
