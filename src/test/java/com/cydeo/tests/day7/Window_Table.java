package com.cydeo.tests.day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Window_Table {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test1() {
        driver.get("https://practice.cydeo.com/tables");
         //table[@id = 'table1']  locate  table
        //   //table[@id = 'table1']//tr  returns all  rows inside the body of the table
        //   //table[@id = 'table1']/tbody//tr  we want to avoid the header row, BC
        //  header define the structure, does not have any data
        // we skip thead head, we control only rows in a body

       //  //table[@id = 'table1']/tbody//tr[3]  return only  3 rom from body



    }
}
