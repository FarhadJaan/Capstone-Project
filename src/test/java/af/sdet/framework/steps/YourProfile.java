package af.sdet.framework.steps;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import af.sdet.framework.pages.POMFactory;
import af.sdet.framework.utilities.CommonUtility;

public class YourProfile extends CommonUtility{
	POMFactory factory = new POMFactory();

	
	//Personal Updated Information Section
	
	@When("User click on Account option")
	public void userClickOnAccountOption() {
	   click(factory.Updated().newProfileText);
	   logger.info("User clicked on option button");
	}
	@And("User update Name {string} and Phone {string}")
	public void userUpdateNameAndPhone(String name, String number) {
		clearText(factory.Updated().nameField);
		sendText(factory.Updated().nameField,name);
		sendText(factory.Updated().phoneNumberField,number);
		logger.info("User Updated their personal information");
		slowDown();
	   
	}
	@And("User click on Update button")
	public void userClickOnUpdateButton() {
	   click(factory.Updated().updateButton);
	   logger.info("User clicked on updated option");
	}
	
	
	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.Updated().personalinformationUpdatedPopup);
		String expected = "Personal Information Updated Successfully";
		String actual = getText(factory.Updated().personalinformationUpdatedPopup);
		Assert.assertEquals(expected, actual);
		logger.info("pop up was displayed");
		
	}
	
	//Updated Password Section
	
	
	@And("User enter below information")
	public void UserEnterBelowInformation(DataTable data) {
		List<Map<String, String>> map = data.asMaps(String.class, String.class);
		sendText(factory.Updated().previousPassword, map.get(0).get("previousPassword"));
		sendText(factory.Updated().newPasswordInput, map.get(0).get("newPassword"));
		sendText(factory.Updated().confirmPasswordInput, map.get(0).get("confirmPassword"));
		logger.info("User entered the below information");
	
	}
	
	
	@And("User click on Change Password button")
	public void userClickedOnChangePasswordButton() {
		click(factory.Updated().changePasswordBtn);
		logger.info("User clicked on change password button");
	}
	
	
	@Then("a message should be displayed Password Updated Successfully")
	public void messageShouldBeDisplayed() {	
	waitTillPresence(factory.Updated().changePasswordPopUp);
	String message="Password Updated Successfully";
	String result = getElementText(factory.Updated().changePasswordPopUp);
	Assert.assertEquals(message, result);
	logger.info("password changed");
	}
	
	//-Adding Card Section
	
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		click(factory.Updated().addPaymentMethodLink);
		logger.info("User click on add payment method link");

	}
	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
	   List<Map<String,String>> map = dataTable.asMaps(String.class, String.class);
	   sendText(factory.Updated.cardNumberInput, map.get(0).get("cardNumber"));
	   sendText(factory.Updated.nameOnCardInput, map.get(0).get("nameOnCard"));
	   selectByVisibleText(factory.Updated.expirationMonthInput, map.get(0).get("expirationMonth"));
	   selectByVisibleText(factory.Updated.expirationYearInput, map.get(0).get("expirationYear"));
	   sendText(factory.Updated.securityCodeInput, map.get(0).get("securityCode"));
	}
	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
	   click(factory.Updated.paymentSubmitBtn);
		logger.info("User clicked on summit button");
	}
	@Then("a message should be displayed Payment Method added successfully")
	public void aMessageShouldBeDisplayedPaymentMethodAddedSuccessfully() {
		String actual = "Payment Method added sucessfully";
		String expect = getElementText(factory.Updated.cardAddedPopUp);
	    Assert.assertEquals(actual, expect);
	    logger.info("Message was displayed successfully");
	}
	
	//Edit Card Section
	
	@When("User click on added card")
	public void userClickedOnAddedCard() {
		click(factory.Updated.ClickOnCardToEdit);
		logger.info("User click on added card");
	}
	
	
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
	    click(factory.Updated.Edit);
	    logger.info("User clicked on login button");
	}
	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
	   List<Map<String,String>> map = dataTable.asMaps(String.class, String.class);
	   clearText(factory.Updated.cardNumberInput);
	   sendText(factory.Updated.cardNumberInput, map.get(0).get("cardNumber"));
	   clearText(factory.Updated.nameOnCardInput);
	   sendText(factory.Updated.nameOnCardInput, map.get(0).get("nameOnCard"));
	   
	  
	   selectByVisibleText(factory.Updated.expirationMonthInput,map.get(0).get("expirationMonth"));
	   selectByVisibleText(factory.Updated.expirationYearInput, map.get(0).get("expirationYear"));
	   clearText(factory.Updated.securityCodeInput);
	   sendText(factory.Updated.securityCodeInput, map.get(0).get("securityCode"));
	   logger.info("User entered the following information");
	}
	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
	
	   click(factory.Updated.paymentSubmitBtn);
	   logger.info("User clicked on updated button");
	}
	@Then("a message should be displayed Payment Method updated Successfully")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully() {
//		slowDown();
		String actual = "Payment Method updated Successfully";
		String expect = getElementText(factory.Updated.cardupdatedPopUp);
	    Assert.assertEquals(actual, expect);
	    logger.info("Message was displayed successfully");
	}
	
	//-Removing Card Section
	
	
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.Updated.remove);
		logger.info("User clicked in remove buttn");
	    
	}
	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(isElementDisplayed(factory.Updated.paymentSubmitBtn));
		logger.info("Card was removed");
	   
	}

	//-Adding Address Section
	
	
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
	   click(factory.Updated.addressAddedIcon);
	   logger.info("User clicked on add address icon");
	}
	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
	    List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
	    selectByValue(factory.Updated.countrySelection,map.get(0).get("country"));
	    sendText(factory.Updated.fullNameInputForAddress, map.get(0).get("fullName"));
	    sendText(factory.Updated.phoneNumberInputForAddress, map.get(0).get("phoneNumber"));
	    sendText(factory.Updated.streetInput, map.get(0).get("streetAddress"));
	    sendText(factory.Updated.apartmentInput, map.get(0).get("apt"));
	    sendText(factory.Updated.cityInput, map.get(0).get("city"));
	    selectByValue(factory.Updated.State, map.get(0).get("state"));
	    sendText(factory.Updated.zipCodeInput, map.get(0).get("zipCode"));
	    logger.info("User added the address information");
	}
	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
	    click(factory.Updated.addedAddressbutton);
	    logger.info("User clicked on add address button");
	}
	@Then("a message should be displayed Address Added Successfully")
	public void aMessageShouldBeDisplayedAddressAddedSuccessfully() {
	    
		String actual = "Address Added Successfully";
		String expect = getElementText(factory.Updated.addressAddedPopUp);
	    Assert.assertEquals(actual, expect);
	    logger.info("Message was displayed successfully");
		
	}
	
	//-Edit Address Option
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
		waitTillPresence(factory.Updated.editAddressOption);
	    click(factory.Updated.editAddressOption);
	    logger.info("User clicked on edit address option");
	}
	
	@When("user fill new address form with below information there")
	public void userFillNewAddressFormWithBelowInformationThere(DataTable dataTable) {
	   List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
	   selectByValue(factory.Updated.countrySelection, map.get(0).get("country"));
	   clearTextUsingSendKeys(factory.Updated.fullNameInputForAddress);
	   sendText(factory.Updated.fullNameInputForAddress, map.get(0).get("fullName"));
	   clearTextUsingSendKeys(factory.Updated.phoneNumberInputForAddress);
	   sendText(factory.Updated.phoneNumberInputForAddress, map.get(0).get("phoneNumber"));
	   waitTillPresence(factory.Updated.streetInput);
	   clearTextUsingSendKeys(factory.Updated.streetInput);
	   sendText(factory.Updated.streetInput, map.get(0).get("streetAddress"));
	   sendText(factory.Updated.apartmentInput, map.get(0).get("apt"));
	   waitTillPresence(factory.Updated.cityInput);
	   clearTextUsingSendKeys(factory.Updated.cityInput);
	   sendText(factory.Updated.cityInput, map.get(0).get("city"));
	   selectByValue(factory.Updated.State, map.get(0).get("state"));
	   waitTillPresence(factory.Updated.zipCodeInput);
	   clearTextUsingSendKeys(factory.Updated.zipCodeInput);
	   sendText(factory.Updated.zipCodeInput, map.get(0).get("zipCode"));
	   logger.info("User updated the address information");
	}
	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
	   click(factory.Updated.updateAddressButton);
	   logger.info("User clicked on update address button");
	}
	@Then("a message should be displayed Address Updated Successfully")
	public void aMessageShouldBeDisplayedAddressUpdatedSuccessfully() {
	    
		String actual = "Address Updated Successfully";
		String expect = getElementText(factory.Updated.addressUpdatePopUp);
	    Assert.assertEquals(actual, expect);
	    logger.info("Message was displayed successfully");
	}
	
	//-Remove Address Section
	
	@When("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
	    click(factory.Updated.removeAddress);
	    logger.info("User clicked on remove option");
	}
	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
	Assert.assertFalse(isNotDisplayed(factory.Updated.remove));
	
	logger.info("Address was removed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

