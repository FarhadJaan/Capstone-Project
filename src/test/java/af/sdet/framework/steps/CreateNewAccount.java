package af.sdet.framework.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import af.sdet.framework.pages.POMFactory;
import af.sdet.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewAccount extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(factory.newAccount().CreateNewAccoutBtn);
		logger.info("User should create a new account");

	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);

		sendText(factory.newAccount().nameField, map.get(0).get("name"));
		sendText(factory.newAccount().emailField, map.get(0).get("email"));
		sendText(factory.newAccount().passwordField, map.get(0).get("password"));
		sendText(factory.newAccount().confirmPasswordField, map.get(0).get("confirmPassword"));
		logger.info("User send the follow texts");

	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {

		click(factory.newAccount().signUpBtn);
		logger.info("User clicked on create account");

	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		Assert.assertTrue(isElementDisplayed(factory.newAccount().TEKSCHOOL));
		logger.info("TEkSCHOOL text should be displayed");

	}

}
