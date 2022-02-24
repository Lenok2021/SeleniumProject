package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice_02_23_2022 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/");

    }


    @Test
    public void testRadioButton_Red() {
        WebElement radioButtonLink = driver.findElement(By.xpath("//div[@class = 'container']//a[. = 'Radio Buttons']"));
        radioButtonLink.click();
        //located red option for radio Button
        WebElement redOption = driver.findElement(By.xpath("//div[@class = 'radio']/input[@id = 'red']"));
        redOption.click();
        Assert.assertTrue(redOption.isSelected());
        System.out.println(redOption.isSelected());

        Assert.assertTrue(redOption.isDisplayed());
        System.out.println(redOption.isDisplayed());

        Assert.assertTrue(redOption.isEnabled());
        System.out.println(redOption.isEnabled());


    }

    @Test
    public void testRadioButton_Green() {
        WebElement radioButtonLink = driver.findElement(By.xpath("//div[@class = 'container']//a[. = 'Radio Buttons']"));
        radioButtonLink.click();
        //located green option for radio Button
        WebElement greenButton = driver.findElement(By.xpath("//div[@class = 'radio']/input[@id = 'green']"));

        boolean a = greenButton.isDisplayed();
        System.out.println("Green button is displayed " + a);

        boolean b = greenButton.isSelected();
        System.out.println("Green button is selected " + b);

        boolean c = greenButton.isEnabled();
        System.out.println("Green button is enabled " + c);


    }


    @Test
    public void HockeyButton() {
        WebElement radioButtonLink = driver.findElement(By.xpath("//div[@class = 'container']//a[. = 'Radio Buttons']"));
        radioButtonLink.click();
        //located Hockey option for radio Button
        WebElement hockey = driver.findElement(By.xpath("//div[@class = 'container']//div[@class = 'radio']/input[@id =  'hockey']"));
        hockey.click();
        Assert.assertTrue(hockey.isSelected(), "PASSED !!!");


        /*
        XPATH PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC #2: Radiobutton handling
1. Open Chrome browser
2. Go to https://practice.cydeo.com/radio_buttons
3. Click to “Hockey” radio button
4. Verify “Hockey” radio button is selected after clicking.
USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

         */


    }


    @Test
    public void testDropDown() {

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        dropDownLink.click();
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select dropDowns = new Select(dropDown);
        // Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”

        WebElement optionSelectedByDefault = dropDowns.getFirstSelectedOption();
        String actualResult = optionSelectedByDefault.getText();
        String expectedResult = "Please select an option";
        Assert.assertEquals(actualResult, expectedResult);


        /*
        1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Verify “Simple dropdown” default selected value is correct
Expected: “Please select an option”
4. Verify “State selection” default selected value is correct
Expected: “Select a State”
         */

    }

    @Test
    public void testDropDownState() {

        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        dropDownLink.click();
        WebElement stateDropDown = driver.findElement(By.id("state"));
        Select dropDowns = new Select(stateDropDown);
        WebElement selectA_stateOption = dropDowns.getFirstSelectedOption();
        // I want to verify is selected ?
        boolean a = selectA_stateOption.isSelected();
        System.out.println("True " + a);
        boolean b = selectA_stateOption.isEnabled();
        System.out.println("True " + b);
        System.out.println("===========================================");
        /* I want to get all options from dropDown and Print it out
        List<WebElement> allOptions = dropDowns.getOptions();
        for(WebElement each : allOptions){
            String nameEachState = each.getText();
            System.out.println(nameEachState);
*/
        // I want to  print out Option which starts from "N"

        List<WebElement> allOptions = dropDowns.getOptions();
        int size = allOptions.size();
        System.out.println("Size " + size);

        System.out.println("==============================================");

        // Select Illinois  by value
        dropDowns.selectByValue("IL");
        dropDowns.getFirstSelectedOption();
        String expectedResult = "Illinois";
        String actualResult = dropDowns.getFirstSelectedOption().getText();
        if (actualResult.equals(expectedResult)) {
            System.out.println("PASSED !!!");
        } else {
            System.out.println("FAILED !!!!");
        }

        System.out.println("===============================================");
        // select Virginia  by visibleText
        dropDowns.selectByVisibleText("Virginia");
        String expectedResult1 = dropDowns.getFirstSelectedOption().getText();
        String actualResult1 = "Virginia";
        if (actualResult1.equals(expectedResult1)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED !!!");
        }
        System.out.println("========================================================");

        // Select California  by index
        dropDowns.selectByIndex(5);
        String actualResult2 = dropDowns.getFirstSelectedOption().getText();
        String expectedResult2 = "California";
        if (actualResult2.equals(expectedResult2)) {
            System.out.println("PASSED !!!");
        } else {
            System.out.println("FAILED !!!!");
        }

/*
        TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
         */


    }

    @Test
    public void testNonSelectDropDowns() {


        WebElement dropDownLink = driver.findElement(By.linkText("Dropdown"));
        dropDownLink.click();
        WebElement nonSelectDropDown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        nonSelectDropDown.click();

        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.facebook.com/";
        Assert.assertEquals(actualURL,expectedURL);

    }

    @Test
    public void testAlerts() {


    }

    @Test
    public void testFrames() {

        WebElement frame = driver.findElement(By.xpath("//div[@id = 'content']//a[. = 'Frames']"));
        frame.click();
        WebElement iframe = driver.findElement(By.linkText("iFrame"));
        iframe.click();
        // locate frame
        //1. by id value
        WebElement frame1 = driver.findElement(By.id("mce_0_ifr"));
        //  switch driver from default content to my frame
         driver.switchTo().frame(frame1);
         WebElement text = driver.findElement(By.xpath("//body[@id = 'tinymce']/p"));
         String expectedResult = text.getText();
         String actualResult = "Your content goes here.";
         Assert.assertEquals(actualResult,expectedResult);
         // switch driver from frame to default content
        driver.switchTo().defaultContent();
        // locate text

        WebElement textInDefaultContent = driver.findElement(By.xpath("//div[@class = 'example']/h3"));
        String actualText = textInDefaultContent.getText();
        String expectedText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        if(actualText.contains("WYSIWYG")){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }

        System.out.println("==================================================");



    }

    @Test
    public void WindowHandle() {


        WebElement  multipleWindows = driver.findElement(By.xpath("//div[@id = 'content']//a[.  = 'Multiple Windows']"));
        multipleWindows.click();
        String currentWindow = driver.getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        // located  click  Link
        




    }
}

