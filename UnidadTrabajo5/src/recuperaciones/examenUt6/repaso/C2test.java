package recuperaciones.examenUt6.repaso;

public class C2test {

	public static void main(String[] args) {

		// Creamos objeto
		C cad = new C();
		
		cad.setCadena("Moco");
		System.out.println("La cadena es: "+cad.getCadena());
		System.out.println("Invertido: "+cad.invertido());
		System.out.println("La cadena es: "+cad.getCadena());
		System.out.println("Con *: "+cad.sust());
		
		System.out.println("La cadena es: "+cad.getCadena());
		System.out.println("Con espacios: ");
		System.out.println("La cadena es: "+cad.getCadena());


	}

}
