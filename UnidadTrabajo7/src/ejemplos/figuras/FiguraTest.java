package ejemplos.figuras;

public class FiguraTest {

	public static void main(String[] args) {

		// Creamos instancias de Rectangulo y triangulo
		Figura f[] = new Figura[4];
		
		f[0] = new Rectangulo(3,4);
		f[1] = new Triangulo(3,4);
		f[2] = new Rectangulo(4, 5);
		f[3] = new Triangulo(4,5);
		
		for (int i=0; i<f.length; i++) {
			if (i==0 || i%2==0) {
				int res = f[i].area();
				System.out.println(f[i].toString()+ " es: "+res);
			} else {
				System.out.println(f[i].toString());
			}
		}
	}

}
