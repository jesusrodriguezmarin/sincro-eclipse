package abstractEjemplo;

public class SorteoTest {

	public static void main(String[] args) {
		
		Dado d = new Dado();
		Moneda m = new Moneda();
		
		System.out.println("Dado: "+d.lanzar());
		System.out.println("Moneda: "+m.lanzar());

	}

}
