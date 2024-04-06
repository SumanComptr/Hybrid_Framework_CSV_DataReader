/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.testcases;

import org.testng.annotations.Test;

import com.blazed.qa.base.TestBase;
import com.blazed.qa.pages.DestinationPage;
import com.blazed.qa.pages.FlightSelectionPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class DestinationPageTest extends TestBase {

	DestinationPage destpage;
	FlightSelectionPage flightselect;

	public DestinationPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		Initialization();

		destpage = new DestinationPage();
	}

	@Test(priority = 1)
	public void CheckPageTitle() throws InterruptedException {

		String strSystemPageTitle = destpage.CheckPageTitle();

		Assert.assertEquals(strSystemPageTitle, "BlazeDemo");
	}
	@Test(priority=2)
	public void CheckPageUrl() throws InterruptedException {
		String strSystemPageurl = destpage.CheckPageUrl();
		Assert.assertEquals(strSystemPageurl, "https://blazedemo.com/");

	}

	@Test(priority = 3)
	public void CheckFlight() throws InterruptedException {

		destpage.DestinationSelect();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
