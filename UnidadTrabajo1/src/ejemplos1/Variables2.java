package ejemplos1;

public class Variables2 {

	public static void main(String[] args) {
		//VARIABLES
		int num; 				//Declaracion
		
		num=10; 				//Inicializacion
		
		System.out.println(num); //Imprime 10
		
		int numero=20; 			//Declaracion e inicializacion en la misma linea
		
		System.out.println(numero); //Imprime 20
		
		num=numero; 			//Asignacion
	
		System.out.println(num); //Imprime 20 porque num=numero
		
		num=num+1;  			
		
		System.out.println(num); //Imprime 21
	}

}