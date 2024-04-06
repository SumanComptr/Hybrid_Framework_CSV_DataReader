/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.blazed.qa.base.TestBase;

public class DestinationPage extends TestBase {

	@FindBy(xpath = "/html/body/div[3]/form/select[1]")
	@CacheLookup
	WebElement DDL_Departure;

	@FindBy(xpath = "/html/body/div[3]/form/select[2]")
	@CacheLookup
	WebElement DDL_Destination;

	@FindBy(xpath = "/html/body/div[3]/form/div/input")
	@CacheLookup
	WebElement BtnSubmit;

	public DestinationPage() {

		PageFactory.initElements(driver, this);
	}
	
	public String CheckPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
	}
	
	public String CheckPageUrl() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}
	
	public FlightSelectionPage DestinationSelect() throws InterruptedException {
		Thread.sleep(3000);
		Select ddlDeparture=new Select(DDL_Departure);
		ddlDeparture.selectByValue("Boston");
		
		Thread.sleep(3000);
		Select ddlDestination=new Select(DDL_Destination);
		ddlDestination.selectByValue("London");
		
		Thread.sleep(3000);
		
		BtnSubmit.click();
		
		return new FlightSelectionPage();
	}
	

}
