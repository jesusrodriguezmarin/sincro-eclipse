package ejercicios;

public class Satelite05 {

	// Atributos
	private double meridiano;
	private double paralelo;
	private double distancia_tierra;

	/**
	 * Constructor con parámetros
	 * @param m - meridiano
	 * @param p - paralelo
	 * @param d - distancia de la tierra
	 */
	Satelite05(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		distancia_tierra = d;
	}

	/**
	 * Constructor sin parámetros que inicializa todos a 0
	 */
	Satelite05() {
		meridiano = paralelo = distancia_tierra = 0;
	}

	/**
	 * Establece la posición del satélite
	 * @param m - meridiano
	 * @param p - paralelo
	 * @param d - distancia de la tierra
	 */
	public void setPosicion(double m, double p, double d) {
		meridiano = m;
		paralelo = p;
		distancia_tierra = d;
	}

	/**
	 * Visualiza la posición de la tierra
	 */
	public void printPosicion() {
		System.out.println("El satelite se encuentra en ");
		System.out.println("el paralelo "+paralelo+" meridiano "+meridiano);
		System.out.println(" a una distancia de la Tierra de "+distancia_tierra+" kms.");
	}
	
	/**
	 * Varía la distancia a la Tierra del satélite según un desplazamiento
	 * Un valor positivo de desplazamiento aleja el satélite de la Tierra
	 * Un valor negativo lo acerca
	 * @param des - desplazamiento
	 */
	public void variaAltura(double des) {
		distancia_tierra+=des;
	}
	
	/**
	 * Indica si el satélite está en la tierra o no
	 * @return false si el satélite está en la tierra, true si o lo está
	 */
	public boolean enOrbita() {
		if (distancia_tierra==0)
			return false;
		return true;
	}
	
	/**
	 * Modifica la posición del satélite 
	 * @param variap - variación del paralelo
	 * @param variam - variación del meridiano
	 */
	public void variaPosicion(double variap, double variam) {
		paralelo+=variap;
		meridiano+=variam;
	}
}
