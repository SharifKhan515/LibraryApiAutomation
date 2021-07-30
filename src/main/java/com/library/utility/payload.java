package com.library.utility;

import org.openqa.selenium.json.Json;

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

    public static String bookAPIJson(){
        return "{ \"instructor\": \"RahulShetty\", \"url\": \"rahulshettycademy.com\", \"services\": \"projectSupport\", \"expertise\": \"Automation\", \"courses\": { \"webAutomation\": [ { \"courseTitle\": \"Selenium Webdriver Java\", \"price\": \"50\" }, { \"courseTitle\": \"Cypress\",\n" +
                "                \"price\": \"40\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"courseTitle\": \"Protractor\",\n" +
                "                \"price\": \"40\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"api\": [\n" +
                "            {\n" +
                "                \"courseTitle\": \"Rest Assured Automation using Java\",\n" +
                "                \"price\": \"50\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"courseTitle\": \"SoapUI Webservices testing\",\n" +
                "                \"price\": \"40\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"mobile\": [\n" +
                "            {\n" +
                "                \"courseTitle\": \"Appium-Mobile Automation using Java\",\n" +
                "                \"price\": \"50\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\n" +
                "}";
    }

}
