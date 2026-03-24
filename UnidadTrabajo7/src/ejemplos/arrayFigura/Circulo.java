package ejemplos.arrayFigura;

public class Circulo  extends ArrayFigura {

	// Atributo
	protected double radio;
	
	// Constructor
	public Circulo(double radio) {
		this.radio=radio;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return radio * radio * Math.PI;
	}

	

}
