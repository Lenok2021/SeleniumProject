package com.cydeo.tests.day10_Action_Class;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Actions {


    @Test
    public void test_actions() {

        Driver.getDriver().get("https://practice.cydeo.com/hovers ");


        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(Driver.getDriver());


        //1. Hover over to first image
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        BrowserUtils.sleepMethod(2);
        actions.moveToElement(img1).perform();
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5 [text() = 'name: user1']"));
        Assert.assertTrue(user1.isDisplayed());
        WebElement profile1 = Driver.getDriver().findElement(By.xpath("(//a)[2]"));
        Assert.assertTrue(profile1.isDisplayed());

        //2. Hover over to second image

        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        BrowserUtils.sleepMethod(2);
        actions.moveToElement(img2).perform();
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5 [text() = 'name: user2']"));
        Assert.assertTrue(user2.isDisplayed());
        WebElement profile2 = Driver.getDriver().findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(profile2.isDisplayed());

        //3. Hover over to second image

        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));
        BrowserUtils.sleepMethod(2);
        actions.moveToElement(img3).perform();
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5 [text() = 'name: user3']"));
        Assert.assertTrue(user3.isDisplayed());
        WebElement profile3 = Driver.getDriver().findElement((By.xpath("(//a)[4]")));
        Assert.assertTrue(profile3.isDisplayed());


    }
}

/*
TC #3: Hover Test
1. Go to https://practice.cydeo.com/hovers
2. Hover over to first image
3. Assert:
a. “name: user1” is displayed
b. “view profile” is displayed
4. Hover over to second image
5. Assert:
a. “name: user2” is displayed
b. “view profile” is displayed
6. Hover over to third image
7. Confirm:
a. “name: user3” is displayed
b. “view profile” is displayed

 */