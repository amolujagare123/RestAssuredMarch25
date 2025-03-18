package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser2 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

        String myBody = "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"SecurePass123!\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"name\": \"John\",\n" +
                "  \"surname\": \"Doe\",\n" +
                "  \"chat_nickname\": \"JohnnyD\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}\n";





        String responseStr2 = given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                .body(myBody)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();




        System.out.println("responseStr2="+responseStr2);
    }
}
