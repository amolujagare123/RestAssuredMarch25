package SamplAPI;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers {

    // https://reqres.in/api/users?page=2

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        given().log().all().queryParam("page","2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200);

    }

}
