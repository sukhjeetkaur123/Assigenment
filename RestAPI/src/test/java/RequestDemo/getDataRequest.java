package RequestDemo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class getDataRequest {

    @Test
    public void Create() {
        Response response1 = given().contentType(ContentType.JSON).when()
                .get("https://reqres.in/api/users?page=2");

        String getResponse = response1.getBody().asString();
        System.out.println("GET Response Body is: " + getResponse);

        //Validate Status code
        int statusCode=response1.getStatusCode();
        System.out.println("Status Code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);

        //Validate the Status line
        String statusLine=response1.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
