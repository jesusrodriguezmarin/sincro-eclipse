package matrices.ejercicios;

public class Ej00pruebasMatriz {

	// Constante para la cantidad de filas de una matriz
	final static int FILAS=3;
	
	// Constante para la cantidad de columnas de una matriz
	final static int COLUMNAS=5;
	
	/**
	 * Muestra todos los elementos de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrar(int M[][]) {
		// Recorremos la fila para recorrer todas las columnas que hay en ella
		for (int fila=0; fila<M.length; fila++) {
			// Recorremos las columnas por cada fila
			for (int col=0; col<M[fila].length; col++) {
				System.out.print(M[fila][col]+"\t");
			}
			// Salto para imprimir la siguiente fila
			System.out.println();
		}
		// Salto para separar del próximo procedimiento del main
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra solo los valores de la primera fila de la matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrarfila(int M[][]) {
		// Recorremos solo la primera fila
		for (int f=0; f<1; f++) {
			// Recorremos todas las columnas de la primera fila
			for (int c=0; c<M[f].length; c++) {
				System.out.print(M[f][c]+"\t");
			}
			// Salto de fila
			System.out.println();
		}
		// Salto de procedimiento
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra solo los valores de la primera columna de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrarcolumna(int M[][]) {
		// Recorremos todas las filas
		for (int f=0; f<M.length; f++) {
			// Recorremos solo la primera columna
			for (int c=0; c<1; c++) {
				System.out.print(M[f][c]+"\t");
			}
			// Salto para recorrer la siguiente fila
			System.out.println();
		}
		// Salto de procedimiento en el main
		System.out.println();
	}
	
	// Alternativa para mostar solo la primera columna sin bucles anidados
	public static void mostrarPrimeraColumna(int M[][]) {
		// Recorremos las filas una a una
		for (int f=0; f<M.length; f++) {
			// Mostramos utilizando las iteraciones de f para las filas 
			// especificando la primera columna con [0] sin necesidad de otro bucle
			System.out.println(M[f][0]);
		}
		// Salto de fila
		System.out.println();
	}
	
	/**
	 * Procedimiento que muestra solo la última fila de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrarUfila(int M[][]) {
		// Recorremos solo la última fila
		for (int f=M.length-1; f>M.length-2; f--) {
			// Recorremos todas las columnas de esa fila
			for (int c=0; c<M[f].length; c++) {
				System.out.print(M[f][c]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// Alternativa a dos bucles anidados para mostrar solo la última fila
	/**
	 * Procedimiento que muestra solo los valores de la última fila de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mUfila(int M[][]) {
		for (int c=0; c<M[M.length-1].length; c++) {
			System.out.print(M[M.length-1][c]+"\t");
		}
		System.out.println();
	}
	
	// Alternativa declarando un int para las posiciones de la última fila de la matriz
	public static void mU(int M[][]) {
		// Última fila de la matriz
		int f=M.length-1;
		
		// Recorremos las columnas hasta el largo de las filas
		for (int c=0; c<M[f].length; c++) {
			// Imprimomos las iteraciones de las columnas centradas en la última fila
			System.out.print(M[f][c]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * Procedimiento que aumenta en 1 la primera fila de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void iFila1(int M[][]) {
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				if (f==0 && c!=0 && c!=4) {
					M[f][c]++;
				}
			}
		}
	}
	
	/**
	 * Procedimiento que incrementa en 1 la última fila de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void iFilaU(int M[][]) {
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				if (f==M.length-1 && c!=0 && c!=4) {
					M[f][c]++;
				}
			}
		}
	}
	
	/**
	 * Procedimiento que incrementa en 1 la primera columna de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void iCol1(int M[][]) {
		for (int f=0; f<M.length; f++) {
				M[f][0]++;
			}
	}
	
	/**
	 * Procedimiento que muestra todos los valores de la primera columna de una matriz
	 * @param M - matriz de números enteros
	 */
	public static void mostrarcol1(int M[][]) {
		for (int f=0; f<M.length; f++) {
			System.out.println(M[f][0]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * Procedimiento que incrementa en 1 los elemntos de la última columna
	 * @param M- matriz de númros enteros
	 */
	public static void i1u(int M[][]) {
		for (int f=0; f<M.length; f++) {
			M[f][M[f].length-1]++;
		}
	}
	
	public static void muc(int M[][]) {
		for (int f=0; f<M.length; f++) {
			System.out.println(M[f][M[f].length-1]+"\t");
		}
		System.out.println();
	}
	
	/**
	 * Procedimiento que incrementa en 1 todos los elementos de la fila de enmedio de una matriz
	 * @param M - matriz de número enteros
	 */
	public static void i2(int M[][]) {
		// Recorremos la matriz completa
		for (int f=0; f<M.length; f++) {
			for (int c=0; c<M[f].length; c++) {
				if (f==1 && c!=0 && c!=4) {
					M[f][c]++;
				}
			}
		}
		System.out.println();
	}
	
	/**
	 * Procediminto que muestra la segunda fila completa de una matriz
	 * @param M -  matriz de números enteros
	 */
	public static void m2(int M[][]) {	
		// Variable para el tamaño total de filas de la matriz
		// para usar en el bucle de las columnas
		int f=M.length-1;
		
		// Recorremos todas las columnas de la fila 2, [1]
		for (int c=0; c<M[f].length; c++) {
			// Imprimimos todas las iteraciones de columnas en la posición segunda de filas
			System.out.print(M[1][c]+"\t");
		}
		System.out.println();
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos una matriz cuadrada
		int M[][]= new int[FILAS][COLUMNAS];
		
		// Mostramos los valores iniciales
		System.out.println("Matriz con los valores sin inicializar:");
		mostrar(M);	
		
		// Incrementamos en 1 la primera fila
		System.out.println("Incrementamos la primera fila [0]: ");
		iFila1(M);
		
		// Mostramos solo la primera fila
		mostrarfila(M);
		
		// Incrementamos en 1 la última fila
		System.out.println("Incrementamos la última fila: ");
		iFilaU(M);
		
		// Mostramos la última fila
		mostrarUfila(M);
		

		// Incrementamos 1 la primera columna
		System.out.println("Incrementamos la primera columna: ");
		iCol1(M);
		
		// Mostramos los valores de la primera columna
		mostrarcol1(M);
		
		// Incrementamos en 1 los valores de la última columna
		i1u(M);
		System.out.println("Incrementamos la última columna: ");
		
		muc(M);
		
		// Incrementamos la fila de enmedio de la matriz
		System.out.println("Incrementamos la fila central: ");
		i2(M);
		
		// Mostramos la fila de enmedio de la matriz
		m2(M);
		
		System.out.println();
		// Mostramos la matriz actual completa
		System.out.println("Mostramos la matriz completamente incrementada: ");
		mostrar(M);
		
		
	}

}
