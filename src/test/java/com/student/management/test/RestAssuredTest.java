package com.student.management.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.student.management.project.StudentEntity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestAssuredTest {
	@LocalServerPort
	String port;
	@Test
	public void test() 
	{
		String uri="http://localhost:"+port;
	}
	@Test
	 void testGetAll() {
		 String baseURI="http://localhost:"+port+"/student/";
		 Response response=given().contentType("application/json").accept("application/json").when().get(baseURI+"getAll").then().statusCode(200).contentType("application/json").extract().response();
			System.out.println(response.body().prettyPrint());
	 }
	@Test
	 void testSave() {
		
		 StudentEntity student1=mockData();
		 String baseURI="http://localhost:"+port+"/student/";
		Response responce = given()
				.contentType("application/json")
				.accept("application/json")
               .body(student1)
               .when()
               .post(baseURI+"save").then().statusCode(200)
               .contentType("application/json").extract().response();
         String res = responce.jsonPath().getString("percentage");
         assertNotNull(res);

		
	 }
	@Test
	 void testUploadImage() 
	 {
		 File test= new File("C:\\Users\\gobikrishnan\\Desktop\\studata.txt");
		 String baseURI="http://localhost:"+port;
		 Response responce= given().
        multiPart("file",test).
        post(baseURI+"/student/uploadFile").then().statusCode(200)
        .extract().response();
		 }
	@Test
	 void testGrater80() {
		 String baseURI="http://localhost:"+port;
		 given().contentType("application/json").accept("application/json").when().get(baseURI+"/student/greaterThan/80").then().statusCode(200).contentType("application/json").extract().response();
			
	 }
	 @Test
	 void testGrater50() {
		 String baseURI="http://localhost:"+port;
		 given().contentType("application/json").accept("application/json").when().get(baseURI+"/student/greaterThan/50").then().statusCode(200).contentType("application/json").extract().response();
			
	 }
	 @Test
	 void testGrater80Females() {
		 String baseURI="http://localhost:"+port;
		 given().contentType("application/json").accept("application/json").when().get(baseURI+"/student/greaterThan/80/female").then().statusCode(200).contentType("application/json").extract().response();
			
	 }
	 @Test
	 void testGrater80Males() {
		 String baseURI="http://localhost:"+port;
		 given().contentType("application/json").accept("application/json").when().get(baseURI+"/student/greaterThan/80/male").then().statusCode(200).contentType("application/json").extract().response();
	 }
	 @Test
	 void testFailedStudents() {
		 String baseURI="http://localhost:"+port;
		 given().contentType("application/json").accept("application/json").when().get(baseURI+"/student/getFail").then().statusCode(200).contentType("application/json").extract().response();
	 }
	 @Test
	 void testBulkSave() 
	 {
		 List<StudentEntity> list=new ArrayList<StudentEntity>();
		 list.add(mockData());
		 String baseURI="http://localhost:"+port;
		 given().body(list).contentType("application/json").accept("application/json").when().post(baseURI+"/student/bulk/save").then().statusCode(200).contentType("application/json").extract().response();
	 }
	public StudentEntity mockData()
	{
		StudentEntity stu= new  StudentEntity();
		stu.setName("gobi");
		stu.setGender("Male");
		stu.setMarks(20);
		stu.setPercentage(20);
		stu.setStatus("Fail");
		return stu;
		
	}
}
