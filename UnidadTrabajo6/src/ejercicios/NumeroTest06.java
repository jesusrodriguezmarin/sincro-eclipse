package ejercicios;

public class NumeroTest06 {

	public static void main(String[] args) {
	
		// Creamos un objeto Numero sin parámetro inicializado a 0
		Numero06 n = new Numero06();
		
		// Creamos otro objeto Numero que se inicializa al parámetro
		Numero06 N = new Numero06(5);
		
		// Vemos el valor interno con getValor
		System.out.println(n.getValor());
		System.out.println(N.getValor());
		
		// Sumamos con suma
		n.suma(5);
		N.suma(5);
		System.out.println(n.getValor());
		System.out.println(N.getValor());
		
		// Restamos con resta
		n.resta(5);
		N.resta(10);
		System.out.println(n.getValor());
		System.out.println(N.getValor());
		
		// Mostramos el triple
		n.setNum(20);
		N.setNum(40);
		System.out.println(n.getTriple());
		System.out.println(N.getTriple());
		System.out.println(n.getValor());
		System.out.println(N.getValor());
		
		// Reinicializamos el dato con setNum
		n.setNum(0);
		N.setNum(0);
		System.out.println(n.getValor());
		System.out.println(N.getValor());

	}

}
