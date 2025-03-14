package SamplAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        String responseStr = given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name", equalTo("morpheus"))
                .extract().asString();


        System.out.println("responseStr="+responseStr);


        JsonPath jp = new JsonPath(responseStr);

        String name = jp.getString("name");
        System.out.println("name="+name);
    }
}
