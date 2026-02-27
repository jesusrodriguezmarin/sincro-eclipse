package ejemplos.fraccion;

public class FraccionTest01 {

	public static void main(String[] args) {
		// Creamos dos fracciones f1 sin parámetros y f2 con los parámetros (1, 4)
		Fraccion f1 = new Fraccion();		// 0/1
		Fraccion f2 = new Fraccion(1, 4);	// 1/4
		
		// Asignamos parámetros al númerador y al denominador son SETTERS
		f1.setNumerador(5);		// Asignamos 5 al numerador
		f1.setDenominador(8);	// Asignamos 8 al denominador
		
		// Mostramos por pantalla las fracciones como String con el método
		System.out.println("Primera fracción: "+f1.toString());
		System.out.println("Segunda fracción: "+f2.toString());
		
		// Sumamos las fracciones
		Fraccion suma;			// Declaramos suma
		suma = f1.sumar(f2);	// Inicializamos suma con el método		
		
		// Mostramos por pantalla con el método toString
		System.out.println(f1.toString()+" + "+f2.toString()+" = "+suma.toString());
		
		// Usamos método simplificar y mostramos
		suma.simplificar();		
		System.out.println(f1.toString()+" + "+f2.toString()+" = "+suma.toString());
		
		// Restamos las fracciones
		Fraccion resta;				// Declaramos resta
		resta = f1.restar(f2);		// Inicializamos resta con el método restar
		
		// Mostramos por pantalla el restultado con el método toString
		System.out.println(f1.toString()+" - "+f2.toString()+" = "+resta);
		
		// Simplificamos con el método simplificar
		resta.simplificar();
		
		// Mostramos por pantalla la resta simplificada SIN toString
		System.out.println(f1+" + "+f2+" = "+resta);
		
		// Multiplicamos las fracciones
		Fraccion multi = f1.multiplicar(f2);	// Declaración e inicialización
		
		// Mostramos por pantalla
		System.out.println(f1+" x "+f2+" = "+multi);
		
		// Simplificamos y mostramos
		multi.simplificar();
		System.out.println(f1+" x "+f2+" = "+multi);
		
		// Dividimos las fracciones
		Fraccion divi = f1.dividir(f2);
		
		// Mostramos por pantalla
		System.out.println(f1+" / "+f2+" = "+divi);
		divi.simplificar();	// Simplificamos
		
		// Mostramos por pantalla simplificada
		System.out.println(f1+" / "+f2+" = "+divi);
	}

}
