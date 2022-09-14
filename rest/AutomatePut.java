package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.core.IsEqual.equalTo;

public class AutomatePut {
    @BeforeClass
    public void beforeClass(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().
                setBaseUri("https://api.postman.com").
                addHeader("X-Api-Key", "PMAK-6278f5274b5ef727ed0bfa1f-7b55d6a7ee36aa6a7e7c0f1bd1043811a9").
                setContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                log(LogDetail.ALL);
        RestAssured.responseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void validate_put_requst_bdd_style(){
        String workspaceId = "77cea198-d5a8-4336-85f0-5fd1aed7b65c";
        String payload = " {\n" +
                "            \"name\": \"My WorkspaceSu\",\n" +
                "            \"type\": \"personal\",\n" +
                "        }";
        given().
                body(payload).
                pathParam("workspaceId", workspaceId).
                when().
                put("/workspaces/{workspaceId}").
                then().
                log().all().
                assertThat().
                body("workspace.name", equalTo("My WorkspaceSu"),
                       "workspace.id", matchesPattern("^[a-z0-9-]{36}$"),
                        "workspace.id", equalTo(workspaceId));;
    }
}
