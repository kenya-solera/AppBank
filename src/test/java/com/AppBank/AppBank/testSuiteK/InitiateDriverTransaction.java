package com.AppBank.AppBank.testSuiteK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class InitiateDriverTransaction {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:3000/personal");

    }

    @AfterClass
    public void shutDown() {
        driver.close();
    }
}
