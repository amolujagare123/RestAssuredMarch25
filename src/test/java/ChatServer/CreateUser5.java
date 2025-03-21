package ChatServer;

import GoRest.CreateUser;
import POJO.ChatServer.ChatServerCreateUSerPOJO;
import io.restassured.RestAssured;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateUser5 {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://demo.livehelperchat.com/site_admin";

        ChatServerCreateUSerPOJO ob = new ChatServerCreateUSerPOJO();

        ob.setUsername("john_doe");
        ob.setPassword("securePass123");
        ob.setName("John");
        ob.setSurname("Doe");
        ob.setEmail("john.doe@example.com");
        ob.setChat_nickname("Johnny");

        ArrayList<Integer> myList1 = new ArrayList<>();
        myList1.add(1);
        myList1.add(2);
        ob.setDepartments(myList1);

        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(2);
        ob.setDepartments_read(myList2);
        myList2.set(0,1);

        ob.setDepartments_read(myList2);
        ob.setDepartment_groups(myList2);
        ob.setUser_groups(myList2);


        String responseStr2 = given().log().all()
                .header("Content-Type", "application/json")
                .auth().preemptive().basic("admin","demo")
                .body(ob)
                .when().post("/restapi/user")
                .then().log().all().assertThat().statusCode(200)
                .extract().asString();




        System.out.println("responseStr2="+responseStr2);
    }
}
