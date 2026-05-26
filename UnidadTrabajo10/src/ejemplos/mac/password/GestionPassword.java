package ejemplos.mac.password;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionPassword {

	// Ruta del fichero
	private static final String FICHERO = "/Users/jesusrodriguezmarin/Documents/BDeclipse/password.dat";

	// Lista que utilizamos para cargar en memoria las contraseñas almacenadas como variable global
	private static ArrayList<Password> listaPasswords;

	// --- MÉTODOS ---

	/**
	 * Recupera del fichero la lista de contraseñas
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));

			// Volcamos los datos directamente en nuestra variable global
			listaPasswords = (ArrayList<Password>) entrada.readObject();
			entrada.close();

		} catch (Exception e) {
			System.out.println(">> Se ha producido un error: " + e.getMessage());
		}
	}

	/**
	 * Guarda el fichero en la lista de contraseñas
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));

			// Forzamos el limpiado del caché antes de escribir
			salida.reset();

			salida.writeObject(listaPasswords);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese usuario está ya en la lista
	 */
	public static int buscarPassword(String usuario) {
		// Recorremos la lista
		for (int i = 0; i < listaPasswords.size(); i++) {
			if (listaPasswords.get(i).getUsuario().equalsIgnoreCase(usuario.trim())) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método para añadir una nueva contraseña en la lista
	 */
	public static void añadirPassword(String usuario, String clave) {
		// Añadimos una nueva credencial
		listaPasswords.add(new Password(usuario, clave));
	}

	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTOR DE CONTRASEÑAS  *");
		System.out.println("* 1) Añadir contraseña     *");
		System.out.println("* 2) Mostrar contraseñas   *");
		System.out.println("* 3) Modificar contraseña  *");
		System.out.println("* 4) Eliminar contraseña   *");
		System.out.println("* 5) Buscar una contraseña *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	/**
	 * Programa principal
	 */
	public static void main(String[] args) {

		// Variables 
		int opcion;            // Opción del menú elegida por el usuario
		String usuario;        // Nombre de usuario único
		String clave;          // La contraseña asociada

		// Crea la lista que tenemos declarada fuera del main
		listaPasswords = new ArrayList<>();

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

				case 1: // AÑADIR CONTRASEÑA
					System.out.println("\n>> AÑADIR CONTRASEÑA");
					System.out.print("Introduce el usuario: ");
					usuario = teclado.nextLine().trim();

					// Comprobamos si el usuario ya tiene una contraseña registrada
					if (buscarPassword(usuario) != -1) {
						System.out.println("Ya existe una contraseña registrada para el usuario '" + usuario + "'.");
					} else {
						// Pedimos la contraseña para el nuevo usuario
						System.out.print("Introduce la contraseña: ");
						clave = teclado.nextLine().trim();
						
						añadirPassword(usuario, clave);

						// Guardamos la lista en el fichero password.dat
						guardarLista();
					}
					break;

				case 2: // LISTAR CONTRASEÑAS
					System.out.println("\n>> MOSTRAR CONTRASEÑAS");

					// Si la lista está vacía informamos
					if (listaPasswords.size() == 0) {
						System.out.println("No hay contraseñas guardadas.");
					} else {
						// Mostramos los objetos almacenados
						for (int i = 0; i < listaPasswords.size(); i++) {
							System.out.println(listaPasswords.get(i));
						}
					}
					break;

				case 3: // MODIFICAR CONTRASEÑA
					System.out.println("\n>> MODIFICAR CONTRASEÑA");
					System.out.print("Introduce el nombre del usuario a modificar: ");
					usuario = teclado.nextLine().trim();

					// Obtenemos el resultado de existencia para filtrar en el condicional
					int res = buscarPassword(usuario);

					// Controlamos si se encuentra
					if (res == -1) {
						System.out.println("No se han encontrado credenciales para el usuario '" + usuario + "'.");
					} else {
						// Pedimos la nueva contraseña
						System.out.print("Introduce la NUEVA contraseña: ");
						clave = teclado.nextLine().trim();

						listaPasswords.get(res).setClave(clave);
						System.out.println("La contraseña del usuario '" + usuario + "' ha sido modificada con éxito.");

						// Guardamos el cambio en el disco duro
						guardarLista();
					}
					break;

				case 4: // ELIMINAR CONTRASEÑA
					System.out.println("\n>> ELIMINAR CONTRASEÑA");
					System.out.print("Usuario que deseas eliminar: ");
					usuario = teclado.nextLine().trim();
					int res2 = buscarPassword(usuario);

					if (res2 == -1) {
						System.out.println("No se han encontrado credenciales para el usuario '" + usuario + "'.");
					} else {
						listaPasswords.remove(res2);
						System.out.println("Las credenciales del usuario '" + usuario + "' han sido eliminadas.");
						// Guardamos la lista actualizada
						guardarLista();
					}
					break;

				case 5: // BUSCAR UNA CONTRASEÑA
					System.out.println("\n>> BUSCAR UNA CONTRASEÑA");
					System.out.print("Introduce el usuario a buscar: ");
					usuario = teclado.nextLine().trim();
					
					// Obtenemos la posición usando el método de búsqueda
					int res3 = buscarPassword(usuario);
					
					if (res3 == -1) {
						System.out.println("No se han encontrado credenciales para el usuario '" + usuario + "'.");
					} else {
						// Mostramos los datos del objeto encontrado accediendo a su posición
						System.out.println("Credencial encontrada: " + listaPasswords.get(res3));
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