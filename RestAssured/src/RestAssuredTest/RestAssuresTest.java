package RestAssuredTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class RestAssuresTest {

	public static void main(String[] args) {
		
		
		RestAssured.baseURI="https://apiv2.moengage.com:443/";
		given().queryParam("app_id", "DAO6UGZ73D9RTK8B5W96TPYN").header("Content-Type","application/json").
		body("data\": [\n" + 
				"    {\n" + 
				"      \"actions\": [\n" + 
				"        \"Accept\",\n" + 
				"        \"May Be\",\n" + 
				"        \"Decline\"\n" + 
				"      ],\n" + 
				"      \"actionsIdentifier\": [\n" + 
				"        \"ACCEPT_IDENTIFIER\",\n" + 
				"        \"MAYBE_IDENTIFIER\",\n" + 
				"        \"DECLINE_IDENTIFIER\",\n" + 
				"        \"Test Action\"\n" + 
				"      ],\n" + 
				"      \"name\": \"INVITE_CATEGORY\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"actions\": [\n" + 
				"        \"Dismiss\"\n" + 
				"      ],\n" + 
				"      \"actionsIdentifier\": [\n" + 
				"        \"MOE_DISMISS_ACTION\"\n" + 
				"      ],\n" + 
				"      \"name\": \"MOE_DISMISS_CATEGORY\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"actions\": [\n" + 
				"        \"Play Now\",\n" + 
				"        \"Remind Me\"\n" + 
				"      ],\n" + 
				"      \"actionsIdentifier\": [\n" + 
				"        \"PLAY_NOW\",\n" + 
				"        \"REMIND_ME\"\n" + 
				"      ],\n" + 
				"      \"name\": \"VIDEO_CATEGORY\"\n" + 
				"    },\n" + 
				"    {\n" + 
				"      \"actions\": [\n" + 
				"        \"Notify\",\n" + 
				"        \"Share Action\"\n" + 
				"      ],\n" + 
				"      \"actionsIdentifier\": [\n" + 
				"        \"NOTIFY_ACTION\",\n" + 
				"        \"SHARE_ACTION\"\n" + 
				"      ],\n" + 
				"      \"name\": \"NOTIFY_CATEGORY\"\n" + 
				"    }\n" + 
				"  ]").when().post("v2/categories/add").then().assertThat().statusCode(200);
	

	}

}
