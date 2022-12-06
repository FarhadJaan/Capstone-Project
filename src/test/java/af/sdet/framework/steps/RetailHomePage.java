package af.sdet.framework.steps;

import java.util.List;
import org.junit.Assert;
import af.sdet.framework.pages.POMFactory;
import af.sdet.framework.utilities.CommonUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RetailHomePage extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.HmPage().allDepartments);

		click(factory.HmPage().hamBurgerBtn);
		logger.info("User clicked on All departments");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);

		if (list.get(0).get(0).equals(getElementText(factory.HmPage().electronicOnAllDeprt))
				&& list.get(0).get(1).equals(getElementText(factory.HmPage().ComputersOnAllDepart))
				&& list.get(0).get(2).equals(getElementText(factory.HmPage().smartHomeOnAllDepart))
				&& list.get(0).get(3).equals(getElementText(factory.HmPage().sportOnAllDepart))
				&& list.get(0).get(4).equals(getElementText(factory.HmPage().AutomativeonAllDepara))) {

			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		logger.info("Options are present");
	}

	@When("User click on All department")
	public void hamburgerBtn() {
		click(factory.HmPage().hamburgerBtn);
		logger.info("User clicked on all department");
	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		Assert.assertTrue(isElementDisplayed(factory.HmPage().shopByDepartment));
		logger.info("User is on " + department);
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);

		String electronic = "Electronics";
		String computer = "Computers";
		String smartHome = "Smart Home";
		String sports = "Sports";
		String automative = "Automotive";

		if (electronic.equals(getElementText(factory.HmPage().electronicOnAllDeprt))) {
			click(factory.HmPage().electronicOnAllDeprt);
			if (list.get(0).get(0).equals(getElementText(factory.HmPage().tvAndVideo))
					&& list.get(0).get(1).equals(getElementText(factory.HmPage().VideoGames))) {
				Assert.assertTrue(true);
			}
		}

		else if (computer.equals(getElementText(factory.HmPage().ComputersOnAllDepart))) {
			click(factory.HmPage().ComputersOnAllDepart);
			if (list.get(1).get(0).equals(getElementText(factory.HmPage().accessoories))
					&& list.get(1).get(1).equals(getElementText(factory.HmPage().Networking))) {
				Assert.assertTrue(true);
			}
		}

		else if (smartHome.equals(getElementText(factory.HmPage().smartHomeOnAllDepart))) {
			click(factory.HmPage().ComputersOnAllDepart);
			if (list.get(2).get(0).equals(getElementText(factory.HmPage().smartHomeLighting))
					&& list.get(2).get(1).equals(getElementText(factory.HmPage().plugsAndOutlets))) {
				Assert.assertTrue(true);
			}
		}

		else if (sports.equals(getElementText(factory.HmPage().sportOnAllDepart))) {
			click(factory.HmPage().ComputersOnAllDepart);
			if (list.get(3).get(0).equals(getElementText(factory.HmPage().athleticClothing))
					&& list.get(3).get(1).equals(getElementText(factory.HmPage().exerciseAndFitness))) {
				Assert.assertTrue(true);
			}
		}

		else if (automative.equals(getElementText(factory.HmPage().AutomativeonAllDepara))) {
			click(factory.HmPage().ComputersOnAllDepart);
			if (list.get(4).get(0).equals(getElementText(factory.HmPage().Automative))
					&& list.get(4).get(1).equals(getElementText(factory.HmPage().motorCycleAndPowersports))) {
				Assert.assertTrue(true);
			}
		} else {
			Assert.assertTrue(false);

		}
		logger.info("below options are present in department");

	}

	// ----------------- Add item

	@Then("User change the category to {string}")
	public void userChangeTheCategoryTo(String string) {
		selectByVisibleText(factory.HmPage().allDepartments, string);
		logger.info("User select the SmartHome option");
	}

	@Then("User search for an item {string}")
	public void userSearchForAnItem(String string) {
		sendText(factory.HmPage().searchInput, string);
		logger.info("User send the value to search input");
	}

	@Then("User click on Search icon")
	public void userClickOnSearchIcon() {
		click(factory.HmPage().searchBtn);
		logger.info("User clicked on serach Button");
	}

	@Then("User click on item")
	public void userClickOnItem() {
		click(factory.HmPage().avialbleItem);
		logger.info("User clicked on item");
	}

	@Then("User select quantity {string}")
	public void userSelectQuantity(String string) {
		selectByVisibleText(factory.HmPage().quantity, string);
		logger.info("User selected 2 for quantity");
	}

	@Then("User click add to Cart button")
	public void userClickAddToCartButton() {
		click(factory.HmPage().addToCartBtn);
		logger.info("User clicked on add cart button");
	}

	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String string) {
		if (getElementText(factory.HmPage().cartQuantity).equals(string)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		logger.info("Quantity changed and matched");
	}

	// CheckOut Section

	@Then("User click on Cart option")
	public void userClickOnCartOption() {
		click(factory.HmPage().cartQuantity);
		logger.info("Order");
	}

	@Then("User click on Proceed to Checkout button")
	public void userClickOnProceedToCheckoutButton() {
		click(factory.HmPage().proceedCheckOutBtn);
		logger.info("User clicked on proceddChechoutButtn");
	}

	@Then("User click Add a new address link for shipping address")
	public void userClickAddANewAddressLinkForShippingAddress() {
		click(factory.HmPage().addAddressBtn);
		logger.info("User clicked on addAddressbtn");
	}

	@Then("User click Add a credit card or Debit Card for Payment method")
	public void userClickAddACreditCardOrDebitCardForPaymentMethod() {
		click(factory.HmPage().addPaymentMethodLink);
		logger.info("User clicked on addPaymentMethod");
	}

	@Then("User click on Place Your Order")
	public void userClickOnPlaceYourOrder() {
		click(factory.HmPage().placeOrderBtn);
		logger.info("User clicked on placed ordered button");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String string) {
		if (getElementText(factory.HmPage().orderdPlacedMessage).equals(string)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		logger.info("Message was displayed");
	}
}