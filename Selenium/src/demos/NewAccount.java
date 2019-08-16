package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		String name = "John Purdy";
		String email = "johnpurdy@gmail.com";
		String phone = "1234567";
		String gender = "male";
		String password = "pass";
		String country = "Germany";
		boolean weeklyEmail = true;
		
		String browserType = "chrome";
		WebDriver driver;
		driver = utilities.DriverFactory.open(browserType);
		
		//navigate to account management page
		driver.get("http://sdettraining.com/trguitransactions/NewAccount.aspx");
			
		//define WebElements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.xpath("//*[@id=\"MainContent_txtHomePhone\"]"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password'][id='MainContent_txtPassword']"));
		WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword"));
		WebElement weeklyCheckboxElement = driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebElement submitElement = driver.findElement(By.id("MainContent_btnSubmit"));
		
		//fill out form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		if(gender.equalsIgnoreCase("male")) {
			maleRadio.click();
		}else {
			femaleRadio.click();
		}
		
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText(country);
		
		//handling checkbox algorithm
		if(weeklyEmail) {
			if(!weeklyCheckboxElement.isSelected()) {
				weeklyCheckboxElement.click();
			}else {
				if(weeklyCheckboxElement.isSelected()) {
					weeklyCheckboxElement.click();
			}
		}
		
		//click submit
		submitElement.click();
		
		//get confirmation and close browser
		String confirmation = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		if(confirmation.contains(expected)) {
			System.out.println("Test passed: confirmation message - " + confirmation);
		}else {
			System.out.println("Test Failed!!!");
		}
		
		driver.close();

	}

}}
