package com.automation.amazon.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.automation.amazon.util.BrowserType;

public class Configuration {

	public static BrowserType Browser = BrowserType.UseDefault;
	public static int TimeOut = 10;
	public static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String os = System.getProperty("os.name").toLowerCase();

		String DriverDirectory = "user.dir";

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", DriverDirectory + "chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", DriverDirectory + "chromedriver.exe");
		}

		switch (Configuration.Browser) {
		case Chrome:
			driver = new ChromeDriver();
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		case Firefox:
			driver = new FirefoxDriver();
			break;
		default:
			// We only support Chrome, IE, Firefox. We default to Chrome
			driver = new ChromeDriver();
			break;
		}
	}
}
