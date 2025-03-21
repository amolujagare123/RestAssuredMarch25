package GoRest;

import POJO.GoRest.GoRestCreateUserPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class CreateUser3 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://gorest.co.in/";

        GoRestCreateUserPOJO ob = new GoRestCreateUserPOJO();
        ob.setName("Ananya");
        ob.setEmail("ananya1234@gmail.com");
        ob.setGender("Female");
        ob.setStatus("active");

        given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .body(ob)
                .when().post("/public/v2/users")
                .then().log().all().assertThat().statusCode(201);

    }
}
