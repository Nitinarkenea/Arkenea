package initiation;

import java.io.IOException;

import org.testng.annotations.Test;


public class ConactUs extends BaseClasses{
	
	@Test(priority=1)
	public void verifyDashBoardTest() throws InterruptedException, IOException
	{
		ContactPage.fillForm();
		
	}
}
