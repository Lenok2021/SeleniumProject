package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void testName() throws InterruptedException {
        Thread.sleep(1000);
        WebElement sighIn = driver.findElement(By.xpath("//div[@class = 'nav-line-1-container']//span[@id = 'nav-link-accountList-nav-line-1']"));
        sighIn.click();
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.xpath("//input[@id = 'ap_email']"));
        login.sendKeys("lena.morgacheva2006@mail.ru");
        Thread.sleep(1000);
        WebElement continueTab  = driver.findElement(By.id("continue"));
        continueTab.click();
        Thread.sleep(1000);
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("Lenok2021");
        Thread.sleep(1000);
        WebElement sighIn1 = driver.findElement(By.id("signInSubmit"));
        sighIn1.click();
        Thread.sleep(1000);
        WebElement all = driver.findElement(By.xpath("//i[@class = 'hm-icon nav-sprite']"));
        all.click();
        



    }
}
