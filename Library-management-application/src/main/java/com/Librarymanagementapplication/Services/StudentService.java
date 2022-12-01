package com.Librarymanagementapplication.Services;

import com.Librarymanagementapplication.Model.Student;
import com.Librarymanagementapplication.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getOneStudent(String studentId) {
        return studentRepository.getOneStudent(studentId);
    }


    public List<Student> getStudents() {
        return studentRepository.getAllStudents();
    }

    public void createStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    public void deleteStudent(Student student) {
        studentRepository.deleteStudent(student.getStudentId());
    }

    public void reduceAvailable(String bookId) {
        Student book = studentRepository.getOneStudent(bookId);
        book.setBooksAllocated(book.getBooksAllocated() - 1);
        studentRepository.updateStudent(book);
    }

    public void increaseAvailable(String bookId) {
        Student book = studentRepository.getOneStudent(bookId);
        book.setBooksAllocated(book.getBooksAllocated() + 1);
        studentRepository.updateStudent(book);
    }

}