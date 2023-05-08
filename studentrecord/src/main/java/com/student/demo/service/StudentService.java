package com.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.demo.model.Student;
import com.student.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	@Autowired
	StudentRepository studsRepository;
	public List<Student> getAllStudent(){
		List<Student> studsList = studsRepository.findAll();
		return studsList;
	}
	public Student saveStudent(Student s)
	{
		Student obj = studsRepository.save(s);
		return obj;
	}
	public Student updateStudent(Student s)
	{
		Student obj = studsRepository.save(s);
		return obj;
	}
	public void deleteStudent(int regno)
	{
		studsRepository.deleteById(regno);
	}
	public Student getStudent(int regno)
	{
		Student s = studsRepository.findById(regno).get();
		return s;
	}
	public List<Student> sortStudents(String name)
	{
		return studsRepository.findAll(Sort.by(name));
	}
	public List<Student> paginate(int offset,int pageSize)
	{
		Page<Student> obj=studsRepository.findAll(PageRequest.of(offset,pageSize));
		return obj.getContent();
	}
	public List<Student> paginateAndSorting(int offset,int pageSize,String name)
	{
		Page<Student> obj=studsRepository.findAll(PageRequest.of(offset,pageSize,Sort.by(name).descending()));
		return obj.getContent();
	}
	public List<Student> fetchStudentByNamePrefix(String prefix) 
	{
		return studsRepository.findByNameStartingWith(prefix);
		
	}
	public List<Student> fetchStudentByNameSuffix(String suffix) 
	{
		return studsRepository.findByNameStartingWith(suffix);
		
	}
	public List<Student> fetchStudentByDepartment(String department)
	{
		return studsRepository.findByDepartment(department);
	}
	
	@Transactional 
	public int deleteStudentByName(String name)
	{
   	return studsRepository.deleteStudentByName(name);
	}
	@Transactional
	public int updateStudentByName(String department,String name)
	{
		return studsRepository.updateStudentByName(department, name);
	}
	
}