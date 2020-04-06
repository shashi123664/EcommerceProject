package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleIphoneXrBlackPage {
   
	@FindBy(xpath="//input[@id=\"add-to-cart-button\"]")
	private WebElement addToCart;
	
	public WebElement getAddToCart()
	{
		return addToCart;
	}
	
	@FindBy(xpath="//span[contains(text(),'Apple iPhone XR (64GB) - Black')]/ancestor::div[@id=\"centerCol\"]//div[@id=\"ddmDeliveryMessage\"]/span")
	private WebElement deliveryDate;

	public WebElement getDeliveryDate() {
		return deliveryDate;
	}
	
	@FindBy(xpath="//i[contains(@class,'a-icon a-icon-star a-star')]/span")
	private WebElement ratings;
	
	public WebElement getRatings() {
		return ratings;
	}
}
