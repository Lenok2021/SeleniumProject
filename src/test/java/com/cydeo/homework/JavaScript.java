package com.cydeo.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScript {



        @Test
        public void test_ScrollElementInto_the_View() throws InterruptedException {

            Driver.getDriver().get("http://practice.cydeo.com/infinite_scroll");

            // get JavaScriptExecutor

            JavascriptExecutor je = (JavascriptExecutor) Driver.getDriver();


            je.executeScript("window.scrollBy(0,750)");

            Driver.getDriver().get("http://practice.cybertekschool.com/large");
            Thread.sleep(2000);

            WebElement schoolLnk = Driver.getDriver().findElement(By.linkText("CYDEO"));
            WebElement homeLnk = Driver.getDriver().findElement(By.linkText("Home"));

            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView(true)" , schoolLnk);
            Thread.sleep(1000);
            jse.executeScript("arguments[0].scrollIntoView(true)",  homeLnk  ) ;
            Thread.sleep(2000);

            jse.executeScript("alert('whats up?')"  ) ;
            Thread.sleep(4000);



            /*
            @Test
public void test_OpenNewTab_withURL() throws InterruptedException {
    driver.get("http://practice.cybertekschool.com");
    Thread.sleep(2000);
    // get JavascriptExecutor reference
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript(" window.open('https://google.com','_blank')  ");
    Thread.sleep(1000);
    jse.executeScript(" window.open('https://cybertekschool.com','_blank')  ");
    Thread.sleep(1000);
    jse.executeScript(" window.open('https://search.yahoo.com','_blank')  ");
    Thread.sleep(3000);

    // get all windows handles and print it out
    // switch to each window and print the title

             */

    }
}
