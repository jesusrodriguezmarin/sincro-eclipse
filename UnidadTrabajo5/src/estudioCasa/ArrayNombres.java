package estudioCasa;

public class ArrayNombres {

	public static void orden(String[] a) {
		String aux;
		for (int i=a.length-1; i>=0; i--) {
			for (int j=0; j<i; j++) {
				if (a[j].compareTo(a[j+1])>0) {
					aux = a[j];
					a[j]=a[j+1];
					a[j+1]=aux;
				}
			}
		}
	}
	
	/**
	 * Procedimiento que muestra todos los elementos de un array de String
	 * @param a - array de String
	 */
	public static void muestra(String[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	// Programa principal
	public static void main(String[] args) {
		
		// Creamos el array
		String[] array = {"Pablo Mato", "Perro Sache", "Mos Tacho"};
		
		// Mostramos el array
		muestra(array);
		
		// Ordenamos el array
		orden(array);
		
		System.out.println();
		
		// Mostramos ordenado
		muestra(array);
		

	}

}
