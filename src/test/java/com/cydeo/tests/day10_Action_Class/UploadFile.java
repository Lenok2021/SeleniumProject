package com.cydeo.tests.day10_Action_Class;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile {


    @Test
    public void test_Upload_file() {

        Driver.getDriver().get(ConfigurationReader.getProperty("practice"));

        //1.find small file

        String path = "C:/Users/cross/OneDrive/Desktop/2.png";

        //2. locate upload

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleepMethod(2);
        // upload the file
        chooseFile.sendKeys(path);

        // locate upload button
        WebElement fileUpload  = Driver.getDriver().findElement(By.id("file-submit"));
        fileUpload.click();

        // verify upload header

        WebElement uploadHeader = Driver.getDriver().findElement(By.tagName("h3"));

        Assert.assertTrue(uploadHeader.isDisplayed());












    }
}
