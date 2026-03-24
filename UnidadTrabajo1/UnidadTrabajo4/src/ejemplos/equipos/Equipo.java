package ejemplos.equipos;

public class Equipo {
	// Atributos (plantilla)
	public int codigo;			// código del equipo
	private String nombre;		// nombre del equipo
	private String ciudad;		// ciudad en la que juega el equipo
	private String pabellon;	// nombre del pabellon donde juega el equipo
	
	// Constructor (para poder usar)
	/**
	 * Constructor del Equipo
	 * @param cod - codigo del equipo (integer)
	 * @param nom - nombre del equipo (String)
	 * @param ciu - ciudad del equipo (String)
	 * @param pab - pabellon donde juega el equipo (String)
	 */
	public Equipo(int cod, String nom, String ciu, String pab) {
		codigo=cod;
		nombre=nom;
		ciudad=ciu;
		pabellon=pab;
	}
	
	// GETTERS
	
	/**
	 * Devuelve el codigo del equipo
	 * @return - el código del equipo
	 */
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Devuelve el nombre del equipo
	 * @return - el nombre del equipo
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve el ciudad del equipo
	 * @return - el ciudad del equipo
	 */
	public String getCiudad() {
		return ciudad;
	}
	
	/**
	 * Devuelve el pabellon del equipo
	 * @return - el pabellon del equipo
	 */
	public String getPabellon() {
		return pabellon;
	}
	
	// SETTERS	(para establecer cambios)
	
	/**
	 * Establece el código del equipo
	 * @param valor - nuevo código del equipo
	 */
	public void setCodigo(int valor) {
		codigo=valor;
	}
	
	/**
	 * Establece el nombre del equipo
	 * @param valor - nuevo nombre del equipo
	 */
	public void setNombre(String valor) {
		nombre=valor;
	}
	
	/**
	 * Establece la ciudad del equipo
	 * @param valor - nueva ciudad del equipo
	 */
	public void setCiudad(String valor) {
		ciudad=valor;
	}
	
	/**
	 * Establece el pabellon del equipo
	 * @param valor - nuevo pabellon del equipo
	 */
	public void setPabellon(String valor) {
		pabellon=valor;
	}
	
	// para poder mostrar
	/**
	 * Procedimiento que muestre por pantalla toda la info referente a un equipo
	 */
	public void mostrarEquipo() {
		System.out.println("Equipo: "+codigo);
		System.out.println("Nombre: "+nombre);
		System.out.println("Ciudad: "+ciudad);
		System.out.println("Pabellon: "+pabellon+"\n");
	}
	
}
