package com.cydeo.utilities;
/*
In this class only general utility methods
that are not related to some specific page.
That means I can you use this method whatever I want in projects
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
/*
This method will accept int (int seconds) and execute Thread.sleep
for given duration
 */

    public static void sleepMethod(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle) {
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);

            System.out.println("Current URL " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));



      /*
        TC #2: Create utility method
 1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.


Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl: to verify if the URL contains given String
-If condition matches, will break Loop
• Arg3: String expectedTitle
-Tobe able to be compared against actualTitle


      */

            }
    /*
    This method accepts String "expectedTitle' and accepts if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);




    }


    /*
   Creating a utility method for ExplicitWait, so we don't have to repeat the lines
    */
    public static void waitForInvisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }



    }




