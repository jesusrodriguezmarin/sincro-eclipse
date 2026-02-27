package ejemplos1;

public class Dado {

	public static void main(String[] args) {

		// Declaración de datos
		int res;
		
		// Cálculamos el resultado de la tirada
		res=(int)(Math.random()*6+1);
		
		// Resultado de 6 tiradas
		System.out.println("Primera tirada dado: "+res);
		res=(int)(Math.random()*6+1);
		System.out.println("Segunda tirada dado: "+res);
		res=(int)(Math.random()*6+1);
		System.out.println("Tercera tirada dado: "+res);
		res=(int)(Math.random()*6+1);
		System.out.println("Cuarta tirada dado: "+res);
		res=(int)(Math.random()*6+1);
		System.out.println("Quinta tirada dado: "+res);
		res=(int)(Math.random()*6+1);
		System.out.println("Sexta tirada dado: "+res);
	}

}
