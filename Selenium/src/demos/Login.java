package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public static void main(String[] args) {
		
		String browserType = "chrome";
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		
		//navigate to login page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		//enter username
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		//enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		
		//click login
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		//get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("Confirmation " + message);
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		//close the browser
		driver.close();

	}

}
