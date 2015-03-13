
import static org.junit.Assert.*;

import org.junit.Test;


public class ATMTest {

	
	@SuppressWarnings("deprecation")
	@Test
	public void testWithdrawal() {
		
		ATM machine2 = new ATM(100, "BOA", "Library");
		
		machine2.addFund(400);
		
		assertEquals(7465.55, machine2.atmFunds(), double delta);
	}
	
}
