package SamplAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static payload.SampleAPI.SampleAPIPayload.getCreateUserPayload;

public class CreateUser3 {

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
        // 1. Read the file
        FileInputStream fis = new FileInputStream("Data/employee_list.xlsx");

        // 2. create the object workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // 3. get sheet name
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        // 4. get row count
       int rowCount = sheet.getPhysicalNumberOfRows() ;
       int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=0;i<rowCount-1;i++) {

            XSSFRow row = sheet.getRow(i+1);

            for (int j=0;j<colCount;j++)
            {
                data[i][j] = row.getCell(j).toString();
            }

            /*data[i][0] = row.getCell(0).toString();
            data[i][1] = row.getCell(1).toString();*/
        }
        return data;
    }
}
