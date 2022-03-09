package com.cydeo.homework;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {


    @Test
    public void test_drag_And_drop() {

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");



        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));



        Actions actions = new Actions(Driver.getDriver());
      //  actions.dragAndDrop(smallCircle, bigCircle).perform();

       //  there is a second way to do it

        actions.moveToElement(smallCircle)
                .clickAndHold().pause(1000)

                .moveToElement(bigCircle).pause(1000)
                .release().perform();



        BrowserUtils.sleepMethod(1000);











    }
}
