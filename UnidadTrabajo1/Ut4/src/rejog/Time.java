package rejog;

public class Time {

		private int hours;
		private int minutes;
		private int seconds;
		
		
		/**
		 * Constructor sin parámetros
		 * @param hours 
		 * @param minutes
		 * @param seconds
		 */
		public Time() {
			hours = 00;
			minutes = 00;
			seconds = 00;
		}
		
		/**
		 * Constructor con parámetros
		 * @param hours
		 * @param minutes
		 * @param seconds
		 */
		public Time(int hours, int minutes, int seconds) {
			this.hours = hours;
			this.minutes = minutes;
			this.seconds = seconds;
		}

		/**
		 * Devuelve las horas en el relog
		 * @return las horas
		 */
		public int getHours() {
			return hours;
		}

		/**
		 * Establece las horas en el relog
		 * @param hours horas establecidas
		 */
		public void setHours(int hours) {
			this.hours = hours;
		}

		/**
		 * Devuelve los minutos en el relog
		 * @return los minutos
		 */
		public int getMinutes() {
			return minutes;
		}

		/**
		 * Establece los minutos en el relog
		 * @param minutes
		 */
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}

		/**
		 * Devuelve los segundos en el relog
		 * @return los segundos
		 */
		public int getSeconds() {
			return seconds;
		}

		/**
		 * Establece los segundos en el relog
		 * @param seconds
		 */
		public void setSeconds(int seconds) {
			this.seconds = seconds;
		}
		
		/**
		 * Método que comprueba la hora
		 */
		public void isValid() {
		if (hours >= 0 && hours <= 23) {
			if (minutes >= 0 && minutes <= 59) {
				if (seconds >= 0 && seconds <=59)
					System.out.println("\n>> Hora introducida: "+hours+":"+minutes+":"+seconds);
				else
					System.out.print("\n>> No es una hora correcta.");
			} else 
				System.out.print("\n>> No es una hora correcta.");
		} else
			System.out.print("\n>> No es una hora correcta.");
		}
		/**
		 * Devuelve una cadena de caracteres que representa la fraccion
		 */
		public String toString() {
			if (hours < 10)
				return "0"+hours;
			if (minutes < 10)
				return "0"+minutes;
			if (seconds < 10)
				return "0"+seconds;
			return hours+"/"+hours+"/"+seconds;
		}
}
