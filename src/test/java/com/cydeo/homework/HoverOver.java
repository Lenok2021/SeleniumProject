package com.cydeo.homework;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOver {


    @Test
    public void testHoverOver() {

        Driver.getDriver().get("http://practice.cydeo.com/hovers");

        // hover over to the first image

        WebElement image1 = Driver.getDriver().findElement(By.xpath("//div[@class = 'figure'][1]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]"));

        // create action class Ob

        org.openqa.selenium.interactions.Actions actions =
                new org.openqa.selenium.interactions.Actions(Driver.getDriver());

        actions.moveToElement(image1).perform();

        Assert.assertTrue(user1.isDisplayed());






    }
}
