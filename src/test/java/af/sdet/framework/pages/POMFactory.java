package af.sdet.framework.pages;
import af.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private loginRetail homePage;
	private CreateNewAccount newAccount;
	public YourProfile Updated;
	private RetailHomePage HmPage;
	private Order orders;

	public POMFactory() {
		this.homePage = new loginRetail();
		this.newAccount = new CreateNewAccount();
		this.Updated = new YourProfile();
		this.HmPage = new RetailHomePage();
		this.orders = new Order();

	}

	public loginRetail homePage() {
		return this.homePage;
	}

	public CreateNewAccount newAccount() {

		return this.newAccount;
	}

	public YourProfile Updated() {
		return this.Updated;
	}

	public RetailHomePage HmPage() {

		return this.HmPage;
	}

	public Order orders() {
		return this.orders;
	}

}
