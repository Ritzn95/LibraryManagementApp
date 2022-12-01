package com.Librarymanagementapplication.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Librarymanagementapplication.Model.Student;
import com.Librarymanagementapplication.Services.StudentService;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value="api/v1/GetAllStudents", method = RequestMethod.GET)
    public ResponseEntity<List<Student>>getStudents() {
        List<Student> studentList = studentService.getStudents();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @RequestMapping(value="api/v1/AddNewStudent", method = RequestMethod.POST)
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }
}
