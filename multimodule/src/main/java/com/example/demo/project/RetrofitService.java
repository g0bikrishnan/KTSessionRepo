package com.example.demo.project;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class RetrofitService {
	RetrofitInterface retrofitInterface;
	static final String API_BASE_URL = "http://localhost:8081/student/";

    public RetrofitService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

    }
    
   
    
    public StudentEntity createStudent(StudentEntity studentEntity) throws  IOException{
    	Call<StudentEntity> retrofitCall = retrofitInterface.createRepo(studentEntity);

        Response<StudentEntity> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    	
    }
    public List<StudentEntity> allGet() throws IOException {
    	Call<List<StudentEntity>> retrofitCall = retrofitInterface.getAll();

        Response<List<StudentEntity>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    	
    }

    
    
    

}
