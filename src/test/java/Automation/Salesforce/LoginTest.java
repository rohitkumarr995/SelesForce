package Automation.Salesforce;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Homepage;
import Resources.BaseSalesforces;

public class LoginTest extends BaseSalesforces{
	public Homepage hp;
	@BeforeTest
	public void openBrowser() throws IOException {		
		initializeDriver();				
	}
	
	@Test(priority=1)
	public void loginTest() {
		
		hp = new Homepage(driver);
		hp.getUsername().sendKeys("abcd");
		hp.getPassword().sendKeys("1234");
		hp.getLogin().click();		
	}
	
	@Test(priority=2)
	public void getTextStatus() {
		String text = hp.getCust().getText();
		Assert.assertEquals(text, "a customer");
	}
	
	//@AfterTest
	public void closeBrowser() {
		driver.close();	
	}
}
