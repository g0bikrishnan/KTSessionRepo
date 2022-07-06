package com.example.demo.project;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitInterface {
	@GET("getAll")
	Call<List<StudentEntity>> getAll();
	@POST("saveStudent")
    Call<StudentEntity> createRepo(@Body StudentEntity studentEntity);

	
}
