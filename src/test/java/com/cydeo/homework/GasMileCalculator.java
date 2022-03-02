package com.cydeo.homework;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GasMileCalculator {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net ");

    }

    @Test
    public void gasMileageCalculatorAutomationTest() {

        WebElement searchInput = driver.findElement(By.id("calcSearchTerm"));
        searchInput.sendKeys("gas mileage");

        WebElement searchButton = driver.findElement(By.xpath("//span[. = 'Search']"));
        searchButton.click();

        WebElement gasLink = driver.findElement(By.linkText("Gas Mileage Calculator"));
        gasLink.click();

        WebElement gasTitle = driver.findElement(By.xpath("//h1[. = 'Gas Mileage Calculator']"));
        String actualTitle = gasTitle.getText();
        String expectedTitle = "Gas Mileage Calculator";

        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertTrue(gasTitle.isDisplayed());

        //Locate, clear and type “7925” into “Current odometer” field

        WebElement clear = driver.findElement(By.cssSelector(".clearbtn"));
        clear.click();
        WebElement odometer = driver.findElement(By.id("uscodreading"));
        odometer.sendKeys("7925");

        WebElement prevOdometer = driver.findElement(By.id("uspodreading"));
        prevOdometer.sendKeys("7550");

        WebElement gasAdded = driver.findElement(By.id("usgasputin"));
        gasAdded.sendKeys("16");

        WebElement gasPrice = driver.findElement(By.id("usgasprice"));
        gasPrice.sendKeys("3.55");

        WebElement calculatorButton = driver.findElement(By.xpath("//*[@id='standard']/tbody/tr[5]/td/input"));
        calculatorButton.click();

        String actualPriceTitle = driver.findElement(By.xpath("//b[. = '23.44 mpg']")).getText();
        String expectedPriceTitle = "23.44 mpg";


        Assert.assertEquals(actualPriceTitle,expectedPriceTitle);


    }
}


/*
Task #: Gas Mileage Calculator Automation Test

1. Add a new class GasMileageCalculatorTest
2. Go to https://www.calculator.net
3. Search for “gas mileage” using search box
4. Click on the “Gas Mileage Calculator” link

5. On Next page verify:
a. Title equals: “Gas Mileage Calculator”
b. “Gas Mileage Calculator” label is displayed

6. Locate, clear and type “7925” into “Current odometer” field
7. Locate, clear and type “7550” into “Previous odometer” field
8. Locate, clear and type “16” into “Gas added” field
9. Locate, clear and type “3.55” into “Gas price” field
10. Click on Calculate button
11. Verify mpg value is as expected:
Expected value: “23.44 mpg”


 */