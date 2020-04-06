package com.amazonTestScript;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amazon.objectRepository.AppleIphoneXrPage;
import com.amazon.objectRepository.AppleIphoneXrRedPage;
import com.amazon.objectRepository.HomePage;
import com.amazon.objectRepository.ShoppingCartPage;
import com.genericLib.Base;

@Listeners(com.listener.EventListener.class)
public class Delete_Product_From_The_Cart extends Base {
	
	
	@Test
	public void Delete_Product_From_The_Cart() {
		
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		/*hp.getCart().click();
	String actualCartPageTitle = driver.getTitle().replaceAll(" ", "");
	String expCartPageTitle="Amazon.in Shopping Cart".replaceAll(" ", "");
	Assert.assertEquals(actualCartPageTitle, expCartPageTitle);
	Reporter.log("cart page successfully displayed",true);*/
		 
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
		iphoneXr.getAppleIphoneXrRed().click();
		
		
		
		String actualTitle = driver.getTitle().replaceAll(" ","");
	 String expTitle = "Apple iPhone XR (64GB) (Product) RED: Amazon.in: Appario Retail Private Ltd".replaceAll(" ", "");
	Assert.assertEquals(actualTitle, expTitle);
	Reporter.log("apple iphone xr red 64gb page  successfully displayed",true);
	
	AppleIphoneXrRedPage iphoneRed=PageFactory.initElements(driver, AppleIphoneXrRedPage.class);
		iphoneRed.getAddToCart().click();
		/* Adding the product to the cart*/
		hp.getCart().click();
		Reporter.log("product is successfully added to the cart",true);
		

		/* reading the total number of items in the cart after adding the product*/
		String totalNumberOfItemsAfterAddingTheProduct = shoppingCart.getSubtotal().getText();
		String[] numberOfItemsAfterAdding = totalNumberOfItemsAfterAddingTheProduct.split(" ");
		String[] numberOfItemsAfterAddingTheProduct = numberOfItemsAfterAdding[1].split("");
		System.out.println("number of items after adding the product in the cart is "+numberOfItemsAfterAddingTheProduct[1]);
	     
		
		int afterAdding = Integer.parseInt(numberOfItemsAfterAddingTheProduct[1]);
		
		/*Deleting the product fronm the cart*/
		shoppingCart.getDelete().click();
		

		/* reading the total number of items in the cart after deleting the product*/
		String totalNumberOfItemsAfterDeleting = shoppingCart.getSubtotal().getText();
		String[] numberOfItemsAfterDeleting = totalNumberOfItemsAfterDeleting .split(" ");
		String[] numberOfItemsAfterDeletingTheProduct = numberOfItemsAfterDeleting[1].split("");
		System.out.println("number of items before adding the product in the cart is"+numberOfItemsAfterDeletingTheProduct[1]);
		int afterDeleting = Integer.parseInt(numberOfItemsAfterDeletingTheProduct[1]);
		
		
		boolean b=afterAdding>afterDeleting;

       Assert.assertTrue(b);
       Reporter.log("product is successfully deleted from the cart",true);
	}

}
