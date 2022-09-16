package RequestDemo;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteDataRequest extends BaseTest {
    Response response1;
    @Test
   public void get_Resuest() {

         response1 = given().contentType(ContentType.JSON).when()
                .delete("https://reqres.in/api/users?page=2");
    }

    @Test
    public void verifyResponse() {
        String getResponse = response1.getBody().asString();
        System.out.println("GET Response Body is: " + getResponse);
    }

    @Test
    public void verifyStatusCode() {
        //Validate Status code
        int statusCode = response1.getStatusCode();
        System.out.println("Status Code is: " + statusCode);
        Assert.assertEquals(statusCode, 204);
    }

    @Test
    public void verifyStatusLne() {
        //Validate the Status line
        String statusLine=response1.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 204 No Content");
    }
}
