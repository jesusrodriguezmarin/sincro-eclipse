package ejemplos.equipos;

public class EquipoTest {

	public static void main(String[] args) {
		// creamos un objeto equipo
		// usando la clase Equipo, creamos el objeto e1, e2, e3, e4...
		Equipo e1 = new Equipo(1,"UCAM Murcia","Murcia","Palacio de los Deportes");
		Equipo e2 = new Equipo(2,"Real Madrid","Madrid","Movistar Arena");
		Equipo e3 = new Equipo(3,"Valencia Basket","Valencia","Roig Arena");
		Equipo e4 = new Equipo(4,"FC Barcelona","Barcelona","Palau Blaugrana");
		
		// mostramos la informacion de cada equipo
		// llamamos al procedimiento de la clase Equipo
		e1.mostrarEquipo();
		e2.mostrarEquipo();
		e3.mostrarEquipo();
		e4.mostrarEquipo();
		
		// cambiamos el valor de algunos atributos y mostramos "solo" los cambios
		// para eso hemos creado los getters
		e1.setCiudad("Alguazas");
		System.out.println("Equipo "+e1.getCodigo()+" - Ciudad: "+e1.getCiudad());
		
		
		e4.setPabellon("Pabellon de Alguazas");
		System.out.println("Equipo "+e4.getCodigo()+" - Pabellon: "+e4.getPabellon());
		
		e2.setNombre("Real Alguazas");
		System.out.println("Equipo "+e2.getCodigo()+" - Nombre: "+e2.getNombre());

	}

}
