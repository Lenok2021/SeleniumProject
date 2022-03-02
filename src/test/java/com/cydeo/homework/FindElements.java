package com.cydeo.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverFactory.getDriver("chrome");


    }

    @Test
    public void checkingNumberOfLinks() {







     /*
       TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332

      */

    }
}


/*

TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page

TC #3: Counting the number of links that does not have text
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of links that does not have text and verify
Expected: 109

NOTE: EXPECTED NUMBER OF LINKS FOR THIS PRACTICE MAY BE DIFFERENT
FROM COMPUTER TO COMPUTER, OR FOR DIFFERENT OS (MAC-WINDOWS). SO
IF YOU ARE GETTING A DIFFERENT NUMBER, JUST USE THAT NUMBER FOR
VERIFICATION.
 */