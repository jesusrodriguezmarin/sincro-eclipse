package ejemplos.agenda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import ejemplos.alumno.Alumno;

public class AgendaPer {

	// Ruta del fichero
	private static final String FICHERO = "C:/PG/contacto.dat";

	// Lista que utilizamos para cargar en memoria los contactos almacenados como
	// variable global
	private static ArrayList<Contacto> agenda;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero una lista de contactos
	 * 
	 * @return - Array - lista de Contacto
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Alumno> leerLista() {
		ArrayList<Alumno> alumnos = new ArrayList<>();
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			alumnos = (ArrayList<Alumno>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
		return alumnos;
	}

	/**
	 * Guarda el fichero en una lista de contactos
	 * 
	 * @param alumnos - array del objeto Contacto
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			salida.writeObject(agenda);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese nombre está ya en la agenda
	 * 
	 * @param nombre a comprobar
	 * @return - int - un número referente a la posición del nombre si está o -1 si
	 *         no está
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
		
		// Añadimos un nuevo alumno
		agenda.add(new Contacto(nombre, numero));
		
		// Guardamos la lista actualizada
		//guardarLista(agenda);
		
		// Mostramos la lista actualizada
		for (int i = 0; i < agenda.size(); i++) {
			System.out.println(agenda.get(i));
		}
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
		System.out.println("*   4) Salir               *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables
		int opcion; // Opción del menú elegida por el usuario
		String nombre; // Nombre del contacto
		int telefono; // Teléfono del contacto

		// Crea la lista que tenemos declarada fuera del main
		agenda = new ArrayList<>();

		// Carga la lista
		leerLista();

		Scanner teclado = new Scanner(System.in);

		try {
			// Repetimos el menú de opciones
			do {
				menu();
				do {
					System.out.print("Elige una opción: ");
					opcion = Integer.parseInt(teclado.nextLine());
					switch (opcion) {
					case 1: // AÑADIR CONTACTO
						System.out.println("\n>> AÑADIR CONTACTO");
						// Pedimos el nombre del contacto a añadir
						System.out.println("Introduce un nombre: ");
						String nom = teclado.nextLine().trim();

						// Comprobamos si el contacto ya se encuentra en la agenda
						if (buscarContacto(nom) != -1) {
							System.out.println("El contacto "+ nom + "+ya se encuentra en la agenda");
						} else {
							// Pedimos el teléfono del contacto a añadir
							System.out.println("Introduce el número: ");
							int num = Integer.parseInt(teclado.nextLine());
							añadirContacto(nom, num);
							
							// Guardamos
							guardarLista();
						}


						break;

					case 2: // LISTAR CONTACTO
						System.out.println("\n>> MOSTRAR CONTACTOS");
						
						// Si la lista está vacía informamos
						if (agenda.isEmpty()) {
							System.out.println("La agenda está vacía");
						} else {
							// Mostramos los objetos almacenados
							for (int i = 0; i < agenda.size(); i++) {
								System.out.println(agenda.get(i));
							}
						}
						
						// Mostramos la lista de contactos
						break;

					case 3: // MODIFICAR CONTACTO
						System.out.println("\n>> MODIFICAR CONTACTOS");
						// Pedimos el nombre del contacto a modificar
						

						// Comprobamos si el contacto ya se encuentra en la agenda
						System.out.println("Introduce el nombre: ");
						String nom1 = teclado.nextLine();
						
						System.out.println("Introduce el número: ");
						int res1 = Integer.parseInt(teclado.nextLine());
						agenda.get(nom1).setTelefono(telefono);
						// Guardamos
						guardarLista();

						break;

					case 4: // ELIMINAR CONTACTO
						System.out.println("\n>> ELIMINAR CONTACTOS");
						// Pedimos el nombre del contacto a eliminar
						agenda.remove(res2);
						// Guardamos
						guardarLista();
						
						
						// Comprobamos si el contacto ya se encuentra en la agenda

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