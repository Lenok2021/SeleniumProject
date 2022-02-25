package com.cydeo.tests.day8_Properties;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {


    @Test
    public void reading_from_properties_test() throws IOException {
// 1. - Create the Object of Properties class.
        Properties properties = new Properties();   //  we created Object from Java.util
//2. - We need to open the file in Java memory using:FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");
//3. - Load the properties Object using FileInputStream Object.
        properties.load(file);
//4. Use "properties" Object to read value

        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
// output = properties.getProperty("browser") = chrome
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
//output = https://login1.nextbasecrm.com/stream/?login=yes
        System.out.println("properties.getProperty(\"helpdesk1@cydeo.com\") = " + properties.getProperty("username"));
//output =   helpdesk1@cydeo.com
       // System.out.println(properties.getProperty("evrt")) - I give wrong key
//output = null   !!!!!!!!

        // everything that outside of Java folder is not a Java code:
                                    //  pom.xml
                                    // configuration.properties
                                    // .gitignore file
        //VERY IMPORTANT!!!  don't put any spaces after, before keys in properties
        // you can get problem. Pay attentions!!!!





    }
}
