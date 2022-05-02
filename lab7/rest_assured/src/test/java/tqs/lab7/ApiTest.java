package tqs.lab7;

import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class ApiTest{

    @Test
    public void endpointToListAllToDosIsAvailableTest(){
        RestAssured.when().get("https://jsonplaceholder.typicode.com/todos").then().statusCode(200);
    }

    @Test
    public void whenQueryToDO4Test(){
        RestAssured.given().get("https://jsonplaceholder.typicode.com/todos/4")
        .then().body("title",Matchers.equalTo("et porro tempora"));
    }

    @Test
    public void whenQueryToDOGetIDs198And199Test(){
        RestAssured.given().get("https://jsonplaceholder.typicode.com/todos")
        .then().body("id",Matchers.hasItems(198,199));
    }

    
}
