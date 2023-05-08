package com.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.model.Student;
import com.student.demo.service.StudentService;
@RestController
public class StudentController {
	@Autowired
	StudentService studsService;
	@GetMapping("/student")
	public List<Student> getAllStudents()
	{
		List<Student> studsList = studsService.getAllStudent();
		return studsList;
	}
	//http://localhost:8080/savestudent
	@PostMapping(value="/saveStudent")
	public Student saveStudent( Student s) 
	{
		return studsService.saveStudent(s);
	}
	@PutMapping(value="/updateStudent")
	public Student updateStudent(Student s) 
	{
		return studsService.saveStudent(s);
	}
	@DeleteMapping(value="/deleteStudent/{rno}")
	public void  deleteStudent(@PathVariable("rno") int regno)
	{
		studsService.deleteStudent(regno);
	}
	@GetMapping(value="/getStudent/{rno}")
	public Student getStudent(@PathVariable("rno") int regno)
	{
		return studsService.getStudent(regno);
	}
	@GetMapping(value="/sortStudent/{name}")
	public List<Student> sortStudents(@PathVariable("name") String name)
	{
		return studsService.sortStudents(name);
	}
	@GetMapping(value="/paginate/{offset}/{pageSize}")
	public List<Student> paginate(@PathVariable("offset") int offset,@PathVariable("pageSize")int pageSize)
	{
		return studsService.paginate(offset,pageSize);
	}
	@GetMapping(value="/paginAndSortingStudents/{offset}/{pageSize}/{name}")
	public List<Student> paginateAndSorting(@PathVariable("offset") int offset,@PathVariable("pageSize")int pageSize,@PathVariable("name") String name)
	{
		return studsService.paginateAndSorting(offset,pageSize,name);
	}
	@GetMapping("/fetchPrefix")
	public List<Student> fetchStudentByNamePrefix(@RequestParam String prefix)
	{
		return studsService.fetchStudentByNamePrefix(prefix);
	}
	@GetMapping("/fetchSuffix")
	public List<Student> fetchStudentByNameSuffix(@RequestParam String suffix)
	{
		return studsService.fetchStudentByNameSuffix(suffix);
	}
	@GetMapping("/fetchByDept")
	public List<Student> fetchStudentDepartment(@RequestParam String department)
	{
		return studsService.fetchStudentByDepartment(department);
	}
	@DeleteMapping("/deleteStudentByName/{name}")
    public String deleteStudentByName(@PathVariable String name)
    {
 	   int result = studsService.deleteStudentByName(name);
 	   if(result>0)
 		     return "Student record deleted";
 	   else
 		     return "Problem occured while deleting";
    }
    @PutMapping("/updateStudentByName/{dept}/{name}")
    public String updateStudentByName(@PathVariable String department,String name)
    {
 	   int res = studsService.updateStudentByName(department, name);
 	   if(res>0)
 		      return "Student record updated";
 	   else
 		    return "Problem occured";
    }
}
