package com.pom_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class Payment extends BaseClass {

	@FindBy(xpath = "//select[@id='payment_type']")
	private static WebElement selectPaymentType;

	@FindBy(xpath = "//label[@for='visa_card']")
	private static WebElement clickVisaBtn;

	@FindBy(xpath = "//input[@placeholder='Card Number']")
	private static WebElement enterCardNo;

	@FindBy(xpath = "//select[@id='month']")
	private static WebElement selectMonth;

	@FindBy(xpath = "//select[@id='year']")
	private static WebElement selectYear;

	@FindBy(xpath = "//input[@placeholder='CVV']")
	private static WebElement enterCvv;

	@FindBy(xpath = "//button[@id='placeOrder']")
	private static WebElement clickPlaceOrder;

	public static WebElement getSelectPaymentType() {
		return selectPaymentType;
	}

	public static WebElement getClickVisaBtn() {
		return clickVisaBtn;
	}

	public static WebElement getEnterCardNo() {
		return enterCardNo;
	}

	public static WebElement getSelectMonth() {
		return selectMonth;
	}

	public static WebElement getSelectYear() {
		return selectYear;
	}

	public static WebElement getEnterCvv() {
		return enterCvv;
	}

	public static WebElement getClickPlaceOrder() {
		return clickPlaceOrder;
	}

	public void payment(String selectPaymentType) throws InterruptedException {

		PageFactory.initElements(wd, this);
		
		Thread.sleep(1000);
		selectByVisibleText(getSelectPaymentType(), selectPaymentType);
		Thread.sleep(1000);
		elementtClick(getClickVisaBtn());
	}

	public void payment1(String enterCardNo, String selectMonth, String selectYear, String enterCvv)
			throws InterruptedException {

		PageFactory.initElements(wd, this);

		sendKeys(getEnterCardNo(), enterCardNo);
		Thread.sleep(1000);
		selectByVisibleText(getSelectMonth(), selectMonth);
		Thread.sleep(1000);
		selectByVisibleText(getSelectYear(), selectYear);
		Thread.sleep(2000);
		sendKeys(getEnterCvv(), enterCvv);
		Thread.sleep(1000);
		elementtClick(getClickPlaceOrder());

	}

}