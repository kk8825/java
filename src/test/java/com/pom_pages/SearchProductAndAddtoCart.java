package com.pom_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class SearchProductAndAddtoCart extends BaseClass {

	@FindBy(xpath = "//input[@id='search']")
	private static WebElement searchBox;

	@FindBy(xpath = "(//a[contains(text(),'Add')])[1]")
	private static WebElement addBtn;

	@FindBy(xpath = "//button[@id='cart-21']")
	private static WebElement addBtnOne;

	@FindBy(xpath = "//button[@id='cart-22']")
	private static WebElement addBtnTwo;

	@FindBy(xpath = "//a[contains(text(),'Go To Cart')]")
	private static WebElement goToCart;

	public static WebElement getSearchBox() {
		return searchBox;
	}

	public static WebElement getAddBtn() {
		return addBtn;
	}

	public static WebElement getAddBtnOne() {
		return addBtnOne;
	}

	public static WebElement getAddBtnTwo() {
		return addBtnTwo;
	}

	public static WebElement getGoToCart() {
		return goToCart;
	}

	public void placeOrder(String searchBox) throws InterruptedException{
		
	PageFactory.initElements(wd, this);
		
	sendKeys(getSearchBox(), searchBox);
	enter(getSearchBox());
	elementtClick(addBtn);
	Thread.sleep(2000);
	elementtClick(addBtnOne);
	Thread.sleep(2000);
	elementtClick(addBtnTwo);
	Thread.sleep(2000);
	elementtClick(goToCart);
	
	}
	
}