Feature: user login
  @test
  Scenario: User Login
    Given Setup "userLoginAPI" API
    When Hit "userLoginAPI" API with "Post" Request
    Then Verify Status code is 200

  @test
  Scenario:Add Product
    Given Setup "addProductAPI" API
    When Hit "addProductAPI" API with "Post" Request
    Then Verify Status code is 201

  @test
  Scenario:Delete Product
    Given Setup "deleteProductAPI" API
    When Hit "deleteProductAPI" API with "Delete" Request
    Then Verify Status code is 200
