package com.library.testClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class oAuthToken {

    String accessCodeUrl = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php";

    @Test
    public void getAccessToken(){
      //  RestAssured.baseURI = "https://rahulshettyacademy.com";



          String code = getAccessCode();


        String accessTokenResponse = given().urlEncodingEnabled(false)
                .queryParams("code",code)
                .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type","authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token")
                .then().extract().response().asString();

        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");




       String response =  given().queryParam("access_token",accessToken)
                .when().get("https://rahulshettyacademy.com/getCourse.php").then().extract().response().asString();
    }


    // Automation is blocked by google from automation framework
    public String getAccessCode(){

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get(accessCodeUrl);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
        String url = driver.getCurrentUrl();

        //extract the code from URL.

        String code=null;

        return code;
    }
}
