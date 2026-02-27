package ejemplos2;

public class IncrementoDecremento {

	public static void main(String[] args) {
		
		// Declaramos e inicializamos
		int x=3, y=8;
		
		// Realizamos las operaciones y mostramos por pantalla
		System.out.println("x="+x+"y="+y);	// x=3 y=8
		x++;								// x=x+1
		y--;								// y=y-1
		System.out.println("x="+x+"y="+y);	// x=4 y=7
		++x;								// x=x+1
		--y;								// y=y-1
		System.out.println("x="+x+"y="+y);	// x=5 y=6
		x+=y;								// x=x+y;
		System.out.println("x="+x+"y="+y);	// x=11 y=6
		x-=3;								// x=x-3
		System.out.println("x="+x+"y="+y);	// x=8 y=6
		x-=y+1;								// x=x-(y+1)=1
		System.out.println("x="+x+"y="+y);	// x=3 y=8
		x=++y;								// y=y+1 --> y=7; x=y=7.
		System.out.println("x="+x+"y="+y);	// x=7 y=7
		x=y++;								// x=y --> x=7; yÇ=y+1=8.
		System.out.println("x="+x+"y="+y);	// x=7 y=8
				

		
	}

}
