package ejemplos.agendaSencillo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaPer {

	// Ruta del fichero
	private static final String FICHERO = "C:/PG/contacto.dat";

	// Lista que utilizamos para cargar en memoria los contactos almacenados como variable global
	private static ArrayList<Contacto> agenda;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero una lista de contactos
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			
			// Volcamos los datos directamente en nuestra variable global
			agenda = (ArrayList<Contacto>) entrada.readObject();
			entrada.close();
			
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en una lista de contactos
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			
			
			salida.reset(); 
			
			salida.writeObject(agenda);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre está ya en la agenda
	 */
	public static int buscarContacto(String nombre) {
		// Recorremos la lista
		for (int i = 0; i < agenda.size(); i++) {
			if (agenda.get(i).getNombre().equalsIgnoreCase(nombre.trim())) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Método para añadir un contacto nuevo en la agenda
	 */
	public static void añadirContacto(String nombre, int numero) {
		// Añadimos un nuevo contacto
		agenda.add(new Contacto(nombre, numero));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("*  AGENDA TELEFONICA       *");
		System.out.println("*   1) Añadir contacto     *");
		System.out.println("*   2) Mostrar contactos   *");
		System.out.println("*   3) Modificar contacto  *");
		System.out.println("*   4) Eliminar contacto   *");
		System.out.println("*   5) Salir               *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables
		int opcion; 	// Opción del menú elegida por el usuario
		String nombre; 	// Nombre del contacto
		int telefono; 	// Teléfono del contacto

		// Crea la lista que tenemos declarada fuera del main
		agenda = new ArrayList<>();

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
				do {
					// Pedimos la opción al usuario
					System.out.print("Elige una opción: ");
					
					// Pedimos como String y parseamos para no tener problemas con scanner
					opcion = Integer.parseInt(teclado.nextLine());
					
					// Aplicamos el filtro selector de la opción elegida
					switch (opcion) {
					
					case 1: // AÑADIR CONTACTO
						System.out.println("\n>> AÑADIR CONTACTO");
						System.out.print("Introduce un nombre: ");
						nombre = teclado.nextLine().trim();

						// Comprobamos si el contacto ya se encuentra en la agenda
						if (buscarContacto(nombre) != -1) {
							System.out.println("El contacto " + nombre + " ya se encuentra en la agenda");
						} else {
							// Pedimos el teléfono del contacto a añadir
							System.out.print("Introduce el número: ");
							telefono = Integer.parseInt(teclado.nextLine());
							añadirContacto(nombre, telefono);
							
							// Guardamos la lista en el fichero contacto.dat
							guardarLista();
						}
						break;

					case 2: // LISTAR CONTACTO
						System.out.println("\n>> MOSTRAR CONTACTOS");
						
						// Si la lista está vacía informamos
						if (agenda.size() == 0) {
							System.out.println("La agenda está vacía");
						} else {
							// Mostramos los objetos almacenados
							for (int i = 0; i < agenda.size(); i++) {
								System.out.println(agenda.get(i));
							}
						}
						break;

					case 3: // MODIFICAR CONTACTO
						System.out.println("\n>> MODIFICAR CONTACTOS");
						System.out.print("Introduce el nombre del contacto a modificar: ");
						nombre = teclado.nextLine().trim();
						
						// Obtenemos el resultado de existencia para filtrar en el condicional
						int res = buscarContacto(nombre);

						// Controlamos si se encuentra
						if (res == -1) {
							System.out.println("No se ha encontrado '" + nombre + "' en la agenda.");
						} else {
							System.out.print("Nuevo teléfono: ");
							telefono = Integer.parseInt(teclado.nextLine().trim());
							
							agenda.get(res).setTelefono(telefono);
							System.out.println("El teléfono " + telefono + " ha sido modificado con éxito.");
							
							// Guardamos el cambio en el disco duro
							guardarLista();
						}
						break;

					case 4: // ELIMINAR CONTACTO
						System.out.println("\n>> ELIMINAR CONTACTOS");
						System.out.print("Nombre del contacto: ");
						nombre = teclado.nextLine().trim();
						int res2 = buscarContacto(nombre);
						
						if (res2 == -1) {
							System.out.println("No se ha encontrado '" + nombre + "' en la agenda.");
						} else {
							agenda.remove(res2);
							System.out.println("El contacto " + nombre + " ha sido eliminado.");
							// Guardamos la lista actualizada
							guardarLista();
						}
						break;

					case 5: // Salir
						System.out.println("Bye bye");
						break;
					default:
						System.out.println("\n>> Opción elegida no válida");
					}
				} while (opcion < 1 || opcion > 5);
			} while (opcion != 5);

			System.out.println("Que tengas un buen día...");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no válido");
		}
	}
}