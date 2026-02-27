package rejog;

public class TimeCorregido {
	
	private int hours;
	private int minutes;
	private int seconds;
	/**
	 * 
	 */
	public TimeCorregido() {
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	/**
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public TimeCorregido(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	
	public boolean isValid() {
		if (hours < 0 || hours > 23)
			return false;
		if (minutes < 0 || minutes >59)
			return false;
		if (seconds < 0 || seconds > 59)
			return false;
		return true;
			
	}

	/**
	 * Método que formatea la hora
	 */
	public String toString() {
		String res = "";
		
		if (hours < 10)
			res += "0";
		res += hours;
		res += ":";
		if (minutes < 10)
			res += "0";
		res += minutes;
		res += ":";
		if (seconds < 10)
			res += "0";
		return res;
	}
	
	
}
