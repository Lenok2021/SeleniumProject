package com.cydeo.homework;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RightClick_DoubleClick_Actions_Class {


    @Test
    public void rightClick() {

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.id("iframeResult")));

        WebElement area = Driver.getDriver().findElement(By.cssSelector("div[contextmenu='mymenu']"));
        //Right-click inside this box to see the context menu!

        // right click

        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(area).perform();

        BrowserUtils.sleepMethod(2000);

        Driver.getDriver().switchTo().alert().accept();

        BrowserUtils.sleepMethod(2000);



    }

    @Test
    public void testDoubleClick() throws InterruptedException {

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");
        Driver.getDriver().switchTo().frame("iframeResult");
        // Double-click this paragraph to trigger a function.
        WebElement pElm = Driver.getDriver().findElement(By.xpath("//p[.='Double-click this paragraph to trigger a function.']"));
        Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(pElm).perform();
        // assert new p element with Hello World text displayed
        WebElement resultElm = Driver.getDriver().findElement(By.xpath("//p[.='Hello World']")) ;
       Assert.assertTrue(resultElm.isDisplayed() );
        Thread.sleep(2000);





    }
}
