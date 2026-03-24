package extendsEjemplo;

public class Test {

	public static void main(String[] args) {

		Cuadrado c = new Cuadrado(5);
		
		System.out.println("Lado del cuadrado: "+c.getLado());
		c.setColor("Verde");
		System.out.println("Color del cuadrado: "+c.getColor());

	}

}
