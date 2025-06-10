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

    public void setAddProductResponse(AddProductResponse addProductResponse) {
        this.addProductResponse = addProductResponse;
    }



    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }



    public AddProductResponse getAddProductResponse() {
        return addProductResponse;
    }


    public AddProduct getAddProduct() {
        addProduct = new AddProduct();

        return addProduct;
    }

    public LoginRequest getLoginRequest() {
        if(loginRequest == null) {
            loginRequest = new LoginRequest();
        }
        return loginRequest;
    }

    public LoginResponse getLoginResponse() {

        System.out.println("object file called");
        return loginResponse;
    }


}
