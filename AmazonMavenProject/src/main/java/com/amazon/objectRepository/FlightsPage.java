package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightsPage {
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchButton;
	
	
	@FindBy(xpath="//input[@placeholder=\"Select Airport\"]")
	private WebElement toCity;
	
	@FindBy(xpath="")
	private WebElement fromCity;

}
