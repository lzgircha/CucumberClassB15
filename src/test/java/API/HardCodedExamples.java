package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.Request;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ4ODUxMTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NDkyODMxNywidXNlcklkIjoiNTM2NiJ9.uG0zgZETJbVX8IbdSVVEUoSyXYjloo9N98yWUGqkgio";

    @Test
    public void createEmployee(){
        //prepare the request
       RequestSpecification preparedRequest = given().
               header("Content-Type", "application/json").
               header("Authorization", token).body("{\n" +
                       "  \"emp_firstname\": \"Lara\",\n" +
                       "  \"emp_lastname\": \"Zurgi\",\n" +
                       "  \"emp_middle_name\": \"G\",\n" +
                       "  \"emp_gender\": \"F\",\n" +
                       "  \"emp_birthday\": \"1976-08-11\",\n" +
                       "  \"emp_status\": \"active\",\n" +
                       "  \"emp_job_title\": \"Engineer\"\n" +
                       "}");

        //hitting the endpoint/send the request
        Response response = preparedRequest.when().post("/createEmployee.php");
        //it will print the output in the console, only for API
        response.prettyPrint();
        //verifying the assertions
        response.then().assertThat().statusCode(201);

        //verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Lara"));
        System.out.println("My test case passed");

    }
}
