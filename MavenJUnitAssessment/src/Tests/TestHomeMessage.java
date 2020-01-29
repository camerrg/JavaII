package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Home;

public class TestHomeMessage {
	String home2 = "Home [numHomes= " + 3 + ", power=  " + 540000 + " kw, windMill=" + 1 + " ]";
	
	

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		assertNotNull(home2);
	}

}
