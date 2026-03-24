package ejemplos.empleados;

public class EmpleadosApp {

	public static void main(String[] args) {

		// Creamos diferentes empleados
		Empleados e[] = new Empleados[4];

		e[0] = new Comercial("Mark Knofler", 100, 100000.00, 500);
		e[1] = new Comercial("Roberto Iniesta", 20, 50000.00, 100);
		e[2] = new Repartidor("Angus Young", 20, 150000.00, "Zona 3");
		e[3] = new Repartidor("Uhoho Anton", 50, 20000.00, "zona 4");

		for (int i = 0; i < e.length; i++) {
			if (e[i].plus()) {
				System.out.println(e[i].toString());
				System.out.println("Recibe PLUS");
			} else {
				System.out.println(e[i].toString());
				System.out.println("No recibe PLUS");
			}

		}
	}

}
