package ejercicios2;

public class Ejercicio4B {


	static void totalSeg(int total) {
		
		int resto=total;
		int horas=resto/3600;
		resto=resto%3600;
		int min=resto/60;
		resto=resto%60;
		int seg=resto;
		
		System.out.println("El total en segundos es: "+total);
		System.out.println(""+horas);
		System.out.println(""+min);
		System.out.println(""+seg);
				
	}
	
	public static void main(String[] args) {

		int total=3661;
		totalSeg(total);
		
			}

}
