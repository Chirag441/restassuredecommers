package pojoclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AddProduct {

    String productName;
    String productAddedBy;
    String productCategory;
    String productSubCategory;
    int productPrice;
    String productDescription;
    String productFor;
    String ProfuctImage;

    Properties prop  =null;
    FileInputStream fis = null;
    String filepath ="/src/test/resources/productDetails.properties";



  void loadFile()
  {
      try {
          fis = new FileInputStream(System.getProperty("user.dir") + filepath);

      } catch (FileNotFoundException e) {
      System.out.println("Unable to Product Details Property File");
      }

      prop = new Properties();
      try {

          prop.load(fis);
      } catch (IOException e) {
          System.out.println("Unable to Property Fil in Product Details");
      }
  }


  public void loadProductDetails(String userid)
  {
      if(prop ==null)
      {
          prop = new Properties();
          loadFile();
      }

      setProductName(prop.getProperty("productName"));
      setProductAddedBy(userid);
      setProductCategory("productCategory");
      setProductSubCategory("productSubCategory");
      setProductDescription(prop.getProperty("productDescription"));
      setProductFor(prop.getProperty("productFor"));
      String image =System.getProperty("user.dir") + "//src//test//resources//"+ prop.getProperty("imagePath");
      //"E://api projects//ecommers//src//test//resources//mac.jpg";

      setProfuctImage(image);
  }


    public String getProductName() {
        return productName;
    }

     void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAddedBy() {
        return productAddedBy;
    }

     void setProductAddedBy(String productAddedBy) {
        this.productAddedBy = productAddedBy;
    }

    public String getProductCategory() {
        return productCategory;
    }

     void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

     void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public int getProductPrice() {
        return productPrice;
    }

     void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

     void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductFor() {
        return productFor;
    }

     void setProductFor(String productFor) {
        this.productFor = productFor;
    }

    public String getProfuctImage() {
        return ProfuctImage;
    }

     void setProfuctImage(String profuctImage) {
        ProfuctImage = profuctImage;
    }


}
