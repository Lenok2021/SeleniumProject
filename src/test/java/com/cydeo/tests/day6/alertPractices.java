package com.cydeo.tests.day6;

import com.cydeo.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class alertPractices {

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts  ");


    }

    @Test
    public void alert_test1() {
        //Click to “Click for JS Alert” button.
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert'] "));
        informationAlertButton.click();

        // Click to OK button from the alert.
        //to be able to  click on Alert OK button  we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        // Click to OK button from the alert.
        alert.accept();

        //Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id = 'result'] "));
        // verify  is displayed
        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed");

        // verify  is the  Text  is  matching with "The text is not matching".
        String actualText = resultText.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText, expectedText, "The text is not matching");

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
    public void alert_test2() {

        // Click to “Click for JS Confirm” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']"));

        // Click to “Click for JS Confirm” button
        informationAlertButton.click();

        // Click to OK button from the alert
        // to be able to  click on Alert OK button  we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.xpath(" //p[@id = 'result']"));
        Assert.assertTrue(resultText.isDisplayed());

        // Verify is text “You clicked: Ok”
        String actualText = resultText.getText();
        String expectedText = "You clicked: Ok";
        Assert.assertEquals(actualText,expectedText,"The text is not matching");



        /*
        TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.


         */

    }

    @Test
    public void alert_test3() {


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


}
