package com.cydeo.tests.officeHours02_12_2022_Adam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC05 {

    public static void main(String[] args) {

     /*
     TC:5 As a user I should be able to see the login page

        //1-open a chrome browser
        //2-goto https://vytrack.com/
        //3-click Login label
        //4-verify the url contains login

      */
        //1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2-goto https://vytrack.com/
        driver.get("https://vytrack.com/ ");
        //in Poly  one  reference  difference Ob.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3-  find login element + click Login label

        WebElement loginWebElement = driver.findElement(By.xpath(" //ul[@ id = 'top-menu']//a[. = 'LOGIN']   "));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginWebElement.click();

        //4-verify the url contains login
        String currentURL = driver.getCurrentUrl();
        if (currentURL.contains("login")) {
            System.out.println("PASSED !!!");
        } else {
            System.err.println(" FAILED !!!");
        }
        driver.close();
    }
}
