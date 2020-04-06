package com.amazon.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {

	@FindBy(xpath="//input[@name=\"email\"]")
	private WebElement email;
	
	@FindBy(xpath="//input[@id=\"continue\"]")
	private WebElement continuebutton;
		
    @FindBy(xpath="//input[@name=\"password\"]")
    private WebElement password;
    
    @FindBy(xpath="//input[@id=\"signInSubmit\"]")
    private WebElement  logIn;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogIn() {
		return logIn;
	}

}
