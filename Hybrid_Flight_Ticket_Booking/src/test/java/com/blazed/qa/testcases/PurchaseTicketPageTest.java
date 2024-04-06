/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.testcases;

import org.testng.annotations.Test;

import com.blazed.qa.base.TestBase;
import com.blazed.qa.pages.DestinationPage;
import com.blazed.qa.pages.FlightSelectionPage;
import com.blazed.qa.pages.PurchaseConfirmPage;
import com.blazed.qa.pages.PurchaseTicketPage;
import com.blazed.qa.utility.DataReader;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class PurchaseTicketPageTest extends TestBase {

	DestinationPage dest;
	FlightSelectionPage flightselect;
	PurchaseTicketPage purchaseTicket;
	PurchaseConfirmPage purchaseConfirm;

	public PurchaseTicketPageTest() {
		super();
	}

	@Test(dataProvider = "registerblazedemo")
	public void RegisterUser(String strName, String strAddr, String strCity, String strState, String strZipCode,
			String strCardType, String strCreditCardNum, String strMonth, String strYear, String strNameOnCard)
			throws InterruptedException {

		purchaseTicket.purchaseconfirm(strName, strAddr, strCity, strState, strZipCode, strCardType, strCreditCardNum,
				strMonth, strYear, strNameOnCard);

	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		Initialization();

		dest = new DestinationPage();
		flightselect = dest.DestinationSelect();

		purchaseTicket = flightselect.purchaseticket();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}

	@DataProvider(name = "registerblazedemo")
	public Object[][] blazeRegister() {
		List<String[]> allData = DataReader.getCSVData("D:\\BlazeDemoRegister.csv", 1);

		String[][] strData = new String[allData.size()][allData.get(0).length];

		int i = 0;
		for (String[] row : allData) {
			int j = 0;
			for (String cell : row) {
				strData[i][j] = cell;
				j = j + 1;
			}
			i = i + 1;
		}
		return strData;
	}

}
