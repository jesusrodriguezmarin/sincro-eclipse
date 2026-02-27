package ejemplos1;

public class TablaMultiplicar2 {
	
	/**
	 * Procedimiento que muestra la tabla de multiplicar de un número num
	 * @param num - numero entero que le muestro a la tablaMul para multiplicar
	 */
	public static void tablaMul(int num) {

		// Tabla de multiplicar
		System.out.println(num+" x 1 = "+(num*1));
		System.out.println(num+" x 2 = "+(num*2));
		System.out.println(num+" x 3 = "+(num*3));
		System.out.println(num+" x 4 = "+(num*4));
		System.out.println(num+" x 5 = "+(num*5));
		System.out.println(num+" x 6 = "+(num*6));
		System.out.println(num+" x 7 = "+(num*7));
		System.out.println(num+" x 8 = "+(num*8));
		System.out.println(num+" x 9 = "+(num*9));
		System.out.println(num+" x 10 = "+(num*10)+"\n");	// Salto de linea con +"\n" 
	}
	
	public static void main(String[] args) {
		tablaMul(1);
		tablaMul(2);
		tablaMul(3);
		tablaMul(10);
		
	}

}
