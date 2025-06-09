package utils;

public enum APIResource {
userLoginAPI("api/ecom/auth/login"),
addProductAPI("/api/ecom/product/add-product"),
deleteProductAPI("/api/ecom/product/delete-product/{productId}") ;

    public String getResource() {
        return resource;
    }

    String resource;

    APIResource(String resource) {
        this.resource = resource;
    }
}
