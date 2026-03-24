package ejemplos.estudiantes;

public class Estudiante {
	
	private String nombre;	// nombre del alumno
	private int nota1;		// nota obtenida en la 1ª evaluación
	private int nota2;		// nota obtenida en la 2ª evaluación
	private int nota3;		// nota obtenida en la 3ª evaluación
	
	/**
	 * @param nombre - String nota del alumno
	 * @param nota1 - nota obtenida en la 1ª evaluación
	 * @param nota2 - nota obtenida en la 2ª evaluación
	 * @param nota3 - nota obtenida en la 3ª evaluación
	 */
	public Estudiante(String nombre, int nota1, int nota2, int nota3) {
		this.nombre = nombre;
		this.nota1 = validarNota(nota1);
		this.nota2 = validarNota(nota2);
		this.nota3 = validarNota(nota3);
	}
	
	/**
	 * Valida la nota para que se encuentre entre 0 y 10
	 * @param nota (int) - nota que queremos validar
	 * @return nota si se encuentra en el rango 0..10,
	 * 0 si la nota es menor que 0, 10 si lo nota es mayor que 10
	 */
	private int validarNota(int nota) {
		if (nota < 0)
			return 0;
		if (nota > 10)
			return 10;
		return nota;
	}
	
	// GETTERS
	
	/**
	 * Devuelve el nombre...
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la nota obtenida en la 1ª evaluación
	 * @return (int) - Nota 1ª evaluación
	 */
	public int getNota1() {
		return nota1;
	}
	
	
	public int getNota2() {
		return nota2;
	}
	
	
	public int getNota3() {
		return nota3;
	}

	
	// SETTERS
	
	/**
	 * Establece el nombre del alumno
	 * @param nombre (String) - nombre del alumno
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

	/**
	 * Establece la nota de la 1ª evaluación
	 * @param nota1 (int) - Nota a establecer para la 1ª evaluación
	 */
	public void setNota1(int nota1) {
		this.nota1 = validarNota(nota1);
	}
	

	/**
	 * Establece la nota...
	 * @param nota2
	 */
	public void setNota2(int nota2) {
		this.nota2 = validarNota(nota2);
	}
	

	public void setNota3(int nota3) {
		this.nota3 = validarNota(nota3);
	}
	
	public double calcularPromedio() {
		return (nota1+nota2+nota3)/3.0;
	
	}
	
	public void mostrarEstudiante() {
		System.out.println("Estudiante: "+nombre);
		System.out.println("Nota primera evaluación: "+nota1);
		System.out.println("Nota segunda evaluación: "+nota2);
		System.out.println("Nota tercera evaluación: "+nota3);
		System.out.println("Promedio: "+calcularPromedio()+"\n");
	}
	
		/**
		 * Determina si un estudiante aprueba el curso
		 * @return true si la nota promedio es igual o superior a 5, false en otro caso
		 */
		public boolean aprueba () {
			return (calcularPromedio() >= 5);
			
	}	
	
}
