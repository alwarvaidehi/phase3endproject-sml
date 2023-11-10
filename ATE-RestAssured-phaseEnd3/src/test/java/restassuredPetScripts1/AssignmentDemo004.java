package restassuredPetScripts1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssignmentDemo004 {
	Logger logger= LogManager.getLogger(AssignmentDemo004.class);
	@Test(priority='1')
	public void assignment004login()
	{
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/login")
		.auth().preemptive().basic("Uname001", "@tt!tude")
		.when()
		.get()
		 //.then().statusCode(200).log().headers()
  		//.then().log().ifError()
  		//.then().statusCode(200).log().cookies();
		.then()
		.statusCode(200).log().cookies()
		.log().all()
		.body("message", Matchers.anything());
		logger.trace("Message has been captured and validated");
	}
}
