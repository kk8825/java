package com.pom_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class LogInPage extends BaseClass {

	@FindBy(id = "email")
	private WebElement txtUsername;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement logInBtn;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}

	public void logIn(String userName, String passworrd) {

		PageFactory.initElements(wd, this);

		sendKeys(getTxtUsername(), userName);
		sendKeys(getTxtPassword(), passworrd);
		elementtClick(getLogInBtn());

	}
}