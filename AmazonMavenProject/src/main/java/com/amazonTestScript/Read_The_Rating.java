package com.amazonTestScript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.objectRepository.AppleIphoneXrBlackPage;
import com.amazon.objectRepository.AppleIphoneXrPage;
import com.amazon.objectRepository.HomePage;
import com.amazon.objectRepository.ShoppingCartPage;
import com.genericLib.Base;

@Listeners(com.listener.EventListener.class)
public class Read_The_Rating extends Base{
	
	@Test
	public void Read_The_Rating() {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		
		ShoppingCartPage shoppingCart=PageFactory.initElements(driver, ShoppingCartPage.class);
		
		/* selecting the module electronics*/	
			WebElement allCategories = hp.getCategories();
			Select sec=new Select(allCategories);
			sec.selectByVisibleText("Electronics");
			
			Reporter.log("successfully selected module electronics",true);
		
			String excelPath="./src\\com\\testData\\Amazon scenario.xlsx";
			/*searching the product*/
			hp.getSearchBox().sendKeys(flib.getExcelData(excelPath, "sheet3", 1, 0));
			hp.getSearchButton().click();  
			
			String actualProductPageTitle = driver.getTitle().replaceAll(" ", "");
			String expProductPageTitle = "Amazon.in: apple Iphone Xr 64gb: Electronics".replaceAll(" ", "");
			Assert.assertEquals(actualProductPageTitle, expProductPageTitle);
			Reporter.log("apple iphone xr 64gb page successfully displayed",true);
			
			
			AppleIphoneXrPage iphoneXr=PageFactory.initElements(driver, AppleIphoneXrPage.class);
			
			/*Clicking on the product*/
			iphoneXr.getAppleIphoneXrBlack().click();
			
			
			String actualTitle = driver.getTitle().replaceAll(" ","");
		 String expTitle = "Apple iPhone XR (64GB) - Black: Amazon.in:Darshita Electronics".replaceAll(" ", "");
		Assert.assertEquals(actualTitle, expTitle);
		Reporter.log("apple iphone xr black 64 gb successfully displayed",true);
		
		AppleIphoneXrBlackPage iphoneBlack=PageFactory.initElements(driver, AppleIphoneXrBlackPage.class);
	    
		/*Reading the rating of the product*/
		String productRatings = iphoneBlack.getRatings().getText();
	     Reporter.log(productRatings,true);
	
	
	
	}

}
