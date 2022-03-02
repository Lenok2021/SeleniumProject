package com.cydeo.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.openxcell.com ");
    }

    @Test
    public void checkingNumberOfLinks() {


        //Count the number of the links on the page and verify

        List<WebElement> links = driver.findElements(By.xpath("//a"));
        int amount = links.size();
        System.out.println("amount = " + amount);

     /*
       TC #1: Checking the number of links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Count the number of the links on the page and verify
Expected: 332

      */

    }


    @Test
    public void printingOutAllText_fromLinks() {

        //Count the number of the links on the page and verify

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        for (WebElement eachLink : links) {
            try {
                System.out.println(eachLink.getText());
            } catch (StaleElementReferenceException ignored) {
            }

        }


        /*
        TC #2: Printing out the texts of the links on the page
1. Open Chrome browser
2. Go to https://www.openxcell.com
3. Print out all of the texts of the links on the page

        */

    }

    @Test
    public void numberEmptyLinks() {

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        int amountOfEmptyLinks = 0;

        for (WebElement eachLink : links) {

            try {
                String nameOfLink = eachLink.getText();
                if (nameOfLink.isEmpty()) {
                    amountOfEmptyLinks++;
                }
            } catch (StaleElementReferenceException ignored) {
            }
        }

        System.out.println("amountOfEmptyLinks = " + amountOfEmptyLinks);
        /*
       
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


    }
}


