package TestAPI_GoogleMaps;
import API_GoogleMaps.Resource;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.comparesEqualTo;

public class Test_GetRequest {
    int statusCode =200;
    String cityName = "London";


    @Test
    public void testgetTC2(){
        baseURI="https://samples.openweathermap.org";
        given(). // header, param, cookies, body
                param("q","London,uk").
                param("appid","b6907d289e10d714a6e88b30761fae22").
        when().// get(resource), post(resource)
                get(Resource.getGetResource1()).
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("weather[0].main",comparesEqualTo("Drizzle") ).and().
                body("name", comparesEqualTo(cityName)).and().
                header("server","openresty/1.9.7.1");
      //  extract().// pulling response body
        System.out.println("testgetTC2");
    }

}



