package com.pet.step_definitions;

import com.pet.Pojo.Category;
import com.pet.Pojo.Pet;
import com.pet.utilities.PetstoreUtil;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    Response response;
    PetstoreUtil url = new PetstoreUtil();

    @Given("User send get request to the right url and {string} end point")
    public void userSendGetRequestToTheRightUrlAndEndPoint(String endPoint) {
        response = given().accept(ContentType.JSON)
                .queryParam("status", "available")
                .when()
                .get(url.getUrl() + endPoint);


    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int expStatusCode) {

        int actual = response.getStatusCode();
        Assert.assertEquals(expStatusCode, actual);
    }


    @Given("User send get request to the right url and {string} end point with id {string}")
    public void userSendGetRequestToTheRightUrlAndEndPointWithId(String endPoint, String ID) {
        response =
                given().accept(ContentType.JSON)
                        .pathParams("petID", ID)
                        .when()
                        .get(url.getUrl() + endPoint);
    }

    @Given("User send POST request to the right url and {string} end point")
    public void userSendPOSTRequestToTheRightUrlAndEndPoint(String endpoint) {
        Category category = new Category();
        category.setId(5000);
        category.setName("Pameraninan");

        Pet newPet = new Pet();
        newPet.setName("Rudy");
        newPet.setId(5000);
        newPet.setCategory(category);
        newPet.setPhotoUrls(Arrays.asList("url"));

        response =
                given().accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .body(newPet)
                        .when().post(url.getUrl() + endpoint);
        response.prettyPrint();

    }

    @Given("User send delete request to the right url and {string} end point with id {int}")
    public void userSendDeleteRequestToTheRightUrlAndEndPointWithId(String endpoint, int ID) {

        response =
                given().accept(ContentType.JSON)
                        .pathParams("petID", ID)
                        .header("api_key",12345)
                        .when()
                        .delete(url.getUrl() +endpoint);
        response.prettyPrint();
    }
}
