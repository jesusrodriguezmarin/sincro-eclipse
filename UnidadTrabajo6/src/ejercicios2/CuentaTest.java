package ejercicios2;

public class CuentaTest {

	public static void main(String[] args) {

		// 1. Creamos una instancia Cuenta
		Cuenta c = new Cuenta("Juan Pérez", 500.50);

		// Mostramos saldo
		System.out.println(c);

		// 2. Realizamos un ingreso de 250€
		c.ingresar(250);
		// Mostramos saldo
		System.out.println(c);

		// 3. Intentamos un ingreso negativo -100€
		c.ingresar(-100);
		// Mostramos saldo
		System.out.println(c);

		// 4. Retiramos 300€
		c.retirar(300);
		// Mostramos saldo
		System.out.println(c);

		// 5. Mostramos0
		// Mostramos saldo
		System.out.println(c);

		// 6. Retiramos 1000€
		c.retirar(1000);
		// Mostramos saldo
		System.out.println(c);

		// 7. Cambiamos de titular
		c.setTitular("María Pérez");
		// Mostramos saldo
		System.out.println(c);
		
		// 8. Mostramos la información con getter
		System.out.println("La cuenta de "+c.getTitular()+" contiene "+ c.getCantidad()+" euros");
	}

}
