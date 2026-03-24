package ejemplos.figura;

public class FiguraTest {

	public static void main(String[] args) {
		
		// Creamos un objeto de la subclase Cuadrado para el lado, con herencia de la superclase Figura para el color
		Cuadrado c = new Cuadrado(5);
		
		// Mostramos el lado
		System.out.println("El lado del cuadrado es: "+c.getLado());
		
		// Establecemos el color
		c.setColor("Verdoso");
		
		// Mostramos el color
		System.out.println("El color es: "+c.getColor());

	}

}
