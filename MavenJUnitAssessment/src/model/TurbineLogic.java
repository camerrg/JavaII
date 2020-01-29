package model;

public class TurbineLogic {
	
	//calculate how many turbines to power number of homes
	public double calculateTurbinePower(Home windMill) {
		double turbinePower = 0;
		turbinePower = windMill.getPower() / 180000;
		return turbinePower;
	}
	
	// calculate number of turbines needed based off of electricity value
	public double calculateElectricNeed(Home numHomes) {
		double electricNeed = 0;
		electricNeed = numHomes.getWindMill()/1800;
		return electricNeed;		
	}
	
	

}
