package ejemplos.arrayFigura;

public class ArrayFiguraTestArray {

	public static void main(String[] args) {
		
		// Creamos un objeto array generalizado de ArrayFigura y especificamos dentro de las posiciones del array
		ArrayFigura[] af;
		
		af = new ArrayFigura[4];
		
		af[0] = new Circulo(5);
		af[1] = new Cuadrado(5);
		af[2] = new Circulo(10);
		af[3] = new Cuadrado(10);
		
		for (int i =0; i<af.length; i++) {
			System.out.println(af[i].area());
		}

	}

}
