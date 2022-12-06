package af.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import af.sdet.framework.base.BaseSetup;
public class loginRetail extends BaseSetup{

	public loginRetail() {
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(id="signinLink")
	public WebElement signInButtn;
	
	@FindBy(id="email")
	public WebElement emailInput;
	
	@FindBy(id="password")
	public WebElement passwordInput;
	
	@FindBy(id="loginBtn")
	public WebElement clickOnLoginBttn;
	
	@FindBy(id="accountLink")
	public WebElement account;
	
}
