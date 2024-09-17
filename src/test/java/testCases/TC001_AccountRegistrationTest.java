package testCases;


import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test(groups = {"Regression", "Master"})
	public void Verify_account_registration() {
		try {
			logger.info("Starting TC001_Account registration");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
			CommonMethods cm=new CommonMethods();
			RegisterPage rp = new RegisterPage(driver);
			rp.setFirstName(cm.randomString().toUpperCase());
			rp.setLastName(cm.randomString().toLowerCase());
			rp.setEmail(cm.randomString()+"@gmail.com");
			rp.setTelephone(cm.randomNumber());
			
			logger.info("feilds are entered");
			
			String pwd= cm.randomAlphaNumaric();
			rp.setPassword(pwd);
			rp.setConfirmPassword(pwd);

			rp.acceptPrivacyPolicy();
			rp.clickContinue();
			
			logger.info("validating expected methods");

			String confmsg = rp.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed testcase name");
			logger.debug("Debug logs");
			Assert.fail();	
		}
			logger.info("FInished testcase TC_001)");
			
	}
	
	

}
