package strings.arrays;

public class abecedario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 65; i < 91; i++) {
			System.out.print((char) i);
		}

		System.out.println();

		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print((char) i);
		}

		System.out.println("Encriptado CESAR3");

		int caracter;
		for (int i = 'A'; i <= 'Z'; i++) {
			caracter=i+3;
			if ((char)caracter > 'Z')
				caracter-=26;
			System.out.print((char)caracter);
		}
	}

}
