package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginButton;
	
	public WebElement  getLoginButton() {
		return loginButton;
	}
	
	@FindBy(xpath="//input[@title=\"Search for products, brands and more\"]")
	private WebElement searchTextField;
	
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	@FindBy(xpath="//span[text()='Cart']")
	private WebElement cart;
	
	
	public WebElement getCart() {
		return cart;
	}
	
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccount;
	
	
	
	public WebElement getMyAccount()
	{
		return myAccount;
	}

	
	@FindBy(xpath="//div[text()='Wishlist']")
	private WebElement wishlist;
	
	
	public WebElement getWishlist() {
		return wishlist;
	}
	
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement logout;
	
	
	
	public WebElement getLogout() {
		return logout;
	}
		
		@FindBy(xpath="//button[@type=\"submit\"]")
		private WebElement submitButton;
		
		public WebElement getSubmitButton() {
			return submitButton;
		}
}
