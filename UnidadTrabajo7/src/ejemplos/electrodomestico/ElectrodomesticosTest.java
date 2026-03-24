package ejemplos.electrodomestico;

public class ElectrodomesticosTest {

	public static void main(String[] args) {
		
		// Creamos array de objetos electrodoméstico
		Electrodomestico[] e = new Electrodomestico[5];
		
		e[0] = new Lavadora();
		e[1] = new Television();
		e[2] = new Lavadora(500, 50);
		e[3] = new Television(1500, 20);
		e[4] = new Lavadora(1000, 500);
		
		double ptotal = 0;
		
		for (int i=0; i<e.length; i++) {
			System.out.println(e[i].toString());
			ptotal += e[i].precioFinal();
		}
		System.out.println("El precio total es: "+ptotal);
		

	}

}
