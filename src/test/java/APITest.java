import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITest {

   @BeforeTest
   public void setBaseUrl(){
       RestAssured.baseURI = "https://postman-echo.com";
   }

    @Test
    public void testGetRequest() {
        GetRequest params = new GetRequest("bar1", "bar2");
        Response response = given()
                .param("foo1", params.getFoo1())
                .param("foo2", params.getFoo2())
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract().response();


        response.then()
                .body("args.foo1", equalTo(params.getFoo1()))
                .body("args.foo2", equalTo(params.getFoo2()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("http://postman-echo.com/get?foo1="+params.getFoo1()+"&foo2="+params.getFoo2()));


    }

    @Test
    public void testPostRequestRawText() {
        PostRequestRawText requestBody = new PostRequestRawText("This is expected to be sent back as part of response body.");

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody.getBody())
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract().response();

        response.then()
                .body("data", equalTo(requestBody.getBody()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPostRequestFormData() {
        PostRequestFormData requestBody = new PostRequestFormData("bar1","bar2");

        Response response = given()
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1",requestBody.getFoo1())
                .formParam("foo2",requestBody.getFoo2())

                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .extract().response();

        response.then()
                .body("form.foo1", equalTo(requestBody.getFoo1()))
                .body("form.foo2", equalTo(requestBody.getFoo2()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", containsString("application/x-www-form-urlencoded"))
                .body("headers.accept", equalTo("*/*"))
                .body("json.foo1", equalTo(requestBody.getFoo1()))
                .body("json.foo2", equalTo(requestBody.getFoo2()))
                .body("url", equalTo("http://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        PutRequest requestBody = new PutRequest("This is expected to be sent back as part of response body.");

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody.getBody())
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .extract().response();

        response.then()
                .body("data", equalTo(requestBody.getBody()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("http://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        PatchRequest requestBody = new PatchRequest("This is expected to be sent back as part of response body.");

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody.getBody())
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .extract().response();

        response.then()
                .body("data", equalTo(requestBody.getBody()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("http://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        DeleteRequest requestBody = new DeleteRequest("This is expected to be sent back as part of response body.");

        Response response = given()
                .header("Content-Type", "text/plain")
                .body(requestBody.getBody())
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract().response();

        response.then()
                .body("data", equalTo(requestBody.getBody()))

                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("http"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.content-type", containsString("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("http://postman-echo.com/delete"));
    }

}