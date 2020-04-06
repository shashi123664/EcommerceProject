package com.amazonTestScript;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.objectRepository.HomePage;
import com.amazon.objectRepository.PumaShoesPage;
import com.amazon.objectRepository.ShoesPage;
import com.genericLib.Base;

@Listeners(com.listener.EventListener.class)
public class Share_The_Product_On_Facebook extends Base{

	
	@Test
	public void Share_The_Product_On_Facebook()  {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		/*selecting the module shoes and handbags*/
		WebElement allCategories = hp.getCategories();
		Select sec=new Select(allCategories);
		sec.selectByVisibleText("Shoes & Handbags");
		String excelPath="./src\\com\\testData\\Amazon scenario.xlsx";
		
		
		/*Searching The product*/
		hp.getSearchBox().sendKeys(flib.getExcelData(excelPath, "sheet3", 2, 0));
		hp.getSearchButton().click();
		
		String expectedShoesTitlePage = driver.getTitle().replaceAll(" ", "");
		String actualShoesTitlePage = "Amazon.in: Shoes: Shoes & Handbags".replaceAll(" ", "");
		
		Assert.assertEquals(actualShoesTitlePage, expectedShoesTitlePage);
		
		Reporter.log("Shoes page is displayed",true);
		
		ShoesPage shoes=PageFactory.initElements(driver,ShoesPage.class);
		
		/*Filtering the shoes by brand*/
		shoes.getFilterShoes().click();
		
		
		String expectedPumaShoesTitle = driver.getTitle().replaceAll(" ", "");
		String actualPumaShoesTitle = "Amazon.in: Shoes - Puma: Shoes & Handbags".replaceAll(" ", "");

	   Assert.assertEquals(actualPumaShoesTitle, expectedPumaShoesTitle);
	   Reporter.log("list of puma shoes successfully filtered",true);
	   
	   /*clicking on first shoes*/
	   shoes.getPumaShoes().click();
	   
	   
	  /*Switching thw window to puma shoes page*/ 
	  Set<String> ids1 = driver.getWindowHandles();
	  Iterator<String> i1=ids1.iterator();
	  String parentId1=i1.next();
	  String childId1=i1.next();
	  
	  
	  driver.switchTo().window(childId1);
	 
	  
	  PumaShoesPage pumaShoesPage=PageFactory.initElements(driver, PumaShoesPage.class);
	  /*clicking on facebook icon*/
	  pumaShoesPage.getFacebookIcon().click();
	  try {
      Thread.sleep(5000);
	  }
	  catch(Throwable e)
	  {
		  e.printStackTrace();
	  }
	Set<String> ids2 =driver.getWindowHandles();
	Iterator<String> i2=ids2.iterator();
	String parentId2=i2.next();
	String childId2=i2.next();
	String childId3 = i2.next();
	
	/*Switching the window to facebook page*/
	driver.switchTo().window(childId3);
	
	/*getting the title and compare*/
	String expectedFacebookTitle = driver.getTitle();
	  String actualFacebookTitle="Facebook";
	  
	  Assert.assertEquals(actualFacebookTitle, expectedFacebookTitle);
		Reporter.log("user can able to share the product on facebook",true);
		
		/*Switching to parent window*/
		driver.switchTo().window(parentId2);
		
		
		
	}
}
