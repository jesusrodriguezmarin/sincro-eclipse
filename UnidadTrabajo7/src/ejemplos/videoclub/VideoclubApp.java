package ejemplos.videoclub;

public class VideoclubApp {

	public static void main(String[] args) {

		// Creamos diferentes instancias de serie y videojuego
		Serie s[] = new Serie[2];
		s[0] = new Serie();
		s[1] = new Serie("Batman", 2, "accion", "marvel", false);
		
		s[1].entregar();

		int prestadoS = 0;
		int disS = 0;
		
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i].toString());
			
			if (s[i].isPrestado()) {
				System.out.println("Prestado");
				prestadoS++;
			} else {
				System.out.println("Disponible");
				disS++;
			}
		}

		Videojuego v[] = new Videojuego[2];
		v[0] = new Videojuego();
		v[1] = new Videojuego("Sonic", 14, "way", "snoopy", true);
		
		v[1].devolver();

		int prestadoV = 0;
		int disV = 0;
		
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i].toString());
			
			if (v[i].isPrestado()) {
				System.out.println("Prestado");
				prestadoV++;
			} else {
				System.out.println("Disponible");
				disV++;
			}
		}
		System.out.println("Series prestadas: "+prestadoS+". Series disponibles: "+disS);
		System.out.println("Videojuegos prestados: "+prestadoV+". Videojuegos disponibles: "+disV);
	}

}
