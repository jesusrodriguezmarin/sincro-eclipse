package ejemplos.mac.cuentaBanco;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionCuentas {

	// Ruta del fichero 
	private static final String FICHERO = "C:/PG/cuentabanco.dat";

	// Lista que utilizamos para cargar en memoria las cuentas almacenadas como variable global
	private static ArrayList<CuentaBanco> listaCuentas;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de cuentas bancarias
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaCuentas = (ArrayList<CuentaBanco>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de cuentas bancarias
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaCuentas);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre de cuenta está ya en la lista
	 */
	public static int buscarCuenta(String nombre) {
		// Recorremos la lista buscando por el identificador único (nombre de la cuenta)
		for (int i = 0; i < listaCuentas.size(); i++) {
			if (listaCuentas.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir una cuenta nueva en la lista
	 */
	public static void añadirCuenta(String nombre, double saldo) {
		// Añadimos una nueva cuenta bancaria
		listaCuentas.add(new CuentaBanco(nombre, saldo));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE CUENTAS BANCO *");
		System.out.println("* 1) Añadir cuenta         *");
		System.out.println("* 2) Mostrar cuentas       *");
		System.out.println("* 3) Modificar saldo       *");
		System.out.println("* 4) Eliminar cuenta       *");
		System.out.println("* 5) Buscar una cuenta     *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;         // Opción del menú elegida por el usuario
		String nombre;      // Nombre de la cuenta (Clave única de búsqueda)
		double saldo;       // Saldo disponible en la cuenta

		// Crea la lista que tenemos declarada fuera del main
		listaCuentas = new ArrayList<>();

		// Carga la lista desde el fichero
		leerLista();

		// Creamos lector
		Scanner teclado = new Scanner(System.in);

		// Control de errores
		try {
			// Repetimos el menú de opciones
			do {
				// Mostramos el menú
				menu();

				// Pedimos la opción al usuario
				System.out.print("Elige una opción: ");

				// Pedimos como String y parseamos para no tener problemas con scanner
				opcion = Integer.parseInt(teclado.nextLine());

				// Aplicamos el filtro selector de la opción elegida
				switch (opcion) {

				case 1: // AÑADIR CUENTA
					System.out.println("\n>> AÑADIR CUENTA");
					System.out.print("Introduce el nombre de la cuenta: ");
					nombre = teclado.nextLine().trim();

					// Comprobamos si la cuenta ya se encuentra registrada por su nombre
					if (buscarCuenta(nombre) != -1) {
						System.out.println("La cuenta '" + nombre + "' ya está registrada.");
					} else {
						// Pedimos el saldo inicial
						System.out.print("Introduce el saldo inicial: ");
						saldo = Double.parseDouble(teclado.nextLine());
						
						añadirCuenta(nombre, saldo);

						// Guardamos la lista en el fichero cuentabanco.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR CUENTAS
					System.out.println("\n>> MOSTRAR CUENTAS");

					// Si la lista está vacía informamos
					if (listaCuentas.size() == 0) {
						System.out.println("No hay cuentas registradas.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaCuentas.size(); i++) {
							System.out.println(listaCuentas.get(i));
						}
					}
					break;

				case 3: // MODIFICAR SALDO
					System.out.println("\n>> MODIFICAR SALDO");
					System.out.print("Introduce el nombre de la cuenta a modificar: ");
					nombre = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarCuenta(nombre);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado la cuenta '" + nombre + "'.");
					} else {
						// Pedimos el nuevo saldo 
						System.out.print("Nuevo saldo: ");
						saldo = Double.parseDouble(teclado.nextLine().trim());

						listaCuentas.get(res).setSaldo(saldo);
						System.out.println("El saldo de la cuenta '" + nombre + "' ha sido modificado con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR CUENTA
					System.out.println("\n>> ELIMINAR CUENTA");
					System.out.print("Nombre de la cuenta a eliminar: ");
					nombre = teclado.nextLine().trim();
					int res2 = buscarCuenta(nombre);

					if (res2 == -1) {
						System.out.println("No se ha encontrado la cuenta '" + nombre + "'.");
					} else {
						listaCuentas.remove(res2);
						System.out.println("La cuenta '" + nombre + "' ha sido eliminada.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UNA CUENTA
					System.out.println("\n>> BUSCAR UNA CUENTA");
					System.out.print("Introduce el nombre de la cuenta a buscar: ");
					nombre = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarCuenta(nombre);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado la cuenta '" + nombre + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Cuenta encontrada: " + listaCuentas.get(res3));
					}
					break;

				case 6: // Salir
					System.out.println("Bye bye");
					break;
				default:
					System.out.println("\n>> Opción elegida no válida");
				}

			} while (opcion != 6);

			System.out.println("Que tengas un buen día...");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no válido");
		}
	}
}