package com.cydeo.homework;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload {


    @Test
    public void testFileUpload() {

        Driver.getDriver().get(ConfigurationReader.getProperty("practice"));
        String filePass = "C:/Users/cross/OneDrive/Desktop/3.png";
        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));
        chooseFile.sendKeys(filePass);

        WebElement upload = Driver.getDriver().findElement(By.id("file-submit"));
        upload.click();





    }
}
