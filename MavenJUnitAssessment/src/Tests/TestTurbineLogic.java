package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Home;
import model.TurbineLogic;

public class TestTurbineLogic {
	TurbineLogic turbine1 = new TurbineLogic();
	Home home1 = new Home ();

	@Before
	public void setUp() throws Exception {
	}

		
	@Test
	public void testCalculateElectricNeed() {
		home1.setNumHomes(5);
		double electric = turbine1.calculateElectricNeed(home1);
		assertTrue(5 < 9000);
		
	}
	
	@Test
	public void testCalculateTurbinePower() {
		home1.setPower(200.0);
		double power = turbine1.calculateTurbinePower(home1);
		assertNotSame(200.0, 5.1);
	}
	
	@Test
	public void testcalculateTurbinePower() {
		home1.setWindMill(720000);
		double blades = turbine1.calculateTurbinePower(home1);
		assertSame(4 , 4);
		}

}
