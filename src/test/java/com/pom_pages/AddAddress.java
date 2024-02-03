package com.pom_pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseClass.BaseClass;

public class AddAddress extends BaseClass {

	@FindBy(xpath = "//div[@data-target='#addressModal']")
	private WebElement clickDelryvAddresBtn;

	@FindBy(xpath = "//select[@id='address_type']")
	private WebElement selectAddressType;

	@FindBy(xpath = "//input[@placeholder='First name*']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last name*']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Contact No*']")
	private WebElement contactNo;

	@FindBy(xpath = "//input[@placeholder='House No*']")
	private WebElement houseNo;

	@FindBy(xpath = "//input[@placeholder='Address*']")
	private WebElement address;

	// @FindBy(xpath = "//select[@name='country']")
	// private WebElement selectCuntry;

	@FindBy(xpath = "//select[@name='state']")
	private WebElement selectState;

	@FindBy(xpath = "//select[@name='city']")
	private WebElement selectCity;

	@FindBy(xpath = "//input[@name='zipcode']")
	private WebElement zipCode;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement clickSaveBtn;

	public WebElement getClickDelryvAddresBtn() {
		return clickDelryvAddresBtn;
	}

	public WebElement getSelectAddressType() {
		return selectAddressType;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getContactNo() {
		return contactNo;
	}

	public WebElement getHouseNo() {
		return houseNo;
	}

	public WebElement getAddress() {
		return address;
	}

	/*
	 * public WebElement getSelectCuntry() { return selectCuntry; }
	 */

	public WebElement getSelectState() {
		return selectState;
	}

	public WebElement getSelectCity() {
		return selectCity;
	}

	public WebElement getZipCode() {
		return zipCode;
	}

	public WebElement getClickSaveBtn() {
		return clickSaveBtn;
	}

	public void fillDeliveryAddres(String selectAddressType) throws IOException, InterruptedException {

		PageFactory.initElements(wd, this);
		
		
		elementtClick(clickDelryvAddresBtn);
		Thread.sleep(1000);
		selectByVisibleText(getSelectAddressType(), selectAddressType);

	}

	public void fillDelivertAddres1(String firstName, String lasttName, String contactNo, String houseNo,
			String address) throws IOException, InterruptedException {

		PageFactory.initElements(wd, this);

		sendKeys(getFirstName(), firstName);
		Thread.sleep(1000);
		sendKeys(getLastName(), lasttName);
		Thread.sleep(1000);
		sendKeys(getContactNo(), contactNo);
		Thread.sleep(1000);
		sendKeys(getHouseNo(), houseNo);
		sendKeys(getAddress(), address);

	}

	public void fillDelivertAddres2(String selectState, String selectCity, String zipCode) throws InterruptedException {

		PageFactory.initElements(wd, this);

		selectByVisibleText(getSelectState(), selectState);
		Thread.sleep(1000);
		selectByVisibleText(getSelectCity(), selectCity);
		Thread.sleep(1000);
		sendKeys(getZipCode(), zipCode);
		Thread.sleep(1000);
		elementtClick(getClickSaveBtn());

	}

}