package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage {
	
	@FindBy(xpath="//div[text()='Parle Hide & Seek Chocolate Chip Cookies']")
	private WebElement productNameInWishList;
	
	public WebElement getProductNameInWishlist() {
		return productNameInWishList;
	}

}
