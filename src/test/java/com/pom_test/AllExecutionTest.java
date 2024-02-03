package com.pom_test;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import com.baseClass.BaseClass;
import com.pom_pages.AddAddress;
import com.pom_pages.GetOrderDetails;
import com.pom_pages.LogInPage;
import com.pom_pages.Payment;
import com.pom_pages.SearchProductAndAddtoCart;

public class AllExecutionTest extends BaseClass {

	public AllExecutionTest(){
		
		PageFactory.initElements(wd, this);
	}
	@Test
	public void booking() throws IOException, InterruptedException{
		
		launchBrowser();
		implicityWait();
		maximizeWindow();
		getUrl("https://www.omrbranch.com/");
		
		
		LogInPage page = new LogInPage();
		
		page.logIn(readCellData("OmrDatas", 1, 0), readCellData("OmrDatas", 1, 1));
		
	
		SearchProductAndAddtoCart spadc = new SearchProductAndAddtoCart();
		
		spadc.placeOrder(readCellData("OmrDatas", 1, 2));
		
		
		AddAddress addres = new AddAddress();
		
		addres.fillDeliveryAddres(readCellData("OmrDatas", 1, 3));
		addres.fillDelivertAddres1(readCellData("OmrDatas", 1, 4), readCellData("OmrDatas", 1, 5),readCellData("OmrDatas", 1, 6), 
			readCellData("OmrDatas", 1, 7), readCellData("OmrDatas", 1, 8));
		addres.fillDelivertAddres2(readCellData("OmrDatas", 1, 10), readCellData("OmrDatas", 1, 11),
				readCellData("OmrDatas", 1, 12));
		
		
		Payment pay = new Payment();
		
		pay.payment(readCellData("OmrDatas", 1, 13));
		pay.payment1(readCellData("OmrDatas", 1, 14), readCellData("OmrDatas", 1, 15), 
				              readCellData("OmrDatas", 1, 16), readCellData("OmrDatas", 1, 17));
		
		
		GetOrderDetails details = new GetOrderDetails();

		details.logIn(readCellData("OmrDatas", 1, 0), readCellData("OmrDatas", 1, 1));
		details.orderDetails();
		
		Thread.sleep(3000);
		wd.quit();
		
	}
	
}