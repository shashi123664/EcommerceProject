package com.amazonTestScript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.objectRepository.HomePage;
import com.amazon.objectRepository.ShoesPage;
import com.genericLib.Base;

@Listeners(com.listener.EventListener.class)
public class Filter_The_Shoes_By_Brand extends Base{

	
	@Test
	public void Filter_The_Shoes_By_Brand() {
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
	
	}
	
}
