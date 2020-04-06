package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleIphoneXrPage {
	
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Black']")
	private WebElement appleIphoneXrBlack;

	public WebElement getAppleIphoneXrBlack() {
		return appleIphoneXrBlack;
	}
	
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) (Product) RED']")
	private WebElement appleIphoneXrRed;

	public WebElement getAppleIphoneXrRed() {
		return appleIphoneXrRed;
	}
	
	
		

}
