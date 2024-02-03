package com.pom_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class GetOrderDetails extends BaseClass{

	@FindBy(id = "email")
	private WebElement txtUsername;

	@FindBy(id = "pass")
	private WebElement txtPassword;

	@FindBy(xpath = "(//button[@type='submit'])[1]")
	private WebElement logInBtn;

	@FindBy(xpath="//a[@data-testid='username']")
	private static WebElement clkWelcomlink;
	
	@FindBy(xpath="//a[text()='orders']")
	private static WebElement clickOrders;
	
	@FindBy(xpath="(//a[text()='More Details'])[1]")
	private static WebElement clickMoreDetails;
	
	@FindBy(xpath="//div[@class='orderStatus']")
	private static WebElement orderText;

	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}

	public static WebElement getClkWelcomlink() {
		return clkWelcomlink;
	}

	public static WebElement getClickOrders() {
		return clickOrders;
	}

	public static WebElement getClickMoreDetails() {
		return clickMoreDetails;
	}
	
	public static WebElement getOrderText() {
		return orderText;
	}

	public void logIn(String userName, String passworrd) throws InterruptedException {

		PageFactory.initElements(wd, this);

		Thread.sleep(2000);
		sendKeys(getTxtUsername(), userName);
		sendKeys(getTxtPassword(), passworrd);
		elementtClick(getLogInBtn());

	}
	public void orderDetails() throws InterruptedException{
		
		PageFactory.initElements(wd, this);
		
		mouseHoverForSingleOption(getClkWelcomlink());
		Thread.sleep(1000);
		elementtClick(getClkWelcomlink());
		Thread.sleep(1000);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(1000);
		elementtClick(getClickOrders());
		Thread.sleep(1000);
		elementtClick(getClickMoreDetails());
		System.out.println(getElementText(getOrderText()));
		
	}
	
}