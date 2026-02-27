package ejemplos.equipos;

public class JugadorTest {

	public static void main(String[] args) {
		// Crear varios objetos jugador
		// 1.Llamamos a la clase por su nombre Jugador
		// 2.Declaramos con nuevo nombre jug1, jug2...
		// 3.Inicializamos llamando al constructor con new y el nombre del constructor
		// Nombre del constructor igual que el nombre de la clase Jugador
		Jugador jug1 = new Jugador(1, "Pau Gasol", 2.16, 300000);
		Jugador jug2 = new Jugador(2, "Marc Gasol", 2.12, 250000);
		Jugador jug3 = new Jugador(3, "Jaycee Carrol", 1.88, 120000);
		Jugador jug4 = new Jugador(4, "LeBron James", 2.06, 500000);
		
		// mostrar los datos de los jugadores
		jug1.mostrarJugador();
		jug2.mostrarJugador();
		jug3.mostrarJugador();
		jug4.mostrarJugador();
		
		// subimos 10.000 el salario de Pau Gasol
		int sueldoPauGasol = jug1.getSueldo();
		jug1.setSueldo(sueldoPauGasol+10000);
		jug1.mostrarJugador();
		
		// bajar 15.000 euros el salario del jugador 4
		int sueldoLeBronJames = jug4.getSueldo();
		jug4.setSueldo(sueldoLeBronJames-15000);
		jug4.mostrarJugador();
		
		// ponemos la misma altura para el jugador 1 y 2 (la más alta)
		double alturaJ1 = jug1.getAltura();
		double alturaJ2 = jug2.getAltura();
		
		if (alturaJ1 > alturaJ2)
			jug2.setAltura(alturaJ1);
		else
			jug1.setAltura(alturaJ2);
		
		// mostramos
		jug1.mostrarJugador();
		jug2.mostrarJugador();
		
		// el jugador 3 va a cobrar el doble que el jugador 2
		jug3.setSueldo(jug2.getSueldo()*2);
		jug3.mostrarJugador();
		
		// mostramos
		jug3.mostrarJugador();
		jug2.mostrarJugador();
		
	}

}
