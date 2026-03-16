package arrays.ejemplosNombrados;

import java.util.Scanner;

public class SinARRAYIntroduce5numeros01 {

	public static void main(String[] args) {
		// Creamos lector
		Scanner sc = new Scanner(System.in);
		
		try {
			int n1, n2, n3, n4, n5;
			System.out.println("Introduce 5 números...");
			System.out.print("Num 1: ");
			n1 = sc.nextInt();
			
			System.out.print("Num 2: ");
			n2 = sc.nextInt();
			
			System.out.print("Num 3: ");
			n3 = sc.nextInt();
			
			System.out.print("Num 4: ");
			n4 = sc.nextInt();
			
			System.out.print("Num 5: ");
			n5 = sc.nextInt();
			
			// Mostramos los números introducidos en el mismo orden
			System.out.println(n1+" "+n2+" "+n3+" "+n4+" "+n5);
			
			// Mostramos los nº introducidos en orden inverso
			System.out.println(n5+" "+n4+" "+n3+n2+" "+n1);
			
			// Mostramos el primer y último nº
			System.out.print("El primer valor: "+n1);
			System.out.print("El último valor: "+n5);
			
		} catch (Exception e) {
			System.err.println(">> ERROR: No has introducido un tipo de datos válido");
		} finally {
			sc.close();
		}

	}

}
