import io.restassured.path.json.JsonPath;

public class ComplexJsonDemo {

    public static void main(String[] args) {


        String responseStr = "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 1162,\n" +
                "    \"website\": \"scriptinglogic.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Appium\",\n" +
                "      \"price\": 36,\n" +
                "      \"copies\": 7\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        System.out.println(responseStr);
    //  1. Print No of courses returned by API

        JsonPath jp = new JsonPath(responseStr);

        int size = jp.getInt("courses.size()");

        System.out.println("size="+size);

      //   2. Print Purchase Amount

        int purchaseAmount = jp.getInt("dashboard.purchaseAmount");

        System.out.println("purchaseAmount="+purchaseAmount);

      //  3. Print Title of the first course

        String title = jp.getString("courses[0].title");
        System.out.println("title="+title);

        String price = jp.getString("courses[0].price");
        System.out.println("price="+price);


        //  4. Print All course titles and their respective Prices

        for(int i = 0 ; i<size ; i++) {
            String myTitle = jp.getString("courses["+i+"].title");
            String myPrice = jp.getString("courses["+i+"].price");
            System.out.println("title=" + myTitle +" price=" + myPrice);
        }
      //  5. Print no of copies sold by RPA Course

        for(int i = 0 ; i<size ; i++) {
            String myTitle = jp.getString("courses["+i+"].title");

            if(myTitle.equalsIgnoreCase("RPA")) {
                //String myPrice = jp.getString("courses["+i+"].price");
                String myCopies = jp.getString("courses[" + i + "].copies");
                System.out.println("title=" + myTitle + " copies=" + myCopies);
            }
        }

      //  6. Verify if Sum of all Course prices matches with Purchase Amount

    }
}
