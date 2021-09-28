package stepDefinitions;

import org.testng.Assert;

import PageObject.Homepage;
import Resources.BaseSalesforces;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition extends BaseSalesforces{
	
	public Homepage hp;
	
	@Given("^initialize the driver with chrome and navigate to https://login\\.salesforce\\.com/\\?locale=eu$")
	public void initialize_the_driver_with_chrome_and_navigate_to_https_login_salesforce_com_locale_eu() throws Throwable {
		initializeDriver();
	    
	}

	@When("^user input username test(\\d+)@gmail\\.com and password(\\d+)$")
	public void user_input_username_test_gmail_com_and_password(String arg1, String arg2) throws Throwable {
		hp = new Homepage(driver);
		hp.getUsername().sendKeys("abcd");
		hp.getPassword().sendKeys("1234");
	    
	}

	@When("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		hp.getLogin().click();
	    
	}

	@Then("^Error message shown$")
	public void error_message_shown() throws Throwable {
		String text = hp.getCust().getText();
		Assert.assertEquals(text, "a customer");
	   
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();	
	    
	}

	

}
