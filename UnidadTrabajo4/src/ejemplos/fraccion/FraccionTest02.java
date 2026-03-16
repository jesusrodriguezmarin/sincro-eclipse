package ejemplos.fraccion;

public class FraccionTest02 {

	public static void main(String[] args) {
		// Creamos tres fracciones
		Fraccion x = new Fraccion(1, 2);
		Fraccion y = new Fraccion(3, 4);
		Fraccion z = new Fraccion(2, 3);
		
		// Mostramos por pantalla las fracciones con el método toSring
		System.out.println("x = "+x.toString());
		System.out.println("y = "+y.toString());
		System.out.println("z = "+z.toString());
		
		// Realizamos la operación (x+y)*z
		Fraccion operacion = z.multiplicar(x.sumar(y));
		
		// Mostramos
		System.out.println("(x+y)*z = "+operacion);
		
		// Simplificamos y mostramos
		operacion.simplificar();
		System.out.println("(x+y)*z = "+operacion);
		
		// Realizamos la operación x+(y*z)
		operacion = x.sumar(y.multiplicar(z));
		
		// Mostramos
		System.out.println("x+(y*z) = "+operacion);
		
		// Simplificamos y mostramos
		operacion.simplificar();
		System.out.println("x+(y*z) = "+operacion);
	}

}
