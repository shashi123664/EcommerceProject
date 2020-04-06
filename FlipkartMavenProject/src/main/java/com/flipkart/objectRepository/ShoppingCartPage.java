package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {
	
	@FindBy(xpath="//a[@class=\"_325-ji _3ROAwx\"]")
	private WebElement productName;
	
	
	public WebElement getProductName() {
		return productName;
	}
	
	@FindBy(xpath="//div[text()='Remove']")
	private WebElement removeButton;
	
	
	public WebElement getRemoveButton() {
		return removeButton;
	}
	
	@FindBy(xpath="(//div[text()='Remove'])[2]")
     private WebElement alertRemoveButton;	

	
	public WebElement getAlertRemoveButton() {
		return alertRemoveButton;
	}
}
