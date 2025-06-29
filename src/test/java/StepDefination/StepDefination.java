package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginResponse;
import utils.APIResource;
import utils.Request;


public class StepDefination extends Request {
    Response response;
    RequestSpecification requestbuild;
    APIResource apiResource;


    @Given("Setup {string} API")
    public void setupAPI(String API) {


        switch (API) {
            case "userLoginAPI" -> requestbuild = loginAPI();
            case "addProductAPI" -> requestbuild = addProductAPI();
            case "deleteProductAPI" -> requestbuild = deleteProductAPI();
        }


    }


    @When("Hit {string} API with {string} Request")
    public void hitAPIWithRequest(String API, String method) {
        //Method is of  no use only for USER understanding  in Feature file

        apiResource = APIResource.valueOf(API);

        switch (API) {
            case "userLoginAPI" -> {
                response = requestbuild.when().post(apiResource.getResource());
                loginResponse = response.then().extract().response().as(LoginResponse.class);

            }
            case "addProductAPI" -> {
                response = requestbuild.when().post(apiResource.getResource());
                addProductResponse = response.then().extract().response().as(AddProductResponse.class);
            }
            case "deleteProductAPI" -> {
                response = requestbuild.when().delete(apiResource.getResource());

            }
        }

    }


    @Then("Verify Status code is {int}")
    public void Verify_status_code(int statuscode) {
        Assert.assertEquals(response.statusCode(), statuscode);

    }

}


