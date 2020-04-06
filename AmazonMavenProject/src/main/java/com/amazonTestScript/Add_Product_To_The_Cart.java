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
public class Add_Product_To_The_Cart extends Base {

	@Test
	public void Add_Product_To_The_Cart() {
		HomePage hp = PageFactory.initElements(driver, HomePage.class);
		hp.getCart().click();
		String actualCartPageTitle = driver.getTitle().replaceAll(" ", "");
		String expCartPageTitle = "Amazon.in Shopping Cart".replaceAll(" ", "");
		Assert.assertEquals(actualCartPageTitle, expCartPageTitle);
		Reporter.log("cart page successfully displayed", true);

		ShoppingCartPage shoppingCart = PageFactory.initElements(driver, ShoppingCartPage.class);

		/* reading the total number of items in the cart before adding the product */
		String totalNumberOfItems = shoppingCart.getSubtotal().getText();
		String[] numberOfItems = totalNumberOfItems.split(" ");
		String[] numberOfItemsBeforeAddingTheProduct = numberOfItems[1].split("");
		System.out.println(
				"number of items before adding the product in the cart is" + numberOfItemsBeforeAddingTheProduct[1]);
		int beforeAdding = Integer.parseInt(numberOfItemsBeforeAddingTheProduct[1]);
		/* selecting the module electronics */
		WebElement allCategories = hp.getCategories();
		Select sec = new Select(allCategories);
		sec.selectByVisibleText("Electronics");

		Reporter.log("successfully selected module electronics", true);

		String excelPath = "./src\\com\\testData\\Amazon scenario.xlsx";
		/* searching the product */
		hp.getSearchBox().sendKeys(flib.getExcelData(excelPath, "sheet3", 1, 0));
		hp.getSearchButton().click();

		String actualProductPageTitle = driver.getTitle().replaceAll(" ", "");
		String expProductPageTitle = "Amazon.in: apple Iphone Xr 64gb: Electronics".replaceAll(" ", "");
		Assert.assertEquals(actualProductPageTitle, expProductPageTitle);
		Reporter.log("apple iphone xr 64gb page successfully displayed", true);

		AppleIphoneXrPage iphoneXr = PageFactory.initElements(driver, AppleIphoneXrPage.class);

		/* Clicking on the product */
		iphoneXr.getAppleIphoneXrBlack().click();

		Reporter.log("apple iphone xr black 64 gb successfully displayed", true);

		AppleIphoneXrBlackPage iphoneBlack = PageFactory.initElements(driver, AppleIphoneXrBlackPage.class);
		iphoneBlack.getAddToCart().click();
		/* Adding the product to the cart */
		hp.getCart().click();
		Reporter.log("product is successfully added to the cart", true);

		/* reading the total number of items in the cart after adding the product */
		String totalNumberOfItemsAfterAddingTheProduct = shoppingCart.getSubtotal().getText();
		String[] numberOfItemsAfterAdding = totalNumberOfItemsAfterAddingTheProduct.split(" ");
		String[] numberOfItemsAfterAddingTheProduct = numberOfItemsAfterAdding[1].split("");
		System.out.println(
				"number of items after adding the product in the cart is " + numberOfItemsAfterAddingTheProduct[1]);

		int afterAdding = Integer.parseInt(numberOfItemsAfterAddingTheProduct[1]);

		boolean b = afterAdding > beforeAdding;

		Assert.assertTrue(b);
		Reporter.log("Product is successfully added to the cart", true);

	}

}
