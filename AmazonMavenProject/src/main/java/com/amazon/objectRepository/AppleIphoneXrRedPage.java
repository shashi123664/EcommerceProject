package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleIphoneXrRedPage {

	@FindBy(xpath="//input[@id=\"add-to-cart-button\"]")
	private WebElement addToCart;
	
	public WebElement getAddToCart()
	{
		return addToCart;
	}

}
