package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaFakerPractice {


    @Test
    public void tearDown() {
        //1.  created Faker Object to reach methods
        Faker faker = new Faker();

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.name().fullName());

        System.out.println("=========================================================");

        System.out.println("faker.numerify(\"###-###-####\") = "
                + faker.numerify("###-###-####"));

        System.out.println("faker.numerify(\"312-###-####\") = "
                + faker.numerify("312-###-####"));

        // ("312-###-####") =>  where  the   312  is unchangeable
        //### is randomly-generated.

        System.out.println("faker.numerify(\"###-100-####\") = "
                + faker.numerify("###-100-####"));

        System.out.println("============================================================");

        // we can generate name  as well
        // will return  letter  where we passed ?
        System.out.println("faker.letterify(\"????-???\") = "
                + faker.letterify("????-???"));
        System.out.println("faker.letterify(\"??AA??BB\") = "
                + faker.letterify("??AA??BB"));





    }
}
