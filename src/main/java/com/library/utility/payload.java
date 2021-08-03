package com.library.utility;

import org.openqa.selenium.json.Json;

import java.util.HashMap;

public class payload {

    public static HashMap<String, Object> addBookPayload(String isbn, String aisle){

        HashMap<String,Object> map = new HashMap<>();

        map.put("name", "Test of hashmap json");
        map.put("isbn",isbn);
        map.put("aisle",aisle);
        map.put("author","Sharif");




        return map;

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
