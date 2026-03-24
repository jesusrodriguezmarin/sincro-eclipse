package ejemplos3;

public class CastingLetra {

	public static void main(String[] args) {

		// Declaración de variables
		int num;
		char letra;
		
		// Asignación de valores
		letra='A';
		num=letra;
		System.out.println(letra);			// A
		
		// Casting implícito
		System.out.println(num);			// 65 (porque se transforma a ASCII, número asignado a la tecla)
		
		// Casting explícito
		System.out.println((char)(num+1));	// (char)66 --> B (caracter '65' + 1 = 66 = B en ASCII)
		System.out.println((char)97);		// a


		
		
	}

}
