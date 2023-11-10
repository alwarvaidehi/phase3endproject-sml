package restassuredPetScripts1;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssignmentDemo006 {
	@Test(priority='1')
	public void assignment006Logout()
	{
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/logout")
		.when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all()
		.body("code", Matchers.equalTo(200))
		.body("type", Matchers.equalTo("unknown"))
		.body("message", Matchers.equalTo("ok"));
		}

}
