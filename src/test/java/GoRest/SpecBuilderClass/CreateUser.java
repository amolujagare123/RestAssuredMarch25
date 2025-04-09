package GoRest.SpecBuilderClass;

import POJO.GoRest.GoRestCreateUserPOJO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.SampleAPI.SampleAPIPayload.getCreateUserPayload;

public class CreateUser {


    @Test
    public void createUserTest() {


        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        RequestSpecification requestSpec
                = requestSpecBuilder.setBaseUri("https://gorest.co.in/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization","Bearer 8769cc34965691163d0f8f5ad427102a5bebad9a1a7b8802777b1d41cf674efd")
                .build();


        GoRestCreateUserPOJO ob = new GoRestCreateUserPOJO();
        ob.setName("Ananya");
        ob.setEmail("ananya11112@gmail.com");
        ob.setGender("Female");
        ob.setStatus("active");


        RequestSpecification req = given().log().all().spec(requestSpec)
                     .body(ob);


        Response response = req.when().post("/public/v2/users");


        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();

        ResponseSpecification respSpec
                = responseSpecBuilder
                .expectStatusCode(201)
                .build();

        String respStr = response.then().log().all().spec(respSpec).extract().asString();

        System.out.println("respStr="+respStr);

    }



}
