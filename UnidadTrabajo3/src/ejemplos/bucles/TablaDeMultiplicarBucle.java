package ejemplos.bucles;

public class TablaDeMultiplicarBucle {

	public static void tablaMul(int num) {
		for (int conta=1; conta<=10; conta++)
			System.out.println(num+" x "+conta+" = "+(num*conta));
	}
	
	public static void main(String[] args) {

		for (int conta=2; conta<=9; conta++) {
			tablaMul(conta);
			System.out.println();
		}
		 
	}

}
