/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazed.qa.base.TestBase;

public class FlightSelectionPage extends TestBase {

	@FindBy(xpath = "/html/body/div[2]/table/tbody/tr[4]/td[1]/input")
	@CacheLookup
	WebElement BtnFlight;

	public FlightSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	public String FlightPageUrl() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}

	public String FlightPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
	}

	public PurchaseTicketPage purchaseticket() throws InterruptedException {
		Thread.sleep(2000);
		BtnFlight.click();
		return new PurchaseTicketPage();
	}

}
