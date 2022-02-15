package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RatioButton {

    public static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {

        List<WebElement> sportRadioButtons = driver.findElements(By.name(nameAttribute));
        for (WebElement each : sportRadioButtons) {
            String eachId = each.getAttribute("id");

            if (eachId.equals(idValue)) {
                each.click();

                System.out.println(eachId + " is selected" + each.isSelected());
                break;


            }

        }
    }
}

