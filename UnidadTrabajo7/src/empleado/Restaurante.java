package empleado;

public class Restaurante {

	public static void main(String[] args) {
		
		// Creamos instancias
		Camarero c = new Camarero("Rebeca Torres", 20, 200.00);
		Camarero c1 = new Camarero("Juan Toledo", 30, 150.00);
		Cocinero z = new Cocinero("Elena Arzak", 20, 5);
		Cocinero z1 = new Cocinero("Juan Roca", 40, 10);
		
		
		System.out.println("CAMARERO/A");
		System.out.println(c.toString());


		
		System.out.println("\nCAMARERO/A");

		System.out.println(c1.toString());

	
		
		System.out.println("\nCOCINERO/A");

		System.out.println(z.toString());


		
		System.out.println("\nCOCINERO/A");

		System.out.println(z1.toString());
	

	
		
		
	}

}
