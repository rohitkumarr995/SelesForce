package Automation.Salesforce;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Homepage;
import Resources.BaseSalesforces;

public class PrivacyPage extends BaseSalesforces{
	
	@BeforeTest
	public void openBrowser() throws IOException {		
		initializeDriver();				
	}
	@Test
	public void getPrivacy() {
		
		Homepage hpm = new Homepage(driver);
		hpm.viewPrivacy().click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWind = it.next();
		String childWind = it.next();
		driver.switchTo().window(childWind);
		
		System.out.println(hpm.getNumber().getText());
		String actNumber = hpm.getNumber().getText();
		Assert.assertEquals(actNumber, "1800-420-7331");
		
	}
	
	//@AfterTest
	public void closeBrowser() {
		driver.close();	
	}

}
