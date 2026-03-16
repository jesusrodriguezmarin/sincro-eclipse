package ejemplos.ejercicios;

import java.util.Scanner;

public class Ejer30cadaUnoPrimo {

    public static boolean esPrimo(int N) {
        if (N <= 1)
            return false;
        else {
            for (int i = 2; i <= N / 2; i++) {
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

            // 1. LECTURA ANTICIPADA:
            // Pedimos el dato ANTES del bucle para poder evaluar la condición del while
            System.out.println("Introduce un valor entero (0 para salir): ");
            num = sc.nextInt();

            // 2. CONDICIÓN: Si es 0, ni siquiera entra.
            while (num != 0) {
                
                // Lógica de validación
                if (num < 0) { 
                    // Quitamos el '=' para que el 0 no se considere error, aunque aquí nunca será 0
                    System.out.println("Error, debe ser un entero positivo.");
                } else {
                    if (esPrimo(num)) {
                        System.out.println("> Es primo.");
                    } else {
                        System.out.println("> No es primo.");
                    }
                }

                // 3. ACTUALIZACIÓN:
                // Volvemos a pedir el dato AL FINAL del bucle para la siguiente vuelta
                System.out.println("Introduce un valor entero (0 para salir): ");
                num = sc.nextInt();
            }
            
            System.out.println("Fin del programa.");

        } catch (Exception e) {
            System.err.println("ERROR: Entrada no válida");
        }

        sc.close();
    }
}
