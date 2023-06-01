package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.Request;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODQ5NzE0NDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY4NTAxNDY0NSwidXNlcklkIjoiNTM2NiJ9.mThopFrU1TK1ICvZNkwt5_eWPc9ZQRcPkmUC9nuOVsw";

    static String employee_id;

    @Test
    public void bgetCreatedEmployee() {
        RequestSpecification preparedRequest = given().
                header("Conent-Type", "application/json").
                header("Authorization", token).queryParam("employee_id", employee_id);

        //hitting the endpoint

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();

        //verify the response
        response.then().assertThat().statusCode(200);

        String tempEmpId = response.jsonPath().getString("employee.employee_id");

        //we have 2 emp. id, one is global and second is local
        Assert.assertEquals(employee_id, tempEmpId);
    }

    @Test
    public void acreateEmployee() {
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
        //preparedRequest contains all the information and you attach it to the request
        Response response = preparedRequest.when().post("/createEmployee.php");
        //it will print the output in the console, only for API
        response.prettyPrint();
        //verifying the assertions
        response.then().assertThat().statusCode(201);

        //we are capturing employee ID from the response
        employee_id = response.jsonPath().get("Employee.employee_id");
        System.out.println(employee_id);

        //verifying the firstname in the response body
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Lara"));
        response.then().assertThat().body("Employee.emp_lastname", equalTo("Zurgi"));


        //verify the response headers
        response.then().assertThat().header("Content-Type", "application/json");
        System.out.println("My test case passed");

    }

    //in homework, create a method to get all employee status and job title
@Test
    public void cupdateEmployee() {
        RequestSpecification preparedRequest = given().
                header("Content-Type", "application/json").
                header("Authorization", token).body("{\n" +
                        "    \"employee_id\": \""+employee_id+"\",\n" +
                        "    \"emp_firstname\": \"Pludd\",\n" +
                        "    \"emp_lastname\": \"Frsuosm\",\n" +
                        "    \"emp_middle_name\": \"h\",\n" +
                        "    \"emp_gender\": \"M\",\n" +
                        "    \"emp_birthday\": \"1954-04-24\",\n" +
                        "    \"emp_status\": \"active\",\n" +
                        "    \"emp_job_title\": \"QA tester\"\n" +
                        "}");
        //hitting the endpoint
        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);

        //for verification
        response.then().assertThat().body("Message", equalTo("Employee record Updated"));

    }
    @Test
    public void dgetUpdatedEmployee(){
        RequestSpecification preparedRequest = given().
                header("Content-Type","application/json").
                header("Authorization", token).
                queryParam("employee_id",employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //if you want to verify the body of the response.
        //you can do that using hamcrest matchers

}

}
