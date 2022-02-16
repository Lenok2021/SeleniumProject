package com.cydeo.tests.day5_testNG_intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Method_To_Locate_Ratio_Button {

    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  // implementation  from Object!!!
        driver.manage().window().maximize();
        //   
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        // Locate name sports Ratio buttons and store in List WebElement

        List<WebElement> sportRadioButtons = driver.findElements(By.name("sport"));
        // loop through the list of webElement and select matching result "hockey"
        for (WebElement each : sportRadioButtons) {
            String eachId = each.getAttribute("id");
            System.out.println("eachId = " + eachId);
            //  loop through  and when Id=hockey  and click on this button
            if (eachId.equals("hockey")) {
                each.click();
                // that  we  want to say, when find it stop the loop
                System.out.println("Hockey is selected : " + each.isSelected());
                break;
               // how do we know  that we break  the loop
               //  BC  after hockey  we have polo, and polo was not printed out

            }
        }


    }




}

/*
Create a utility method to handle above logic.
Method name: clickAndVerifyRadioButton
Return type: void or boolean
Method args:
1. WebDriver
2. Name attribute as String (for providing which group of radio buttons)
3. Id attribute as String (for providing which radio button to be clicked)

Method should loop through the given group of radio buttons. When it finds the
matching option, it should click and verify option is Selected.
Print out verification: true

 */