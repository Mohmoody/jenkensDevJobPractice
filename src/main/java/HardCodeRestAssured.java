import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


public class HardCodeRestAssured {

  String  baseURl=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
  static String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9" +
          ".eyJpYXQiOjE2MjY1ODIyMzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYyNjYyNTQzMiwidXNlcklkIjoiMjkxMSJ9." +
          "90BjexrwcSRzuHKrGJ1i6WTmqTTMYiY8Bl0Wlb8X61s";
@Test
  public void getOneEmployee(){
      RequestSpecification requestSpecification =given().header("Content-Type","application/json").header("Authorization",token).queryParam("employee_id","22344A");
      Response response =requestSpecification.when().get("/getOneEmployee.php");

    System.out.println(response.asString());

    response.then().assertThat().body("employee.emp_middle_name",equalTo("dd"));
    response.then().assertThat().statusCode(200);
    response.then().assertThat().header("Server",equalTo("Apache/2.4.39 (Win64) PHP/7.2.18"));

  }
  @Test
  public void createEmployee(){
   RequestSpecification requestSpecification= given().header("Content-Type","application/json").header("Authorization",token).body("    {\n" +
            "          \n" +
            "             \"emp_firstname\": \"Johnn\",\n" +
            "  \"emp_lastname\": \"Cinan\",\n" +
            "  \"emp_middle_name\": \"ddn\",\n" +
            "  \"emp_gender\": \"F\",\n" +
            "  \"emp_birthday\": \"2021-07-16\",\n" +
            "  \"emp_status\": \"Employee\",\n" +
            "  \"emp_job_title\": \"Cloud Architect\"\n" +
            "        }");
  Response response= requestSpecification.when().post("\n" +
           "/createEmployee.php");
   response.prettyPrint();
      String empID=response.jsonPath().getString("Employee.employee_id");
      //response.then().assertThat().body("Employee.employee_id",equalTo("22943A"));
      response.then().assertThat().body("Message",equalTo("Employee Created"));

     }
}
