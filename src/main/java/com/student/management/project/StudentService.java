package com.student.management.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.lang.System.*; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	@Autowired
	StudentRepo repo;

	public Object save(StudentEntity studentEntity) {
		return repo.save(studentEntity);
	}

	public List<StudentEntity> getGrater80() {
		List<StudentEntity> stu1 = repo.findAll();
		return stu1.stream().filter(x -> (x.getPercentage() > 80)).collect(Collectors.toList());
	}

	public List<StudentEntity> getGrater50() {
		List<StudentEntity> stu1 = repo.findAll();
		return stu1.stream().filter(x -> (x.getPercentage() > 50)).collect(Collectors.toList());

	}

	public List<StudentEntity> getGrater80Female() {
		List<StudentEntity> stu1 = repo.findAll();
		return stu1.stream().filter(x -> (x.getPercentage() > 80 && x.getGender().equals("female")))
				.collect(Collectors.toList());
	}

	public List<StudentEntity> getGrater80Male() {
		List<StudentEntity> stu1 = repo.findAll();
		return stu1.stream().filter(x -> (x.getPercentage() > 80 && x.getGender().equals("male")))
				.collect(Collectors.toList());
	}

	public List<StudentEntity> getAllStudents() {
		return repo.findAll();

	}

	public List<StudentEntity> getFailStudents() {
		List<StudentEntity> stu1 = repo.findAll();
		List<StudentEntity> stu2;
		ArrayList<StudentEntity> stu3 = new ArrayList<StudentEntity>();
		stu2 = stu1.stream().filter(x -> (x.getStatus().equalsIgnoreCase("Fail"))).collect(Collectors.toList());
		for (StudentEntity s : stu2) {
			s.setReqPercentage(50 - s.getPercentage());
			stu3.add(s);
		}
		return stu3;
	}

public Object bulkSave(List<StudentEntity> file) {
		
		int sizeOfList=file.size();
		if(sizeOfList>10) {
			out.println("inside if");
		 int limit=sizeOfList/3;
		 List<StudentEntity> list1=file.subList(0, limit);
		 List<StudentEntity> list2=file.subList(limit+1, limit+limit);
		 List<StudentEntity> list3=file.subList(limit+limit+1, file.size());
		 CompletableFuture.supplyAsync(()->		 
		 			repo.saveAll(list1))	
		 			.thenRunAsync(()->repo.saveAll(list2))
		 			.thenRunAsync(()->repo.saveAll(list3));

		 

		}
		else {
		CompletableFuture.runAsync(new Runnable() {

			@Override
			public void run() {
				file.forEach(x -> new Thread(() -> saveByThread(x)).start());
				out.println(Thread.currentThread().getName());						

			}
		});
		return "Success";
	}
		return "Success";
	}
	

	public Object readFromFile(File file) {
		List<StudentEntity> listOfStudentEntities= new ArrayList<StudentEntity>();
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line;
			String[] s = null;
			while((line=reader.readLine())!=null) 
			{
				
				System.out.println(line);
				line=reader.readLine();
				
				try {
					s=line.split("\\s+");
				} catch (NullPointerException e) {
					return "End Of File";
				}
				StudentEntity stu= new StudentEntity();
				stu.setName(s[0]);
				stu.setGender(s[1]);
				stu.setMarks(Integer.valueOf(s[2]));
				stu.setPercentage(Integer.valueOf(s[3]));
				stu.setStatus(s[4]);
				stu.setReqPercentage(50-Integer.valueOf(s[2]));
				listOfStudentEntities.add(stu);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return bulkSave(listOfStudentEntities);
		
		
	}
	public void saveByThread(StudentEntity stu) {
		if(stu.getStatus().equalsIgnoreCase("fail"))
		{
			stu.setReqPercentage(50-stu.getPercentage());
		}
		repo.save(stu);
		
		System.out.println(Thread.currentThread().getName());
		
		
	}



}
