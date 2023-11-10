package restassuredPetScripts1;

import java.io.File;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.RestAssured;


public class AssignmentDemo001 {
	Logger logger= LogManager.getLogger(AssignmentDemo001.class);
	@Test(priority='1')
	public void assignment001post()
	{
		logger.info("Course End Project -Assignment001 -POST request");
		File file =new File("resources/data.json");
		int id =RestAssured
				.given()
				.baseUri("https://petstore.swagger.io/v2/pet")
				.contentType(ContentType.JSON)
				.body(file)
				.when().post()
				.then()
				.statusCode(200)
				.log().all()
				.body("name", Matchers.equalTo("duck")).extract().path("id");
		logger.trace("The status code is checked");
		
		System.out.println(id);
		
		logger.trace("Id has been captured and validated");
			}
	@Test(priority='2')
	public void assignment001Get()
	{
		
		logger.info("Course End project - Assignment001 - GET request");
	int id = RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet/564")
		.when()
		.get()
		.then()
		.statusCode(200)
		.log().all()
		.body("status", Matchers.equalTo("available")).extract().path("category.id");
      System.out.println(id); // 0
      logger.trace("Id and status has been captured and validated");
	}

	@Test(priority='3')
	public void assignment001Delete()
	{
		logger.info("Course End project - Assignment001 - Delete request");
RestAssured.given()
		.baseUri("https://petstore.swagger.io/v2/pet/564")
		.when()
		.delete()
		.then()
		.statusCode(200)
		.log().all()
		.body("code", Matchers.equalTo(200))
		.body("type", Matchers.equalTo("unknown"))
		.body("message", Matchers.equalTo("564"));
	}
}
	


