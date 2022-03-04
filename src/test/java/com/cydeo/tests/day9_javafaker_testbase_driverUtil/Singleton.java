package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

public class Singleton {

    //#1. create private Constructor
    private Singleton() {
    }

    //#2. create private static String word;
    private static String word;

    //#3.  this utility method will return the "word" in the way we want return
    public static String getWord() {

        if (word == null) {
            System.out.println("First time call the Word Object is null"+
                    "Assigning value to it now");
            word = "something";
        }else{
            System.out.println("Wrd already has value");
        }
        return word;
    }

}
