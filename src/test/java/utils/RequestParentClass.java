package utils;

//import StepDefination.Resource;
import pojoclasses.AddProduct;
import pojoclasses.AddProductResponse;
import pojoclasses.LoginRequest;
import pojoclasses.LoginResponse;

import java.io.*;
import java.util.Properties;

public class RequestParentClass extends ObjecFiles   {

    String baseurl ;
    String id ;
    String password;
    PrintStream log = null;
    Properties prop = null;
    String filePath = "//src//test//resources//global.properties";
    FileInputStream fis = null;


    protected void setUserDetails()
    {
        id = setUserId();
        password = setPassword();
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public  String getBaseURI() {
        return prop.getProperty("BaseURI");
    }

    public  String setUserId() {
        return prop.getProperty("email");
    }

    public  String setPassword(){
        return prop.getProperty("Password");
    }




    protected void loadLogFile()
    {
        baseurl = getBaseURI();

        try {
            log = new PrintStream(new FileOutputStream("Logs.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Unable to load Log file");
        }
    }

     protected void loadFile()
    {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + filePath);

        } catch (
                FileNotFoundException e) {
            System.out.println("Unable to load global  properties file");
        }

        prop = new Properties();
        try {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Unable to load properties file");
        }

    }
}
