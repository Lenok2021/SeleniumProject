package com.cydeo.tests.officeHours02_12_2022_Adam;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC07 {
    public static void main(String[] args) throws InterruptedException {

        //  TC:7 As a user I should be able to see User is John Doe

        //1-open a chrome browser
        //2-goto https://vytrack.com/
        //3-click Login label
        //4-enter username "User1"
        //5-enter password "UserUser123"
        //6-click LOG IN
        //7-verify the user John Doe

        //1-open a chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2-go to https://vytrack.com/
        driver.get("https://vytrack.com/");
         Thread.sleep(1000);
        //3-click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//ul[@ id = 'top-menu']/li[6]/a "));
        // WebElement loginLabel1 = driver.findElement(By.xpath("//a[.= 'LOGIN'] "));
        loginLabel.click();
        Thread.sleep(1000);
        //4-enter username "User1"
        WebElement username = driver.findElement(By.cssSelector(" #prependedInput"));
        username.sendKeys("User1");


        //5-enter password "UserUser123"
        WebElement password = driver.findElement(By.cssSelector("#prependedInput2"));
        password.sendKeys("UserUser123");

        //6-click LOG IN
        // WebElement loginButton = driver.findElement(By.xpath("//h2[.= 'Login'] "));
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        //7-verify the user John Doe
        //7-verify the user John Doe

        //7-verify the user John Doe
        Thread.sleep(1000);
        String actualName = driver.findElement(By.xpath("//a[@href='javascript: void(0);']")).getText();
        String result=(actualName.equals("John Doe"))?"Name PASSED!":"NAME FAILED!!!!";
        System.out.println("result = " + result);
        driver.quit();



    }
}
