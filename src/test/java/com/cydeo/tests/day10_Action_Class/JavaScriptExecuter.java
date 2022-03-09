package com.cydeo.tests.day10_Action_Class;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JavaScriptExecuter {

    @Test
    public void test1() {

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        // we cannot create  from Interface we cast it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // our  driver  cannot get  this  method   js.executeScript
        // from Selenium library
        // this method is in   JavascriptExecutor
        //  we  down Cast and driver can get methods from    JavascriptExecutor interface

        //750 pixels down 10 times.
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleepMethod(1);
            js.executeScript("window.scrollBy(0,750)");

        }
        //750 pixels up 10 times
        for (int i = 0; i < 10; i++) {
            BrowserUtils.sleepMethod(1);
            js.executeScript("window.scrollBy(0,-750)");

        }



    }

}

/*
TC #6: Scroll using JavascriptExecutor
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/infinite_scroll
3- Use below JavaScript method and scroll
a.  750 pixels down 10 times.
b.  750 pixels up 10 times

JavaScript method to use : window.scrollBy(0,0)


 */