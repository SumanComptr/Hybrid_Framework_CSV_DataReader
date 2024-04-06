/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import com.blazed.qa.base.TestBase;


public class PurchaseTicketPage extends TestBase {
	@FindBy(xpath = "//*[@id=\"inputName\"]")
	@CacheLookup
	WebElement txtName;

	@FindBy(xpath = "//*[@id=\"address\"]")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(xpath = "//*[@id=\"city\"]")
	@CacheLookup
	WebElement txtCity;

	@FindBy(xpath = "//*[@id=\"state\"]")
	@CacheLookup
	WebElement txtState;

	@FindBy(xpath = "//*[@id=\"zipCode\"]")
	@CacheLookup
	WebElement txtZip;

	@FindBy(xpath = "//*[@id=\"cardType\"]")
	@CacheLookup
	WebElement ddlCardType;

	@FindBy(xpath = "//*[@id=\"creditCardNumber\"]")
	@CacheLookup
	WebElement txtCreditCard;

	@FindBy(xpath = "//*[@id=\"creditCardMonth\"]")
	@CacheLookup
	WebElement txtCardMonth;

	@FindBy(xpath = "//*[@id=\"creditCardYear\"]")
	@CacheLookup
	WebElement txtCardYear;

	@FindBy(xpath = "//*[@id=\"nameOnCard\"]")
	@CacheLookup
	WebElement txtNameonCard;

	@FindBy(xpath = "/html/body/div[2]/form/div[11]/div/input")
	@CacheLookup
	WebElement BtnPurchase;
	
	public PurchaseTicketPage() {
		
		PageFactory.initElements(driver,this);
	}

	public String verifyPurchaseUrl() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}

	public String verifyPurchaseTitle() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
	}

	public PurchaseConfirmPage purchaseconfirm(String strNamePage, String strAddrPage, String strCityPage, String strStatePage, 
			String strZipCodePage,String strCardTypePage, String strCreditCardNumPage, String strMonthPage, String strYearPage, 
			String strNameOnCardPage) throws InterruptedException {
		//System.out.println(strNamePage);
		
		Thread.sleep(2000);
		
		txtName.clear();
		txtName.sendKeys(strNamePage);
		Thread.sleep(2000);
		
		txtAddress.clear();
		txtAddress.sendKeys(strAddrPage);
		Thread.sleep(2000);
		
		txtCity.clear();
		txtCity.sendKeys(strCityPage);
		Thread.sleep(2000);
		
		txtState.clear();
		txtState.sendKeys(strStatePage);
		Thread.sleep(2000);
		
		txtZip.clear();
		txtZip.sendKeys(strZipCodePage);
		Thread.sleep(2000);
		
		Select ddlcardtype=new Select(ddlCardType);
		ddlcardtype.selectByValue(strCardTypePage);
		Thread.sleep(2000);
		
		txtCreditCard.clear();
		txtCreditCard.sendKeys(strCreditCardNumPage);
		Thread.sleep(2000);
		
		txtCardMonth.clear();
		txtCardMonth.sendKeys(strMonthPage);
		Thread.sleep(2000);
		
		txtCardYear.clear();
		txtCardYear.sendKeys(strYearPage);
		Thread.sleep(2000);
		
		txtNameonCard.clear();
		txtNameonCard.sendKeys(strNameOnCardPage);
		Thread.sleep(2000);
				

		BtnPurchase.click();
		Thread.sleep(2000);

		return new PurchaseConfirmPage();
	}
	
	

}
