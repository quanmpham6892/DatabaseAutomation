package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.DatabasePage;
import page.LoginPage;
import page.TestBase;

public class LoginPageTest extends TestBase{
	LoginPage loginPageObj;
	
	@BeforeMethod
	public void setUp() {
		initDriver();
		loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@Test
	public void loginTest() throws Throwable {
		
		loginPageObj.enterUserName(DatabasePage.getData("username"));
		loginPageObj.enterPassword(DatabasePage.getData("password"));
		Thread.sleep(4000);
		loginPageObj.clickSignInButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
