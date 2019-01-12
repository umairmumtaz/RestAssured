package TestCases;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.testng.annotations.TestInstance;


public class Test1_GetService {

    @Test
    public void testResponseCode1(){
        int statusCode =201;
        String cityName = "London";
        given().
        when().
           get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
        then().
            assertThat().statusCode(statusCode).
            log().all();
        System.out.println("testResponseCode1");
    }

    @Test(dependsOnMethods = "testResponseCode1")
    public void testResponseCode2(){
        given().
        when().
             get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
        then().
            extract().response();
        System.out.println("testResponseCode2");
    }


    @Test(dependsOnMethods = "testResponseCode2")
    public void testgetTC3(){
        baseURI="https://samples.openweathermap.org";
        given(). // header, param, cookies, body
                param("location","-38.383494,33.427362").
        when().// get(resource), post(resource)


        then().// assertions

        extract().// pulling response body

        System.out.println("testResponseCode3");
    }

}



