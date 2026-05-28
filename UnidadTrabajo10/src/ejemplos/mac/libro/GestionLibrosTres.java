package ejemplos.mac.libro;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionLibrosTres {

	private static final String FICHERO = "C:/PG/libro.dat";
	private static ArrayList<Libro> listaLibros;

	/**
	 * Recupera del fichero la lista de libros
	 */
	@SuppressWarnings("unchecked")
	public static void leerLista() {
		try {
			ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
			listaLibros = (ArrayList<Libro>) entrada.readObject();
			entrada.close();
		} catch (Exception e) {
			listaLibros = new ArrayList<>();
		}
	}

	/**
	 * Guarda el fichero en la lista de libros
	 */
	public static void guardarLista() {
		try {
			ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO));
			salida.reset(); 
			salida.writeObject(listaLibros);
			salida.close();
		} catch (Exception e) {
			System.out.println(">> Se ha producido un error al guardar: " + e.getMessage());
		}
	}

	/**
	 * Método que comprueba si ese título de libro está ya en la lista
	 */
	public static int buscarLibro(String titulo) {
		for (int i = 0; i < listaLibros.size(); i++) {
			if (listaLibros.get(i).getTitulo().equalsIgnoreCase(titulo.trim())) {
				return i;
			}
		}
		return -1;
	}

	private static void menu() {
		System.out.println("\n****************************");
		System.out.println("* GESTIÓN DE LIBROS (V3)   *");
		System.out.println("* 1) Añadir libro          *");
		System.out.println("* 2) Mostrar libros        *");
		System.out.println("* 3) Modificar datos       *");
		System.out.println("* 4) Eliminar libro        *");
		System.out.println("* 5) Buscar un libro       *");
		System.out.println("* 6) Salir                 *");
		System.out.println("****************************");
	}

	public static void main(String[] args) {

		int opcion = 0;     
		String titulo;      
		String autor;       
		int paginas;        

		leerLista();
		Scanner teclado = new Scanner(System.in);

		do {
			try {
				menu();
				System.out.print("Elige una opción: ");
				opcion = Integer.parseInt(teclado.nextLine().trim());

				switch (opcion) {

				case 1: // AÑADIR LIBRO
					System.out.println("\n>> AÑADIR LIBRO");
					System.out.print("Introduce el título del libro: ");
					titulo = teclado.nextLine().trim();

					if (buscarLibro(titulo) != -1) {
						System.out.println("El libro '" + titulo + "' ya está registrado.");
					} else {
						System.out.print("Introduce el autor: ");
						autor = teclado.nextLine().trim();
						
						try {
							System.out.print("Introduce el número de páginas: ");
							paginas = Integer.parseInt(teclado.nextLine().trim());
							
							listaLibros.add(new Libro(titulo, autor, paginas));
							guardarLista();
							System.out.println("Libro guardado con éxito.");
						} catch (NumberFormatException e) {
							System.out.println(">> ERROR: Las páginas deben ser un número entero. Operación cancelada.");
						}
					}
					break;

				case 2: // LISTAR LIBROS
					System.out.println("\n>> MOSTRAR LIBROS");
					if (listaLibros.isEmpty()) {
						System.out.println("No hay libros registrados.");
					} else {
						for (Libro l : listaLibros) {
							System.out.println(l);
						}
					}
					break;

				case 3: // MODIFICAR DATOS (TOTALMENTE PROTEGIDO)
					System.out.println("\n>> MODIFICAR DATOS");
					System.out.print("Introduce el título del libro a modificar: ");
					titulo = teclado.nextLine().trim();

					int res = buscarLibro(titulo);

					if (res == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						System.out.println("\n¿Qué dato deseas modificar para el libro '" + titulo + "'?");
						System.out.println("1 - Cambiar Autor");
						System.out.println("2 - Cambiar Número de páginas");
						System.out.print("Selecciona una opción (1 o 2): ");
						
						try {
							int subOpcion = Integer.parseInt(teclado.nextLine().trim());

							if (subOpcion == 1) {
								System.out.print("Introduce el NUEVO autor: ");
								autor = teclado.nextLine().trim();
								listaLibros.get(res).setAutor(autor);
								System.out.println("Autor modificado con éxito.");
								guardarLista(); 
							} else if (subOpcion == 2) {
								try {
									System.out.print("Introduce el NUEVO número de páginas: ");
									paginas = Integer.parseInt(teclado.nextLine().trim());
									listaLibros.get(res).setPaginas(paginas);
									System.out.println("Número de páginas modificado con éxito.");
									guardarLista(); 
								} catch (NumberFormatException e) {
									System.out.println(">> ERROR: Has introducido letras en las páginas. No se ha modificado nada.");
								}
							} else {
								System.out.println("Opción del submenú no válida. Cancelando operación.");
							}
						} catch (NumberFormatException e) {
							System.out.println(">> ERROR: Debes introducir un número (1 o 2) en el submenú.");
						}
					}
					break;

				case 4: // ELIMINAR LIBRO
					System.out.println("\n>> ELIMINAR LIBRO");
					System.out.print("Título del libro a eliminar: ");
					titulo = teclado.nextLine().trim();
					int res2 = buscarLibro(titulo);

					if (res2 == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						listaLibros.remove(res2);
						System.out.println("El libro '" + titulo + "' ha sido eliminado.");
						guardarLista();
					}
					break;

				case 5: // BUSCAR UN LIBRO
					System.out.println("\n>> BUSCAR UN LIBRO");
					System.out.print("Introduce el título a buscar: ");
					titulo = teclado.nextLine().trim();
					
					int res3 = buscarLibro(titulo);
					
					if (res3 == -1) {
						System.out.println("No se ha encontrado el libro '" + titulo + "'.");
					} else {
						System.out.println("Libro encontrado: " + listaLibros.get(res3));
					}
					break;

				case 6: // Salir
					System.out.println("¡Hasta luego!");
					break;
				default:
					System.out.println("\n>> Opción elegida no válida");
				}

			} catch (NumberFormatException e) {
				System.out.println("\n>> ERROR: Por favor, introduce un número válido para las opciones del menú.");
				// Ponemos opcion en 0 para asegurarnos de que el do-while no se rompa y vuelva a mostrar el menú
				opcion = 0; 
			} catch (Exception e) {
				System.out.println("\n>> Ha ocurrido un error inesperado: " + e.getMessage());
				opcion = 0;
			}

		} while (opcion != 6);

		teclado.close();
	}
}