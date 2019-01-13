package TestCases;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.comparesEqualTo;


public class Test_PostRequest {
    int statusCode =200;
    Response response;
    String placeID;

    @Test
    public void testPostTC1(){
        baseURI="http://216.10.245.166";
        response =given(). // header, param, cookies, body
                queryParam("key","qaclick123").
                body("{\n" +
                        "    \"location\":{\n" +
                        "        \"lat\" : -38.383494,\n" +
                        "        \"lng\" : 33.427362\n" +
                        "    },\n" +
                        "    \"accuracy\":50,\n" +
                        "    \"name\":\"Frontline house\",\n" +
                        "    \"phone_number\":\"(+91) 983 893 3937\",\n" +
                        "    \"address\" : \"29, side layout, cohen 09\",\n" +
                        "    \"types\": [\"shoe park\",\"shop\"],\n" +
                        "    \"website\" : \"http://google.com\",\n" +
                        "    \"language\" : \"French-IN\"\n" +
                        "}\n").
        when().// get(resource), post(resource)
                post("/maps/api/place/add/json").
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("status",comparesEqualTo("OK") ).and().
                body("scope",comparesEqualTo("APP") ).
        extract().response();// pulling response body


        JsonPath jsonPathEvaluator = response.jsonPath();
        placeID=jsonPathEvaluator.get("place_id");
        System.out.println(placeID);

    }

    @Test(dependsOnMethods = "testPostTC1")
    public void testPostTC2(){ //delete above post
        baseURI="http://216.10.245.166";
        given(). // header, param, cookies, body
                queryParam("key","qaclick123").
                body("{\n" +
                        "    \"place_id\":\"" + placeID + "\" \n" +
                        "}\n").
        when().// get(resource), post(resource)
                post("/maps/api/place/delete/json").
        then().// assertions
                assertThat().statusCode(statusCode).and().contentType(ContentType.JSON).and().
                body("status",comparesEqualTo("OK") );
        System.out.println("testpostTC2");
        System.out.println(placeID);
    }



}
