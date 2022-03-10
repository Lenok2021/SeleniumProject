package com.cydeo.tests.day11ActionPractice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Circle_Drag_Drop {

    @Test
    public void testName() {

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //Locate "Accept Cookies" button and click
        WebElement acceptCookiesButton = Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookiesButton.click();

        //2. Drag and drop the small circle to bigger circle.

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));


      Actions actions = new Actions(Driver.getDriver());
      actions.dragAndDrop(smallCircle,bigCircle).perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        String actualBigCircleText = "You did great!";
        String expectedBigCircleText = bigCircle.getText();
        Assert.assertEquals(actualBigCircleText, expectedBigCircleText );



    }
}
