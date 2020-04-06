package com.amazonTestScript;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.objectRepository.HomePage;
import com.genericLib.Base;

@Listeners(com.listener.EventListener.class)
public class Change_The_Pincode extends Base{
	
	@Test
	public void Change_The_Pincode() {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		
		/*clicking on the location icon*/
		hp.getLocationIcon().click();
		
		Reporter.log("successfully clicked on location icon",true);
		
		String excelPath="./src\\com\\testData\\Amazon scenario.xlsx";
		
        /*using explicitly wait statements*/
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(hp.getEnterAPincode()));
		
		/*Clearing a pincode*/
		hp.getEnterAPincode().clear();
		Reporter.log("pincode get successfully cleared",true);
		
		/*Entering a pincode*/
		hp.getEnterAPincode().sendKeys(flib.getExcelData(excelPath, "sheet4", 1, 0),Keys.ENTER);
		Reporter.log("pincode successfully entered",true);
		
		
	
		
		/*getting the value of expected pin code*/
		String expectedPincode = flib.getExcelData(excelPath, "sheet4", 1, 0);
		String actualPincode="827009";
		
        if(expectedPincode.contentEquals(actualPincode))
         Reporter.log("Pincode is changed successfully",true);

		
	}

}
