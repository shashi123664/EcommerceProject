package com.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.flipkart.objectRepository.HomePage;
import com.flipkart.objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	public String path = "./src\\main\\java\\com\\testData\\commonData.properties";
	public static WebDriver driverListener = null;
	public FileLib flib = new FileLib();

	@BeforeClass(groups = { "smoke", "regression" })
	public void configBC() {
		/* open the browser */
		if (flib.getPropertyKeyValue(path, "browser").equals("chrome")) {
			driver = new ChromeDriver();
			driverListener = driver;
		}

		/* maximize the browser */
		driver.manage().window().maximize();

		/* using implicitly wait statement */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(flib.getPropertyKeyValue(path, "url"));

	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void configBM() {
		/* creating object of login page */
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/* entering username */
		lp.getEmailTextField().sendKeys(flib.getPropertyKeyValue(path, "username"));

		/* entering password */
		lp.getPasswordTExtField().sendKeys(flib.getPropertyKeyValue(path, "password"));

		lp.getLoginButton().click();

		String actualTitle = driver.getTitle().replaceAll(" ", "");
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"
				.replaceAll(" ", "");
		
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		Reporter.log("Home page is displayed",true);
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/* creating object of Home page */
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		
		Actions act=new Actions(driver);
		
		WebElement myAcc = hp.getMyAccount();
		act.moveToElement(myAcc).perform();
		
		/*logout the application*/
		hp.getLogout().click();
		
		
	}
	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		/* close the browser*/
		driver.quit();
		
	}

}
