package af.sdet.framework.steps;

import org.junit.Assert;

import af.sdet.framework.pages.POMFactory;
import af.sdet.framework.utilities.CommonUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login extends CommonUtility{
	
	POMFactory factory = new POMFactory();
	
	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = "React App";
		String expect = getTitle();
		Assert.assertEquals(expect, actualTitle);
		logger.info("the title were equal");
	}

	@When("User click on Sign in option")
	public void userClickOnSignInOption() {
		click(factory.homePage().signInButtn);
		logger.info("User clicked on sign in button");

	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(factory.homePage().emailInput, email);
		sendText(factory.homePage().passwordInput, password);
		logger.info("User enterd the below information");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(factory.homePage().clickOnLoginBttn);
		logger.info("User clicked on login button");

	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		boolean abc = isElementDisplayed(factory.homePage().account);
		Assert.assertTrue(abc);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
