package ejemplos.formas;

public class FormasTest {

	public static void main(String[] args) {
		
		// Creamos un objeto rectángulo
		Rectangulo r = new Rectangulo(3,4);
		System.out.println("Area del rectángulo: "+r.area()); 
		
		// Creaos un objeto triángulo
		Triangulo t = new Triangulo(3,4);
		System.out.println("Area del triángulo: "+t.area());
	}

}
