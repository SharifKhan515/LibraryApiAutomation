package com.library.testClasses;

import com.library.utility.DataReader;
import com.library.utility.HelperMethod;
import com.library.utility.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookApi {

    @Test(dataProvider = "APITestDataProvider", dataProviderClass = DataReader.class)
    public void addBookApi(String isbn, String aisle) {

        RestAssured.baseURI = "http://216.10.245.166";
        String jsonPayload = payload.addBookPayload(isbn, aisle);

        String response = given().header("content-type", "application/json").body(jsonPayload)
                .when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();

        JsonPath responseJson = HelperMethod.stringToJson(response);
        String bookId = responseJson.getString("ID");
        System.out.println(bookId);
    }

    @Test(dataProvider = "APITestDataProvider", dataProviderClass = DataReader.class)
    public void deleteBookApi(String isbn, String aisle) {

        RestAssured.baseURI = "http://216.10.245.166";
        String bookId = payload.deleteBookPayload(isbn, aisle);

        String response = given().header("content-type", "application/json").body(bookId)
                .when().post("Library/DeleteBook.php")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath responseJson = HelperMethod.stringToJson(response);
        String message = responseJson.getString("msg");
        System.out.println(message);
    }

    @Test()
    public void revers(){

        String s = "Sharif";
        String r= new String();
        for(int i = s.length() - 1; i >= 0; i--){
            r+= s.charAt(i);
        }
        System.out.println(s);
        System.out.println(r);

    }


}
