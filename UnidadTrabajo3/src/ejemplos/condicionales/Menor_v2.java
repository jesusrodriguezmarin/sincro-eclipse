package ejemplos.condicionales;

public class Menor_v2 {

	public static void main(String[] args) {
		int primero, segundo;
		primero=Menor_v1.aleatorio(25);
		segundo=Menor_v1.aleatorio(25);
		
		int menor=Menor_v1.menor(primero, segundo);
		
		System.out.println("Valores: "+primero+" y "+segundo);
		System.out.println("Menor: "+menor);
	}
}