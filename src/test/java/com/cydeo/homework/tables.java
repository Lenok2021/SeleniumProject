package com.cydeo.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class tables {


    @Test
    public void testName() {

        Driver.getDriver().get("http://practice.cydeo.com/web-tables");

        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']//tbody//tr/td[2]"));
        for (WebElement webElement : list) {
          String name = webElement.getText();
            System.out.println(name);
        }



    }
}
