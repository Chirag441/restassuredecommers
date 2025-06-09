package StepDefination;

import pojoclasses.AddProduct;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginRequest;
import pojoclasses.LoginResponse;
//import utils.BaseConext;
import utils.APIResource;
import utils.Request;
import utils.ObjecFiles;

public class Resource  {
    Request request;

    public void setObjecFiles(ObjecFiles objecFiles) {
        this.objecFiles = objecFiles;
    }

    ObjecFiles objecFiles;
    protected LoginRequest loginRequest;
    protected LoginResponse loginResponse;
    protected AddProduct addProduct;
   protected AddProductResponse addProductResponse;
    APIResource apiResource;
    public void setup()
    {
       // request = base.request;
        //objecFiles = base.objecFiles;
        loginRequest=objecFiles.getLoginRequest();
        addProduct=objecFiles.getAddProduct();
        loginResponse =objecFiles.getLoginResponse();

    }

}
