package af.sdet.framework.steps;

import org.junit.Assert;
import af.sdet.framework.pages.POMFactory;
import af.sdet.framework.utilities.CommonUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Order extends CommonUtility {
	POMFactory factory = new POMFactory();

	@When("User click on Orders section")
	public void userClickOnOrdersSection() {
		click(factory.orders().orderPageOption);
		logger.info("User clicked on order option");
	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() {
		click(factory.orders().firstOrder);
		logger.info("User clicked on first order");
	}

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() {
		click(factory.orders().CancelTheOrderButton);
		logger.info("User clicked on cancel order");
	}

	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReasonBoughtWrongItem(String element) {
		selectByVisibleText(factory.orders().reasonOption, element);
		logger.info("User selected the Bought wrong item reason");
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orders().cancelOrder);
		logger.info("User clicked on cancel order");
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayedYourOrderHasBeenCancelled(String str) {
		String expect = str;
		String actual = getElementText(factory.orders().cancelOrderMessage);
		Assert.assertEquals(actual, expect);
		logger.info("the message was displayed");
	}

	// --------------------- return Order

	@When("User click on Return Items button")
	public void userClickOnReturnItemsButton() {
		click(factory.orders().returnOption);
		logger.info("User clicked on return option");
	}

	@When("User select the Return Reason {string}")
	public void userSelectTheReturnReason(String element) {
		selectByVisibleText(factory.orders().reasonOption, element);
		logger.info("User selected damaged reason");
	}

	@When("User select the drop off service {string}")
	public void userSelectTheDropOffService(String element) {
		selectByVisibleText(factory.orders().dropOffInput, element);
	}

	@When("User click on Return Order button")
	public void userClickOnReturnOrderButton() {
		click(factory.orders().returnButton);
		logger.info("User clicked on order button");
	}

	@Then("a cancelation message should displayed {string}")
	public void aCancelationMessageShouldBeDisplayedReturnWasSuccessful(String str) {

		String expect = str;
		String actual = getElementText(factory.orders().retutnOrderMessage);
		Assert.assertEquals(actual, expect);
		logger.info("the message was displayed");
	}

	// ------------------------- Review Order

	@When("User click on Review button")
	public void userClickOnReviewButton() {
		click(factory.orders().reviewButton);
		logger.info("User clicked on review Buttton");
	}

	@When("User write Review headline {string} and {string}")
	public void userWriteReviewHeadlineAnd(String string, String string2) {
		sendText(factory.orders().headlineInput, string);
		sendText(factory.orders().descriptionInput, string2);
		logger.info("User filled the form");
	}

	@When("User click Add your Review button")
	public void userClickAddYourReviewButton() {
		click(factory.orders().reviewSubmitBtn);
		logger.info("User clicked on review Submit Button");
	}

	@Then("a review message should be displayed {string}")
	public void aReviewMessageShouldBeDisplayedYourReviewWasAddedSuccessfully(String str) {

		String expect = str;
		String actual = getElementText(factory.orders().reviewPopup);
		Assert.assertEquals(actual, expect);
		logger.info("the message was displayed");
	}

}
