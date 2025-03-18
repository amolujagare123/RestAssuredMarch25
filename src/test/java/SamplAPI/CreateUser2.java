package SamplAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPI.SampleAPIPayload.getCreateUserPayload;

public class CreateUser2 {

    @Test (dataProvider = "getData")
    public void createUserTest(String name,String job) {
        RestAssured.baseURI = "https://reqres.in";

        String responseStr = given().log().all()
                .header("Content-Type", "application/json")
                .body(getCreateUserPayload(name,job))
                .when().post("/api/users")
                .then().log().all().assertThat().statusCode(201)
                .body("name", equalTo(name))
                .extract().asString();


        System.out.println("responseStr="+responseStr);

        JsonPath jp = new JsonPath(responseStr);
        String myName = jp.getString("name");
        System.out.println("name="+myName);
    }


    @DataProvider
    Object[][] getData()
    {
        Object[][] data = new Object[4][2];

        data[0][0] = "John Smith";
        data[0][1] = "Software Engineer";

        data[1][0] = "Emma Wilson";
        data[1][1] = "Data Scientist";

        data[2][0] = "Michael Chen";
        data[2][1] = "Product Manager";

        data[3][0] = "Sarah Davis";
        data[3][1] = "UX Designer";

        return data;
    }
}
