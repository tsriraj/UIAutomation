package com.automation.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.automation.amazon.config.WebConfiguration;
import com.automation.amazon.pages.base.BasePage;
import com.automation.amazon.util.DriverHelper;

public class HomePage extends BasePage{
	
	 @FindBy (css="#nav-link-accountList")
	 private WebElement accountAndLists;
	 
	 @FindBy (css="[data-nav-ref='nav_signin']")
	 private WebElement signInButton;

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void AtChecker() throws Exception{
		DriverHelper.AssertPageTitleContains("Amazon");
		DriverHelper.AssertPageUrlStartsWith(WebConfiguration.BaseUrl);
	}

	public void ClickOnSignIn() {
        Actions hoverAccountAndLists = new Actions(driver);
        hoverAccountAndLists.moveToElement(accountAndLists).build().perform();
        signInButton.click();
    }

}
