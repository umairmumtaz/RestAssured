package API_GoogleMaps;

public class PayLoads {

  static String strBody1 = "{\n" +
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
            "}\n";

  static String placeID;
  static String strBody2 = "{\n" +
          "    \"place_id\":\"" + placeID + "\" \n" +
          "}\n";

  static public String getStrBody1() {
      return strBody1;

  }
   static public String getStrBody2() {
       return("{\n" +
               "    \"place_id\":\"" + placeID + "\" \n" +
               "}\n");
   }

   static public void setPlaceID(String strplaceID) {
          placeID = strplaceID;
   }
}
