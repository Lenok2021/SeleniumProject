package com.cydeo.Akbur_videos;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day45_Double_Click_Right_Click {

    @Test
    public void testRightClick() {

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");

        //1.  switch  driver to iframe
        Driver.getDriver().switchTo().frame("iframeResult");
        // click on it
        Actions actions = new Actions(Driver.getDriver());
        // locate area
        WebElement area = Driver.getDriver().findElement(By.cssSelector("div[oncontextmenu = 'myFunction()']"));
        actions.contextClick(area).perform();

        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();


    }

    @Test
    public void testing_double_click() {

        Driver.getDriver().get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_ondblclick");

        // switch to iframe by using iframe id
        Driver.getDriver().switchTo().frame("iframeResult");
        // imitate double click
        Actions actions = new Actions(Driver.getDriver());
        WebElement area = Driver.getDriver().findElement(By.xpath("//p[@ondblclick = 'myFunction()']"));
        actions.moveToElement(area).doubleClick().perform();

        BrowserUtils.sleepMethod(3);

        // verify that Hello word was appeared

        String actualText = Driver.getDriver().findElement(By.id("demo")).getText();
        String expectedText = "Hello World";
        Assert.assertEquals(actualText, expectedText);

        Driver.closeDriver();
    }
}
