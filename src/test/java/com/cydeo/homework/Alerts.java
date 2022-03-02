package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void TC_1_testJavaScriptAlerts() {
        //Click to “Click for JS Alert” button
        WebElement clickButton = driver.findElement(By.xpath("//div/button[. = 'Click for JS Alert']"));
        clickButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // Verify “You successfully clicked an alert” text is displayed.
        WebElement text = driver.findElement(By.xpath("//p[. = 'You successfully clicked an alert']"));
        String actualText = text.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expectedText, "Passed !!!");

/*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfully clicked an alert” text is displayed.

 */

    }

    @Test
    public void TC_2_testJavaScriptAlerts() {
        WebElement button = driver.findElement(By.xpath("//div[@class = 'container']/button[2]"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement text = driver.findElement(By.xpath("//p[. = 'You clicked: Cancel']"));
        String actualText = text.getText();
        String expectedText = "You clicked: Cancel";
        Assert.assertEquals(actualText,expectedText, "PASSED !!!");

    }

    @Test
    public void TC_3_testJavaScriptAlerts(){

        WebElement button = driver.findElement(By.xpath("//div/button[3]"));
        button.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        WebElement result = driver.findElement(By.xpath("//p[@id = 'result']"));
        String actualResult = result.getText();
        String expectedResult = "You entered: hello";
        Assert.assertEquals(actualResult,expectedResult, "PASSED !!!");

        /*
        TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.

         */

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}









/*
TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify You clicked: Cancel text is displayed.

 */