package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Siblings {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void testSiblings() {
        driver.get("http://practice.cydeo.com/");
        WebElement dropdown = driver.findElement(By.xpath("//div[@id = 'content']//a[. = 'Dropdown']"));
        dropdown.click();
        WebElement el1 = driver.findElement(By.xpath("//select[@id = 'state']//option[@value = 'FL']/preceding-sibling :: option[1]"));
        String actualResult = el1.getAttribute("value");
        String expectedResult = "DC";
        Assert.assertEquals(actualResult, expectedResult);
        System.out.println(actualResult);

        System.out.println("------------------------------------------------------");
        // let's return April
        WebElement elm2 = driver.findElement(By.xpath("//select[@id = 'month']/option[@value = '5']/preceding-sibling:: option[2]"));
        String actualResult1 = elm2.getText();
        String expectedResult2 = "April";
        Assert.assertEquals(actualResult1, expectedResult2);
        System.out.println(expectedResult2);
        System.out.println("---------------------------------------------");
        // Let's return December
        WebElement elm3 = driver.findElement(By.xpath("//select[@id = 'month']/option[@value = '5']/following-sibling::option[6]"));
        String actualResult4 = elm3.getText();
        String expectedResult4 = "December";

        Assert.assertEquals(actualResult4, expectedResult4);
        System.out.println(actualResult4);


    }

    @Test
    public void iFrame() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement element = driver.findElement(By.linkText("Frames"));
        element.click();
        WebElement frames = driver.findElement(By.linkText("iFrame"));
        frames.click();
        // Verify the ‘Your content goes here.’ label
        //  by id value
        // driver.switchTo().frame("mce_0_ifr");
        // by index
        driver.switchTo().frame(0);
        // locate content
        WebElement content = driver.findElement(By.xpath("//body[@id = 'tinymce']/p"));
        String actualResult = content.getText();
        String expectedResult = "Your content goes here.";
        Assert.assertEquals(actualResult, expectedResult);
        // switch driver from iframe to default content

        driver.switchTo().defaultContent();
        WebElement text = driver.findElement(By.xpath("//div[@class  = 'example']/h3"));
        String actualResult1 = text.getText();
        String expectedResult1 = "TinyMCE WYSIWYG";
        Assert.assertTrue(actualResult1.contains("TinyMCE WYSIWYG"));
        System.out.println(actualResult1);



        /*
        TC 1: As a User I should be able to see ‘Your content goes here.’ And ‘An iFrame
containing the TinyMCE WYSIWYG Editor’
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click iFrame
4- Verify the ‘Your content goes here.’ label
5- Verify the header ‘An iFrame containing the TinyMCE WYSIWYG Editor’


         */
    }

    @Test
    public void testNested_iFrame() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement element = driver.findElement(By.linkText("Frames"));
        element.click();
        WebElement nestedFrame = driver.findElement(By.xpath("//div[@class = 'example']//a[. = 'Nested Frames']"));
        nestedFrame.click();
        //  Verify the BOTTOM label
        driver.switchTo().frame("frame-bottom");
        WebElement elm = driver.findElement(By.xpath("//body"));
        String ex = elm.getText();
        String ac ="BOTTOM";
        if(ac.equals(ex)){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }

 /*
      TC 2: As a User I should be able to see BOTTOM label
1- Open a chrome browser
2- Go to https://the-internet.herokuapp.com/
3- Click Nested Frames
4- Verify the BOTTOM label
     */



    }

    @AfterMethod
    public void tearDown() {
      driver.close();
    }
}

