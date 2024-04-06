/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();

			FileReader reader = new FileReader(
					"C:\\Users\\suman\\eclipse-workspace\\Hybrid_Flight_Ticket_Booking\\src\\test\\java\\com\\blazed\\qa\\config\\config.properties");

			prop.load(reader);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialization() {
		
		String StrBrowser=prop.getProperty("browser");
		String StrUrl=prop.getProperty("url");
		
		if (StrBrowser.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(StrUrl);
		
	}

}
