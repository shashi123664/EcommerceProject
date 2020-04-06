package com.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.amazon.objectRepository.HomePage;
import com.amazon.objectRepository.SignInPage;



public class Base {
	public WebDriver driver=null;
	public String path="./src\\com\\testData\\commonData.properties";
	public static WebDriver driverListener=null;
	public FileLib flib=new FileLib();
	
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC()
	{
/* open the browser*/
		if(flib.getPropertyKeyValue(path, "browser").equals("chrome"))
		{
			driver=new ChromeDriver();
			driverListener=driver;
		}
		
		/*maximize the browser*/
		driver.manage().window().maximize();
		
		
		/*using implicitly wait statement*/
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		/*Enter the url*/
		driver.get(flib.getPropertyKeyValue(path, "url"));
	
		
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		
		/*performing mouse hover actions on hello sign in*/
		Actions act=new Actions(driver);
		act.moveToElement(hp.getHelloSignIn()).perform();
		
		/*clicking on the sign in button*/
		hp.getSignIn().click();

		/*Verify login page*/
		String actualLoginTitle=driver.getTitle().replaceAll(" ", "");
		String expLoginTitle="Amazon Sign In".replaceAll(" ", "");
		org.testng.Assert.assertEquals(actualLoginTitle, expLoginTitle);

		Reporter.log("login page is displayed",true);
	
	}
	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM()
	{
		SignInPage signIn=PageFactory.initElements(driver, SignInPage.class);
		signIn.getEmail().sendKeys(flib.getPropertyKeyValue(path, "username"));
		signIn.getContinuebutton().click();
		signIn.getPassword().sendKeys(flib.getPropertyKeyValue(path, "password"));
		signIn.getLogIn().click();
		
		/* Verify home page is displayed*/
		String exptHomePageName="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in".replaceAll(" ", "");
				String actualHomePageName=driver.getTitle().replaceAll(" ", "");
				Assert.assertEquals(actualHomePageName, exptHomePageName);
				Reporter.log("Home page is displayed",true);
	}
	@AfterMethod(groups= {"smoke","regression"})
	public void configAM()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		/* logout the application*/
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		wait.until(ExpectedConditions.elementToBeClickable(hp.getAccountsAndList()));
		/*performing mouse hover actions on accounts and list*/
		Actions act=new Actions(driver);
		act.moveToElement(hp.getAccountsAndList()).perform();
		
		/*click on sign out button*/
		hp.getSignOut().click();
	}
	
	
	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		/* close the browser*/
		driver.quit();
		
	}


}
