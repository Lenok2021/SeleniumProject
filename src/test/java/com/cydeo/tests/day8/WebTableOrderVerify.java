package com.cydeo.tests.day8;

import com.cydeo.utilities.WebTableUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableOrderVerify {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void order_name_verify_test() {
        driver.get("https://practice.cydeo.com/web-tables");
        //Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        //Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        //1. Locate the  cell which has Bob Martin in it.
        WebElement BobMartinCell
                = driver.findElement(By.xpath("//table[@id  = 'ctl00_MainContent_orderGrid']/tbody/tr[7]/td[. = 'Bob Martin']"));
        String theValueOfTheCell = BobMartinCell.getText();
        String actualResult = "Bob Martin";
        Assert.assertEquals(actualResult, theValueOfTheCell);

        //2. Locate cell  - order
        WebElement dateOfOrderCell =
                driver.findElement(By.xpath("//table[@class = 'SampleTable']/tbody/tr[7]/td[. = 'Bob Martin']/following-sibling::td[.  = '12/31/2021']"));

        String actualOrderCell = dateOfOrderCell.getText();
        String expectedOrderCell = "12/31/2021";
        Assert.assertEquals(actualOrderCell, expectedOrderCell);


    }

    //We use the utility method we created.
    @Test
    public void test2() {
        driver.get("https://practice.cydeo.com/web-tables");
        String costumerOrderDate1 = WebTableUtility.returnOrderDate(driver, "Alexandra Gray");
        System.out.println("costumerOrderDate1 = " + costumerOrderDate1);

    }
}
