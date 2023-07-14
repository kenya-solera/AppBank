package com.AppBank.AppBank.testSuiteK;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_03_001 extends InitiateDriverTransaction {

    @Test
    public void test_03_001_DataLoadingFromDatabase() throws InterruptedException {
        String textInTable = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(2) > .MuiTableCell-root:nth-child(2)")).getText();
        Assert.assertNotNull(textInTable);
    }

    @Test
    public void test_03_002_Transactions_inFriends_Different_From_Everyone() throws InterruptedException {
        String textInEveryone = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2)")).click();
        String textInFriends = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        Assert.assertNotEquals(textInEveryone, textInFriends);
    }

    @Test
    public void test_03_003_Transactions_inFriends_Different_From_Mine() throws InterruptedException {
        driver.findElement(By.cssSelector(".MuiButtonBase-root:nth-child(2)")).click();
        String textInFriends = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        driver.findElement(By.cssSelector(".MuiTab-root:nth-child(3)")).click();
        String textInMine = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        Assert.assertNotEquals(textInMine, textInFriends);
    }

    @Test
    public void test_03_004_Transactions_in_Mine_Different_From_Everyone() throws InterruptedException {
        driver.findElement(By.cssSelector(".MuiTab-root:nth-child(1)")).click();
        String textInEveryone = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        driver.findElement(By.cssSelector(".MuiTab-root:nth-child(3)")).click();
        String textInMine = driver.findElement(By.cssSelector(".MuiTableRow-root:nth-child(1) > .MuiTableCell-body:nth-child(2)")).getText();
        Assert.assertNotEquals(textInEveryone, textInMine);
    }

    @Test

}
