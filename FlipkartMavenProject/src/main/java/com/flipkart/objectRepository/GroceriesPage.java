package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroceriesPage {
	
	@FindBy(xpath="//a[@class=\"_2cLu-l\"]")
	private WebElement firstProduct;
	
	
	public WebElement getFirstProduct() {
		return firstProduct;
	}

}
