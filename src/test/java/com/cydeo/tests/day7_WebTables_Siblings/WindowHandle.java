package com.cydeo.tests.day7_WebTables_Siblings;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void window_handling_test() {
        //2. Go to: https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Copy-paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
        // we created For Loop  in order to switch from one Window to another

        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {

            driver.switchTo().window(each);
            System.out.println("Current URL " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("Etsy")) {
                break;
            }
        }

        //5. Assert:Title contains “Etsy”

        String actualTitle = driver.getTitle();
        String expectedTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // we want  to  create  situation  when the driver get (contains)  Etsy,
        // driver  stop  on this  page  do not go forward
        // do not  switch the page
        // when  we print URL out   we do not see Google


    }


}
