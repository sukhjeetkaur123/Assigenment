package RequestDemo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteDataRequest {
    @Test
    void Create_Customer() {

        Response response1 = given().contentType(ContentType.JSON).when()
                .delete("https://reqres.in/api/users?page=2");

        String getResponse = response1.getBody().asString();
        System.out.println("GET Response Body is: " + getResponse);

        //Validate Status code
        int statusCode=response1.getStatusCode();
        System.out.println("Status Code is: " + statusCode);
        Assert.assertEquals(statusCode, 204);

        //Validate the Status line
        String statusLine=response1.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
    }
}
