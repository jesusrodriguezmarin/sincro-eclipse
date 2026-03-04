package ejercicios;

public class MiNumeroTest03 {

	public static void main(String[] args) {
		
		// Creamos una instancia  para calcular doble, triple y cuadruple de números enteros
		MiNumero03 n = new MiNumero03(5);
		
		// Mostramos los cálculos
		System.out.println("Doble: "+n.doble());
		System.out.println("Triple: "+n.triple());
		System.out.println("Cuadruple: "+n.cuadruple());

	}

}
