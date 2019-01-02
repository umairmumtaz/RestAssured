package TestCases;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.annotations.TestInstance;

public class GetService {

    @Test

    public void testResponseCode(){

        int statusCode =200;

        String cityName = "London";

        given().



                when().

                get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").



                then().



                assertThat().statusCode(statusCode);

    }



    @Test

    public void testResponseCode2(){

        Response response =

                given().

                        get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").

                        then().

                        extract().

                        response();

        System.out.println(response.toString());

        //  response.body("q",is("London"));

    }


}



