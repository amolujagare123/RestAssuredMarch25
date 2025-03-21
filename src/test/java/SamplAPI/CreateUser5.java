package SamplAPI;

import POJO.sampleUSer.CreateUserPOJO;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static SamplAPI.DataProvider.MyDataProvider.getMyData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPI.SampleAPIPayload.getCreateUserPayload;

public class CreateUser5 {

    @Test
    public void createUserTest() {
        RestAssured.baseURI = "https://reqres.in";

        CreateUserPOJO ob = new CreateUserPOJO();
        ob.setName("Venketesh");
        ob.setJob("Manager");


        String responseStr = given().log().all()
                .header("Content-Type", "application/json")
                .body(ob)
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name", equalTo("Venketesh"))
                .extract().asString();


        System.out.println("responseStr="+responseStr);

        JsonPath jp = new JsonPath(responseStr);
        String myName = jp.getString("name");
        System.out.println("name="+myName);
    }


}
