package com.cydeo.homework;

import org.testng.annotations.Test;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "maData")
     public Object[][] provideData(){
         return new Object[][] {
                 {"Adam"},
                 {"John"},
                 {"Mary"},
                 {"Elena"},
         };
     }

    @Test (dataProvider = "maData")
    public void testMultipleData(String name) {

        System.out.println(name);
    }


    @org.testng.annotations.DataProvider (name = "TwoSetOfData")
    public Object[][] provideTwoData(){
        return new Object[][] {
                {"Adam", 20},
                {"John", 23},
                {"Mary", 25},
                {"Elena",56},
        };

    }

    @Test (dataProvider = "TwoSetOfData")
    public void testTwoData(String name, int batchNumber) {
        System.out.println(name+ " is from batch "+batchNumber);
    }
}
