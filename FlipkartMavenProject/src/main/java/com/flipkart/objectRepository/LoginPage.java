package com.flipkart.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	@FindBy(xpath="(//input[@type=\"text\"])[2]")
	private WebElement emailTextField;
	
	
	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	@FindBy(xpath="//input[@type=\"password\"]")
	private WebElement passwordTextField;
	
	
	public WebElement getPasswordTExtField() {
		return passwordTextField;
	}
	
	@FindBy(xpath="(//span[text()='Login'])[2]")
	private WebElement loginButton;
	
	
	public WebElement getLoginButton() {
		return loginButton;
	}

}
