package com.library.testClasses;

import com.library.pojo.Api;
import com.library.pojo.GetCourse;
import com.library.pojo.WebAutomation;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class oAuthToken {

    String accessCodeUrl = "https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php";

    @Test
    public void getAccessToken(){
      //  RestAssured.baseURI = "https://rahulshettyacademy.com";



          /*String code = "4%2F0AX4XfWh8j_NluB7G6MIrO4LgcBxcWyXc5A4I5oWfafdDLvkFpFJCpUTg87vSwhAkGgKz7w";


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

        System.out.println("Access token: "+accessToken);*/


        String accessToken = "ya29.a0ARrdaM-KmH7djhAYF5660DJWEXJLE3KKAZO-Y3Jd2yspC1_-xguwDz1rXwDsLeKvmcSSVfLEyRBn0DfpQxdQqKIaPuaRJFZqIA--xS2QiOislvbe0I7jJHxb2eJbvlhGGCKMVB7JF_zA1694jDhgBrLfzpRF-Q";

      //get result as pojo object
       GetCourse response =  given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

        System.out.println("Instructor: "+response.getInstructor());
        System.out.println("LinkedIn :"+response.getLinkedIn());

        List<Api> apis = response.getCourses().getApi();
        for (Api api:apis){
            if(api.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")){
                System.out.println(api.getPrice());
                break;
            }
        }

        Optional<Api> soapUI_webservices_testing = apis.stream().filter(s -> s.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")).findFirst();
        System.out.println(soapUI_webservices_testing.get().getPrice());

        //all course title print

        List<WebAutomation> webAutomations = response.getCourses().getWebAutomation();

        webAutomations.stream().forEach(s-> System.out.println(s.getCourseTitle()));



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
