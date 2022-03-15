package com.cydeo.Akbur_videos;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class day45_Actions_Demo_DragAndDropActions {

    @Test
    public void first_way() {

        // 1. go to webpage
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2.  locates circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //3.  print out  the text of circles

        System.out.println("smallCircle.getText() = " + smallCircle.getText());
        System.out.println("bigCircle.getText() = " + bigCircle.getText());

        // drug and drop

        Actions actions = new Actions(Driver.getDriver()) ;


        actions.dragAndDrop(smallCircle, bigCircle).perform(); ;
        BrowserUtils.sleepMethod(3);


    }

    @Test
    public void second_way() {

        // 1. go to webpage
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //2.  locates circles
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //3.  print out  the text of circles

        System.out.println("smallCircle.getText() = " + smallCircle.getText());
        System.out.println("bigCircle.getText() = " + bigCircle.getText());

        // drug and drop

        Actions actions = new Actions(Driver.getDriver()) ;

        actions.moveToElement(smallCircle).pause(1000)
                .clickAndHold().moveToElement(bigCircle).pause(1000)
                .release().perform();



    }
}
