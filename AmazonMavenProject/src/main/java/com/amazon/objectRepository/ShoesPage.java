package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoesPage {
@FindBy(xpath="//span[text()='Brands']/ancestor::div[@id=\"brandsRefinements\"]/descendant::span[text()='Puma']")
private WebElement filterShoes;

public WebElement getFilterShoes() {
	return filterShoes;
}

@FindBy(xpath="//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
private WebElement pumaShoes;

public WebElement getPumaShoes() {
	return pumaShoes;
}

}
