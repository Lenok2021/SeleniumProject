package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Table {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testTable() {

        driver.get("http://practice.cydeo.com/");
        WebElement table = driver.findElement(By.xpath("//div[@class = 'large-12 columns']//a[. = 'Sortable Data Tables']"));
        table.click();
        // return the table itself
        WebElement table1 = driver.findElement(By.xpath("//table[@id = 'table1']"));
        // return all rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id = 'table1']//tr"));
        for (WebElement each : rows) {
            System.out.println(each.getText());
        }
        System.out.println("==================================================");
        // return all rows in the body
        List<WebElement> rowsInTheBody = driver.findElements(By.xpath("//table[@id = 'table1']//tbody//tr"));
        for (WebElement each : rowsInTheBody) {
            System.out.println(each.getText());

        }
        System.out.println("===================================================");
        //I want to return 3 row   from the table
        WebElement thirdRow = driver.findElement(By.xpath("//table[@id = 'table1']//tbody//tr[3]"));
        System.out.println(thirdRow.getText());

        System.out.println("=================================================");
         // returns all  cells from rows

        List<WebElement> cells = driver.findElements(By.xpath("//table[@id = 'table1']//tr//td"));
        for(WebElement each : cells){
            System.out.println(each.getText());
        }


        }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

