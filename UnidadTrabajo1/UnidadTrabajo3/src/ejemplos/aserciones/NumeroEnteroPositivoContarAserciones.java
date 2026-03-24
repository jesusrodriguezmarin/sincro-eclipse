package ejemplos.aserciones;

import java.util.Scanner;

public class NumeroEnteroPositivoContarAserciones {

	public static void main(String[] args) {
		// abrimos lector
		Scanner sc = new Scanner(System.in);
		
		// controlamos errores
		try {
			// declaracion de variable para pedir
			int num;
			
			// pedimos número entero positivo			
			System.out.print("Introduce un número entero posotivo: ");
			num = sc.nextInt();
			
			// aserción para verificar que el número sea positivo
			assert num > 0 : "No has introducido un valor positivo";
			
			// contamos y mostramos
			for (int conta = 3; conta <= num; conta += 2)
				System.out.print(conta+" ");
			
			// mostramos desde 3 al número introducido
		} catch (Exception e) {
			System.err.println("ERROR");
		} catch (AssertionError a) {
			System.err.println(a.getMessage());
		} finally {
			// cierre lector
			sc.close();
		}
		
	}

}
