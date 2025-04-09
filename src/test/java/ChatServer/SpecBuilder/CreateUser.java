package ChatServer.SpecBuilder;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static payload.chatserver.ChatServerPayload.getCreateUserPlayLoad;

public class CreateUser {


    @Test
    public void createUserTest()
    {

        PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
        auth.setUserName("admin");
        auth.setPassword("demo");

        RequestSpecification requestSpec
                 = new RequestSpecBuilder()
            .setBaseUri("https://demo.livehelperchat.com/site_admin/")
            .addHeader("Content-Type","application/json")
            .setAuth(auth).build();

        RequestSpecification req = given().log().all().spec(requestSpec)
                .body(getCreateUserPlayLoad("sunita","demo123",
                        "sunita@gmail.com","Sunita",
                        "dete","s1234"));

        Response response = req.when().post("/restapi/user");

        ResponseSpecification respSpec
                =  new ResponseSpecBuilder()
                .expectStatusCode(200).build();

        String respStr = response.then().log().all()
                .spec(respSpec).extract().asString();

        System.out.println("respStr="+respStr);
    }
}
