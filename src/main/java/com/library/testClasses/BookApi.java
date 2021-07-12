package com.library.testClasses;

import com.library.utility.HelperMethod;
import com.library.utility.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookApi {

    @Test()
    public void addBookApi(){

        RestAssured.baseURI = "http://216.10.245.166";

       String response =  given().header("content-type","application/json").body(payload.addBookPayload())
                .when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
        JsonPath responseJson = HelperMethod.stringToJson(response);
        String bookId = responseJson.getString("ID");
        System.out.println(bookId);

    }
}
