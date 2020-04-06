package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage {

	@FindBy(xpath="//span[@id=\"sc-subtotal-label-buybox\"]")
	private WebElement subtotal;
	
	
	@FindBy(xpath="//input[@aria-label=\"Delete Apple iPhone XR (64GB) (Product) RED\"]")
	private WebElement delete;
	
	public WebElement getDelete() {
		return delete;
	}
	
	public WebElement getSubtotal() {
	return subtotal;
	}
}
