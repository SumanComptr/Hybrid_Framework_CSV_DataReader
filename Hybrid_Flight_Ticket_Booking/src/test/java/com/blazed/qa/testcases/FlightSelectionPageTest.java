/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.testcases;

import org.testng.annotations.Test;

import com.blazed.qa.base.TestBase;
import com.blazed.qa.pages.DestinationPage;
import com.blazed.qa.pages.FlightSelectionPage;
import com.blazed.qa.pages.PurchaseTicketPage;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FlightSelectionPageTest extends TestBase {
	DestinationPage dest;
	FlightSelectionPage flightselect;
	PurchaseTicketPage purchaseticket;

	public FlightSelectionPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		Initialization();
		dest = new DestinationPage();
		flightselect = dest.DestinationSelect();
	}

	@Test(priority = 1)
	public void verifyFlightPageUrl() throws InterruptedException {
		Thread.sleep(2000);
		String strUrl = flightselect.FlightPageUrl();
		Assert.assertEquals(strUrl, "https://blazedemo.com/reserve.php");
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void verifyFlightPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		String strTitle = flightselect.FlightPageTitle();
		// System.out.println("Title : " + strTitle);
		Assert.assertEquals(strTitle, "BlazeDemo - reserve");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void verifyPurchaseTicketPage() throws InterruptedException {
		Thread.sleep(2000);
		purchaseticket = flightselect.purchaseticket();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
