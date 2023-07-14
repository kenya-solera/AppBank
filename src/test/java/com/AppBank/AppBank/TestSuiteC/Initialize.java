package com.AppBank.AppBank.TestSuiteC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Initialize {

    protected WebDriver driver;

    @BeforeMethod
    void initialize() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/account");
    }
}
