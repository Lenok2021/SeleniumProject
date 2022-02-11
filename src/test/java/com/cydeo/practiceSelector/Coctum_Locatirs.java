package com.cydeo.practiceSelector;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Coctum_Locatirs {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        /*
        XPATH and CSS Selector PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.
         */

        driver.get("http://practice.cybertekschool.com/forgot_password");
      //  WebElement home = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement home = driver.findElement(By.xpath("//a[@class='nav-link'] "));

        //home.click();
        WebElement forgetP = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        forgetP.click();
        


    }






}
