package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;


public class Request extends RequestParentClass {
    public static   RequestSpecification baseRequest;
    public  RequestSpecification        addProductAPI, loginAPI, deleteProductAPI;//loginRequest;


    public Request() {

        baseRequestSpecification();
    }


    public RequestSpecification baseRequestSpecification() {
        if (baseRequest == null) {
            loadFile();
            loadLogFile();
            baseRequest = new RequestSpecBuilder().setBaseUri(baseurl)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
        }

        return baseRequest;


    }

    public RequestSpecification loginAPI() {
        if (loginAPI == null) {
            setUserDetails();
            loginRequest.setUserEmail(getId());
            loginRequest.setUserPassword(getPassword());
            loginAPI = given().spec(baseRequestSpecification()).contentType(ContentType.JSON)
                    .body(loginRequest);
        }
        return loginAPI;

    }

    public RequestSpecification addProductAPI() {
        if (addProductAPI == null) {
            addProduct.loadProductDetails(loginResponse.getUserId());


            addProductAPI = given().spec(baseRequestSpecification())
                    .header("Authorization", loginResponse.getToken())
                    .contentType(ContentType.MULTIPART)
                    .multiPart("productName", addProduct.getProductName())
                    .multiPart("productAddedBy", addProduct.getProductAddedBy())
                    .multiPart("productCategory", addProduct.getProductCategory())
                    .multiPart("productSubCategory", addProduct.getProductSubCategory())
                    .multiPart("productPrice", addProduct.getProductPrice())
                    .multiPart("productDescription", addProduct.getProductDescription())
                    .multiPart("productFor", addProduct.getProductFor())
                    .multiPart("productImage", new File(addProduct.getProfuctImage()));
        }
        return addProductAPI;

    }

    public RequestSpecification deleteProductAPI() {
        if (deleteProductAPI == null) {
            deleteProductAPI = given().spec(baseRequestSpecification())
                    .header("Authorization", loginResponse.getToken())
                    .contentType(ContentType.JSON)
                    .pathParams("productId", addProductResponse.getProductId());
        }
        return deleteProductAPI;

    }


}
