package com.example.demo.project;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




@SpringBootTest
//@ActiveProfiles("test")
//@TestPropertySource(locations = "classpath:application.properties")

@RunWith(MockitoJUnitRunner.class)
public class RetrofitControllerTest {
	@InjectMocks
	RetrofitService retrofitService;
	@Mock
	RetrofitInterface retrofitInterface; 
	@Autowired
	Retrofit retrofit;
	

//	 @Test
//	 void testGetById() throws IOException {
//		StudentEntity studentEntity=dummyStudent();
//		// int id = 1;
//	        Response<StudentEntity> expectedResponse= Response.success(studentEntity);
//	        @SuppressWarnings("unchecked")
//	        Call<StudentEntity> call= mock(Call.class);
//	        when(retrofitInterface.throughId(Mockito.anyInt())).thenReturn(call);
//	        when(call.execute()).thenReturn(expectedResponse);
//	        RetrofitInterface retrofitInterface1= mock(RetrofitInterface.class);
//	        retrofitService.allById(Mockito.anyInt());
//
//	 }
	
	 
	
	
	 public StudentEntity dummyStudent(){
	        StudentEntity student1 = new StudentEntity();
	        student1.setId(1);
	        student1.setName("sai");
	        student1.setMarks(85);
	        student1.setPercentage(85);
	        student1.setGender("male");
	        student1.setStatus("pass");
	        return  student1;
	    }
	 public StudentEntity dummyStudent1(){
	        StudentEntity student2 = new StudentEntity();
	        student2.setId(1);
	        student2.setName("sai");
	        student2.setMarks(25);
	        student2.setPercentage(25);
	        student2.setGender("male");
	        student2.setStatus("fail");
	        return  student2;
	    }
	

}
