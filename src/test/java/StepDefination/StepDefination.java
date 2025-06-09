package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginResponse;
import utils.APIResource;
import utils.Request;
//import utils.BaseConext;
import java.io.File;


import static io.restassured.RestAssured.given;

public class StepDefination extends  Resource  {
 Response response;
 RequestSpecification requestbuild;
 Request request  = new Request();


    @Given("Setup {string} API")
    public void setupAPI(String API) {

        //request.baseRequestSpecification();
        //request.setUserDetails();
//        loginRequest.setUserEmail(request.getId());
//        loginRequest.setUserPassword(request.getPassword());
//        requestbuild = given().spec(request.baseRequestSpecification()).contentType(ContentType.JSON)
//                .body(loginRequest);
       switch (API) {
           case "userLoginAPI" -> requestbuild = request.loginAPI();
           case "addProductAPI" -> requestbuild = request.addProductAPI();
           case "deleteProductAPI" -> requestbuild = request.deleteProductAPI();
       }
        System.out.println("hello");

    }


    @When("Hit {string} API with {string} Request")
    public void hitAPIWithRequest(String API, String method) {
        //Method is of  no use only for USER understanding  in Feature file

                apiResource=APIResource.valueOf(API);

        switch (API) {
            case "userLoginAPI" -> {
                response = requestbuild.when().post(apiResource.getResource());
                loginResponse = response.then().extract().response().as(LoginResponse.class);
                System.out.println("token step="+ loginResponse.getToken());



            }
            case "addProductAPI" -> {
                response = requestbuild.when().post(apiResource.getResource());
                addProductResponse = response.then().extract().response().as(AddProductResponse.class);
                System.out.println("Add Product="+ addProductResponse.getMessage());
            }
            case "deleteProductAPI" -> {
                response = requestbuild.when().delete(apiResource.getResource());

            }
        }

    }



    @Then("Verify Status code is {int}")
    public void Verify_status_code(int statuscode)
    {
        Assert.assertEquals(response.statusCode(),statuscode);

        setupAPI("addProductAPI");
        hitAPIWithRequest("addProductAPI","posr");
        setupAPI("deleteProductAPI");
        hitAPIWithRequest("deleteProductAPI","posr");

    }


    void addingProduct()
    {
        addProduct.loadProductDetails(loginResponse.getUserId());
     requestbuild = given().spec(request.baseRequestSpecification())
             .header("Authorization",loginResponse.getToken())
             .contentType(ContentType.MULTIPART)
             .multiPart("productName",addProduct.getProductName())
             .multiPart("productAddedBy",addProduct.getProductAddedBy())
             .multiPart("productCategory",addProduct.getProductCategory())
             .multiPart("productSubCategory", addProduct.getProductSubCategory())
             .multiPart("productPrice",addProduct.getProductPrice())
             .multiPart("productDescription",addProduct.getProductDescription())
             .multiPart("productFor",addProduct.getProductFor())
             .multiPart("productImage",new File(addProduct.getProfuctImage()));





    }

    void deleteproduct()
    {
        requestbuild = given().spec(request.baseRequestSpecification())
                .header("Authorization",loginResponse.getToken())
                .contentType(ContentType.JSON)
                .pathParams("productId",addProductResponse.getProductId());








    }



}


