package TestAPI_GoogleMaps;
import API_GoogleMaps.PayLoads;
import API_GoogleMaps.Resource;
import FileReaders.ConfigFileReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.security.Key;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.comparesEqualTo;


public class Test_PostRequest {
    int statusCode =200;
    Response response;
    String placeID;


    @Test
    public void testPostTC1(){
        RestAssured.baseURI = "http://216.10.245.166";
        response =given(). // header, param, cookies, body
                queryParam("key", "qaclick123").
                body(PayLoads.getStrBody1()).
        when().// get(resource), post(resource)
                post(Resource.getAddResource1()).
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("status",comparesEqualTo("OK") ).and().
                body("scope",comparesEqualTo("APP") ).
        extract().response();// pulling response body


        JsonPath jsonPathEvaluator = response.jsonPath();
        placeID=jsonPathEvaluator.get("place_id");
        PayLoads.setPlaceID(placeID);
        System.out.println(placeID);

    }

    @Test(dependsOnMethods = "testPostTC1")
    public void testPostTC2(){ //delete above post

        given(). // header, param, cookies, body
                queryParam("key","qaclick123").
                body(PayLoads.getStrBody2()).
        when().// get(resource), post(resource)
                post(Resource.getDelResource1()).
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("status",comparesEqualTo("OK") );
        System.out.println("testpostTC2");
        System.out.println(placeID);
    }



}
