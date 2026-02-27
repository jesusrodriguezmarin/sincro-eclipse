package ejemplos1;

public class TotalSegundos {

	public static void main(String[] args) {
		
		// Declaración de variabñles
		int h, m, s;
		int total;
		
		// Realizamos los cálculos y mostramos por consola
		h=0; m=0; s=1;
		total=3600*h+60*m+s;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+total+" segundos");
		
		h=1; m=5; s=55;
		total=3600*h+60*m+s;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+total+" segundos");
		
		h=3; m=15; s=21;
		total=3600*h+60*m+s;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+total+" segundos");
		
		h=0; m=59; s=59;
		total=3600*h+60*m+s;
		System.out.println(h+" horas "+m+" min "+s+" seg --> Total: "+total+" segundos");
	}

}
