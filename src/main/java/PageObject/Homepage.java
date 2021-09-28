package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Resources.BaseSalesforces;

public class Homepage extends BaseSalesforces {
	
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	WebDriver driver;
	By username = By.id("username");
	By password = By.id("password");
	By login = By.xpath("//*[@id='Login']");
	//By cust = By.cssSelector("[class*='mr16']");
	By cust = By.xpath("//*[@id='signup']/p"); 
	
	By privacy = By.id("privacy-link");
	By number = By.cssSelector(".hidden-xs");
	
	public WebElement getNumber() {
		return driver.findElement(number);
	}
	
	public WebElement viewPrivacy() {
		return driver.findElement(privacy);
	}

	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	

	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getCust() {
		return driver.findElement(cust);
	}

}
