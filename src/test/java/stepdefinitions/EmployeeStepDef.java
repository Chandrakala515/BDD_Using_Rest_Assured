package stepdefinitions;

import com.emp.demo.model.Employee;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpStatus;

import static com.jayway.restassured.RestAssured.get;

public class EmployeeStepDef {

    private String url;

    Employee obj;

    @Given("I hit the Post api endpoint")
    public void i_hit_the_Post_api_endpoint() {
         url="http://localhost:8080/employeeservice/employee";
    }

    @When("^I post the employee id (.*), name (.*),location (.*),salary (.*)$")
    public void i_post_the_employee_id_name_xyz(Integer id,String name,String location,Long salary) {
        Employee emp=new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setLocation(location);
        emp.setSalary(salary);
        obj = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(emp)
                .post(url)
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee.class);
        System.out.println(obj);
    }

    @Then("I will get new employee record")
    public void i_will_get_new_employee_record() {

        Employee response = get(url + "/" + obj.getId())
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .extract().as(Employee.class);
        Assert.assertNotNull(response);
    }
}
