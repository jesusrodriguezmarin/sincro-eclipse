package examenRecuperacionUt4;

public class Time {

	private int hours;
	private int minutes;
	
	/**
	 * Constructor sin parámetros
	 * @param hours
	 * @param minutes
	 */
	public Time() {
		hours = 00;
		minutes = 00;
	}
	
	/**
	 * Constructor
	 * @param hours
	 * @param minutes
	 */
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}

	/**
	 * Muestra las horas
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * Establece las horas
	 * @param hours the hours to set
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}

	/**
	 * Muestra los minutos
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Establece los minutos
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	/**
	 * Función que valida las horas
	 * @return true si son correctas, false si no lo son
	 */
	public boolean isValid() {
		if (hours < 0 || hours > 23)
			return false;
		if (minutes < 0 || minutes > 59)
			return false;
		return true;
	}

	/**
	 * Convierte las horas a cadena de carácteres en formato 00:00
	 * determina tambien el formato am/pm
	 */
	@Override
	public String toString() {
		String format = "";
		if (hours < 10)
			format += "0";
		format += hours+":";
		if (minutes < 10)
			format += "0";
		format += minutes;
		return format;
	}
	
	
}
