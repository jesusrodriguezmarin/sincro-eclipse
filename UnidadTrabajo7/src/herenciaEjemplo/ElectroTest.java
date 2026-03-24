package herenciaEjemplo;

public class ElectroTest {

	public static void main(String[] args) {
		
		// Creamos un array padre, de electrodomésticos
		// más tarde lo especializaremos en lavadora y televisión
		Electrodomestico lista[] = new Electrodomestico[5];
		
		// Ahora llamamos con new a la especificación
		// Por jerarquía Electrodoméstico tiene dos hijos
		// Lavadora y televisión
		
		lista[0] = new Electrodomestico(200, 60, 'C', "Verde");
		lista[1] = new Lavadora(150, 30);
		lista[2] = new Television(500, 80, 'E', "negro", 65);
		lista[3] = new Electrodomestico();
		lista[4] = new Electrodomestico(250, 70);
		
		for (int i=0; i<lista.length; i++) {
			System.out.println(lista[i]);
		}

		// Para el precio final de todos los electrodomésticos
		double ptotal = 0;
		for (int i=0; i<lista.length; i++) {
			System.out.println(lista[i]);
			ptotal = lista[i].precioFinal();
		}
		
		System.out.println("\nEl precio total: "+ptotal);
	}

}
