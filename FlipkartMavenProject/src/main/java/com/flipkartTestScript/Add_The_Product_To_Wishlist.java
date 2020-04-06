package com.flipkartTestScript;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flipkart.objectRepository.FirstProductPage;
import com.flipkart.objectRepository.GroceriesPage;
import com.flipkart.objectRepository.HomePage;
import com.flipkart.objectRepository.WishlistPage;
import com.genericLib.BaseClass;

@Listeners(com.listener.EventListener.class)
public class Add_The_Product_To_Wishlist extends BaseClass {

	@Test
	public void Add_The_Product_To_Wishlist() throws Throwable {

		HomePage hp = PageFactory.initElements(driver, HomePage.class);

		/* seacrhing the product in search text field */

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(hp.getSearchTextField()));
		Thread.sleep(2000);

		/* searching the product */
		hp.getSearchTextField().sendKeys("biscuits", Keys.ENTER);

		Thread.sleep(5000);

		String actualGroceriesTitle = driver.getTitle().replaceAll(" ", "");
		String expectedGroceriesTitle = "Biscuits - Buy Products Online at Best Price in India - All Categories | Flipkart.com"
				.replaceAll(" ", "");
		Assert.assertEquals(actualGroceriesTitle, expectedGroceriesTitle);
		Reporter.log("Groceries page is displayed", true);

		/* click on the first product */
		GroceriesPage gp = PageFactory.initElements(driver, GroceriesPage.class);

		/* clicking on the first product */
		gp.getFirstProduct().click();

		Set<String> sessionId = driver.getWindowHandles();

		Iterator<String> i = sessionId.iterator();

		String parentSessionId = i.next();
		String childSessionId = i.next();

		driver.switchTo().window(childSessionId);

		FirstProductPage fp = PageFactory.initElements(driver, FirstProductPage.class);
		Thread.sleep(5000);

		String actualProductName = fp.getFirstProductName().getText();

		/* clicking on the wishlist icon */
		fp.getWhislistButton().click();

		Actions act = new Actions(driver);

		WebElement myAcc = hp.getMyAccount();
		act.moveToElement(myAcc).perform();

		hp.getWishlist().click();

		WishlistPage wp = PageFactory.initElements(driver, WishlistPage.class);

		String expectedProductName = wp.getProductNameInWishlist().getText();

		if (actualProductName.contains(expectedProductName)) {

			Reporter.log("Product is successfully added to the wishlist", true);
		}

	}
}
