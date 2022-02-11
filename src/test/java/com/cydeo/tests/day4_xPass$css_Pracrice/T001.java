package com.cydeo.tests.day4_xPass$css_Pracrice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T001 {
    public static void main(String[] args) {

      /*
      DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #1: XPATH and cssSelector Practices
1. Open Chrome browser
2. Go to https://practice.cydeo.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS
locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cydeo text
4. Verify all web elements are displayed.
First solve the task with using cssSelector only. Try to create 2 different
cssSelector if possible

Then solve the task using XPATH only. Try to create 2 different
XPATH locator if possible

       */
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password ");

        //  3. Locate all the WebElements on the page using XPATH and/or CSS
        //   locator only (total of 6)
        // a) “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector(" a[class='nav-link'] "));
        WebElement homeLink1 = driver.findElement(By.cssSelector(" a.nav-link "));
        WebElement homeLink2 = driver.findElement(By.cssSelector(" a[href='/'] "));

        // b) “Forgot password” header
        // locate by css: locate parent element move to h2
        WebElement forgotPassword = driver.findElement(By.cssSelector("div.example>h2 "));

        // locate by x-Path
        // we located by using text
        WebElement forgotPassword1 = driver.findElement(By.xpath(" //h2[text()='Forgot Password'] "));
        WebElement forgotPassword2 = driver.findElement(By.xpath(" //h2[.='Forgot Password'] "));

        // c)  “E-mail” text
        WebElement emailLabel = driver.findElement(By.xpath(" //label[@for = 'email'] "));
        WebElement emailLabel1 = driver.findElement(By.xpath(" //label[ .= 'E-mail']  "));

        // d)  input box      //input[@name= 'email']
        WebElement inputBox = driver.findElement(By.xpath(" input[@name= 'email'] "));
        WebElement inputBox1 = driver.findElement(By.xpath(" //input[contains(@pattern,'a-z') "));

        // e) “Retrieve password” button

        WebElement retrievePasswordBtn = driver.findElement(By.xpath(" //button[@id = 'form_submit'] "));
        WebElement retrievePasswordBtn1 = driver.findElement(By.xpath(" //button[@class = 'radius']  "));

    }
}
