package com.cydeo.tests.day6_Alerts_iFrame_HandleWindow;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class iFrame {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://practice.cydeo.com/iframe");

    }


   // @Ignore  if  I put  this   = the test  wil  not be running
    @Test
    public void test_iframe1() {
        //  let's  simulate  if  we  did not  change  to iframe

        //WebElement yourContentGoesHere = driver.findElement(By.xpath("//p"));
        // after  that we got NoSuchElementException
        //  We have to switch the driver to iframe box
        // we have to switch the focus of our driver to iframe

        //We need to switch driver's focus to iframe
        //option #1- switching to iframe using id attribute value
        //driver.switchTo().frame("mce_0_ifr");

        //option #2- passing index number of iframe
        //driver.switchTo().frame(0);

        //option #3- locate as web element and pass in frame() method
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));


        WebElement yourContentGoesHere = driver.findElement(By.xpath("//p"));

        Assert.assertTrue(yourContentGoesHere.isDisplayed(),"FAILED !!!");

        driver.switchTo().parentFrame();  //  came  back  to  outer


        WebElement text = driver.findElement(By.xpath("//div[@class = 'example']//h3 "));
        Assert.assertTrue(text.isDisplayed(), "FAILED !!!");

        String actualResult = text.getText();
        String expectedResult = "An iFrame containing the TinyMCE WYSIWYG Editor";
       if(actualResult.contains("TinyMCE WYSIWYG")){
           System.out.println("PASSED !!!");
       }else{
           System.out.println("FAILED !!!");
        }



    }

   @AfterClass
    public void close(){
        driver.close();
   }

}


/*
TC #4: Iframe practice

1. Create a new class called: T4_Iframes
2. Create new test and make set ups
3. Go to: https://practice.cydeo.com/iframe
4. Assert: “Your content goes here.” Text is displayed.
5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”


 */
