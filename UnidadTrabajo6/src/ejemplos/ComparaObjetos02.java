package ejemplos;

public class ComparaObjetos02 {

	public static void main(String[] args) {
	
		// Creamos un String
		String cad1 = "PROGRAMACION";
		
		// Creamos un objeto
		String cad2 = new String("PROGRAMACION");
		
		// No son objetos iguales, no se pueden comparar con ==
		if (cad1==cad2) {
			System.out.println("[==] Son iguales");
		} else {
			System.out.println("[==] Son distintos");
		}
		
		// Si tienen el mismo contenido
		if (cad1.equals(cad2)) {
			System.out.println("[equals] Son iguales");
		} else {
			System.out.println("[equals] Son distintos");
		}

	}

}
