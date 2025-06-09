package utils;

import pojoclasses.AddProduct;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginRequest;
import pojoclasses.LoginResponse;

public class ObjecFiles {

    AddProduct addProduct;
    LoginRequest loginRequest;
    LoginResponse loginResponse;
    AddProductResponse addProductResponse;

    public AddProductResponse getAddProductResponse() {
        return addProductResponse;
    }


    public AddProduct getAddProduct() {
        addProduct = new AddProduct();

        return addProduct;
    }

    public LoginRequest getLoginRequest() {
        loginRequest = new LoginRequest();
        return loginRequest;
    }

    public LoginResponse getLoginResponse() {
        loginResponse = new LoginResponse();
        return loginResponse;
    }


}
