package com.automacao_api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class apiSteps {
    private Response response;
    

    @Given("que eu defino a URL base como {string}")
    public void setBaseUrl(String baseUrl) {
        RestAssured.baseURI = baseUrl;
    }

    @When("eu faço uma requisição GET para {string}")
    public void makeGetRequest(String endpoint) {
        response = given().when().get(endpoint);
    }

    @When("eu faço uma requisição PUT para {string} com o seguinte body:")
    public void makePutRequest(String endpoint, String body) {
        response = given()
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .put(endpoint);
    }

    @When("eu faço uma requisição DELETE para {string}")
    public void makeDeleteRequest(String endpoint) {
        response = given().when().delete(endpoint);
    }

    @Then("o status code deve ser {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("o response body deve conter {string} igual a {string}")
    public void validateResponseBody(String key, String value) {
        response.then().body(key, equalTo(value));
    }

    @Then("o response body deve conter {string} igual a {int}")
    public void validateResponseBody(String key, int value) {
        response.then().body(key, equalTo(value));
    }

    @When("eu faço uma requisição POST para {string} com o seguinte body:")
    public void makePostRequest(String endpoint, String body) {
        response = given()
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .post(endpoint);
    }

}
