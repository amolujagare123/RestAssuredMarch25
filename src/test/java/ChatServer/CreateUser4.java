package ChatServer;

import io.restassured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static payload.chatserver.ChatServerPayload.getCreateUserPlayLoad;

public class CreateUser4 {

    public static void main(String[] args) throws IOException {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";


        Path path = Paths.get("json/chatServer1.json");

        byte[] readBytes = Files.readAllBytes(path);

        String myBody =new String(readBytes);




        String responseStr2 = given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                .body(myBody)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();




        System.out.println("responseStr2="+responseStr2);
    }
}
