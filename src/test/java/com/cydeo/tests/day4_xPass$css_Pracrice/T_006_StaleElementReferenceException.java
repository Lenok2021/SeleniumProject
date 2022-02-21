package com.cydeo.tests.day4_xPass$css_Pracrice;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T_006_StaleElementReferenceException {


    public static void main(String[] args) {

        //1. Go to http://practice.cydeo.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2 go to "https://practice.cydeo.com/"
        driver.get("https://practice.cydeo.com/abtest");

        // locate Cydeo Link, verify is it display
        WebElement  cydeoLink = driver.findElement(By.xpath("//a[. = 'CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        // refresh page
        driver.navigate().refresh();


         //  5.  verify is displayed again

         cydeoLink = driver.findElement(By.xpath("//a[. = 'CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //  we  got  StaleElementReferenceException  after refresh page:
        // we can  refresh  the web element by re-assigning / relocating
        // web element  after when we refreshed the page.
        // BC  when you  refreshed your page we lost connection

       driver.close();


    }
}
