package TestCases;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.testng.annotations.TestInstance;
import static org.hamcrest.Matchers.comparesEqualTo;

public class Test1_GetService {
    int statusCode =200;

    @Test
    public void testResponseCode1(){
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


    @Test
    public void testgetTC3(){
        baseURI="https://samples.openweathermap.org";
        given(). // header, param, cookies, body
                param("q","London,uk").
                param("appid","b6907d289e10d714a6e88b30761fae22").
        when().// get(resource), post(resource)
                get("/data/2.5/weather").
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("weather[0].main",comparesEqualTo("Drizzle") ).and().
                body("name",comparesEqualTo("London"));

      //  extract().// pulling response body

        System.out.println("testResponseCode3");
    }

}



