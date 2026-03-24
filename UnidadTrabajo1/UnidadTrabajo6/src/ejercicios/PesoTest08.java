package ejercicios;

public class PesoTest08 {

	public static void main(String[] args) {
		
		// Creamos un objeto Peso08
		Peso08 p = new Peso08(10.00, "K");
		
		// Mostramos el dato
		System.out.println("Peso en kg: "+p.getKilos());
		System.out.println("Peso en Lb: "+p.getLibras());
		System.out.println("Peso en Li: "+p.getLingotes());
		System.out.println("Peso en Oz: "+p.getOnzas());
		System.out.println("Peso en g: "+p.getGramos());
		System.out.println("Peso en Q: "+p.getQuintales());
		System.out.println("Peso en P: "+p.getPeniques());
		System.out.println("Peso navaja suiza: "+p.getPeso("G"));
	}

}
