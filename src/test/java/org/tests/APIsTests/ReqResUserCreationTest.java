package org.tests.APIsTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReqResUserCreationTest {

    @BeforeClass
    public void setup() {
        // Set Base URI for RestAssured
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void testUserCreation() {
        // Create JSON object with user data
        JSONObject userData = new JSONObject();
        userData.put("name", "morpheus");
        userData.put("job", "leader");

        // Send POST request to create a user
        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(userData.toString())
                .post("/users");

        // Print the response (optional for debugging)
        System.out.println("Response: " + response.asPrettyString());

        // Assertions
        // 1. Assert status code
        Assert.assertEquals(response.getStatusCode(), 201, "Status code is not as expected!");

        // 2. Validate response body
        String id = response.jsonPath().getString("id");
        String name = response.jsonPath().getString("name");
        String job = response.jsonPath().getString("job");
        String createdAt = response.jsonPath().getString("createdAt");

        Assert.assertNotNull(id, "ID should not be null");
        Assert.assertEquals(name, "morpheus", "Name does not match!");
        Assert.assertEquals(job, "leader", "Job does not match!");
        Assert.assertNotNull(createdAt, "CreatedAt should not be null");

        System.out.println("Test Passed: User creation verified successfully!");
    }
}
