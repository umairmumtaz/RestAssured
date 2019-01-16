package Utilities;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
//import javax.xml.ws.Response;
import io.restassured.response.*;

public class Reader {

    public static String rawToXML(Response response, String strParameter) {
        String strResponse = response.toString();
        XmlPath xmlString = new XmlPath(strResponse);
        return (xmlString.get(strParameter));// return value of the strParameter,from the the XML response.
    }

    public static JsonPath rawToJson(Response r)
    {
        String respon=r.asString();
        JsonPath x=new JsonPath(respon);
        return x;
    }

}
