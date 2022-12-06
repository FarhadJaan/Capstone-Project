package af.sdet.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import af.sdet.framework.base.BaseSetup;

public class CreateNewAccount extends BaseSetup {

	public CreateNewAccount() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(id = "newAccountBtn")
	public WebElement CreateNewAccoutBtn;

	@FindBy(id = "nameInput")
	public WebElement nameField;

	@FindBy(id = "emailInput")
	public WebElement emailField;

	@FindBy(id = "passwordInput")
	public WebElement passwordField;

	@FindBy(id = "confirmPasswordInput")
	public WebElement confirmPasswordField;

	@FindBy(id = "signupBtn")
	public WebElement signUpBtn;
	
	@FindBy(xpath = "//a[@class='top-nav__logo']")
	public WebElement TEKSCHOOL; 

}
