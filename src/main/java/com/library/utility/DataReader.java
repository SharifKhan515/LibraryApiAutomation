package com.library.utility;

import org.testng.annotations.DataProvider;

public class DataReader {

    @DataProvider(name = "APITestDataProvider")
    public static Object[][] ApiTestData(){

        Object[][] data = new Object[][]{{"aaaasdad","111"},{"bbbbasdsad","22222"},{"ccccdsadweqe","3333"}};

        return data;
    }
}
