package JobPortal;

import POJO.JobPortal.JobPortalCreateUserPOJO;
import POJO.JobPortal.Project;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class JobPortalCreateUser {


    @Test
    public void createJob() {
        RestAssured.baseURI = "http://localhost:9897/";

        JobPortalCreateUserPOJO ob = new JobPortalCreateUserPOJO();
        ob.setJobId(34);
        ob.setJobTitle("Automation Tester with API Knowledge");
        ob.setJobDescription("Should have knowldge of ,java POSTMAN , Kavascript , Karate framework");

        ArrayList<String> exp = new ArrayList<>();
        exp.add("1 year in manual testing");
        exp.add("1 year in Selenium");
        exp.add("1 year in API testing");

        ob.setExperience(exp);

        Project project1 = new Project();
        project1.setProjectName("AI bot with Javascript");

        ArrayList<String> tech1 = new ArrayList<>();
        tech1.add("Java");
        tech1.add("selenium");
        tech1.add("postman");
        tech1.add("karate");
        project1.setTechnology(tech1);

        Project project2 = new Project();
        project2.setProjectName("E-commerce Web App");

        ArrayList<String> tech2 = new ArrayList<>();
        tech2.add("React");
        tech2.add("Node.js");
        tech2.add("MongoDB");
        tech2.add("Express.js");
        project2.setTechnology(tech2);

        Project project3 = new Project();
        project3.setProjectName("Mobile Banking App");

        ArrayList<String> tech3 = new ArrayList<>();
        tech3.add("Kotlin");
        tech3.add("Firebase");
        tech3.add("Retrofit");
        tech3.add("JUnit");
        project3.setTechnology(tech3);



        ArrayList<Project> project = new ArrayList<>();
        project.add(project1);
        project.add(project2);
        project.add(project3);

        ob.setProject(project);



        String responseStr = given().log().all()
                .header("Content-Type", "application/json")
                .body(ob)
                .when().post("/normal/webapi/add")
                .then().log().all().assertThat().statusCode(201)
              //  .body("name", equalTo("morpheus"))
                .extract().asString();

        System.out.println("responseStr="+responseStr);
    }
}