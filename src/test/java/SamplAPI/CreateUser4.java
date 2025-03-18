package SamplAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static SamplAPI.DataProvider.MyDataProvider.getMyData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPI.SampleAPIPayload.getCreateUserPayload;

public class CreateUser4 {

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
    Object[][] getData() throws IOException {
        return  getMyData("Sheet1","Data/employee_list.xlsx");
    }
}
