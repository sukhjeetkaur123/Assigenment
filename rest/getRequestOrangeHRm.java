package rest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getRequestOrangeHRm {
    @Test
    public void validate_status_code() {
        given().
                baseUri("https://opensource-demo.orangehrmlive.com").
                when().
                get("/web/index.php/api/v2/admin/users").   then().
                log().all().
                statusCode(200);
    }

         WebDriver driver = WebDriverManager.chromedriver().create();

         public void initialize() {
             driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
             driver.manage().window().maximize();
             driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]")).sendKeys("Admin");
             driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("admin123");
             driver.findElement(By.xpath("//button[@type='submit']")).click();
         WebElement ele = driver.findElement(By.xpath("(//div[@role='row'])[31]"));
         String text = ele.getText();
         System.out.println("the text is :"+text);

     }
    public static void main(String[] args) throws InterruptedException {
    getRequestOrangeHRm gs = new getRequestOrangeHRm();
         gs.initialize();

}
}
