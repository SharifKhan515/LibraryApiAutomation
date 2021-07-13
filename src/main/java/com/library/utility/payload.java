package com.library.utility;

public class payload {

    public static String addBookPayload(String isbn, String aisle){

        String book = "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";

        return book;

    }
    public static String deleteBookPayload(String isbn, String aisle){

        String book = "{\n" +
                " \n" +
                "\"ID\" : \""+isbn+aisle+"\"\n" +
                " \n" +
                "} \n";

        return book;

    }

}
