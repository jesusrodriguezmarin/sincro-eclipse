package ejemplos.agenda;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaPer2 {
	
	// Ruta del fichero en Windows (Asegúrate de que la carpeta C:/PG exista en tu PC)
	private static final String FICHERO = "C:/PG/contacto.dat";
	
	// Lista que utilizamos para cargar en memoria los contactos almacenados como variable global
	private static ArrayList<Contacto> agenda;
	
	// --- MÉTODOS DE PERSISTENCIA (SOPORTE) ---
	
	/**
	 * Recupera del fichero la lista de contactos y la vuelca en la variable global
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			// CORREGIDO: Cargamos los datos directamente en nuestra variable global 'agenda'
			agenda = (ArrayList<Contacto>) entrada.readObject();
			entrada.close();
		} catch (Exception e) {
			// Si el archivo no existe (primera vez), inicializamos la lista vacía para que no sea null
			agenda = new ArrayList<Contacto>();
		}
	}
	
	/**
	 * Guarda la lista global de contactos en el fichero binario
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			
			// ¡MUY IMPORTANTE PARA EL EXAMEN! Limpia el caché para que el "Modificar" (Update) funcione de verdad
			salida.reset(); 
			
			salida.writeObject(agenda);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}
	
	// --- MÉTODOS DE OPERACIONES LÓGICAS (CRUD) ---

	/**
	 * 1) CREATE: Pide datos, comprueba duplicados, añade a la lista y guarda en el fichero
	 */
	public static void añadirContacto(Scanner teclado) {
		System.out.println("\n>> NUEVO CONTACTO");
		
		System.out.print("Introduce el nombre: ");
		String nombre = teclado.nextLine().trim();
		
		// Control de duplicados recorriendo la lista global
		boolean duplicado = false;
		for (Contacto c : agenda) {
			if (c.getNombre().equalsIgnoreCase(nombre)) {
				duplicado = true;
				break;
			}
		}
		
		if (duplicado) {
			System.out.println(">> ¡Error! Ese contacto ya se encuentra en la agenda.");
		} else {
			System.out.print("Introduce el teléfono: ");
			int telefono = Integer.parseInt(teclado.nextLine());
			
			// Añadimos el nuevo contacto a la variable global
			agenda.add(new Contacto(nombre, telefono));
			
			// Guardamos de inmediato en el archivo
			guardarLista();
			System.out.println(">> Contacto añadido y guardado con éxito.");
		}
	}

	/**
	 * 2) READ: Recorre la lista en memoria y muestra todos los contactos
	 */
	public static void mostrarContactos() {
		System.out.println("\n>> CONTACTOS ALMACENADOS");
		
		if (agenda.isEmpty()) {
			System.out.println("La agenda está vacía.");
		} else {
			for (Contacto c : agenda) {
				System.out.println(c); // Usa automáticamente el toString() de tu clase Contacto
			}
		}
	}

	/**
	 * 3) UPDATE: Busca un contacto por nombre y modifica su número de teléfono
	 */
	public static void modificarContacto(Scanner teclado) {
		System.out.println("\n>> MODIFICAR CONTACTO");
		
		if (agenda.isEmpty()) {
			System.out.println("La agenda está vacía. No hay nada que modificar.");
			return;
		}
		
		System.out.print("Introduce el nombre del contacto que deseas modificar: ");
		String nombreBuscar = teclado.nextLine().trim();
		
		Contacto contactoEncontrado = null;
		// Buscamos el objeto en la lista global
		for (Contacto c : agenda) {
			if (c.getNombre().equalsIgnoreCase(nombreBuscar)) {
				contactoEncontrado = c;
				break;
			}
		}
		
		if (contactoEncontrado != null) {
			System.out.print("Introduce el NUEVO teléfono para " + contactoEncontrado.getNombre() + ": ");
			int nuevoTelefono = Integer.parseInt(teclado.nextLine());
			
			// Modificamos el atributo en memoria RAM
			contactoEncontrado.setTelefono(nuevoTelefono);
			
			// Forzamos la escritura en el disco (aquí es donde el salida.reset() de arriba nos salva la vida)
			guardarLista();
			System.out.println(">> Teléfono modificado y guardado con éxito.");
		} else {
			System.out.println(">> No se encontró ningún contacto con ese nombre.");
		}
	}
	
	/**
	 * Procedimiento que muestra por pantalla un menú de operaciones
	 */
	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* AGENDA TELEFONICA       *");
		System.out.println("* 1) Añadir contacto     *");
		System.out.println("* 2) Mostrar contactos   *");
		System.out.println("* 3) Modificar contacto  *"); // Corregido el texto acorde al case 3
		System.out.println("* 4) Salir               *");
		System.out.println("****************************");
	}
	
	/**
	 * Programa principal
	 */
	public static void main(String[] args) {
		
		// Variables
		int opcion;			// Opción del menú elegida por el usuario
		Scanner teclado = new Scanner(System.in);
		
		// 1. Inicializamos la lista global en blanco por seguridad
		agenda = new ArrayList<>();
		
		// 2. Cargamos los contactos existentes desde el archivo C:/PG/contacto.dat al arrancar
		leerLista();
		
		try {
			// Repetimos el menú de opciones
			do {
				menu();				
				do {
					System.out.print("Elige una opción: ");
					opcion = Integer.parseInt(teclado.nextLine());				
					switch (opcion) {
						case 1: 
								// Llamamos al método de añadir pasándole el teclado
								añadirContacto(teclado);
								break;
								
						case 2: 
								// Llamamos al método de listar
								mostrarContactos();
								break;							
							
						case 3: 
								// Llamamos al método de modificar pasándole el teclado
							    modificarContacto(teclado);
								break;					
								
						case 4: 
								System.out.println("Bye bye"); 
								break;
						default: 
								System.out.println("\n>> Opción elegida no válida");
					}
				} while (opcion < 1 || opcion > 4);				
			} while (opcion != 4);			
			
			System.out.println("Que tengas un buen día...");
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR. Valor introducido no válido o error inesperado.");
		}
	}
}