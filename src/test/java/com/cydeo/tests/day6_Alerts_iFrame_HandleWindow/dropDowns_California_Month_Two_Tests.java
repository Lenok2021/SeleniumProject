package com.cydeo.tests.day6_Alerts_iFrame_HandleWindow;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dropDowns_California_Month_Two_Tests {


    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void dropdown_task5() throws InterruptedException {
        //TC #5: Selecting state from State dropdown and verifying result 1. Open Chrome browse

        //we located the dropdown and it is ready to use
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        //3. Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        //5. Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualOptionText, expectedOptionText);
    }

    @Test
    public void dropdown_task6() {
        //Select “December 1 , 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        List<WebElement> list = yearDropdown.getOptions();
        System.out.println(list.size());
        List<WebElement> list4 = monthDropdown.getOptions();
        System.out.println("list4.size() = " + list4.size());


        //Select year using : visible text
        yearDropdown.selectByVisibleText("1923");

        //Select month using : value attribute
        monthDropdown.selectByValue("11");

        //Select day using : index number
        dayDropdown.selectByIndex(0);

        //creating expected values
        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from browser
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //create assertions
        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);



      /*
        TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number
       */


    }


    @AfterMethod
   public void close() {
      //  driver.close();
    }

}







