package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FirstProductPage {
	
	@FindBy(xpath="//input[@placeholder=\"Enter Delivery Pincode\"]")
	private WebElement deliveryPincodeTextField;

	
	public WebElement getDeliveryPincodeTextField() {
		return deliveryPincodeTextField;
	}
	
	@FindBy(xpath="//div[text()='Currently out of stock in this area.']")
	private WebElement deliveryDate;
	
	
	public WebElement getDeliveryDate() {
		return deliveryDate;
	}
	
	
	@FindBy(xpath="//span[text()='Share']/..")
	private WebElement shareButton;
	
	
	public WebElement getShareButton() {
		return shareButton;
	}
	
	@FindBy(xpath="//img[@alt=\"Facebook\"]")
	private WebElement facebookLink;
	
	public WebElement getFacebookLink() {
		return facebookLink;
	}
	
	@FindBy(xpath="//img[@alt=\"Twitter\"]")
	private WebElement twitterLink;
	
	public WebElement getTwitterLink() {
		return twitterLink;
	}
	
	
	@FindBy(xpath="//span[@class=\"_35KyD6\"]")
	private WebElement firstProductName;
	
	
	public WebElement getFirstProductName() {
		return firstProductName;
	}
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCart;
	
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	
	@FindBy(xpath="//div[@class=\"_3gDSOa _13EqDR\"]")
	private WebElement whislistButton;
	
	
	public WebElement getWhislistButton() {
		return whislistButton;
	}
	@FindBy(xpath="//span[text()='Check']")
	private WebElement checkButton;
	
	
	public WebElement getCheckButton() {
		return checkButton;
	}
}
