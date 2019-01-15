package API_GoogleMaps;

import jdk.internal.dynalink.beans.StaticClass;

public class Resource {

    static String strAddResource= "/maps/api/place/add/json";
    static String strDelResource= "/maps/api/place/delete/json";
    static String strgetResource= "/data/2.5/weather";

    static public String getAddResource1() {
        return strAddResource;
    }

    static public String getDelResource1() {
        return strDelResource;
    }

    static public String getGetResource1() {
        return strgetResource;
    }
}
