package smokeTests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTest {
	WebDriver driver;

	@Test
	public void ATagsPresent() {
		System.out.println("Running test");
		boolean createAccountPresent = false;
		
		List <WebElement> liElements = driver.findElements(By.tagName("a"));
		
		int numOfAElements = liElements.size();
		System.out.println("There are " + numOfAElements + " a tags present on this page");
		
		for(WebElement liElement : liElements) {
			if(liElement.getText().equals("CREATE ACCOUNT")) {
				createAccountPresent = true;
				break;
			}
		}
		Assert.assertTrue(createAccountPresent);
	}

	@BeforeMethod
	public void setup() {
		System.out.println("Initializing test");
		driver = utilities.DriverFactory.open("chrome");
		String WebUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		driver.get(WebUrl);
	}

	@AfterMethod
	public void teardown() {
		System.out.println("Closing test");
		driver.close();
	}

}
