package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selectorCustom {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        //1 css selector
        // verify amazon Label
        WebElement label = driver.findElement(By.cssSelector("a[class = 'nav-logo-link nav-progressive-attribute']"));
        boolean a = label.isDisplayed();
        System.out.println("Label is displayed " + a);

        System.out.println("-------------------------------------------------------------");
        // 2. scc selector,  verify searchIcon
        WebElement searchIcon = driver.findElement(By.cssSelector("div>span>input"));
        boolean b = searchIcon.isDisplayed();
        System.out.println("Search icon is displayed " + b);
        String value = searchIcon.getAttribute("class");
        System.out.println("The value of class attribute is "+ value);

        System.out.println("-------------------------------------------------------");
       // css  selector

        WebElement selectYourAddress = driver.findElement(By.cssSelector("span#glow-ingress-line2"));
        String valueId = selectYourAddress.getAttribute("id");
        String expectedResult = "glow-ingress-line2";
        if(valueId.equals(expectedResult)){
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }

        System.out.println("-----------------------------------------------------------------");

        // css  by class
        WebElement hello  = driver.findElement(By.cssSelector("span[class = 'nav-line-1 nav-progressive-content'"));
        String expectedText = hello.getText();
        String actualText = "Hello";
        if(actualText.equals(actualText)){
            System.out.println("PASSED !!!");
        }

        System.out.println("---------------------------------------------------------------------");

        // css  class value

        WebElement helloSight = driver.findElement(By.cssSelector("span.nav-line-2"));
        boolean c = helloSight.isDisplayed();
        System.out.println("c = " + c);

      // 1. locate  within x-path
        System.out.println("------------------------------------------------------------------");
        WebElement labelAmazon = driver.findElement(By.xpath("//a[@aria-label = 'Amazon']"));
        String ariaLabel = labelAmazon.getAttribute("aria-label");
        System.out.println("ariaLabel = " + ariaLabel);

        // 2. locate  with x-path

        WebElement  search = driver.findElement(By.xpath("//span/input[@type ='submit']"));
        String searchText = search.getAttribute("value");
        System.out.println("The  text  is "+ searchText);

        System.out.println("-----------------------------------------------------------");


        // 3. locate with x-path  by  text
        WebElement BestSellers = driver.findElement(By.xpath("//div/a[. = 'Best Sellers']"));
        String text = BestSellers.getText();
        System.out.println("The text is " + text);
        System.out.println("------------------------------------------------------");





    }

}
