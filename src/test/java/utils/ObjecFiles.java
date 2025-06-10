package utils;

import pojoclasses.AddProduct;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginRequest;
import pojoclasses.LoginResponse;

public class ObjecFiles {

     public static   AddProduct addProduct;
    public static LoginRequest loginRequest;
    public static LoginResponse loginResponse;
    public static AddProductResponse addProductResponse;


    public ObjecFiles()
    {
        getLoginRequest();
        getAddProduct();
    }



    public void getLoginRequest() {

           loginRequest = new LoginRequest();

    }


    public void getAddProduct() {
        addProduct = new AddProduct();

    }
}
