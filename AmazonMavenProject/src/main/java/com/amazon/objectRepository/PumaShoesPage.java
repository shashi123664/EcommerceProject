package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PumaShoesPage {
	@FindBy(xpath="//i[@class=\"a-icon a-icon-share-facebook\"]")
	private WebElement facebookIcon;

	public WebElement getFacebookIcon() {
		return facebookIcon;
	}
	
	@FindBy(xpath="//i[@class=\"a-icon a-icon-share-twitter\"]")
	private WebElement twitterIcon;
	
	
	public WebElement getTwitterIcon() {
		return twitterIcon;
	}
	
	
	

}
