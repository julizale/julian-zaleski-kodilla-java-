package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FacebookTestingApp {

    public final static String XPATH_COOKIES_BUTTON = "//*[starts-with(@id, \"u_0_e\")]";
    public final static String XPATH_SIGN_IN_BUTTON = "//*[starts-with(@id, \"u_0_0\")]";
    public final static String XPATH_WAIT_FOR = "//div[contains(@class, \"large_form\")]";
    public final static String XPATH_SELECT_DAY = "//*[@id=\"day\"]";
    public final static String XPATH_SELECT_MONTH = "//*[@id=\"month\"]";
    public final static String XPATH_SELECT_YEAR = "//*[@id=\"year\"]";


    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES_BUTTON)).click();
        driver.findElement(By.xpath(XPATH_SIGN_IN_BUTTON)).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_WAIT_FOR)));

        Select selectDay = new Select(driver.findElement(By.xpath(XPATH_SELECT_DAY)));
        selectDay.selectByValue("8");

        Select selectMonth = new Select(driver.findElement(By.xpath(XPATH_SELECT_MONTH)));
        selectMonth.selectByValue("8");

        Select selectYear = new Select(driver.findElement(By.xpath(XPATH_SELECT_YEAR)));
        selectYear.selectByValue("1998");
    }

}
