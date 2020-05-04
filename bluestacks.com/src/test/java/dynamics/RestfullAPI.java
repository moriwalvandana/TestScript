package dynamics;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;

import files.ReUsableMethods;
import files.payload;

public class RestfullAPI {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(payload.AddPlace()).when().post("maps/api/place/add/json").then()
	    .log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js=new JsonPath(response); //for parsing Json
		String placeId=js.getString("place_id");
		
		System.out.println(placeId);
		String newAddress="Haryana, India" ;
		String response1= given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n" + 
				"\"place_id\":\""+placeId+"\",\r\n" + 
				"\"address\":\""+newAddress+"\",\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}").when().put("maps/api/place/update/json").then()
			    .log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
				.header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
				
				System.out.println(response1);
				//Get Place
				
				String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
					.queryParam("place_id",placeId)
					.when().get("maps/api/place/get/json")
					.then().assertThat().log().all().statusCode(200).extract().response().asString();
				JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
				String actualAddress =js1.getString("address");
				System.out.println(actualAddress);
				Assert.assertEquals(actualAddress, "Haryana, India");
	}
	    
       

}
