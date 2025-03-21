package SamplAPI;


import POJO.sampleUSer.GetAllUsersPOJO;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class GetAllUsers2 {

    // https://reqres.in/api/users?page=2

    public static void main(String[] args) {

        RestAssured.baseURI = "https://reqres.in";

        GetAllUsersPOJO respAllUsers = given().log().all().queryParam("page", "2")
                .when().get("/api/users")
                .then().log().all().assertThat().statusCode(200)
                .extract().as(GetAllUsersPOJO.class);

        /*
        * Print the values of

            page
            per_page
            total
            total_pages

            url
            text

            first name
            email of each user

        * */

        System.out.println("page=" + respAllUsers.getPage());
        System.out.println("per_page=" + respAllUsers.getPer_page());
        System.out.println("total=" + respAllUsers.getTotal());
        System.out.println("total_pages=" + respAllUsers.getTotal_pages());



        System.out.println("url=" + respAllUsers.getSupport().getUrl());
        System.out.println("text=" + respAllUsers.getSupport().getText());

        for (int i=0;i<respAllUsers.getData().size();i++)
        {
           String fName =  respAllUsers.getData().get(i).getFirst_name();
           String email =  respAllUsers.getData().get(i).getEmail();

            System.out.println("\nfName="+fName);
            System.out.println("email="+email);
        }

    }

}
