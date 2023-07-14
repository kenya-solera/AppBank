package com.AppBank.AppBank.TestSuiteC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC_02_002 extends Initialize {


    @Test
    void CreateButton(){

        driver.get("http://localhost:3000/account");

        WebElement createButton = driver.findElement(By.id("create"));
        if (createButton.isDisplayed()){
            System.out.println("Create button is displayed");
        }else{
            System.out.println("Create button is not displayed");
        }

        driver.quit();
    }

    @Test
    void DeleteButton(){


        driver.get("http://localhost:3000/account");

        WebElement createButton = driver.findElement(By.id("delete"));
        if (createButton.isDisplayed()){
            System.out.println("Create button is displayed");
        }else{
            System.out.println("Create button is not displayed");
        }

        driver.quit();
    }
    }


