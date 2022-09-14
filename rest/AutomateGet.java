package rest;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.IsEqual.equalTo;

public class AutomateGet {
    @Test
    public void validate_status_code() {
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-6278f5274b5ef727ed0bfa1f-7b55d6a7ee36aa6a7e7c0f1bd1043811a9").
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200);
    }


    @Test
    public void validate_response_body() {
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-6278f5274b5ef727ed0bfa1f-7b55d6a7ee36aa6a7e7c0f1bd1043811a9").
                when().
                get("/workspaces").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("Team Workspace", "My Workspace", "API Learning and method"),
                        "workspaces.type", hasItems("personal", "team", "personal"),
                        "workspaces[0].name", equalTo("My Workspace")

                );
    }
}
