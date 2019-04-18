package com.automation.amazon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.amazon.config.WebConfiguration;

public class DriverHelper {
	
    public static boolean AssertElementIsAbsent(By by) throws Exception {
        WebDriver driver = WebConfiguration.driver;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException e) {
            return true;
        }
        throw new Exception(String.format("Element is expected to be absent but is present"));
    }
    
    public static boolean AssertPageTitleContains(String partialTitle) throws Exception {

        WebDriver driver = WebConfiguration.driver;

        boolean result = (new WebDriverWait(driver, WebConfiguration.TimeOut))
                .until(ExpectedConditions.titleContains(partialTitle));

        return result;
    }

    public static boolean AssertPageUrlStartsWith(String givenUrl) throws Exception {

        WebDriver driver = WebConfiguration.driver;
        String currUrl = driver.getCurrentUrl();
        boolean result = currUrl.toLowerCase().startsWith(givenUrl.toLowerCase());
        if(!result) {
            throw new Exception(String.format("%s does not start with %s", currUrl, givenUrl));
        }
        return result;
    }

}
