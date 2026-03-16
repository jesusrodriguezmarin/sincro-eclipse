package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer30_v2 {

    /**
     * Funcion que devuelve si un nº entero es o no primo
     * @param N - nº entero
     * @return TRUE si N es nº primo y FALSE si no lo es
     */
    public static boolean esPrimo(int N) {
        if (N <= 1)
            return false;
        else {
            // Optimization: checking up to the square root is sufficient
            // Recorremos los posibles divisores
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0)
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int num;
            do {
                System.out.println("Introduce un valor entero (0 para salir): ");
                num = sc.nextInt();

                if (num > 0) {
                    // Check primality only if positive
                    if (esPrimo(num)) {
                        System.out.println("Es primo");
                    } else {
                        System.out.println("No es primo");
                    }
                } else if (num < 0) {
                    // Check negative numbers
                    System.out.println("Error, no es un valor positivo");
                }
                // If num == 0, the loop will naturally end
                
            } while (num != 0); // Checks condition after the code block executes

        } catch (Exception e) {
            System.err.println("ERROR: Entrada no válida");
        }
        
        sc.close();
    }
}
