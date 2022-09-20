package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import javax.xml.crypto.Data;

import io.restassured.response.Response;

import static io.restassured.matcher.ResponseAwareMatcher.*;

import static org.hamcrest.Matchers.*;

public class RestExample {
	
	@Test
	public void Test_one()
	{
		//Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		Response response= get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		System.out.println(response.time());
	}
   @Test
   public void Test_2()
   {
	   baseURI="https://reqres.in/api";
	   given().
	     get("/users?page=2").
	   then().
	      statusCode(200).body("data[1].id", equalTo(8))
	      .log().all();
	   
   }
}
