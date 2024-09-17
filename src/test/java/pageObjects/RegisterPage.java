package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {

	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@name='email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@name='confirm']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPrivacyPolicy;

	@FindBy(xpath = "//input[@type='submit' and @value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}

	// Method to set Last Name
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	// Method to set Email
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	// Method to set Telephone
	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}

	// Method to set Password
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	// Method to set Confirm Password
	public void setConfirmPassword(String confirmPassword) {
		txtConfirmPassword.sendKeys(confirmPassword);
	}

	public void acceptPrivacyPolicy() {
		if (!chkPrivacyPolicy.isSelected()) {
			chkPrivacyPolicy.click();
		}
	}

	// Method to click Continue button
	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		
		

	}

}
