package com.flipkartTestScript;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
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
import com.genericLib.BaseClass;

@Listeners(com.listener.EventListener.class)
public class Share_The_Product_On_Facebook extends BaseClass {

	@Test
	public void Share_The_Product_On_Facebook() throws Throwable {

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

		/* clicking on the share button */
		fp.getShareButton().click();

		/* clicking on the facebook icon */
		fp.getFacebookLink().click();
		Set<String> ids2 = driver.getWindowHandles();
		Iterator<String> i2 = ids2.iterator();
		String parentId2 = i2.next();
		String childId2 = i2.next();
		String childId3 = i2.next();

		/* Switching the window to facebook page */
		driver.switchTo().window(childId3);

		/* getting the title and compare */
		String expectedFacebookTitle = driver.getTitle();
		String actualFacebookTitle = "Facebook";

		Assert.assertEquals(actualFacebookTitle, expectedFacebookTitle);
		Reporter.log("user can able to share the product on facebook", true);

		/* Switching to parent window */
		driver.switchTo().window(parentId2);

	}
}
