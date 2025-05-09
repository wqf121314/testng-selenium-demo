package com.selenium.test;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.selenium.utils.WebDriverFactory;

@Slf4j
public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        WebDriverFactory.getDriver(WebDriverFactory.BrowserType.CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    protected WebDriver getDriver() {
        return WebDriverFactory.getDriver(WebDriverFactory.BrowserType.CHROME);
    }
}