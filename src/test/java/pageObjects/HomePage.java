package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement lnkMyaccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement lnkRegister;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement sndTxt;

	@FindBy(linkText = "Login")			//login link for step5
	WebElement linkLogin;

	public WebElement link_myAccount() {
		return lnkMyaccount;
	}
	
	public void clickMyAccount() {
		link_myAccount().click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void sendtext(String ele) {
		sndTxt.sendKeys(ele);
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
}
