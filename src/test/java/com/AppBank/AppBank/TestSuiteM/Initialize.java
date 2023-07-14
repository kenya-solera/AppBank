package com.AppBank.AppBank.TestSuiteM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Initialize {
    protected WebDriver driver;

    @BeforeMethod
    void initializeLogin(){
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/login");
    }
}
