package SamplAPI.SpecBuilderDemo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUser {


    @Test
    public void updateUserTest() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        RequestSpecification requestSpec
                = requestSpecBuilder.setBaseUri("https://reqres.in")
                .addHeader("Content-Type", "application/json")
                .build();

        RequestSpecification req = given().log().all().spec(requestSpec).body("{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"zion resident\"\n" +
                "}");

        Response response = req.when().put("/api/users/2");

        ResponseSpecification respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        String respStr = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println("respStr = "+respStr);


    }
}
