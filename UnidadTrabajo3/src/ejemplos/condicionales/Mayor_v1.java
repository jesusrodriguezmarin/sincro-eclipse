package ejemplos.condicionales;

public class Mayor_v1 {

	public static void main(String[] args) {
		// Declaración e inicialización de la variable
		int mates=4, lengua=6;
		
		// Condicional simple
		if (mates>=5 && lengua>= 5) {
			System.out.println("Has aprobado las dos asignaturas");
		} else if (mates>=5) {
			System.out.println("Has aprobado solo matematicas");
		}  else if (lengua >=5) {
		System.out.println("Has aprobado solo lengua");
		} else {
		System.out.println("No has aprobado ninguna asignatura");
		}
	
	}
}