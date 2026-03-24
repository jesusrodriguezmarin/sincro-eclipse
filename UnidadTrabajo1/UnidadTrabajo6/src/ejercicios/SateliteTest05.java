package ejercicios;

public class SateliteTest05 {

	public static void main(String[] args) {
		// Creamos un objeto Satélite sin parámetros
		Satelite05 s = new Satelite05();
		
		// Creamos un objeto Satélite con parámetros
		Satelite05 v = new Satelite05(5.5, 10, 20.60);
		
		// Llamamos al método setPosicion para establecer la posición de s
		s.setPosicion(0.5, 5.0, 0);
		
		// Lamamos al método printPosicion para ver la situción de ambos satélites
		s.printPosicion();
		v.printPosicion();
		
		// Llamamos al método variaAltura para indicar un desplazamiento
		// Nos mostrará como ha afectado a su distancia de la Tierra
		s.variaAltura(5);
		v.variaAltura(-20.60);
		s.printPosicion();
		v.printPosicion();
		
		// Llamamos al método enOrbita para ver si el satélite está en la tierra
		if (s.enOrbita()) {
			System.out.println("No está en la tierra");
		} else {
			System.out.println("Si está en la tierra");
		}
		
		if (v.enOrbita()) {
			System.out.println("No está en la tierra");
		} else {
			System.out.println("Si está en la tierra");
		}
		

		// Llamamos al método variaPosicion para variar el meridiano y paralelo del satélite
		s.variaPosicion(-10, 25);
		v.variaPosicion(45, -50);
		s.printPosicion();
		v.printPosicion();
	}

}
