package restassuredPetScripts1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class AssignmentDemo003 {
	Logger logger= LogManager.getLogger(AssignmentDemo003.class);
	@Test(priority='1')
	public void assignment003User()
	{
		RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/user/Uname001")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.body("username", Matchers.equalTo("Uname001"))
		.body("email", Matchers.equalTo("Positive@Attitude.com"))
		.body("userStatus", Matchers.equalTo(1));
		logger.trace("The status code is checked");
			
	}
	
}
