package model;

public class InchesFeetConverter {
	
	private double inches;
	private int feet;
	
	public InchesFeetConverter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InchesFeetConverter(double inches) {
		super();
		this.inches = inches;
		setMeasure(inches);		
	}
	
	public InchesFeetConverter (int feet) {
		super();
		this.feet = feet;
		setFootage(feet);
	}
	
	public void setInches(double inches) {
		this.inches = inches;
		
	}
	
	public void setFeet(int feet) {
		this.feet = feet;
		
	}

	public double getInches() {
		return inches;
	}

	public int getFeet() {
		return feet;
	}
	
	public void setMeasure (double inches) {
		final double FOOT = 12.0;
		
		
		
		setInches(inches/FOOT);		
	}
	
	public void setFootage(int feet) {
		final int INCH = 12;
		
		setFeet(feet*INCH);
	}

	@Override
	public String toString() {
		return "InchesFeetConverter [inches=" + inches +"]";
	
	}
	
	public String tooString() {
	 
		return " FeetInchesConverter [ feet = "+ feet + "]";
	}
	
	
}
