package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer15romanos {

	/**
	 * Procedimiento que devuelve un nº en su forma romana
	 * @param N - nº entero
	 * @return un nº en su equivalencia romana
	 */
	public static String roman (int N) {
		String res = "";
		int num = Math.abs(N);
		while (num >= 1000) {
			num-=1000;
			res+="M";
		}
		while (num >= 900) {
			num-=900;
			res+="CM";
		}
		while (num >= 500) {
			num-=500;
			res+="D";
		}
		while (num >= 400) {
			num-=400;
			res+="CD";
		}
		while (num >= 100) {
			num-=100;
			res+="C";
		}
		while (num >= 90) {
			num-=90;
			res+="XC";
		}
		while (num >= 50) {
			num-=50;
			res+="L";
		}
		while (num >= 40) {
			num-=40;
			res+="XL";
		}
		while (num >= 10) {
			num-=10;
			res+="X";
		}
		while (num >= 9) {
			num-=9;
			res+="IX";
		}
		while (num >= 5) {
			num-=5;
			res+="V";
		}
		while (num >= 4) {
			num-=4;
			res+="IV";
		}
		while (num >= 1) {
			num-=1;
			res+="I";
		}
		if (N < 0) {
			return res+=" a.C";
		} else {
			return res;
		}
			
	}
	public static void main(String[] args) {
		// lector
		Scanner sc = new Scanner(System.in);
		// control
		try {
			// pedimos nº por teclado
			System.out.print("Introduce un nº: ");
			int num = sc.nextInt();
			System.out.println(roman(num));
			
		} catch (Exception e) {
			System.err.println("ERROR! tipo de valor incorrecto!");
		}
		
		// cierre lector
		sc.close();

	}

}
