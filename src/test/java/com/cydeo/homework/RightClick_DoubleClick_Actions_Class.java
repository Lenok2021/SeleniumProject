package com.cydeo.homework;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    public void testDoubleClick() {

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

        Driver.getDriver().switchTo().frame("iframeResult");

        WebElement  element = Driver.getDriver().findElement(By.xpath("//p[text() = 'Double-click this paragraph to trigger a function.']"));


        Actions actions = new Actions(Driver.getDriver());

        actions.doubleClick(element).perform();





    }
}
