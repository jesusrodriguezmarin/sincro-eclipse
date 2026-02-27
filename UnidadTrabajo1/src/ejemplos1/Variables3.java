package ejemplos1;

public class Variables3 {

	public static void main(String[] args) {
int num=3; //Declaracion e Inicializacion 
		
		num=num+10;
		
		System.out.println(num);	//13
		
		num=num-5;
		
		System.out.println(num);	//8
		
		System.out.println(num-3); 	//<--- Es 5 pero NO se guarda en memoria porque no esta declarado  
		
		System.out.println(num); 	//8
	}

}
