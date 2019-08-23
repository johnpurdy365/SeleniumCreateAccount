package smokeTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//test to see if login elements are present on the page in TestNG
public class LoginPresentTestNG {
	WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		System.out.println("Running test");
		boolean loginEmailText = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean loginPasswordText = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailText, "Email textbox present");
		Assert.assertTrue(loginPasswordText, "Password textbox present");
		
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
