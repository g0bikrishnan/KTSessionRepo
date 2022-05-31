package com.student.management.project;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.bytebuddy.utility.RandomString;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	private byte[] bytes;
	@PostMapping("/save")
	public Object save(@RequestBody StudentEntity stu) {
		return service.save(stu);
	}
	@PostMapping("/uploadFile")
	public Object uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
		File f= new File("uploads/"+file.getOriginalFilename());
		OutputStream os = new FileOutputStream(f);
		os.write(file.getBytes());
		os.close();
		return service.readFromFile(new File("uploads/"+file.getOriginalFilename()));
	}
	
	
	@PostMapping(value="bulk/save", consumes = {"*/*"})
	public Object bulkSave(@RequestBody List<StudentEntity> file) {
		return service.bulkSave(file);
	}
	@GetMapping("/greaterThan/80")
	public List<StudentEntity> getMore80(){
		return service.getGrater80();
	}
	@GetMapping("/greaterThan/50")
	public List<StudentEntity> getMore50(){
		return service.getGrater50();
	}
	@GetMapping("/greaterThan/80/female")
	public List<StudentEntity> getMore80Female(){
		return service.getGrater80Female();
	}
	@GetMapping("/greaterThan/80/male")
	public List<StudentEntity> getMore80Male(){
		return service.getGrater80Male();
	}
	@GetMapping("/getAll")
	public List<StudentEntity> getAll(){
		return service.getAllStudents();
	}
	@GetMapping("/getFail")
	public List<StudentEntity> getAllFailed(){
		return service.getFailStudents();
	}

}