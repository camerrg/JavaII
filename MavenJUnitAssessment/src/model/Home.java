package model;

public class Home {
	
		private int numHomes;
		private double power;
		private int windMill;
		
		
		public Home() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Home(int numHomes, double power,  int windMill) {
			super();
			this.numHomes = numHomes;
			this.power = power;
			this.windMill = windMill;
		}

		public int getNumHomes() {
			return numHomes;
		}

		public void setNumHomes(int numHomes) {
			this.numHomes = numHomes;
		}

		public double getPower() {
			return power;
		}

		public void setPower(double power) {
			this.power = power;
		}

		public int getWindMill() {
			return windMill;
		}

		public void setWindMill(int windMill) {
			this.windMill = windMill;
		}

		@Override
		public String toString() {
			return "Home [numHomes=" + numHomes + ", power=" + power + " kw, windMill=" + windMill + "]";
		}
		
		
		
		
		
		
		

}
