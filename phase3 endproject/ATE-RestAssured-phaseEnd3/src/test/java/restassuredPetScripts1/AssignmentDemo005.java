package restassuredPetScripts1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssignmentDemo005 {

	@Test(priority='1')
	public void assignment005FindByStatus()
	{
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet/findByStatus")
		.queryParam("status", "pending")
          .when()
		.get()
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all();	
	}
}


//.queryParam("status", "available")
		//.queryParam("status", "pending")
//.queryParam("status", "sold")