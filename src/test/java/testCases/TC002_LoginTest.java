package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups ={"Sanity", "Master"})
	public void verify_login() {
		
		try {
			logger.info("Starting TC_002_LoginTest");
			
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp= new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			MyAccountPage mac=new MyAccountPage(driver);
			boolean targetPage  = mac.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
			
			logger.info("Fineshed Starting TC_002_LoginTest");
			
		} catch (Exception e) {
			Assert.fail();
	
		}
		
}

}