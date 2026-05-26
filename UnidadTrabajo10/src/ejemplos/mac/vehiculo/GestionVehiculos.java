package ejemplos.mac.vehiculo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionVehiculos {

	// Ruta del fichero
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/vehiculo.dat";

	// Lista que utilizamos para cargar en memoria los vehículos almacenados como variable global
	private static ArrayList<Vehiculo> listaVehiculos;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de vehículos
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaVehiculos = (ArrayList<Vehiculo>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de vehículos
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaVehiculos);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si esa matrícula está ya en la lista
	 */
	public static int buscarVehiculo(String matricula) {
		// Recorremos la lista buscando por el identificador único (matrícula)
		for (int i = 0; i < listaVehiculos.size(); i++) {
			if (listaVehiculos.get(i).getMatricula().equalsIgnoreCase(matricula.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir un vehículo nuevo en la lista
	 */
	public static void añadirVehiculo(String matricula, String marca) {
		// Añadimos un nuevo vehículo
		listaVehiculos.add(new Vehiculo(matricula, marca));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE VEHÍCULOS     *");
		System.out.println("* 1) Añadir vehículo       *");
		System.out.println("* 2) Mostrar vehículos     *");
		System.out.println("* 3) Modificar marca       *");
		System.out.println("* 4) Eliminar vehículo     *");
		System.out.println("* 5) Buscar un vehículo    *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;            // Opción del menú elegida por el usuario
		String matricula;      // Matrícula del vehículo (Clave única de búsqueda)
		String marca;          // Marca del vehículo

		// Crea la lista que tenemos declarada fuera del main
		listaVehiculos = new ArrayList<>();

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

				case 1: // AÑADIR VEHÍCULO
					System.out.println("\n>> AÑADIR VEHÍCULO");
					System.out.print("Introduce la matrícula: ");
					matricula = teclado.nextLine().trim();

					// Comprobamos si el vehículo ya se encuentra registrado por su matrícula
					if (buscarVehiculo(matricula) != -1) {
						System.out.println("El vehículo con matrícula " + matricula + " ya está registrado.");
					} else {
						// Pedimos el resto de datos del vehículo
						System.out.print("Introduce la marca: ");
						marca = teclado.nextLine().trim();
						
						añadirVehiculo(matricula, marca);

						// Guardamos la lista en el fichero vehiculo.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR VEHÍCULOS
					System.out.println("\n>> MOSTRAR VEHÍCULOS");

					// Si la lista está vacía informamos
					if (listaVehiculos.size() == 0) {
						System.out.println("No hay vehículos registrados.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaVehiculos.size(); i++) {
							System.out.println(listaVehiculos.get(i));
						}
					}
					break;

				case 3: // MODIFICAR MARCA
					System.out.println("\n>> MODIFICAR MARCA");
					System.out.print("Introduce la matrícula del vehículo a modificar: ");
					matricula = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarVehiculo(matricula);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se ha encontrado el vehículo con matrícula '" + matricula + "'.");
					} else {
						// Pedimos la nueva marca
						System.out.print("Nueva marca: ");
						marca = teclado.nextLine().trim();

						listaVehiculos.get(res).setMarca(marca);
						System.out.println("La marca del vehículo con matrícula " + matricula + " ha sido modificada con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR VEHÍCULO
					System.out.println("\n>> ELIMINAR VEHÍCULO");
					System.out.print("Matrícula del vehículo a eliminar: ");
					matricula = teclado.nextLine().trim();
					int res2 = buscarVehiculo(matricula);

					if (res2 == -1) {
						System.out.println("No se ha encontrado el vehículo con matrícula '" + matricula + "'.");
					} else {
						listaVehiculos.remove(res2);
						System.out.println("El vehículo con matrícula " + matricula + " ha sido eliminado.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN VEHÍCULO
					System.out.println("\n>> BUSCAR UN VEHÍCULO");
					System.out.print("Introduce la matrícula del vehículo a buscar: ");
					matricula = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarVehiculo(matricula);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado el vehículo con matrícula '" + matricula + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Vehículo encontrado: " + listaVehiculos.get(res3));
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