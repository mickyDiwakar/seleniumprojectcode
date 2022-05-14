package stepDefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pageobjectmodel.CollectionOfIsbns;
import pageobjectmodel.College;
import pageobjectmodel.pojo;
public class restGetTeststep {
	String token;
	 @SuppressWarnings("unchecked")
	@Given("^user is authorized user$")
	    public void user_is_authorized_user() throws Throwable {
		 RestAssured.baseURI="https://bookstore.toolsqa.com";
		 RequestSpecification request=RestAssured.given().header("Content-Type","application/json");	
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("userName","TOOLSQA-Test");
		jsonobject.put("password","Test@@123");
		 Response response=request.body(jsonobject.toJSONString()).post("/Account/v1/GenerateToken");
		// response.then().log().all();
		  token=response.getBody().jsonPath().get("token").toString();
		 	//System.out.println(str);
	    }
	 @When("^user try to fetch data from bookstore$")
	    public void user_try_to_fetch_data_from_bookstore() throws Throwable {
	       RestAssured.baseURI="https://bookstore.toolsqa.com";
	      // RequestSpecification request=RestAssured.given().accept(ContentType.JSON).header("Authorization","Bearer "+token);
	       RequestSpecification request=RestAssured.given().auth().oauth2(token);
	      Response response= request.get("/BookStore/v1/Books");
	     // response.then().log().all();
	      List<Map<String,String>> books1=response.jsonPath().get("books");
	    //  JsonPath.from(response.asString()).get("books");
	     int booksize=books1.size();
	     for(int i=0;i<booksize;i++) {
	    	 String s=books1.get(i).get("isbn").toString();
	    	 System.out.println(s);
	     }
	     CollectionOfIsbns coi1=new CollectionOfIsbns("123", "diwala1");
	     CollectionOfIsbns coi2=new CollectionOfIsbns("1231", "diwala1kumar");
	     List<CollectionOfIsbns> coi=new ArrayList<CollectionOfIsbns>();
	     coi.add(coi1);
	     coi.add(coi2);
	     College col=new College("sdm", "dharward");
	     pojo p=new pojo(col,coi,"diwa");
	     ObjectMapper mapper=new ObjectMapper();
	    String s= mapper.writeValueAsString(p);
	    System.out.println(s);
	    }


}
