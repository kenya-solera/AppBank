package com.AppBank.AppBank.TestSuiteM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//Tests cases about Login page
public class  TC_01_001 extends Initialize{

@Test
    void happyLogin(){
        WebElement usernameInput = driver.findElement(By.id("userName"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".MuiButton-root"));

        //http://localhost:3000/user/settings/
        usernameInput.sendKeys("solera@solera.com");
        passwordInput.sendKeys("bootcamp2");
        loginButton.click();
        loginButton.click();
        loginButton.click();
        String nextPageURL = driver.getCurrentUrl();
        String result = nextPageURL;
        System.out.println(result);

        Assert.assertTrue(result.contains("localhost:3000/user/settings/"));



}
}
