package com.amazon.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
   
	@FindBy(xpath="//select[@id=\"searchDropdownBox\"]")
	private WebElement categories;
	
	@FindBy(xpath="//a[@aria-label=\"Open Menu\"]")
	private WebElement moreMenu;
	
	@FindBy(xpath="//input[@id=\"twotabsearchtextbox\"]")
	private WebElement searchBox;
	
	@FindBy(xpath="//a[@id=\"nav-cart\"]")
	private WebElement cart;
	
	@FindBy(xpath="//span[text()='Sign Out']")
private WebElement signOut;
	
	@FindBy(xpath="//span[text()='Hello. Sign in']")
	private WebElement helloSignIn;
	
	
	@FindBy(xpath="//div[@id=\"nav-al-signin\"]/descendant::span")
	private WebElement signIn;
	
	@FindBy(xpath="//a[@id=\"nav-link-accountList\"]")
	private WebElement accountsAndList;
	
	@FindBy(xpath="//input[@value=\"Go\"]")
	private WebElement searchButton;
	
	
	@FindBy(xpath="//span[contains(text(),'Deliver to')]/ancestor::a/div[@id=\"nav-packard-glow-loc-icon\"]")
	private WebElement locationIcon;
	
	public WebElement getLocationIcon() {
		return locationIcon;
	}
	
	@FindBy(xpath="//input[@aria-label=\"or enter a pincode\"]")
	private WebElement enterAPincode;
	
	public WebElement getEnterAPincode() {
		return enterAPincode;
	}
	
	@FindBy(xpath="//span[text()='Apply' and @class=\"a-button-text\"]")
	private WebElement apply;
	
	
	public WebElement getApply() {
		return apply;
	}
	
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public WebElement getAccountsAndList()
	{
		return accountsAndList;
	}
	
	public WebElement getSignIn()
	{
		return signIn;
	}
	
	public WebElement getHelloSignIn() {
		return helloSignIn;
	}
	
	public WebElement getSignOut() {
		return signOut;
	}
	public WebElement getCategories() {
		return categories;
	}

	public WebElement getMoreMenu() {
		return moreMenu;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getCart() {
		return cart;
	}
	
}
