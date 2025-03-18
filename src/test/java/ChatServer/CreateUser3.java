package ChatServer;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static payload.chatserver.ChatServerPayload.getCreateUserPlayLoad;

public class CreateUser3 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

       /* String responseStr2 = given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                .body(getCreateUserPlayLoad())
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();*/

        String responseStr2 = given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                .body(getCreateUserPlayLoad("sunita1234","demo123","sunita@gmail.com","Sunita","dete","s1234"))
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();




        System.out.println("responseStr2="+responseStr2);
    }
}
