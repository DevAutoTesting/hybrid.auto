package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "DataDriven")
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("Started TC_003 loginDDT");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			MyAccountPage mac = new MyAccountPage(driver);
			boolean targetPage = mac.isMyAccountPageExists();
			Assert.assertTrue(targetPage);

			// Data is valild - login is Success- test pass-logout
			// login failed - test failed

			// Data is Invalid - login is success - test fail- logout
			// login failed - test pass

			if (exp.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					mac.clickLogout();
					Assert.assertTrue(true);

				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {

				{
					if (targetPage == true) {

						mac.clickLogout();
						Assert.assertTrue(false);
					} else {

						Assert.assertTrue(true);
					}
				}

			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("Finished TC_003 loginDDT");
	}

}
